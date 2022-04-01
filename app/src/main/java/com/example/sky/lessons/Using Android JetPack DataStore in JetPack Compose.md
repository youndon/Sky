# Using Android JetPack DataStore in JetPack Compose

In this article we will learn about Jetpack DataStore which is a new data storage solution in android and how to use it in a Compose Application

![img](https://miro.medium.com/max/875/1*TJ4f4cfLVZSauUlpswomQg.jpeg)


According to Google

> Jetpack is a **suite of libraries to help developers follow best practices, reduce boilerplate code, and write code** that works consistently across Android versions and devices so that developers can focus on the code they care about.

Jetpack Datastore is one of the awesome libraries that have being introduced into the growing list of Jetpack Libraries and according to them

> Jetpack DataStore is a data storage solution that **allows you to store key-value pairs or typed objects with protocol buffers**. DataStore uses Kotlin coroutines and Flow to store data asynchronously, consistently, and transactionally

and it is a replacement for our dear old [SharedPreference](https://developer.android.com/reference/android/content/SharedPreferences)s and there’s a great differences between them.

## **DataStore Vs SharedPreferences**

![img](https://miro.medium.com/max/875/1*kDQKAjnpv6VHYrQcN3ouAQ.png)

Image from [Android developer blog](https://android-developers.googleblog.com/2020/09/prefer-storing-data-with-jetpack.html)

## **Types of saving data in DataStore**

- **Preference DataStore**, like SharedPreferences, has no way to define a schema or to ensure that keys are accessed with the correct type.
- **Proto DataStore** lets you define a schema using [Protocol buffers](https://developers.google.com/protocol-buffers). Using Protobufs allows persisting **strongly typed data**. They are faster, smaller, simpler, and less ambiguous than XML and other similar data formats. While Proto DataStore requires you to learn a new serialization mechanism, we believe that the strongly typed schema advantage brought by Proto DataStore is worth it.

## **Using DataStore in Our app**

add the required dependencies to you build file

```groovy
dependencies {
    // Preferences DataStore (SharedPreferences like APIs)
    implementation "androidx.datastore:datastore-preferences:1.0.0"
    
    // Alternatively - use the following artifact without an Android dependency.
    implementation "androidx.datastore:datastore-preferences-core:1.0.0"

    // optional - RxJava2 support
    implementation "androidx.datastore:datastore-preferences-rxjava2:1.0.0"

    // optional - RxJava3 support
    implementation "androidx.datastore:datastore-preferences-rxjava3:1.0.0"
}
```



after importing the right dependencies, we move the next step.

## **Saving Data in DataStore**

let say we want to our User’s email when logging in, in case we need later in the app. We will create a Kotlin class called *SaveUserEmail and this class will be used to handle all the saving and retrieving of our data.*
```kotlin
class StoreUserEmail(private val context: Context) {

}
```

```kotlin
// to make sure there's only one instance
companion object {
    private val Context.dataStoree: DataStore<Preferences> by preferencesDataStore("userEmail")
    val USER_EMAIL_KEY = stringPreferencesKey("user_email")
}

//get the saved email
val getEmail: Flow<String?> = context.dataStoree.data
    .map { preferences ->
        preferences[USER_EMAIL_KEY] ?: "FirstLast@gmail.com"
    }

//save email into datastore
suspend fun saveEmail(name: String) {
    context.dataStoree.edit { preferences ->
        preferences[USER_EMAIL_KEY] = name
    }
}
```

- The *SaveUserEmail* class will require the `Context` object to create our`DataStore`.
- We then create our `DataStore` with the `preferencesDataStore `using extension function of the `Context` object. We need to set the name of our datastore with the compulsory `name` parameter.
- We need to define a key for each `String` value to save with the `stringPreferenceesKey()` function. You also need to define the name of the key with `name` parameter (this is available for other primitive values too).
- We can create a function to save the email in the `DataStore`. The `DataStore` provides a `edit()` method to save the value. We can pass the key and value to the `MutablePreferences` in the trailing lambda. Note that the `edit()` function is a `suspend` function ( which needs to run in a Coroutine Scope).
- Now you can get the saved preferences from the datastore with `datastore.data` which returns a `Flow<Preferences>` and with the `.map{}` operator we can can get the `Flow<String>` which is our email by passing the right key into the preferences.

now we head to our composable and do the necessary stuffs

```kotlin
@Composable
fun LoginSCreen() {
    //context
    val context = LocalContext.current
    // a coroutine scope
    val scope = rememberCoroutineScope()
    // we instantiate the saveEmail class
    val dataStore = StoreUserEmail(context)

    Column(modifier = com.example.sky.Modifier.fillMaxSize()) {
        var email by rememberSaveable { mutableStateOf("") }
        //
        Text(
            modifier = com.example.sky.Modifier
                .padding(16.dp, 0.dp)
                .alpha(0.6f),
            text = "EMAIL",
            fontWeight = FontWeight.SemiBold,
            color = Color.Gray,
            fontSize = 12.sp
        )
        //email field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType
                = KeyboardType.Email
            ),
            modifier = com.example.sky.Modifier
                .padding(16.dp, 0.dp, 16.dp, 0.dp)
                .fillMaxWidth(),
        )
        Spacer(modifier = com.example.sky.Modifier.height(16.dp))
        Button(
            onClick = {
                //launch the class in a coroutine scope
                scope.launch {
                    dataStore.saveEmail(email)
                }

            },
            modifier = com.example.sky.Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(16.dp, 0.dp, 16.dp, 0.dp),
        ) {
            Text(
                style = MaterialTheme.typography.subtitle1,
                color = Color.White,
                text = "Save Email",

                )
        }
        Spacer(modifier = com.example.sky.Modifier.height(32.dp))

    }
}
```
in order to get the saved data well collect it from flow like this.

`val userEmail = dataStore.getEmail.collectAsState(initial = "")`

 `Text(text = userEmail.value!!)`

after running this we show get the desired result

and the whole code looks like this.

```kotlin
//
@Composable
fun LoginSCreen() {
    //context
    val context = LocalContext.current
    // a coroutine scope
    val scope = rememberCoroutineScope()
    // we instantiate the saveEmail class
    val dataStore = StoreUserEmail(context)
Column(modifier = com.example.sky.Modifier.wrapContentSize()) {
    var email by rememberSaveable { mutableStateOf("") }
    //
    Text(
        modifier = com.example.sky.Modifier
            .padding(16.dp, 0.dp)
            .alpha(0.6f),
        text = "EMAIL",
        fontWeight = FontWeight.SemiBold,
        color = Color.Gray,
        fontSize = 12.sp
    )
    //email field
    OutlinedTextField(
        value = email,
        onValueChange = { email = it },

        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType
            = KeyboardType.Email
        ),
        modifier = com.example.sky.Modifier
            .padding(16.dp, 0.dp, 16.dp, 0.dp)
            .fillMaxWidth(),
        )
    Spacer(modifier = com.example.sky.Modifier.height(16.dp))
    Button(
        onClick = {
            //launch the class in a coroutine scope
            scope.launch {
                dataStore.saveEmail(email)
            }

        },
        modifier = com.example.sky.Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(16.dp, 0.dp, 16.dp, 0.dp),
    ) {
        Text(
            style = MaterialTheme.typography.subtitle1,
            color = Color.White,
            text = "Save Email",

            )
    }
    Spacer(modifier = com.example.sky.Modifier.height(32.dp))

    val userEmail = dataStore.getEmail.collectAsState(initial = "")

    Text(text = userEmail.value!!)
    }
}
```

***Done!***