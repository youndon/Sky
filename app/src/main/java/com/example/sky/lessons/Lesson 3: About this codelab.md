Jetpack Compose basics

## About this codelab

*account_circle*Written by Manuel Vivo

## [1. Before you begin](https://developer.android.com/codelabs/jetpack-compose-basics?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-basics#0)

[Jetpack Compose](https://developer.android.com/jetpack/compose) is a modern toolkit designed to simplify UI development. It combines a reactive programming model with the conciseness and ease of use of the Kotlin programming language. It is fully declarative, meaning you describe your UI by calling a series of functions that transform data into a UI hierarchy. When the underlying data changes, the framework automatically recalls these functions, updating the view hierarchy for you.

A Compose app is made up of composable functions - just regular functions marked with `@Composable`, which can call other composable functions. A function is all you need to create a new UI component. The annotation tells Compose to add special support to the function for updating and maintaining your UI over time. Compose lets you structure your code into small chunks. Composable functions are often referred to as "composables" for short.

By making small reusable composables - it's easy to build up a library of UI elements used in your app. Each one is responsible for one part of the screen and can be edited independently.

**Note:** In this codelab, the terms "UI Components," "Composable functions," and "composables" are used interchangeably to refer to the same concept.

## Prerequisites

- Experience with Kotlin syntax, including lambdas

## What you'll do

In this codelab, you will learn:

- What Compose is
- How to build UIs with Compose
- How to manage state in composable functions
- Data flow principles in Compose

## [2. Starting a new Compose project](https://developer.android.com/codelabs/jetpack-compose-basics?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-basics#1)

To start a new Compose project, open Android Studio Arctic Fox and select **Start a new Android Studio project** as shown:

![dabf04f3abbdc28a.png](https://developer.android.com/codelabs/jetpack-compose-basics/img/dabf04f3abbdc28a.png)

If the screen above doesn't appear, go to **File** > **New** > **New Project**.

When creating a new project, choose **Empty Compose Activity** from the available templates.

![a67ba73a4f06b7ac.png](https://developer.android.com/codelabs/jetpack-compose-basics/img/a67ba73a4f06b7ac.png)

Click **Next** and configure your project as usual. Make sure you select a *minimumSdkVersion* of at least API level 21, which is the minimum API Compose supports.

**Note:** For more information about setting up Compose with an empty activity or adding it to an existing project, check out the [documentation](https://developer.android.com/jetpack/compose/setup).

When choosing the **Empty Compose Activity** template, the following code is generated for you in your project:

- The project is already configured to use Compose.
- The `AndroidManifest.xml` file is created
- The `app/build.gradle` (or `build.gradle (Module: YourApplicationName.app)`) file imports the Compose dependencies and enables Android Studio to work with Compose with the `buildFeatures { compose true }` flag. Also, make sure that `kotlinCompilerVersion` is not present in the `composeOptions` block.

In this codelab we'll also use functions from the Kotlin standard library, so let's add it to the list of dependencies. Open the `app/build.gradle` file, it should look something like this:

```
android {
    ...
    kotlinOptions {
        jvmTarget = '1.8'
        useIR = true
    }
    buildFeatures {
        compose true
    }
    composeOptions {
        kotlinCompilerExtensionVersion compose_version
        // Remove kotlinCompilerVersion from here 
    }
}

dependencies {
    ...
    implementation "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
    implementation "androidx.compose.ui:ui:$compose_version"
    implementation "androidx.activity:activity-compose:1.3.0"
    implementation "androidx.compose.material:material:$compose_version"
    implementation "androidx.compose.ui:ui-tooling:$compose_version"
    ...
}
```

After syncing the project, open `MainActivity.kt` and check out the code.

```
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BasicsCodelabTheme {
        Greeting("Android")
    }
}
```

**Warning**: The app theme used inside `setContent` depends on how your project is named. This codelab assumes that the project is called *BasicsCodelab*. If you copy-paste code from the codelab, don't forget to update `BasicsCodelabTheme` with the name of your theme available in the `ui/Theme.kt` file. We'll get into theming later in the codelab.

In the next section, you'll see what each method does, and how you can improve them to create flexible and reusable layouts.

## Solution to the codelab

You can get the code for the solution of this codelab from GitHub:

```
$ git clone https://github.com/googlecodelabs/android-compose-codelabs
```

Alternatively you can download the repository as a Zip file:

[Download Zip](https://github.com/googlecodelabs/android-compose-codelabs/archive/main.zip)

You'll find the solution code in the `BasicsCodelab` project. We recommend that you follow the codelab step-by-step at your own pace and check the solution if you consider it necessary. During the codelab, you'll be presented with snippets of code that you'll need to add to the project.

## [3. Getting started with Compose](https://developer.android.com/codelabs/jetpack-compose-basics?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-basics#2)

Go through the different classes and methods related to Compose that the template has generated for you.

## Composable functions

A **composable function** is a regular function annotated with `@Composable`. This enables your function to call other `@Composable` functions within it. You can see how the `Greeting` function is marked as `@Composable`. This function will produce a piece of UI hierarchy displaying the given input, `String`. `Text` is a composable function provided by the library.

```
@Composable
fun Greeting(name: String) {
   Text(text = "Hello $name!")
}
```

**Note:** Composable functions are Kotlin functions that are marked with the `@Composable` annotation, as you can see in the code snippet above.

## Compose in an Android app

With Compose, `Activities` remain the entry point to an Android app. In our project, `MainActivity` is launched when the user opens the app (as it's specified in the `AndroidManifest.xml` file). You use `setContent` to define your layout, but instead of using an XML file as you'd do in the traditional View system, you call Composable functions within it.

```
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}
```

`BasicsCodelabTheme` is a way to style Composable functions. You'll see more about this in the **Theming your app** section. To see how the text displays on the screen, you can either run the app in an emulator or device, or use the Android Studio preview.

To use the Android Studio preview, you just have to mark any parameterless Composable function or functions with default parameters with the `@Preview` annotation and build your project. You can already see a `Preview Composable` function in the `MainActivity.kt` file. You can have multiple previews in the same file and give them names.

```
@Preview(showBackground = true, name = "Text preview")
@Composable
fun DefaultPreview() {
    BasicsCodelabTheme {
        Greeting(name = "Android")
    }
}
```

![88d6e7a2cfc33ed9.png](https://developer.android.com/codelabs/jetpack-compose-basics/img/88d6e7a2cfc33ed9.png)

**Note:** When importing classes related to Jetpack Compose in this project, use those from:

- androidx.compose.* for compiler and runtime classes
- androidx.compose.ui.* for UI toolkit and libraries

The preview might not appear if **Code** ![bcf00530a220eea9.png](https://developer.android.com/codelabs/jetpack-compose-basics/img/bcf00530a220eea9.png) is selected. Click **Split** ![aadde7eea0921d0f.png](https://developer.android.com/codelabs/jetpack-compose-basics/img/aadde7eea0921d0f.png) to see the preview.

## [4. Declarative UI](https://developer.android.com/codelabs/jetpack-compose-basics?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-basics#3)

If you want to set a different background color for the `Greeting`, you need to define a `Surface` that contains it:

```
import androidx.compose.ui.graphics.Color
...

@Composable
fun Greeting(name: String) {
    Surface(color = Color.Yellow) {
        Text (text = "Hello $name!")
    }
}
```

The components nested inside `Surface` will be drawn on top of that background color (unless specified otherwise by another `Surface`).

When you add that code to the project, you will see a **Build & Refresh** button in the top-right corner of Android Studio. Tap on it or build the project to see the new changes in the preview.

![1886a2cbfefe7df3.png](https://developer.android.com/codelabs/jetpack-compose-basics/img/1886a2cbfefe7df3.png)

You can see the new changes in the preview:

![5ee5b5542f238f2b.png](https://developer.android.com/codelabs/jetpack-compose-basics/img/5ee5b5542f238f2b.png)

## Modifiers

Most Compose UI elements like `Surface` and `Text` accept an optional modifier parameter. Modifier parameters tell a UI element how to lay out, display, or behave within its parent layout. Modifiers are regular Kotlin objects.

You can assign them to variables and reuse them. You can also chain several of these modifiers one after the other thanks to the factory-extension functions or with the function `then` that are merged to a single argument.

The `padding` modifier will apply an amount of space around the element it decorates. In order to add padding to your text on the screen, you can add the modifier to your `Text`:

```
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
...

@Composable
fun Greeting(name: String) {
    Surface(color = Color.Yellow) {
        Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
    }
}
```

Click **Build & Refresh** to see the new changes.

![fad946d5bf776ee3.png](https://developer.android.com/codelabs/jetpack-compose-basics/img/fad946d5bf776ee3.png)

## Compose reusability

The more components you add to the UI, the more levels of nesting you create, just like other functions in your codebase. This can affect readability if a function becomes really large. By making small reusable components it's easy to build up a library of UI elements used in your app. Each one is responsible for one small part of the screen and can be edited independently.

**Note:** The `@Composable` annotation is necessary just for functions which emit UI or call other composable functions. They can call both regular and other composable functions. If a function doesn't meet these requirements, it shouldn't be annotated with `@Composable`.

Notice how the composable functions in `MainActivity.kt` are outside of the `MainActivity` class, declared as top-level functions. The more code you have outside of the Activity, the more you can share and reuse.

First, refactor your code to make it more reusable and create a new `@Composable MyApp` function that contains the Compose UI logic specific to this Activity.

Second, it doesn't make sense that the background color of the app is placed in the reusable `Greeting` Composable. That configuration should be applied to every piece of UI on this screen, so move the `Surface` from `Greeting` to your new `MyApp` function:

```
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    BasicsCodelabTheme {
        Surface(color = Color.Yellow) {
            Greeting(name = "Android")
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
}

@Preview
@Composable
fun DefaultPreview() {
    MyApp()
}
```

You'd like to reuse the `MyApp` Composable function in different activities since it defines top-level configuration that can be used in multiple places. However, its current state doesn't allow it since it has `Greeting` embedded in it. Keep reading to learn how to create a container that holds common app configuration.

## Making container functions

What if you want to create a container that has all the common configurations of your app?

To make a generic container, create a Composable function that takes as a parameter a Composable function (here called `content`) which returns `Unit`. You return `Unit` because, as you might have noticed, Composable functions don't return UI components, they emit them. That's why they must return `Unit` :

```
@Composable
fun MyApp(content: @Composable () -> Unit) {
    BasicsCodelabTheme {
        Surface(color = Color.Yellow) {
            content()
        }
    }
}
```

**Note**: Watch out for the extra parentheses in `@Composable`**`()`** when using a Composable function as a parameter. Since the annotation is applied on a function, they're needed!

```
fun MyApp(content: @Composable` **`()`** `-> Unit) { ... }
```

Inside your function, you define all of the shared configuration you want your container to provide and then invoke the passed children Composable. In this case, you want to apply a `MaterialTheme` and a yellow surface, and then call `content()`.

You can use it like this (utilizing Kotlin's [trailing lambda syntax](https://kotlinlang.org/docs/reference/lambdas.html#passing-a-lambda-to-the-last-parameter)):

```
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                Greeting("Android")
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    BasicsCodelabTheme {
        Surface(color = Color.Yellow) {
            content()
        }
    }
}

@Preview("Text preview")
@Composable
fun DefaultPreview() {
    MyApp {
        Greeting("Android")
    }
}
```

This code is equivalent to what you had in the previous section, but is now more flexible. Making container composable functions is a good practice that improves readability and encourages reusing code.

## Calling Composable functions multiple times using Layouts

You extract UI components into Composable functions so that you can reuse them without duplicating code. In the following example, you can show two greetings reusing the same Composable function with different parameters.

To place items in a vertical sequence, use the `Column` Composable function (similar to a vertical `LinearLayout`).

```
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Divider
...

@Composable
fun MyScreenContent() {
    Column {
        Greeting("Android")
        Divider(color = Color.Black)
        Greeting("there")
    }
}
```

**Note:** `Divider` is a provided composable function that creates a horizontal divider.

As you want `MyScreenContent` to be what your users see when they open the app, you have to modify the `MainActivity` code accordingly. Also, you can modify the preview code, so that you can iterate faster in Android Studio without deploying the app to a device or emulator.

```
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyScreenContent()
            }
        }
    }
}

@Preview("MyScreen preview")
@Composable
fun DefaultPreview() {
    MyApp {
        MyScreenContent()
    }
}
```

If you refresh the preview, you'll see the items placed vertically:

![148453907504be1f.png](https://developer.android.com/codelabs/jetpack-compose-basics/img/148453907504be1f.png)

**Note:** When a Composable function is called, it adds elements to the Compose UI hierarchy. You can call the same function (with potentially different parameters) from multiple parts of your code to add new elements. You can think of this as if UI elements are emitted by calling the composable function.

## Compose and Kotlin

Compose functions can be called like any other function in Kotlin. This makes building UIs really powerful since you can add statements to influence how the UI will be displayed.

For example, you can use a `for` loop to add elements to the `MyScreenContent` `Column`:

```
@Composable
fun MyScreenContent(names: List<String> = listOf("Android", "there")) {
    Column {
        for (name in names) {
            Greeting(name = name)
            Divider(color = Color.Black)
        }
    }
}
```

![9ec1ce770c25da83.png](https://developer.android.com/codelabs/jetpack-compose-basics/img/9ec1ce770c25da83.png)



## [5. State in Compose](https://developer.android.com/codelabs/jetpack-compose-basics?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-basics#4)

Reacting to state changes is at the very heart of Compose. Compose apps transform data into UI by calling Composable functions. If your data changes, you recall these functions with the new data, creating an updated UI. Compose offers tools for observing changes in your app's data, which will automatically recall your functions—this is called **recomposing**. Compose also looks at what data is needed by an individual composable so that it only needs to recompose components whose data has changed and can skip composing those that are not affected.

Under the hood, Compose uses a custom Kotlin compiler plugin so when the underlying data changes, the composable functions can be re-invoked to update the UI hierarchy.

For example, when you call `Greeting("Android")`in the `MyScreenContent` Composable function, you are hard-coding the input (`"Android"`), so `Greeting` will get added to the UI tree once and won't ever change, even if the body of `MyScreenContent` gets recomposed.

To add internal state to a composable, use the `mutableStateOf` function, which gives a composable mutable memory. To not have a different state for every recomposition, remember the mutable state using `remember`. And, if there are multiple instances of the composable at different places on the screen, each copy will get its own version of the state. You can think of internal state as a private variable in a class.

The composable function will automatically be subscribed to it. If the state changes, composables that read these fields will be recomposed.

Make a counter that keeps track of how many times the user has clicked a `Button`. Define `Counter` as a Composable function with a `Button` that shows how many times it has been clicked:

```
import androidx.compose.material.Button
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
...

@Composable
fun Counter() {

    val count = remember { mutableStateOf(0) }

    Button(onClick = { count.value++ }) {
        Text("I've been clicked ${count.value} times")
    }
}
```

**Note:** Compose provides different types of `Button` according to the [Material Design Buttons spec](https://material.io/develop/android/components/buttons/)—`Button`, `OutlinedButton`, and `TextButton`. In your case, you'll use a `Button` that has a `Text` as the `Button` content showing how many times it's been clicked.

Since `Button` reads `count.value`, `Button` will be recomposed whenever it changes and will display the new value of `count`.

You now can add a `Counter` to your screen:

```
@Composable
fun MyScreenContent(names: List<String> = listOf("Android", "there")) {
    Column {
        for (name in names) {
            Greeting(name = name)
            Divider(color = Color.Black)
        }
        Divider(color = Color.Transparent, thickness = 32.dp)
        Counter()
    }
}
```

If you run the app in an emulator or click on the interactive preview button ![67a7d5b8fec7dfc7.png](https://developer.android.com/codelabs/jetpack-compose-basics/img/67a7d5b8fec7dfc7.png), you can see how `Counter` maintains state and it increases on every click.

![8766b5185e6476a5.gif](https://developer.android.com/codelabs/jetpack-compose-basics/img/8766b5185e6476a5.gif)

## Source of truth

In Composable functions, state that can be useful to calling functions should be exposed because it's the only way it can be consumed or controlled—this process is called **state hoisting**.

State hoisting is the way to make internal state controllable by the function that called it. You do so by exposing the state through a parameter of the controlled composable function and instantiating it externally from the controlling composable. Making state hoistable avoids duplicating state and introducing bugs, helps reuse composables, and makes composables substantially easier to test. State that is not interesting to a composable caller should be internal.

There are situations where the consumer might not care about a certain state (for example, in a scroller, the `scrollerPosition` state is exposed whereas the `maxPosition` is not). The source of truth belongs to whoever creates and controls that state.

In the example, since consumers of `Counter` can be interested in the state, you can defer it to the caller completely by introducing a `(count, updateCount)` pair as parameters of `Counter`. In this way, `Counter` is hoisting its state:

```
@Composable
fun MyScreenContent(names: List<String> = listOf("Android", "there")) {
    val counterState = remember { mutableStateOf(0) }

    Column {
        for (name in names) {
            Greeting(name = name)
            Divider(color = Color.Black)
        }
        Divider(color = Color.Transparent, thickness = 32.dp)
        Counter(
            count = counterState.value,
            updateCount = { newCount ->
                counterState.value = newCount
            }
        )
    }
}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
    Button(onClick = { updateCount(count+1) }) {
        Text("I've been clicked $count times")
    }
}
```



## [6. Flexible layouts](https://developer.android.com/codelabs/jetpack-compose-basics?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-basics#5)

You briefly touched on `Column` before, which is used to place items in a vertical sequence. In the same way, you can use `Row` to place items horizontally.

`Row` and `Column` place their items one after the other. If you want to make some items flexible so they occupy the screen with a certain weight, you can use the `weight` modifier.

Say you want to put the `Button` at the bottom of the screen while the other content remains at the top. You can do this with the following steps:

1. Wrap the flexible items inside another `Column` with a `weight` modifier. Since this `Column` is flexible and the rest of the content is inflexible, it will take up as much space as it can. It will be able to use all the remaining height after the outer `Column` is sized.
2. Leave the `Counter` in the outer `Column` that, by default, is inflexible.

```
import androidx.compose.foundation.layout.fillMaxHeight
...

@Composable
fun MyScreenContent(names: List<String> = listOf("Android", "there")) {
    val counterState = remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxHeight()) {
        Column(modifier = Modifier.weight(1f)) {
            for (name in names) {
                Greeting(name = name)
                Divider(color = Color.Black)
            }
        }
        Counter(
            count = counterState.value,
            updateCount = { newCount ->
                counterState.value = newCount
            }
        )
    }
}
```

You use the `fillMaxHeight()` modifier on the outer `Column` to make it occupy as much screen as it can (`fillMaxSize()` and `fillMaxWidth()` modifiers are also available).

1. If you refresh the preview, you can see the new changes:

![eb089602c1c5d55e.png](https://developer.android.com/codelabs/jetpack-compose-basics/img/eb089602c1c5d55e.png)

As another example of leveraging Kotlin in Compose, you could change the `Button`'s background color depending on the number of times the user tapped on it with an `if...else` statement:

```
import androidx.compose.material.ButtonDefaults
...

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
    Button(
        onClick = { updateCount(count+1) },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (count > 5) Color.Green else Color.White
        )
    ) {
        Text("I've been clicked $count times")
    }
}
```

![ce6ac33a852a4ee9.gif](https://developer.android.com/codelabs/jetpack-compose-basics/img/ce6ac33a852a4ee9.gif)

Now let's make the names list more realistic. So far you have displayed two items in a `Column` but can it handle thousands of them? Before changing the list items, let's extract the names column to a dedicated `Composable`:

```
@Composable
fun NameList(names: List<String>, modifier: Modifier = Modifier) {
   Column(modifier = modifier) {
       for (name in names) {
           Greeting(name = name)
           Divider(color = Color.Black)
       }
   }
}
```

Change the default list value in the `MyScreenContent` parameters to use another list constructor which allows to set the list size and fill it with the value contained in its lambda (here `$it` represents the list index):

```
names: List<String> = List(1000) { "Hello Android #$it" }
```

Whether you render it in the interactive mode or deploy it on a device/emulator, you won't be able to scroll through these thousands of rows as `Column` isn't scrollable by default.

To display a scrollable column we use a `LazyColumn`. `LazyColumn` renders only the visible items on screen, allowing performance gains when rendering a big list. It is equivalent to `RecyclerView` in Android Views.

As the list holds thousands of items, which will impact the app's fluidity when rendered, use `LazyColumn` to only render the visible elements on the screen rather than all of them.

In its basic usage, the `LazyColumn` API provides an `items` element within its scope, where individual item rendering logic is written:

```
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
...

@Composable
fun NameList(names: List<String>, modifier: Modifier = Modifier) {
   LazyColumn(modifier = modifier) {
       items(items = names) { name ->
           Greeting(name = name)
           Divider(color = Color.Black)
       }
   }
}
```

**Note:** `LazyColumn` doesn't recycle its children like `RecyclerView`. It emits new Composables as you scroll through it and is still performant as emitting Composables is relatively cheap compared to instantiating Android `Views`.

![7021b34729244ba8.gif](https://developer.android.com/codelabs/jetpack-compose-basics/img/7021b34729244ba8.gif)

## Full code for this section

```
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codelab.basics.ui.BasicsCodelabTheme

class MainActivity : AppCompatActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       setContent {
           MyApp {
               MyScreenContent()
           }
       }
   }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
   BasicsCodelabTheme {
       Surface(color = Color.Yellow) {
           content()
       }
   }
}

@Composable
fun MyScreenContent(names: List<String> = List(1000) { "Hello Android #$it" }) {
   val counterState = remember { mutableStateOf(0) }

   Column(modifier = Modifier.fillMaxHeight()) {
       NameList(names, Modifier.weight(1f))
       Counter(
           count = counterState.value,
           updateCount = { newCount ->
               counterState.value = newCount
           }
       )
   }
}

@Composable
fun NameList(names: List<String>, modifier: Modifier = Modifier) {
   LazyColumn(modifier = modifier) {
       items(items = names) { name ->
           Greeting(name = name)
           Divider(color = Color.Black)
       }
   }
}

@Composable
fun Greeting(name: String) {
   Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
   Button(
       onClick = { updateCount(count + 1) },
       colors = ButtonDefaults.buttonColors(
           backgroundColor = if (count > 5) Color.Green else Color.White
       )
   ) {
       Text("I've been clicked $count times")
   }
}

@Preview("MyScreen preview")
@Composable
fun DefaultPreview() {
   MyApp {
       MyScreenContent()
   }
}
```



## [7. Animating your list](https://developer.android.com/codelabs/jetpack-compose-basics?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-basics#6)

With less than 100 lines of code so far, you were able to display a long and performant scrolling list with a button that changes its background color once it has been clicked 5 times, great! Now let's make the list even more interactive.

Say you want to change the background color of a list item once you've clicked on it. You have already done it earlier with the button, but this time, the transition from one background color to another will be animated and not instant, like as follows:

![1a7b3467851eec7b.gif](https://developer.android.com/codelabs/jetpack-compose-basics/img/1a7b3467851eec7b.gif)

To do this, you will use the `animateColorAsState` APIs but first you need to update the `Greeting` Composable to add a `isSelected` state, initialized with `remember` to false, and a click handler, to toggle that state:

```
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
...

@Composable
fun Greeting(name: String) {
   var isSelected by remember { mutableStateOf(false) }
   val backgroundColor by animateColorAsState(if (isSelected) Color.Red else Color.Transparent)

   Text(
       text = "Hello $name!",
       modifier = Modifier
           .padding(24.dp)
           .background(color = backgroundColor)
           .clickable(onClick = { isSelected = !isSelected })
   )
}
```

**Note:** Make sure these imports are included in your file otherwise delegate properties (the `by` keyword) won't work:

```
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
```

In this specific use case, `animateColorAsState` takes a Color as a parameter, saves it and generates automatically the intermediate colors required to display an animated transition from the previously set color to the new one.

```
val backgroundColor by animateColorAsState(if (isSelected) Color.Red else Color.Transparent)
```

You can now add the animated change of background by setting a `background` modifier on the `Text` composable:

```
@Composable
fun Greeting(name: String) {
   var isSelected by remember { mutableStateOf(false) }
   val backgroundColor by animateColorAsState(if (isSelected) Color.Red else Color.Transparent)

   Text(
       text = "Hello $name!",
       modifier = Modifier
           .padding(24.dp)
           .background(color = backgroundColor)
           .clickable(onClick = { isSelected = !isSelected })
   )
}
```

**Note:** As `isSelected` state is hoisted in the `Greeting` composable, the `NameList` will not keep track if its items are selected or not. Once items are scrolled out of the screen, their states will be set to `false`. The behavior is intended as the goal of this exercise is to keep a simple list. To keep track of selected items in the list, their `isSelected` state should be hoisted at the `NameList` level.

## Full code for this section

```
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codelab.basics.ui.BasicsCodelabTheme

class MainActivity : AppCompatActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       setContent {
           MyApp {
               MyScreenContent()
           }
       }
   }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
   BasicsCodelabTheme {
       Surface(color = Color.Yellow) {
           content()
       }
   }
}

@Composable
fun MyScreenContent(names: List<String> = List(1000) { "Hello Android #$it" }) {
   val counterState = remember { mutableStateOf(0) }

   Column(modifier = Modifier.fillMaxHeight()) {
       NameList(names, Modifier.weight(1f))
       Counter(
           count = counterState.value,
           updateCount = { newCount ->
               counterState.value = newCount
           }
       )
   }
}

@Composable
fun NameList(names: List<String>, modifier: Modifier = Modifier) {
   LazyColumn(modifier = modifier) {
       items(items = names) { name ->
           Greeting(name = name)
           Divider(color = Color.Black)
       }
   }
}

@Composable
fun Greeting(name: String) {
   var isSelected by remember { mutableStateOf(false) }
   val backgroundColor by animateColorAsState(if (isSelected) Color.Red else Color.Transparent)

   Text(
       text = "Hello $name!",
       modifier = Modifier
           .padding(24.dp)
           .background(color = backgroundColor)
           .clickable(onClick = { isSelected = !isSelected })
   )
}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
   Button(
       onClick = { updateCount(count + 1) },
       colors = ButtonDefaults.buttonColors(
           backgroundColor = if (count > 5) Color.Green else Color.White
       )
   ) {
       Text("I've been clicked $count times")
   }
}

@Preview("MyScreen preview")
@Composable
fun DefaultPreview() {
   MyApp {
       MyScreenContent()
   }
}
```



## [8. Theming your app](https://developer.android.com/codelabs/jetpack-compose-basics?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-basics#7)

You didn't define any styling for any composables in the previous examples of the codelab. How can you theme your app? A theme is part of the hierarchy of Components as any other Composable function. `BasicsCodelabTheme` is an example of this.

If you open the `Theme.kt` file, you see that `BasicsCodelabTheme` uses `MaterialTheme` in its implementation. `MaterialTheme` is a Composable function that reflects the styling principles from the [Material design specification](https://material.io/design/material-theming/implementing-your-theme.html). That styling information cascades down to the components that are inside it, which may read the information to style themselves. In your original simple UI, you can use `BasicsCodelabTheme` as follows:

```
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                Greeting(name = "Android")
            }
        }
    }
}
```

Because `BasicsCodelabTheme` wraps `MaterialTheme` internally, `Greeting` is styled with the properties defined in the theme. You can retrieve properties of `MaterialTheme` and use them to define the style of the `Text` in this way:

```
@Composable
fun Greeting(name: String) {
    Text (
        text = "Hello $name!",
        modifier = Modifier.padding(24.dp),
        style = MaterialTheme.typography.h1
    )
}
```

The `Text` composable in the example above sets three arguments, a String to be displayed, modifiers, and a `TextStyle`. You can create your own `TextStyle`, or you can retrieve a theme-defined style by using `MaterialTheme.typography`. This construct gives you access to the Material-defined text styles, such as `h1`, `body1` or `subtitle1`. In your example, you use the `h1` style defined in the theme.

**Note:** Whenever you want to query a color or a text style from your Theme, use `MaterialTheme.colors` or `MaterialTheme.typography` in a Composable function.

For example, `style = MaterialTheme.typography.body1`

For example, `color = MaterialTheme.colors.surface`

If you see the preview with this code, you see the following screenshot:

```
@Preview(showBackground = true, name = "Text preview")
@Composable
fun DefaultPreview() {
    BasicsCodelabTheme {
        Greeting("Android")
    }
}
```

![1e9254f91d86a92b.png](https://developer.android.com/codelabs/jetpack-compose-basics/img/1e9254f91d86a92b.png)

**Note:** You can modify a predefined style by using the `copy` function.

For example, `style = MaterialTheme.typography.body1.copy(color = Color.Yellow)`

## Create your app's theme

You can create an app theme like the one in `Theme.kt`. See the code in the file for more details so that you can understand what's happening.

As you might want `BasicsCodelabTheme` in multiple places of your app (likely in all Activities), you create a reusable component.

As you saw in the **Theming your app** section, a theme is a Composable function that takes other children Composable functions. To make it reusable, you create a container Composable function as you did in the **Declarative UI** section:

```
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable

@Composable
fun BasicsCodelabTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    // TODO 
}
```

`MaterialTheme` holds configuration for colors and typography. You just change some colors at this point to achieve the design you want.

```
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable


private val DarkColors = darkColors(
    primary = purple200,
    primaryVariant = purple700,
    secondary = teal200
)

private val LightColors = lightColors(
    primary = purple500,
    primaryVariant = purple700,
    secondary = teal200
)

@Composable
fun BasicsCodelabTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColors
    } else {
        LightColors
    }

    MaterialTheme(colors = colors) {
        content()
    }
}
```

You provided your custom colors overriding those from `lightColors` and `darkColors` methods, which default colors to the light and dark Material baseline theme unless otherwise provided. That is passed to the `MaterialTheme` composable that, as you saw before, implements the styling principles from the Material design specification.

In the same way, you can override the typography and shapes used in the app by passing them to the `MaterialTheme` function.

## [9. Congratulations](https://developer.android.com/codelabs/jetpack-compose-basics?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-basics#8)

Congratulations! You learned the basics of Compose!

## Solution to the codelab

You can get the code for the solution of this codelab from GitHub:

```
$ git clone https://github.com/googlecodelabs/android-compose-codelabs
```