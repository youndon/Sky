# Layouts in Jetpack Compose

## About this codelab

*account_circle*Written by Manuel Vicente Vivo

## [1. Introduction](https://developer.android.com/codelabs/jetpack-compose-layouts?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-layouts#0)

In the [Jetpack Compose basics codelab](https://codelabs.developers.google.com/codelabs/jetpack-compose-basics/#0), you learnt how to build simple UIs with Compose using composables like `Text` as well as flexible layout composables such as `Column` and `Row` that allow you to place items (vertically and horizontally, respectively) on the screen and configuring the alignment of the elements within it. On the other hand, if you don't want items to be displayed vertically or horizontally, `Box` allows you to have items behind and/or in front of others.

![596386b0dceed4f6.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/596386b0dceed4f6.png)

You can use these **standard layout components** to build UIs like this one:

![d2c39f3c2416c321.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/d2c39f3c2416c321.png)

```
@Composable
fun PhotographerProfile(photographer: Photographer) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(...)
        Column {
            Text(photographer.name)
            Text(photographer.lastSeenOnline, ...)
        }
    }
}
```

Thanks to Compose's reusability and composability, you can build your own composables by combining the different parts needed at the correct level of abstraction together in a new composable function.

In this codelab, you'll learn how to use Compose's highest level of UI abstraction, [Material Design](https://material.io/design/), as well as low-level composables like `Layout` that allows you to measure and place elements on the screen.

If you want to create a [Material Design](https://material.io/design/)-based UI, Compose has built-in [Material components](https://material.io/components/) composables that you can use as we'll see in the codelab. If you don't want to use Material Design or want to build something that is not in the Material Design specs, you'll also learn about how to create custom layouts.

## What you will learn

In this codelab, you will learn:

- How to use [Material components](https://material.io/components/) composables
- What modifiers are and how you can use them in layouts
- How to create your custom layout
- When you might need intrinsics

## Prerequisites

- Experience with Kotlin syntax, including lambdas
- Knowing the [basics of Compose](https://codelabs.developers.google.com/codelabs/jetpack-compose-basics/#0).

## [3. Modifiers](https://developer.android.com/codelabs/jetpack-compose-layouts?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-layouts#2)

Modifiers allow you to decorate a composable. You can change its behavior, appearance, add information like accessibility labels, process user input or even add high-level interactions like making something clickable, scrollable, draggable or zoomable. Modifiers are regular Kotlin objects. You can assign them to variables and reuse them. You can also chain several modifiers one after the other to compose them.

Let's implement the profile layout seen in the introduction section:

![d2c39f3c2416c321.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/d2c39f3c2416c321.png)

Open `MainActivity.kt` and add the following:

```
@Composable
fun PhotographerCard() {
    Column {
        Text("Alfred Sisley", fontWeight = FontWeight.Bold)
        // LocalContentAlpha is defining opacity level of its children
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text("3 minutes ago", style = MaterialTheme.typography.body2)
        }
    }
}

@Preview
@Composable
fun PhotographerCardPreview() {
    LayoutsCodelabTheme {
        PhotographerCard()
    }
}
```

With preview:

![bf29f2c3f5d6a27.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/bf29f2c3f5d6a27.png)

**Important**: The app theme used inside `setContent` depends on how your project is named. This codelab assumes that the project is called *LayoutsCodelab*. If you copy-paste code from the codelab, don't forget to update `LayoutsCodelabTheme` with the name of your theme available in the `ui/Theme.kt` file.

**Note:** In this code snippet, we're using `CompositionLocalProvider`. It allows us to pass data implicitly through the composition tree. In this case, we're accessing `ContentAlpha.medium`, the medium opacity level, which is defined at the theme level in this case by `MaterialTheme`.

Next, while the picture is loading, you might want to show a placeholder. For that, you can use a `Surface` where we specify a circle shape and the placeholder color. To specify how big it should be, we can use the `size` modifier:

```
@Composable
fun PhotographerCard() {
    Row {
        Surface(
            modifier = Modifier.size(50.dp),
            shape = CircleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {
            // Image goes here
        }
        Column {
            Text("Alfred Sisley", fontWeight = FontWeight.Bold)
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text("3 minutes ago", style = MaterialTheme.typography.body2)
            }
        }
    }
}
```

![84f2bb229d67987b.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/84f2bb229d67987b.png)

There are a couple of improvements we would like to do here:

1. We want some separation between the placeholder and the text.
2. We would like the text to be centered vertically.

For #1, we can use `Modifier.padding` on the `Column` that contains the text to add some space at the `start` of the composable to separate the image and the text. For #2, some layouts offer modifiers that are only applicable to them and their layout characteristics. For example composables in a `Row` can access certain modifiers (from the `RowScope` receiver of Row's content) that make sense there such as `weight` or `align`. This scoping offers type-safety, so you cannot accidentally use a modifier which does not make sense in another layout, for example `weight` does not make sense in a `Box`, so this will be prevented as a compile-time error.

**Note:** Modifiers can play a similar role to XML attributes in the View system, but the type safety of scope-specific modifiers helps you to discover and understand what is available and applicable to a certain layout. Compare this with XML layouts where it was not always clear if a layout attribute was applicable to a given View.

```
@Composable
fun PhotographerCard() {
    Row {
        Surface(
            modifier = Modifier.size(50.dp),
            shape = CircleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {
            // Image goes here
        }
        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text("Alfred Sisley", fontWeight = FontWeight.Bold)
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text("3 minutes ago", style = MaterialTheme.typography.body2)
            }
        }
    }
}
```

With preview:

![1542fadc7f68feb2.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/1542fadc7f68feb2.png)

Most composables accept an optional modifier parameter to make them more flexible, enabling the caller to modify them. If you're creating your own composable, consider having a modifier as a parameter, default it to `Modifier` (i.e. empty modifier that doesn't do anything) and apply it to the root composable of your function. In this case:

```
@Composable
fun PhotographerCard(modifier: Modifier = Modifier) {
    Row(modifier) { ... }
}
```

**Note:** By convention, the modifier is specified as the *first* optional parameter of a function. This enables you to specify a modifier on a composable without having to name all parameters.

## Order of modifiers matter

In the code, notice how you can chain multiple modifiers one after the other by using the factory-extension functions (i.e. `Modifier.padding(start = 8.dp).align(Alignment.CenterVertically)`).

Be mindful when chaining modifiers as the order matters. As they're concatenated into a single argument, the order affects the final result.

If you wanted to make the Photographer profile both clickable and have some padding, you could do something like this:

```
@Composable
fun PhotographerCard(modifier: Modifier = Modifier) {
    Row(modifier
        .padding(16.dp)
        .clickable(onClick = { /* Ignoring onClick */ })
    ) {
        ...
    }
}
```

Using interactive preview or running in an emulator:

![c15a1050b051617f.gif](https://developer.android.com/codelabs/jetpack-compose-layouts/img/c15a1050b051617f.gif)

Notice how the whole area is **not** clickable! This is because `padding` was applied *before* the `clickable` modifier. If we apply the `padding` modifier *after* the `clickable` one then the padding is included in the clickable area:

```
@Composable
fun PhotographerCard(modifier: Modifier = Modifier) {
    Row(modifier
        .clickable(onClick = { /* Ignoring onClick */ })
        .padding(16.dp)
    ) {
        ...
    }
}
```

Using interactive preview or running in an emulator:

![a1ea4c8e16d61ffa.gif](https://developer.android.com/codelabs/jetpack-compose-layouts/img/a1ea4c8e16d61ffa.gif)

**Note:** The explicit order helps you to reason about how different modifiers will interact. Compare this to the View system where you had to learn the box model; that margins applied "outside" the element but padding "inside" it and a background element would be sized accordingly. The modifier design makes this behavior explicit and predictable, and gives you more control to achieve the exact behavior you want.

Let your imagination fly! Modifiers let you modify your composable in a very flexible way. For example, if you wanted to add some outer spacing, change the background color of the composable, and round the corners of the `Row`, you could use the following code:

```
@Composable
fun PhotographerCard(modifier: Modifier = Modifier) {
    Row(modifier
        .padding(8.dp)
        .clip(RoundedCornerShape(4.dp))
        .background(MaterialTheme.colors.surface)
        .clickable(onClick = { /* Ignoring onClick */ })
        .padding(16.dp)
    ) {
        ...
    }
}
```

Using interactive preview or running in an emulator:

![4c7652fc71ccf8dc.gif](https://developer.android.com/codelabs/jetpack-compose-layouts/img/4c7652fc71ccf8dc.gif)

We'll see more about how modifiers work under the hood later in the codelab.



## [4. Slot APIs](https://developer.android.com/codelabs/jetpack-compose-layouts?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-layouts#3)

Compose provides high-level [Material Components](https://material.io/components/) composables that you can use to build your UI. As they're building blocks for creating UI, you still need to provide the information of what to show on the screen.

**Slot APIs** are a pattern Compose introduces to bring in a layer of customization on top of composables, in this use case, the available Material Components composables.

**Note:** This section of the codelab is theoretical. You shouldn't copy the code in here to Android Studio.

Let's see this with an example:

If you think about a [Material **Button**](https://material.io/components/buttons/), there is a set guideline on how a Button should look and what it should contain, which we could translate into a simple API to use:

```
Button(text = "Button")
```

![b3cb99320ec18268.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/b3cb99320ec18268.png)

However, often you want to customize components well beyond what we may expect. We can try and add a parameter for each individual element you could customize, but that quickly gets out of hand:

```
Button(
    text = "Button",
    icon: Icon? = myIcon,
    textStyle = TextStyle(...),
    spacingBetweenIconAndText = 4.dp,
    ...
)
```

![ef5893f332864e28.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/ef5893f332864e28.png)

Therefore, instead of adding multiple parameters to customize the component in a way we cannot expect, we added Slots. **Slots leave an empty space in the UI for the developer to fill as they wish**.

![fccfb817afa8876e.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/fccfb817afa8876e.png)

For example in the case of Button, we can leave the inside of the Button to be filled by you, who may wish to insert a row with an icon and a text:

```
Button {
    Row {
        MyImage()
        Spacer(4.dp)
        Text("Button")
    }
}
```

To enable this, we provide an API for Button that takes a children composable lambda ( `content: @Composable () -> Unit`). This allows you to define your own composable to be emitted within the Button.

```
@Composable
fun Button(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    ...
    content: @Composable () -> Unit
)
```

Notice that this lambda, which we've named `content`, is the last parameter. This allows us to use the [**trailing lambda syntax**](https://kotlinlang.org/docs/reference/lambdas.html#passing-a-lambda-to-the-last-parameter) to insert content into the Button in a structured way.

Compose uses Slots heavily in more complex components such as the Top App Bar.

![4365ce9b02ec2805.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/4365ce9b02ec2805.png)

Here we can customize more things apart from the title:

![2decc9ec64c79a84.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/2decc9ec64c79a84.png)

Example of usage:

```
TopAppBar(
    title = {
        Text(text = "Page title", maxLines = 2)
    },
    navigationIcon = {
        Icon(myNavIcon)
    }
)
```

When building your own composables, you can **use the Slots API pattern** to make them more reusable.

In the next sections, we'll see the different Material Components composables available and how to use them when building an Android app.

## [5. Material Components](https://developer.android.com/codelabs/jetpack-compose-layouts?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-layouts#4)

Compose comes with built-in Material Component composables that you can use to create your app. The most high-level composable is [**`Scaffold`**](https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#Scaffold(androidx.compose.ui.Modifier,androidx.compose.material.ScaffoldState,kotlin.Function0,kotlin.Function0,kotlin.Function1,kotlin.Function0,androidx.compose.material.FabPosition,kotlin.Boolean,kotlin.Function1,kotlin.Boolean,androidx.compose.ui.graphics.Shape,androidx.compose.ui.unit.Dp,androidx.compose.ui.graphics.Color,androidx.compose.ui.graphics.Color,androidx.compose.ui.graphics.Color,androidx.compose.ui.graphics.Color,androidx.compose.ui.graphics.Color,kotlin.Function1)).

## Scaffold

`Scaffold` allows you to implement a UI with the basic Material Design layout structure. It provides slots for the most common top-level Material components such as [TopAppBar](https://material.io/components/app-bars-top/), [BottomAppBar](https://material.io/components/app-bars-bottom/), [FloatingActionButton](https://material.io/components/buttons-floating-action-button/) and [Drawer](https://material.io/components/navigation-drawer/). With `Scaffold`, you make sure these components will be positioned and work together correctly.

Based on the generated Android Studio template, we're going to modify the sample code to use `Scaffold`. Open `MainActivity.kt` and feel free to remove the `Greeting` and `GreetingPreview` composables as they won't be used.

Create a new composable called `LayoutsCodelab` that we'll be modifying throughout the codelab:

```
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.codelab.layouts.ui.LayoutsCodelabTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutsCodelabTheme {
                LayoutsCodelab()
            }
        }
    }
}

@Composable
fun LayoutsCodelab() {
    Text(text = "Hi there!")
}

@Preview
@Composable
fun LayoutsCodelabPreview() {
    LayoutsCodelabTheme {
        LayoutsCodelab()
    }
}
```

If you see the Compose preview function that must be annotated with `@Preview`, you'll see `LayoutsCodelab` as this:

![bd1c58d4497f523f.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/bd1c58d4497f523f.png)

Let's add the `Scaffold` composable to our example so that we can have a typical Material Design structure. All parameters in the `Scaffold API` are optional except the body content that is of type `@Composable (InnerPadding) -> Unit`: the lambda receives a padding as a parameter. That's the padding that should be applied to the content root composable to constrain the items appropriately on the screen. To start simple, let's add `Scaffold` without any other Material component:

```
@Composable
fun LayoutsCodelab() {
    Scaffold { innerPadding ->
        Text(text = "Hi there!", modifier = Modifier.padding(innerPadding))
    }
}
```

With preview:

![54b175d305766292.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/54b175d305766292.png)

If we wanted to have a `Column` with the main content of our screen, we should apply the modifier to `Column`:

```
@Composable
fun LayoutsCodelab() {
    Scaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(text = "Hi there!")
            Text(text = "Thanks for going through the Layouts codelab")
        }
    }
}
```

With preview:

![aceda77e27f25fe9.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/aceda77e27f25fe9.png)

To make our code more reusable and testable, we should structure it into small chunks. For that, let's create another composable function with the content of our screen.

```
@Composable
fun LayoutsCodelab() {
    Scaffold { innerPadding ->
        BodyContent(Modifier.padding(innerPadding))
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = "Hi there!")
        Text(text = "Thanks for going through the Layouts codelab")
    }
}
```

It's typical to see a top AppBar in Android apps with information about the current screen, navigation and actions. Let's add that to our example now.

## TopAppBar

`Scaffold` has a slot for a top AppBar with the `topBar` parameter of type `@Composable () -> Unit`, meaning we can fill the slot with any composable we want. For example, if we just want it to contain a `h3` style text, we could use `Text` in the provided slot as follows:

```
@Composable
fun LayoutsCodelab() {
    Scaffold(
        topBar = {
            Text(
                text = "LayoutsCodelab",
                style = MaterialTheme.typography.h3
            )
        }
    ) { innerPadding ->
        BodyContent(Modifier.padding(innerPadding))
    }
}
```

With preview:

![6adf05bb92b48b76.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/6adf05bb92b48b76.png)

However, as for most Material components, Compose comes with a [**`TopAppBar`**](https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#TopAppBar(kotlin.Function0,androidx.compose.ui.Modifier,kotlin.Function0,kotlin.Function1,androidx.compose.ui.graphics.Color,androidx.compose.ui.graphics.Color,androidx.compose.ui.unit.Dp)) **composable** that has slots for a title, navigation icon, and actions. Also, it comes with some default that adjusts to what Material specs recommend such as the color to use on each component.

Following the slots API pattern, we want the `title` slot of `TopAppBar` to contain a `Text` with the title of the screen:

```
@Composable
fun LayoutsCodelab() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "LayoutsCodelab")
                }
            )
        }
    ) { innerPadding ->
        BodyContent(Modifier.padding(innerPadding))
    }
}
```

With preview:

![c93d09851d6560c7.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/c93d09851d6560c7.png)

Top AppBars usually have some **action items**. In our example, we're going to add a *favorite* button you can tap when you think you learnt something. Compose also comes with some predefined [Material icons](https://material.io/resources/icons/?style=baseline) you can use, for example the *close*, *favorite* and *menu* icons.

The slot for action items in the top AppBar is the `actions` parameter that internally uses a `Row`, so multiple actions will be placed horizontally. In order to use one of the predefined icons, we can use the `IconButton` composable with an `Icon` inside it:

```
@Composable
fun LayoutsCodelab() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "LayoutsCodelab")
                },
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(Icons.Filled.Favorite, contentDescription = null)
                    }
                }
            )
        }
    ) { innerPadding ->
        BodyContent(Modifier.padding(innerPadding))
    }
}
```

With preview:

![b2d81ccec4667ef5.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/b2d81ccec4667ef5.png)

Normally, actions modify the state of your application somehow. For more information about state, you can learn the basics of state management in the [Basics Compose codelab](https://codelabs.developers.google.com/codelabs/jetpack-compose-basics).

## Placing modifiers

Whenever we create new composables, having a `modifier` parameter that defaults to `Modifier` is a good practice to make the composable more reusable. Our `BodyContent` composable already takes a modifier as a parameter. If we wanted to add some more extra padding to `BodyContent`, where should we place the `padding` modifier?

We have two possibilities:

1. Apply the modifier to the only direct child inside the composable so that all calls to `BodyContent` apply the extra padding:

```
@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(8.dp)) {
        Text(text = "Hi there!")
        Text(text = "Thanks for going through the Layouts codelab")
    }
}
```

1. Apply the modifier when calling the composable that will add the extra padding just when needed:

```
@Composable
fun LayoutsCodelab() {
    Scaffold(...) { innerPadding ->
        BodyContent(Modifier.padding(innerPadding).padding(8.dp))
    }
}
```

Deciding where to do it totally depends on the type of composable and the use case. If the modifier is intrinsic to the composable, place it inside; if not, outside. In our case, we'd go for option 2 as padding is something we might not always force whenever we call `BodyContent`, it should be applied on a case-by-case basis.

Modifiers can be chained by calling each successive modifier function on the previous one. When there is no available chaining method, you can use `.then()`. In our example, we start with `modifier` (lower case), meaning the chain builds on top of the chain passed in as a parameter.

## More icons

Apart from the icons we listed before, you can use the full list of [Material icons](https://material.io/resources/icons/?style=baseline) by adding a new dependency to the project. In case you want to experiment with those icons, open the `app/build.gradle` (or `build.gradle (Module: app)`) file and import the `ui-material-icons-extended` dependency:

```
dependencies {
  ...
  implementation "androidx.compose.material:material-icons-extended:$compose_version"
}
```

Go ahead and feel free to change the icons of the `TopAppBar` as much as you like.

## Further work

[`Scaffold`](https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#Scaffold(androidx.compose.ui.Modifier,androidx.compose.material.ScaffoldState,kotlin.Function0,kotlin.Function0,kotlin.Function1,kotlin.Function0,androidx.compose.material.FabPosition,kotlin.Boolean,kotlin.Function1,kotlin.Boolean,androidx.compose.ui.graphics.Shape,androidx.compose.ui.unit.Dp,androidx.compose.ui.graphics.Color,androidx.compose.ui.graphics.Color,androidx.compose.ui.graphics.Color,androidx.compose.ui.graphics.Color,androidx.compose.ui.graphics.Color,kotlin.Function1)) and [`TopAppBar`](https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#TopAppBar(kotlin.Function0,androidx.compose.ui.Modifier,kotlin.Function0,kotlin.Function1,androidx.compose.ui.graphics.Color,androidx.compose.ui.graphics.Color,androidx.compose.ui.unit.Dp)) are just some composables that can be used to have a Material looking application. The same can be done for other Material components such as [`BottomNavigation`](https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#BottomNavigation(androidx.compose.ui.Modifier,androidx.compose.ui.graphics.Color,androidx.compose.ui.graphics.Color,androidx.compose.ui.unit.Dp,kotlin.Function1)) or [`BottomDrawer`](https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#BottomDrawer(kotlin.Function1,androidx.compose.ui.Modifier,androidx.compose.material.BottomDrawerState,kotlin.Boolean,androidx.compose.ui.graphics.Shape,androidx.compose.ui.unit.Dp,androidx.compose.ui.graphics.Color,androidx.compose.ui.graphics.Color,androidx.compose.ui.graphics.Color,kotlin.Function0)). As an exercise, we invite you to try to fill the `Scaffold` slots with those APIs in the same way we've done until now.

## [6. Working with lists](https://developer.android.com/codelabs/jetpack-compose-layouts?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-layouts#5)

Displaying a list of items is a common pattern in applications. Jetpack Compose makes this pattern easy to implement with the `Column` and `Row` composables, but it also offers lazy lists that only composes and lays out the currently visible items.

Let's practise by creating a vertical list with 100 items using the `Column` composable:

```
@Composable
fun SimpleList() {
    Column {
        repeat(100) {
            Text("Item #$it")
        }
    }
}
```

As `Column` doesn't handle scrolling by default, some items aren't visible as they're outside of the screen. Add the [`verticalScroll`](https://developer.android.com/reference/kotlin/androidx/compose/foundation/package-summary#verticalScroll(androidx.compose.ui.Modifier,androidx.compose.foundation.ScrollState,kotlin.Boolean,androidx.compose.foundation.gestures.FlingBehavior,kotlin.Boolean)) modifier to enable scrolling within the `Column`:

```
@Composable
fun SimpleList() {
    // We save the scrolling position with this state that can also 
    // be used to programmatically scroll the list
    val scrollState = rememberScrollState()

    Column(Modifier.verticalScroll(scrollState)) {
        repeat(100) {
            Text("Item #$it")
        }
    }
}
```

## Lazy list

The `Column` renders all the list items, even the ones not visible on the screen, which is a performance issue when the list size gets bigger. To avoid this problem, use [`LazyColumn`](https://developer.android.com/reference/kotlin/androidx/compose/foundation/lazy/package-summary#LazyColumn(androidx.compose.ui.Modifier,androidx.compose.foundation.lazy.LazyListState,androidx.compose.foundation.layout.PaddingValues,kotlin.Boolean,androidx.compose.foundation.layout.Arrangement.Vertical,androidx.compose.ui.Alignment.Horizontal,androidx.compose.foundation.gestures.FlingBehavior,kotlin.Function1)), which renders only the visible items on screen, allowing performance gains and doesn't need to `scroll` modifier.

**Note:** `LazyColumn` in Jetpack Compose is the equivalent of `RecyclerView` in Android Views.

`LazyColumn` has a [DSL](https://developer.android.com/jetpack/compose/kotlin#dsl) to describe its list content. You will use `items`, which can take a number as list size. It also supports arrays and lists (read more in the [Lists documentation section](https://developer.android.com/jetpack/compose/lists)).

```
@Composable
fun LazyList() {
    // We save the scrolling position with this state that can also 
    // be used to programmatically scroll the list
    val scrollState = rememberLazyListState()

    LazyColumn(state = scrollState) {
        items(100) {
            Text("Item #$it")
        }
    }
}
```

## ![931742d3086b49f9.gif](https://developer.android.com/codelabs/jetpack-compose-layouts/img/931742d3086b49f9.gif)

## Displaying images

As we've seen earlier with the `PhotographCard`, `Image` is a composable that you can use to display a [Bitmap](https://developer.android.com/reference/android/graphics/Bitmap) or a vector image. If the image is fetched remotely, the process involves more steps as your app needs to download the asset, decode it to a bitmap, and finally render it within an `Image`.

To simplify those steps, you will use the [Coil](https://github.com/coil-kt/coil) library, which provides composables that run these tasks efficiently.

**Note:** While we use [Coil](https://github.com/coil-kt/coil) in the code sample below, you can choose [Glide](https://bumptech.github.io/glide/) via an [Accompanist wrapper](https://google.github.io/accompanist/glide/) if you prefer.

Add the Coil dependency in your project's `build.gradle` file:

```
// build.gradle
implementation 'io.coil-kt:coil-compose:1.3.0'
```

As we will be fetching a remote image, add the `INTERNET` permission to your manifest file:

```
<!-- AndroidManifest.xml -->
<uses-permission android:name="android.permission.INTERNET" />
```

Now, create an item composable where you will display an image with the item index next to it:

```
@Composable
fun ImageListItem(index: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {

        Image(
            painter = rememberImagePainter(
                data = "https://developer.android.com/images/brand/Android_Robot.png"
            ),
            contentDescription = "Android Logo",
            modifier = Modifier.size(50.dp)
        )
        Spacer(Modifier.width(10.dp))
        Text("Item #$index", style = MaterialTheme.typography.subtitle1)
    }
}
```

Next, swap the `Text` composable in your list with this `ImageListItem`:

```
@Composable
fun ImageList() {
    // We save the scrolling position with this state
    val scrollState = rememberLazyListState()

    LazyColumn(state = scrollState) {
        items(100) {
            ImageListItem(it)
        }
    }
}
```

## ![d1cffa197a8479d6.gif](https://developer.android.com/codelabs/jetpack-compose-layouts/img/d1cffa197a8479d6.gif)

## List scrolling

Now let's control manually the scrolling position of the list. We will add two buttons that allow us to smoothly scroll to the top and bottom of the list. To avoid blocking the list rendering while we scroll, the scrolling APIs are suspend functions. Therefore, we'll need to call them in a coroutine. To do so, we can create a [`CoroutineScope`](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines/-coroutine-scope/) using the [`rememberCoroutineScope`](https://developer.android.com/reference/kotlin/androidx/compose/runtime/package-summary#rememberCoroutineScope(kotlin.Function0)) function to create coroutines from the button event handlers. This `CoroutineScope` will follow the lifecycle of the call site. For more information about composable lifecycles, coroutines, and side effects, check out this [guide](https://developer.android.com/jetpack/compose/lifecycle).

```
val listSize = 100
// We save the scrolling position with this state
val scrollState = rememberLazyListState()
// We save the coroutine scope where our animated scroll will be executed
val coroutineScope = rememberCoroutineScope()
```

Finally we add our buttons that will control the scroll:

```
Row {
    Button(onClick = {
        coroutineScope.launch {
            // 0 is the first item index
            scrollState.animateScrollToItem(0)
        }
    }) {
        Text("Scroll to the top")
    }

    Button(onClick = {
        coroutineScope.launch {
            // listSize - 1 is the last index of the list
            scrollState.animateScrollToItem(listSize - 1)
        }
    }) {
        Text("Scroll to the end")
    }
}
```

![59d4da7b7c982ffa.gif](https://developer.android.com/codelabs/jetpack-compose-layouts/img/59d4da7b7c982ffa.gif)

## Full code for this section

```
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import kotlinx.coroutines.launch

@Composable
fun ImageListItem(index: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = rememberImagePainter(
                data = "https://developer.android.com/images/brand/Android_Robot.png"
            ),
            contentDescription = "Android Logo",
            modifier = Modifier.size(50.dp)
        )
        Spacer(Modifier.width(10.dp))
        Text("Item #$index", style = MaterialTheme.typography.subtitle1)
    }
}

@Composable
fun ScrollingList() {
    val listSize = 100
    // We save the scrolling position with this state
    val scrollState = rememberLazyListState()
    // We save the coroutine scope where our animated scroll will be executed
    val coroutineScope = rememberCoroutineScope()

    Column {
        Row {
            Button(onClick = {
                coroutineScope.launch {
                    // 0 is the first item index
                    scrollState.animateScrollToItem(0)
                }
            }) {
                Text("Scroll to the top")
            }

            Button(onClick = {
                coroutineScope.launch {
                    // listSize - 1 is the last index of the list
                    scrollState.animateScrollToItem(listSize - 1)
                }
            }) {
                Text("Scroll to the end")
            }
        }

        LazyColumn(state = scrollState) {
            items(listSize) {
                ImageListItem(it)
            }
        }
    }
}
```



## [7. Create your custom layout](https://developer.android.com/codelabs/jetpack-compose-layouts?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-layouts#6)

Compose promotes reusability of composables as small chunks that can be enough for some custom layouts by combining built-in composables such as `Column`, `Row`, or `Box`.

However, you might need to build something unique to your app that requires measuring and laying out children manually. For that, you can use the [`Layout`](https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main-release:compose/ui/ui/src/commonMain/kotlin/androidx/compose/ui/layout/Layout.kt) composable. In fact all higher level layouts like `Column` and `Row` are built with this.

**Note:** In the View system, creating a custom layout required extending `ViewGroup` and implementing measure and layout functions. In Compose you simply write a function using the `Layout` composable.

Before diving into how to create custom layouts, we need to know more about the principles of Layouts in Compose.

## Principles of layouts in Compose

Some composable functions emit a piece of UI when invoked that is added to a UI tree that will get rendered on the screen. Each emission (or element) has one parent and potentially many children. Also, it has a location within its parent: an (x, y) position, and a size: a `width` and `height`.

Elements are asked to measure themselves with Constraints that should be satisfied. Constraints restrict the minimum and maximum `width` and `height` of an element. If an element has child elements it may measure each of them to help determine its own size. Once an element reports its own size, it has an opportunity to place its child elements relative to itself. This will be further explained when creating the custom layout.

**Compose UI does not permit multi-pass measurement**. This means that a layout element may not measure any of its children more than once in order to try different measurement configurations. Single-pass measurement is good for performance, allowing Compose to handle efficiently deep UI trees. If a layout element measured its child twice and that child measured one of its children twice and so on, a single attempt to lay out a whole UI would have to do a lot of work, making it hard to keep your app performing well. However, there are times when you really need additional information on top of what a single child measurement would tell you - for these cases there are ways of doing this, we will talk about them later.

## Using the layout modifier

Use the `layout` modifier to manually control how to measure and position an element. Usually, the common structure of a custom `layout` modifier is as follows:

```
fun Modifier.customLayoutModifier(...) = Modifier.layout { measurable, constraints ->
  ...
})
```

When using the `layout` modifier, you get two lambda parameters:

- `measurable`: child to be measured and placed
- `constraints`: minimum and maximum for the width and height of the child

Let's say you want to display a `Text` on the screen and control the distance from the top to the baseline of the first line of texts. In order to do that, you'd need to manually place the composable on the screen using the `layout` modifier. See the desired behavior in the next picture where the distance from top to first baseline is `24.dp`:

![4ee1054702073598.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/4ee1054702073598.png)

Let's create a `firstBaselineToTop` modifier first:

```
fun Modifier.firstBaselineToTop(
  firstBaselineToTop: Dp
) = this.then(
    layout { measurable, constraints ->
        ...
    }
)
```

The first thing to do is measure the composable. As we mentioned in the Principles of Layout in Compose section, **you can only measure your children once**.

Measure the composable by calling `measurable.measure(constraints)`. When calling `measure(constraints)`, you can pass in the given constraints of the composable available in the `constraints` lambda parameter or create your own. The result of a `measure()` call on a `Measurable` is a `Placeable` that can be positioned by calling `placeRelative(x, y)`, as we will do later.

For this use case, don't constrain measurement further, just use the given constraints:

```
fun Modifier.firstBaselineToTop(
    firstBaselineToTop: Dp
) = this.then(
    layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)

        ...
    }
)
```

Now that the composable has been measured, you need to calculate its size and specify it by calling the `layout(width, height)` method which also accepts a lambda used for placing the content.

In this case, the width of our composable will be the `width` of the measured composable and the height will be the composable's `height` with the desired top-to-baseline height minus the first baseline:

```
fun Modifier.firstBaselineToTop(
    firstBaselineToTop: Dp
) = this.then(
    layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)

        // Check the composable has a first baseline
        check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
        val firstBaseline = placeable[FirstBaseline]

        // Height of the composable with padding - first baseline
        val placeableY = firstBaselineToTop.roundToPx() - firstBaseline
        val height = placeable.height + placeableY
        layout(placeable.width, height) {
            ...
        }
    }
)
```

Now, you can position the composable on the screen by calling `placeable.placeRelative(x, y)`. If you don't call `placeRelative`, the composable won't be visible. `placeRelative` automatically adjusts the position of the placeable based on the current `layoutDirection`.

**Warning**: When creating a custom `Layout` or `LayoutModifier`, Android Studio will give a warning until the `layout` function is called.

In this case, the `y` position of the text corresponds to the top padding minus the position of the first baseline:

```
fun Modifier.firstBaselineToTop(
    firstBaselineToTop: Dp
) = this.then(
    layout { measurable, constraints ->
        ...

        // Height of the composable with padding - first baseline
        val placeableY = firstBaselineToTop.roundToPx() - firstBaseline
        val height = placeable.height + placeableY
        layout(placeable.width, height) {
            // Where the composable gets placed
            placeable.placeRelative(0, placeableY)
        }
    }
)
```

To verify this works as expected, you can use this modifier on a `Text` as you saw in the picture above:

```
@Preview
@Composable
fun TextWithPaddingToBaselinePreview() {
  LayoutsCodelabTheme {
    Text("Hi there!", Modifier.firstBaselineToTop(32.dp))
  }
}

@Preview
@Composable
fun TextWithNormalPaddingPreview() {
  LayoutsCodelabTheme {
    Text("Hi there!", Modifier.padding(top = 32.dp))
  }
}
```

With preview:

![dccb4473e2ca09c6.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/dccb4473e2ca09c6.png)

## Using the Layout composable

Instead of controlling how a single composable gets measured and laid out on the screen, you might have the same necessity for a group of composables. For that, you can use the [`Layout`](https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main-release:compose/ui/ui/src/commonMain/kotlin/androidx/compose/ui/layout/Layout.kt) composable to manually control how to measure and position the layout's children. Usually, the common structure of a composable that uses `Layout` is as follows:

```
@Composable
fun CustomLayout(
    modifier: Modifier = Modifier,
    // custom layout attributes 
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        // measure and position children given constraints logic here
    }
}
```

The minimum required parameters for a `CustomLayout` are a `modifier` and `content`; these parameters are then passed to `Layout`. In the trailing lambda of `Layout` (of type `MeasurePolicy`), you get the same lambda parameters as you get with the `layout` modifier.

To show `Layout` in action, let's start implementing a very basic `Column` using `Layout` to understand the API. Later, we'll build something more complex to showcase flexibility of the `Layout` composable.

## Implementing a basic Column

Our custom implementation of `Column` **lays out items vertically**. Also, for simplicity, our layout **occupies as much space as it can in its parent**.

Create a new composable called `MyOwnColumn` and add the common structure of a `Layout` composable:

```
@Composable
fun MyOwnColumn(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        // measure and position children given constraints logic here
    }
}
```

As before, the first thing to do is measure our children that can only be measured once. Similarly to how the layout modifier works, in the `measurables` lambda parameter, you get all the `content` that you can measure by calling `measurable.measure(constraints)`.

For this use case, you won't constrain our child views further. When measuring the children, you should also keep track of the `width` and the maximum `height` of each row to be able to place them correctly on the screen later:

```
@Composable
fun MyOwnColumn(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->

        // Don't constrain child views further, measure them with given constraints
        // List of measured children
        val placeables = measurables.map { measurable ->
            // Measure each child
            measurable.measure(constraints)
        }
    }
}
```

Now that you have the list of measured children in our logic, before positioning them on the screen, you need to calculate the size of our version of `Column`. As you're making it as big as its parent, the size of it is the constraints passed in by the parent. Specify the size of our own `Column` by calling the `layout(width, height)` method, which also gives you the lambda used for placing the children:

```
@Composable
fun MyOwnColumn(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        // Measure children - code in the previous code snippet
        ...

        // Set the size of the layout as big as it can
        layout(constraints.maxWidth, constraints.maxHeight) {
            // Place children
        }
    }
}
```

Lastly, we position our children on the screen by calling `placeable.placeRelative(x, y)`. In order to place the children vertically, we keep track of the `y` coordinate we have placed children up to. The final code of `MyOwnColumn` looks like this:

```
@Composable
fun MyOwnColumn(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        // Don't constrain child views further, measure them with given constraints
        // List of measured children
        val placeables = measurables.map { measurable ->
            // Measure each child
            measurable.measure(constraints)
        }

        // Track the y co-ord we have placed children up to
        var yPosition = 0

        // Set the size of the layout as big as it can
        layout(constraints.maxWidth, constraints.maxHeight) {
            // Place children in the parent layout
            placeables.forEach { placeable ->
                // Position item on the screen
                placeable.placeRelative(x = 0, y = yPosition)

                // Record the y co-ord placed up to
                yPosition += placeable.height
            }
        }
    }
}
```

## MyOwnColumn in action

Let's see `MyOwnColumn` on the screen by using it in the `BodyContent` composable. Replace the content inside BodyContent with the following:

```
@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    MyOwnColumn(modifier.padding(8.dp)) {
        Text("MyOwnColumn")
        Text("places items")
        Text("vertically.")
        Text("We've done it by hand!")
    }
}
```

With preview:

![e69cdb015e4d8abe.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/e69cdb015e4d8abe.png)



## [8. Complex custom layout](https://developer.android.com/codelabs/jetpack-compose-layouts?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-layouts#7)

Once the basics of `Layout` are covered. Let's create a more complex example to showcase the flexibility of the API. We'll build the custom [Material Study Owl](https://material.io/design/material-studies/owl.html)'s staggered grid that you can see in the middle of the following picture:

![7a54fe8390fe39d2.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/7a54fe8390fe39d2.png)

Owl's staggered grid lays out items vertically, filled out a column at a time given a `n` number of rows. Doing this with a `Row` of `Columns` is not possible since you wouldn't get the staggering of the layout. Having a `Column` of `Rows` could be possible if you prepare the data so that it displays vertically.

However, the custom layout also gives you the opportunity to constrain the height of all the items in the staggered grid. So to have more control over the layout and learn how to create a custom one, we'll measure and position the children on our own.

If we wanted to make the grid reusable on different orientations, we could take as a parameter the number of rows we want to have on the screen. Since that information should come when the layout is invoked, we pass it as a parameter:

```
@Composable
fun StaggeredGrid(
    modifier: Modifier = Modifier,
    rows: Int = 3,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        // measure and position children given constraints logic here
    }
}
```

As before, the first thing to do is measure our children. Remember **you can only measure your children once**.

For our use case, we won't constrain our child views further. When measuring our children, we should also keep track of what's the `width` and the max `height` of each row:

```
Layout(
    modifier = modifier,
    content = content
) { measurables, constraints ->

    // Keep track of the width of each row
    val rowWidths = IntArray(rows) { 0 }

    // Keep track of the max height of each row
    val rowHeights = IntArray(rows) { 0 }

    // Don't constrain child views further, measure them with given constraints
    // List of measured children
    val placeables = measurables.mapIndexed { index, measurable ->

        // Measure each child
        val placeable = measurable.measure(constraints)

        // Track the width and max height of each row
        val row = index % rows
        rowWidths[row] += placeable.width
        rowHeights[row] = max(rowHeights[row], placeable.height)

        placeable
    }
    ...
}
```

Now that we have the list of measured children in our logic, before positioning them on the screen, we need to calculate the size of our grid (full `width` and `height`) . Also, since we already know the maximum height of each row, we can calculate where we'll position the elements for each row in the Y position. We save the Y positions in the `rowY` variable:

```
Layout(
    content = content,
    modifier = modifier
) { measurables, constraints ->
    ... 

    // Grid's width is the widest row
    val width = rowWidths.maxOrNull()
        ?.coerceIn(constraints.minWidth.rangeTo(constraints.maxWidth)) ?: constraints.minWidth

    // Grid's height is the sum of the tallest element of each row
    // coerced to the height constraints 
    val height = rowHeights.sumOf { it }
        .coerceIn(constraints.minHeight.rangeTo(constraints.maxHeight))

    // Y of each row, based on the height accumulation of previous rows
    val rowY = IntArray(rows) { 0 }
    for (i in 1 until rows) {
        rowY[i] = rowY[i-1] + rowHeights[i-1]
    }

    ...
}
```

Lastly, we position our children on the screen by calling `placeable.placeRelative(x, y)`. In our use case, we also keep track of the X coordinate for each row in the `rowX` variable:

```
Layout(
    content = content,
    modifier = modifier
) { measurables, constraints ->
    ... 

    // Set the size of the parent layout
    layout(width, height) {
        // x cord we have placed up to, per row
        val rowX = IntArray(rows) { 0 }

        placeables.forEachIndexed { index, placeable ->
            val row = index % rows
            placeable.placeRelative(
                x = rowX[row],
                y = rowY[row]
            )
            rowX[row] += placeable.width
        }
    }
}
```

## Using the custom StaggeredGrid in an example

Now that we have our custom grid layout that knows how to measure and position children, let's use it in our app. To simulate Owl's chips in the grid, we can easily create a composable that does something similar:

```
@Composable
fun Chip(modifier: Modifier = Modifier, text: String) {
    Card(
        modifier = modifier,
        border = BorderStroke(color = Color.Black, width = Dp.Hairline),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(start = 8.dp, top = 4.dp, end = 8.dp, bottom = 4.dp), 
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.size(16.dp, 16.dp)
                    .background(color = MaterialTheme.colors.secondary)
            )
            Spacer(Modifier.width(4.dp))
            Text(text = text)
        }
    }
}

@Preview
@Composable
fun ChipPreview() {
    LayoutsCodelabTheme {
        Chip(text = "Hi there")
    }
}
```

With preview:

![f1f8c6bb7f12cf1.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/f1f8c6bb7f12cf1.png)

Now, let's create a list of topics that we can show in our `BodyContent` and display them in the `StaggeredGrid`:

```
val topics = listOf(
    "Arts & Crafts", "Beauty", "Books", "Business", "Comics", "Culinary",
    "Design", "Fashion", "Film", "History", "Maths", "Music", "People", "Philosophy",
    "Religion", "Social sciences", "Technology", "TV", "Writing"
)


@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    StaggeredGrid(modifier = modifier) {
        for (topic in topics) {
            Chip(modifier = Modifier.padding(8.dp), text = topic)
        }
    }
}

@Preview
@Composable
fun LayoutsCodelabPreview() {
    LayoutsCodelabTheme {
        BodyContent()
    }
}
```

With preview:

![e9861768e4e27dd4.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/e9861768e4e27dd4.png)

Notice that we can change the number of rows of our grid and it still works as expected:

```
@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    StaggeredGrid(modifier = modifier, rows = 5) {
        for (topic in topics) {
            Chip(modifier = Modifier.padding(8.dp), text = topic)
        }
    }
}
```

With preview:

![555f88fd41e4dff4.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/555f88fd41e4dff4.png)

As depending on the number of rows, our topics can go off the screen, we can make our `BodyContent` scrollable by just wrapping the `StaggeredGrid` in a scrollable `Row` and passing the modifier to it instead of `StaggeredGrid`.

```
@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    Row(modifier = modifier.horizontalScroll(rememberScrollState())) {
        StaggeredGrid {
            for (topic in topics) {
                Chip(modifier = Modifier.padding(8.dp), text = topic)
            }
        }
    }
}
```

If you use the Interactive Preview button ![bb4c8dfe4b8debaa.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/bb4c8dfe4b8debaa.png)or run the app on the device by tapping on the Android Studio run button, you'll see how you can scroll the content horizontally.

## [9. Layout modifiers under the hood](https://developer.android.com/codelabs/jetpack-compose-layouts?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-layouts#8)

Now that we know the basics of modifiers, how to create custom composables and measure and position children manually, we'll better understand how modifiers work under the hood.

As a recap, modifiers allow you to customize the behavior of a composable. You can combine multiple modifiers by chaining them together. There are multiple types of modifiers, but in this section, we'll focus on [`LayoutModifier`](https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main-release:compose/ui/ui/src/commonMain/kotlin/androidx/compose/ui/layout/LayoutModifier.kt)s since they can change the way a UI component is measured and laid out.

Composables are responsible for their own content and that content may not be inspected or manipulated by a parent unless that composables's author exposes an explicit API to do so. Similarly, modifiers of a composable decorate what they modify in the same opaque way: modifiers are encapsulated.

## Analysing a modifier

Since `Modifier` and `LayoutModifier` are public interfaces, you can create your own modifiers. As we used `Modifier.padding` before, let's analyse its implementation to understand modifiers better.

[`padding`](https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main-release:compose/foundation/foundation-layout/src/commonMain/kotlin/androidx/compose/foundation/layout/Padding.kt) is a function that is backed up by a class that implements the `LayoutModifier` interface and it's going to override the `measure` method. `PaddingModifier` is a regular class that implements `equals()` so the modifier can be compared across recompositions.

As an example, here's the source code of how `padding` modifies the size and constraints of the element is applied on:

```
// How to create a modifier
@Stable
fun Modifier.padding(all: Dp) =
    this.then(
        PaddingModifier(start = all, top = all, end = all, bottom = all, rtlAware = true)
    )

// Implementation detail
private class PaddingModifier(
    val start: Dp = 0.dp,
    val top: Dp = 0.dp,
    val end: Dp = 0.dp,
    val bottom: Dp = 0.dp,
    val rtlAware: Boolean,
) : LayoutModifier {

    override fun MeasureScope.measure(
        measurable: Measurable,
        constraints: Constraints
    ): MeasureResult {

        val horizontal = start.roundToPx() + end.roundToPx()
        val vertical = top.roundToPx() + bottom.roundToPx()

        val placeable = measurable.measure(constraints.offset(-horizontal, -vertical))

        val width = constraints.constrainWidth(placeable.width + horizontal)
        val height = constraints.constrainHeight(placeable.height + vertical)
        return layout(width, height) {
            if (rtlAware) {
                placeable.placeRelative(start.roundToPx(), top.roundToPx())
            } else {
                placeable.place(start.roundToPx(), top.roundToPx())
            }
        }
    }
}
```

The new `width` of the element will be the `width` of the child + the start and end padding values coerced to the element's width constraints. The `height` will be the `height` of the child + the top and bottom padding values coerced to the element's height constraints.

## Order matters

As you saw in the first section, **order matters when chaining modifiers** as they're applied to the composable they modify from earlier to later, meaning that the measurement and layout of the modifiers on the left will affect the modifier on the right. The final size of the composable depends on all modifiers passed as a parameter.

First, modifiers will **update the constraints from left to right**, and then, they **return back the size from right to left**. Let's see this better with an example:

```
@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .background(color = Color.LightGray)
            .size(200.dp)
            .padding(16.dp)
            .horizontalScroll(rememberScrollState())
    ) {
        StaggeredGrid {
            for (topic in topics) {
                Chip(modifier = Modifier.padding(8.dp), text = topic)
            }
        }
    }
}
```

The modifiers applied in this way produce this preview:

![cb209bb5edf634d6.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/cb209bb5edf634d6.png)

First, we change the background to see how modifiers affect the UI, then we restrict the size to have `200.dp` `width` and `height`, and lastly, we apply padding to add some space between the text and the surroundings.

Because the constraints are propagated through the chain from left to right, the constraints with which the content of the `Row` to be measured are `(200-16-16)=168` dp for both minimum and maximum `width` and `height`. This means that the size of the `StaggeredGrid` will be exactly `168x168` dp. Therefore, the final size of the scrollable `Row`, after the `modifySize` chain is run from right to left, will be `200x200` dp.

If we change the order of the modifiers, to apply first the padding and then the size, we get a different UI:

```
@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .background(color = Color.LightGray, shape = RectangleShape)
            .padding(16.dp)
            .size(200.dp)
            .horizontalScroll(rememberScrollState())
    ) {
        StaggeredGrid {
            for (topic in topics) {
                Chip(modifier = Modifier.padding(8.dp), text = topic)
            }
        }
    }
}
```

With preview:

![17da5805d6d8fc91.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/17da5805d6d8fc91.png)

In this case, the constraints that the scrollable `Row` and `padding` had originally will be coerced to the `size` constraints to measure the children. Therefore, the `StaggeredGrid` will be constrained to `200` dp for both minimum and maximum `width` and `height`. The `StaggeredGrid` size is `200x200` dp and as the size is modified from right to left, the `padding` modifier will increment the size to `(200+16+16)x(200+16+16)=232x232` that will be the final size of the `Row` as well.

## Layout direction

You can change the layout direction of a composable using the `LayoutDirection` ambient.

If you're placing composables manually on the screen, the `layoutDirection` is part of the `LayoutScope` of the `layout` modifier or `Layout` composable. When using `layoutDirection`, place composables using `place` as unlike the `placeRelative` method, it won't automatically mirror the position in right-to-left context.

## Full code for this section

```
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.codelab.layouts.ui.LayoutsCodelabTheme
import kotlin.math.max

val topics = listOf(
    "Arts & Crafts", "Beauty", "Books", "Business", "Comics", "Culinary",
    "Design", "Fashion", "Film", "History", "Maths", "Music", "People", "Philosophy",
    "Religion", "Social sciences", "Technology", "TV", "Writing"
)

@Composable
fun LayoutsCodelab() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "LayoutsCodelab")
                },
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(Icons.Filled.Favorite, contentDescription = null)
                    }
                }
            )
        }
    ) { innerPadding ->
        BodyContent(Modifier.padding(innerPadding))
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    Row(modifier = modifier
        .background(color = Color.LightGray)
        .padding(16.dp)
        .size(200.dp)
        .horizontalScroll(rememberScrollState()),
        content = {
            StaggeredGrid {
                for (topic in topics) {
                    Chip(modifier = Modifier.padding(8.dp), text = topic)
                }
            }
        })
}

@Composable
fun StaggeredGrid(
    modifier: Modifier = Modifier,
    rows: Int = 3,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->

        // Keep track of the width of each row
        val rowWidths = IntArray(rows) { 0 }

        // Keep track of the max height of each row
        val rowHeights = IntArray(rows) { 0 }

        // Don't constrain child views further, measure them with given constraints
        // List of measured children
        val placeables = measurables.mapIndexed { index, measurable ->
            // Measure each child
            val placeable = measurable.measure(constraints)

            // Track the width and max height of each row
            val row = index % rows
            rowWidths[row] += placeable.width
            rowHeights[row] = max(rowHeights[row], placeable.height)

            placeable
        }

        // Grid's width is the widest row
        val width = rowWidths.maxOrNull()
            ?.coerceIn(constraints.minWidth.rangeTo(constraints.maxWidth)) ?: constraints.minWidth

        // Grid's height is the sum of the tallest element of each row
        // coerced to the height constraints
        val height = rowHeights.sumOf { it }
            .coerceIn(constraints.minHeight.rangeTo(constraints.maxHeight))

        // Y of each row, based on the height accumulation of previous rows
        val rowY = IntArray(rows) { 0 }
        for (i in 1 until rows) {
            rowY[i] = rowY[i - 1] + rowHeights[i - 1]
        }

        // Set the size of the parent layout
        layout(width, height) {
            // x co-ord we have placed up to, per row
            val rowX = IntArray(rows) { 0 }

            placeables.forEachIndexed { index, placeable ->
                val row = index % rows
                placeable.placeRelative(
                    x = rowX[row],
                    y = rowY[row]
                )
                rowX[row] += placeable.width
            }
        }
    }
}

@Composable
fun Chip(modifier: Modifier = Modifier, text: String) {
    Card(
        modifier = modifier,
        border = BorderStroke(color = Color.Black, width = Dp.Hairline),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(start = 8.dp, top = 4.dp, end = 8.dp, bottom = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(16.dp, 16.dp)
                    .background(color = MaterialTheme.colors.secondary)
            )
            Spacer(Modifier.width(4.dp))
            Text(text = text)
        }
    }
}

@Preview
@Composable
fun ChipPreview() {
    LayoutsCodelabTheme {
        Chip(text = "Hi there")
    }
}

@Preview
@Composable
fun LayoutsCodelabPreview() {
    LayoutsCodelabTheme {
        LayoutsCodelab()
    }
}
```

## [10. Constraint Layout](https://developer.android.com/codelabs/jetpack-compose-layouts?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-layouts#9)

`ConstraintLayout` can help you place composables relative to others on the screen and is an alternative to using multiple `Row`s, `Column`s and `Box`es. ConstraintLayout is useful when implementing larger layouts with more complicated alignment requirements.

**Note:** In the View system, [`ConstraintLayout`](https://developer.android.com/training/constraint-layout) was the recommended way to create large and complex layouts as the flat view hierarchy was better for performance. However, this is not a concern in Compose, which is able to efficiently handle deep layout hierarchies.

You can find the Compose Constraint Layout dependency in your project's `build.gradle` file:

```
// build.gradle
implementation "androidx.constraintlayout:constraintlayout-compose:1.0.0-alpha07"
```

`ConstraintLayout` in Compose works with a [DSL](https://kotlinlang.org/docs/reference/type-safe-builders.html):

- References are created using `createRefs()` (or `createRef()`) and each composable in `ConstraintLayout` needs to have a reference associated.
- Constraints are provided using the `constrainAs` modifier which takes the reference as a parameter and lets you specify its constraints in the body lambda.
- Constraints are specified using `linkTo` or other helpful methods.
- `parent` is an existing reference that can be used to specify constraints towards the `ConstraintLayout` composable itself.

Let's start with a simple example:

```
@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout {

        // Create references for the composables to constrain
        val (button, text) = createRefs()

        Button(
            onClick = { /* Do something */ },
            // Assign reference "button" to the Button composable
            // and constrain it to the top of the ConstraintLayout
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = 16.dp)
            }
        ) {
            Text("Button")
        }

        // Assign reference "text" to the Text composable
        // and constrain it to the bottom of the Button composable
        Text("Text", Modifier.constrainAs(text) {
            top.linkTo(button.bottom, margin = 16.dp)
        })
    }
}

@Preview
@Composable
fun ConstraintLayoutContentPreview() {
    LayoutsCodelabTheme {
        ConstraintLayoutContent()
    }
}
```

This constrains the top of the `Button` to the parent with a margin of `16.dp` and a `Text` to the bottom of the `Button` also with a margin of `16.dp`.

![72fcb81ab2c0483c.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/72fcb81ab2c0483c.png)

If we wanted to center the text horizontally, we can use the `centerHorizontallyTo` function that sets both the `start` and `end` of the `Text` to the edges of the `parent`:

```
@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout {
        ... // Same as before

        Text("Text", Modifier.constrainAs(text) {
            top.linkTo(button.bottom, margin = 16.dp)
            // Centers Text horizontally in the ConstraintLayout
            centerHorizontallyTo(parent)
        })
    }
}
```

With preview:

![729a1b4c03f1f187.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/729a1b4c03f1f187.png)

`ConstraintLayout`'s size will be as small as possible to wrap its content. That's why it seems `Text` is centered around the `Button` instead of the parent. If other sizing behavior is desired, sizing modifiers (e.g. `fillMaxSize`, `size`) should be applied to the `ConstraintLayout` composable as with any other layout in Compose.

## Helpers

The DSL also supports creating guidelines, barriers and chains. For example:

```
@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout {
        // Creates references for the three composables
        // in the ConstraintLayout's body
        val (button1, button2, text) = createRefs()

        Button(
            onClick = { /* Do something */ },
            modifier = Modifier.constrainAs(button1) {
                top.linkTo(parent.top, margin = 16.dp)
            }
        ) { 
            Text("Button 1") 
        }

        Text("Text", Modifier.constrainAs(text) {
            top.linkTo(button1.bottom, margin = 16.dp)
            centerAround(button1.end)
        })

        val barrier = createEndBarrier(button1, text)
        Button(
            onClick = { /* Do something */ },
            modifier = Modifier.constrainAs(button2) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(barrier)
            }
        ) { 
            Text("Button 2") 
        }
    }
}
```

With preview:

![a4117576ef1768a2.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/a4117576ef1768a2.png)

Note that

- barriers (and all the other helpers) can be created in the body of `ConstraintLayout`, but not inside `constrainAs`.
- `linkTo` can be used to constrain with guidelines and barriers the same way it works for edges of layouts.

## Customizing dimensions

By default, the children of `ConstraintLayout` will be allowed to choose the size they need to wrap their content. For example, this means that a Text is able to go outside the screen bounds when the text is too long:

```
@Composable
fun LargeConstraintLayout() {
    ConstraintLayout {
        val text = createRef()

        val guideline = createGuidelineFromStart(fraction = 0.5f)
        Text(
            "This is a very very very very very very very long text",
            Modifier.constrainAs(text) {
                linkTo(start = guideline, end = parent.end)
            }
        )
    }
}

@Preview
@Composable
fun LargeConstraintLayoutPreview() {
    LayoutsCodelabTheme {
        LargeConstraintLayout()
    }
}
```

![616c19b971811cfa.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/616c19b971811cfa.png)

Obviously, you'd like the text to line break in the available space. To achieve this, we can change the `width` behavior of the text:

```
@Composable
fun LargeConstraintLayout() {
    ConstraintLayout {
        val text = createRef()

        val guideline = createGuidelineFromStart(0.5f)
        Text(
            "This is a very very very very very very very long text",
            Modifier.constrainAs(text) {
                linkTo(guideline, parent.end)
                width = Dimension.preferredWrapContent
            }
        )
    }
}
```

With preview:

![fc41cacd547bbea.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/fc41cacd547bbea.png)

Available `Dimension` behaviors are:

- `preferredWrapContent` - the layout is wrap content, subject to the constraints in that dimension.
- `wrapContent` - the layout is wrap content even if the constraints would not allow it.
- `fillToConstraints` - the layout will expand to fill the space defined by its constraints in that dimension.
- `preferredValue` - the layout is a fixed dp value, subject to the constraints in that dimension.
- `value` - the layout is a fixed dp value, regardless of the constraints in that dimension

Also, certain `Dimension`s can be coerced:

```
width = Dimension.preferredWrapContent.atLeast(100.dp)
```

## Decoupled API

So far, in the examples, constraints have been specified inline, with a modifier in the composable they're applied to. However, there are cases when keeping the constraints decoupled from the layouts they apply to is valuable: the common example is for easily changing the constraints based on the screen configuration or animating between 2 constraint sets.

For these cases, you can use `ConstraintLayout` in a different way:

1. Pass in a `ConstraintSet` as a parameter to `ConstraintLayout`.
2. Assign references created in the `ConstraintSet` to composables using the `layoutId` modifier.

This API shape applied to the first `ConstraintLayout` example shown above, optimized for the width of the screen, looks like this:

```
@Composable
fun DecoupledConstraintLayout() {
    BoxWithConstraints {
        val constraints = if (maxWidth < maxHeight) {
            decoupledConstraints(margin = 16.dp) // Portrait constraints
        } else {
            decoupledConstraints(margin = 32.dp) // Landscape constraints
        }

        ConstraintLayout(constraints) {
            Button(
                onClick = { /* Do something */ },
                modifier = Modifier.layoutId("button")
            ) {
                Text("Button")
            }

            Text("Text", Modifier.layoutId("text"))
        }
    }
}

private fun decoupledConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val button = createRefFor("button")
        val text = createRefFor("text")

        constrain(button) {
            top.linkTo(parent.top, margin= margin)
        }
        constrain(text) {
            top.linkTo(button.bottom, margin)
        }
    }
}
```



## [11. Intrinsics](https://developer.android.com/codelabs/jetpack-compose-layouts?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-layouts#10)

One of the rules of Compose is that you should only measure your children once; measuring children twice throws a runtime exception. However, there are times when you need some information about your children before measuring them.

**Intrinsics lets you query children before they're actually measured**.

To a composable, you can ask for its `intrinsicWidth` or `intrinsicHeight`:

- `(min|max)IntrinsicWidth`: Given this height, what's the minimum/maximum width you can paint your content properly.
- `(min|max)IntrinsicHeight`: Given this width, what's the minimum/maximum height you can paint your content properly.

For example, if you ask the `minIntrinsicHeight` of a `Text` with infinite `width`, it'll return the `height` of the `Text` as if the text was drawn in a single line.

## Intrinsics in action

Imagine that we want to create a composable that displays two texts on the screen separated by a divider like this:

![835f0b8c9f07cd9.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/835f0b8c9f07cd9.png)

How can we do this? We can have a `Row` with two `Text`s inside that expands as much as they can and a `Divider` in the middle. We want the Divider to be as tall as the tallest `Text` and thin (`width = 1.dp`).

```
@Composable
fun TwoTexts(modifier: Modifier = Modifier, text1: String, text2: String) {
    Row(modifier = modifier) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 4.dp)
                .wrapContentWidth(Alignment.Start),
            text = text1
        )

        Divider(color = Color.Black, modifier = Modifier.fillMaxHeight().width(1.dp))
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(end = 4.dp)
                .wrapContentWidth(Alignment.End),

            text = text2
        )
    }
}

@Preview
@Composable
fun TwoTextsPreview() {
    LayoutsCodelabTheme {
        Surface {
            TwoTexts(text1 = "Hi", text2 = "there")
        }
    }
}
```

If we preview this, we see that the Divider expands to the whole screen and that's not what we want:

![d61f179394ded825.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/d61f179394ded825.png)

This happens because `Row` measures each child individually and the height of `Text` cannot be used to constraint the `Divider`. We want the `Divider` to fill the available space with a given height. For that, we can use the `height(IntrinsicSize.Min)` modifier .

`height(IntrinsicSize.Min)` sizes its children being forced to be as tall as their minimum intrinsic height. As it's recursive, it'll query `Row` and its children `minIntrinsicHeight`.

Applying that to our code, it'll work as expected

```
@Composable
fun TwoTexts(modifier: Modifier = Modifier, text1: String, text2: String) {
    Row(modifier = modifier.height(IntrinsicSize.Min)) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 4.dp)
                .wrapContentWidth(Alignment.Start),
            text = text1
        )

        Divider(color = Color.Black, modifier = Modifier.fillMaxHeight().width(1.dp))
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(end = 4.dp)
                .wrapContentWidth(Alignment.End),
            text = text2
        )
    }
}

@Preview
@Composable
fun TwoTextsPreview() {
    LayoutsCodelabTheme {
        Surface {
            TwoTexts(text1 = "Hi", text2 = "there")
        }
    }
}
```

With preview:

![835f0b8c9f07cd9.png](https://developer.android.com/codelabs/jetpack-compose-layouts/img/835f0b8c9f07cd9.png)

Row's `minIntrinsicHeight` will be the maximum `minIntrinsicHeight` of its children. Divider's `minIntrinsicHeight` is 0 as it doesn't occupy space if no constraints are given; Text's `minIntrinsicHeight` will be that of the text given a specific `width`. Therefore, Row's `height` constraint will be the max `minIntrinsicHeight` of the `Text`s. `Divider` will then expand its `height` to the `height` constraint given by Row.

## DIY

Whenever you are creating your custom layout, you can modify how intrinsics are calculated with the `(min|max)Intrinsic(Width|Height)MeasurePolicy` [parameters](https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main-release:compose/ui/ui/src/commonMain/kotlin/androidx/compose/ui/layout/Layout.kt); however, the defaults should be enough most of the time.

Also, you can modify intrinsics with modifiers overriding the `Density.(min|max)Intrinsic(Width|Height)Of` methods of the [Modifier](https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main-release:compose/ui/ui/src/commonMain/kotlin/androidx/compose/ui/layout/LayoutModifier.kt) interface which also have a good default.

## [12. Congratulations](https://developer.android.com/codelabs/jetpack-compose-layouts?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-layouts#11)

Congratulations, you've successfully completed this codelab!

## Solution to the codelab

You can get the code for the solution of this codelab from GitHub:

```
$ git clone https://github.com/googlecodelabs/android-compose-codelabs
```