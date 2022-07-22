# #1 Floating Windows on Android: Jetpack Compose & Room

Learn how to use floating windows in your Android apps. The first lesson teaches you how to build the main app using Jetpack Compose and Room.

Have you ever wondered how to make those floating windows used by Facebook Heads and other apps? Have you ever wanted to use the same technology in your app? It’s easy, and I will guide you through the whole process.

I’m the author of [Floating Apps](https://floatingapps.net/); the first app of its kind on Google Play and the most popular one with over 8 million downloads. After 6 years of the development of the app, I know a bit about it. It’s sometimes tricky, and I spent months reading documentation and Android source code and experimenting. I received feedback from tens of thousands of users and see various issues on different phones with different Android versions.

Here’s what I learned along the way.

**In this article, I teach you how to build the simple main app with Jetpack Compose and Room.**

## The Idea [🔗](https://localazy.com/blog/floating-windows-on-android-1-jetpack-compose-room#the-idea)

We need an idea to apply floating technology. Let’s build an app that allows taking quick notes. That’s a perfect case. For writing a fast note, you usually don’t want to leave your current task.

Let’s implement it as a long-running service with a permanent notification - always ready to serve whenever needed. The user taps our notification and starts adding notes.

For your app, you can change this behavior. There is no need for long-running services.

## The Main App [🔗](https://localazy.com/blog/floating-windows-on-android-1-jetpack-compose-room#the-main-app)

Well, we need to start from the very begging. Let’s build the main app first. It allows us to showcase the integration process in a real-life scenario.

I decided to use [Kotlin](https://kotlinlang.org/), [Jetpack Compose](https://developer.android.com/jetpack/compose) and [Room](https://developer.android.com/topic/libraries/architecture/room), and build a very simple notes taking app.

Btw, you need to install Android Studio Canary as Jetpack Compose, at this moment, is not available in stable builds.

## Room [🔗](https://localazy.com/blog/floating-windows-on-android-1-jetpack-compose-room#room)

The [Room](https://developer.android.com/training/data-storage/room) persistence library provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite.

Let’s start with a simple entity for our notes:

```kotlin
@Entity  
data class Note(  
  @PrimaryKey val id: Int,  
  @ColumnInfo(name = "content") val content: String  
)
```

And corresponding DAO:

```kotlin
@Dao  
interface NotesDao {  
  
  @Query("SELECT * FROM note")  
  fun getAll(): List<Note>  
  
  @Insert  
  fun insert(note: Note)  
  
  @Delete  
  fun delete(note: Note)
}
```

And the last missing piece for accessing our data is `AppDatabase` class. Again, it’s very simple:

```kotlin
@Database(entities = [Note::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun notes(): NotesDao

}
```

## ViewModel [🔗](https://localazy.com/blog/floating-windows-on-android-1-jetpack-compose-room#viewmodel)

Now, make our data accessible through `ViewModel` with `MutableState` for Jetpack Compose. Changing the `notes` variable automatically run recomposition of `@Composable`’s that use it.

Room is accessed using [Kotlin Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) as we can’t invoke calls to SQLite on the main thread. However, only the basic approach is used as more complex scenarios are out of the scope of this article.

```kotlin
class NotesViewModel(application: Application) : AndroidViewModel(application) {  
  
  private val db = Room.databaseBuilder(  
    application.applicationContext,  
    AppDatabase::class.java,  
    "db-notes"  
  ).build()  
  
  var notes by mutableStateOf(listOf<Note>())  
    private set  
    
  // Load initial data from Room asynchronously.  
  init {  
    GlobalScope.launch {  
      val items = db.notes().getAll()  
      viewModelScope.launch { notes = items }  
    }  
  }  
  
  fun addNote(note: String) {  
    // Generate ID in a simple way - from timestamp.  
    val noteObj = Note(
      (System.currentTimeMillis() % Int.MAX_VALUE).toInt(), 
      note
    )  
    notes = notes + listOf(noteObj)  
    GlobalScope.launch { db.notes().insert(noteObj) }  
  }  
  
  fun removeNote(note:Note) {  
    notes = notes - listOf(note)  
    GlobalScope.launch { db.notes().delete(note) }  
  }  
  
}
```

## Composables [🔗](https://localazy.com/blog/floating-windows-on-android-1-jetpack-compose-room#composables)

Again, keep things simple and create just two complex `@Composable`’s - one for adding notes and the second for listing and deleting them.

### AddNote Composable [🔗](https://localazy.com/blog/floating-windows-on-android-1-jetpack-compose-room#addnote-composable)

Just a text field with a plus button. Nothing more.

```kotlin
@Composable
fun AddNote(title: String, onNoteAdded: (String) -> Unit) {
    Row {
        val text = remember { mutableStateOf(TextFieldValue("")) }
        TextField(
            value = text.value,
            onValueChange = { text.value = it },
            label = { Text(title) },
            modifier = Modifier
                .weight(1f, true)
                .padding(16.dp, 16.dp, 8.dp, 16.dp)
        )
        Button(
            onClick = {
                val newNote = text.value.text
                if (newNote.isNotBlank()) {
                    onNoteAdded(newNote)
                    text.value = TextFieldValue("")
                }
            },
            modifier = Modifier
                .padding(8.dp, 16.dp, 16.dp, 16.dp)
                .align(Alignment.CenterVertically)
        ) {
            Icon(
                Icons.Filled.Add,
                "...",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
```

### ShowNotes Composable [🔗](https://localazy.com/blog/floating-windows-on-android-1-jetpack-compose-room#shownotes-composable)

Composable `LazyColumnFor` lists all our notes automatically and when `items` comes from the view model, updates it whenever changed.

```Kotlin
@Composable
fun ShowNotes(items: List<Note>, onNodeRemoved: (Note) -> Unit) {
    LazyColumn {
        items(items = items) {
            Row {
                Text(
                    text = it.content,
                    modifier = Modifier
                        .padding(16.dp, 4.dp, 4.dp, 4.dp)
                        .weight(1f, true)
                        .align(Alignment.CenterVertically)
                )
                TextButton(
                    onClick = {
                        onNodeRemoved(it)
                    },
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier
                        .padding(4.dp, 4.dp, 16.dp, 4.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    Icon(
                        Icons.Filled.Delete,
                        "...",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}
```

## Activity - The Glue [🔗](https://localazy.com/blog/floating-windows-on-android-1-jetpack-compose-room#activity-the-glue)

Our `MainActivity` just glues all the code above together and displays our two composables.

```kotlin
class MainActivity : AppCompatActivity() {

  private val notesViewModel by viewModels<NotesViewModel>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      Column {

        AddNote(getString(R.string.add_note)) {
          notesViewModel.addNote(it)
        }

        ShowNotes(notesViewModel.notes) {
          notesViewModel.removeNote(it)
        }

      }
    }
  }

}
```

## Localization [🔗](https://localazy.com/blog/floating-windows-on-android-1-jetpack-compose-room#localization)

As you can notice in the previous chapter, I get the title for `AddNote` using `getString(...)`. It’s an extremely useful practice to prepare your app for localization from the begging.

I’m from the Czech Republic, a small country from the heart of Europe. We have our own language, and people here use it proudly. Many of them don’t speak English at all.

For this reason, I’m used to preparing my app for more languages. **Btw, [Floating Apps](https://floatingapps.net/) is available in 30 languages, and it helped me to skyrocket it to where it is.**

In our sample app, and you can notice it in the source code, I use [Localazy](https://localazy.com/android) by including lines below in my root build.gradle:

```groovy
repositories {  
  maven { url "https://maven.localazy.com/repository/release/" }  
}  

dependencies {  
  classpath "com.localazy:gradle:1.5.2"  
}
```

And in my app’s build.gradle:

```groovy
apply plugin: 'com.localazy.gradle'

localazy {  
  readKey "a8922414862262844150-..."  
  writeKey "a8922414862262844150-..."  
}
```

And that’s enough. Nothing else is necessary for me to manage my strings using [Localazy translation management](https://localazy.com/) for free. **Updated translations and even new languages are delivered online without re-submitting the app to Play Store.**