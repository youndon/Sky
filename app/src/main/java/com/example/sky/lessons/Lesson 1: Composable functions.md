## Lesson 1: Composable functions

Jetpack Compose is built around composable functions. These functions let you define your app's UI programmatically by describing how it should look and providing data dependencies, rather than focusing on the process of the UI's construction (initializing an element, attaching it to a parent, etc.). To create a composable function, just add the `@Composable` annotation to the function name.

![img](https://developer.android.com/images/jetpack/compose-tutorial/lesson1-01.svg)

#### Add a text element

To begin, download the most recent version of [Android Studio Arctic Fox](https://developer.android.com/studio), and create an app using the Empty Compose Activity template. The default template already contains some Compose elements, but let's build it up step by step.

First, we’ll display a “Hello world!” text by adding a text element inside the `onCreate` method. You do this by defining a content block, and calling the `Text()` function. The `setContent` block defines the activity's layout where we call composable functions. Composable functions can only be called from other composable functions.

Jetpack Compose uses a Kotlin compiler plugin to transform these composable functions into the app's UI elements. For example, the `Text()` function that is defined by the Compose UI library displays a text label on the screen.

#### Define a composable function

To make a function composable, add the `@Composable` annotation. To try this out, define a `MessageCard()` function which is passed a name, and uses it to configure the text element.

#### Preview your function in Android Studio

[Android Studio](https://developer.android.com/studio) lets you preview your composable functions within the IDE, instead of installing the app to an Android device or emulator. The composable function must provide default values for any parameters. For this reason, you can't preview the `MessageCard()` function directly. Instead, let’s make a second function named `PreviewMessageCard()`, which calls `MessageCard()` with an appropriate parameter. Add the `@Preview` annotation before `@Composable`.

Rebuild your project. The app itself doesn't change, since the new `PreviewMessageCard()` function isn't called anywhere, but Android Studio adds a preview window. This window shows a preview of the UI elements created by composable functions marked with the `@Preview` annotation. To update the previews at any time, click the refresh button at the top of the preview window.

<img src="https://developer.android.com/images/jetpack/compose-tutorial/lesson1-03.png" alt="img" style="zoom:25%;" />

![img](https://developer.android.com/images/jetpack/compose-tutorial/lesson1-04.png)

**Figure 1.** Using Android Studio to preview your composable functions.



## Lesson 2: Layouts

UI elements are hierarchical, with elements contained in other elements. In Compose, you build a UI hierarchy by calling composable functions from other composable functions.

![img](https://developer.android.com/images/jetpack/compose-tutorial/lesson2-01.svg)

#### Add multiple texts

So far we’ve built our first composable function and preview! To discover more Jetpack Compose capabilities, we’re going to build a simple messaging screen containing a list of messages that can be expanded with some animations.
Let’s start by making our message composable richer by displaying the name of its author and a message content. We need first to change our composable parameter to accept a `Message` object instead of a `String`, and add another `Text` composable inside the `MessageCard` composable. Make sure to update the preview as well:

This code creates two text elements inside the content view. However, since we haven't provided any information about how to arrange them, the text elements are drawn on top of each other, making the text unreadable.

#### Using a Column

The `Column` function lets you arrange elements vertically. Add `Column` to the `MessageCard()` function.
You can use Row to arrange items horizontally and Box to stack elements.

#### Add an image element

Let's enrich our message card by adding a profile picture of the sender. Use the [Resource Manager](https://developer.android.com/studio/write/resource-manager#import) to import an image from your photo library or use [this one](https://developer.android.com/images/jetpack/compose-tutorial/profile_picture.png). Add a `Row` composable to have a well structured design and an `Image` composable inside it:

#### Configure your layout

Our message layout has the right structure but its elements aren't well spaced and the image is too big! To decorate or configure a composable, Compose uses **modifiers**. They allow you to change the composable's size, layout, appearance or add high-level interactions, such as making an element clickable. You can chain them to create richer composables. Let's use some of them to improve the layout:

```kotlin

```

<img src="https://developer.android.com/images/jetpack/compose-tutorial/lesson2-02.png" alt="img" style="zoom:25%;" />

![img](https://developer.android.com/images/jetpack/compose-tutorial/lesson2-03.png)

```kotlin

```

<img src="https://developer.android.com/images/jetpack/compose-tutorial/lesson2-04.png" alt="img" style="zoom:25%;" />

```kotlin

```

<img src="https://developer.android.com/images/jetpack/compose-tutorial/lesson2-05.png" alt="img" style="zoom:25%;" />

```kotlin
@Composable
fun MessageCard(msg: Message) {
    // Add padding around our message
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                // Set image size to 40 dp
                .size(40.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
        )

        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = msg.author)
            // Add a vertical space between the author and message texts
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = msg.body)
        }
    }
}
  
```

HIDE PREVIEW

<img src="https://developer.android.com/images/jetpack/compose-tutorial/lesson2-06.png" alt="img" style="zoom:25%;" />



## Lesson 3: Material design

Compose is built to support material design principles. Many of its UI elements implement material design out of the box. In this lesson, you'll style your app with material widgets.

![img](https://developer.android.com/images/jetpack/compose-tutorial/lesson3-01.svg)

#### Use Material Design

Our message design now has a layout, but it doesn't look too good yet.

Jetpack Compose provides an implementation of Material Design and its UI elements out of the box. We'll improve the appearance of our MessageCard composable using Material Design styling.

To start, we wrap our `MessageCard` function with the Material theme created in your project, `ComposeTutorialTheme` in this case. Do it both in the `@Preview` and in the `setContent` function.

Material Design is built around three pillars: Color, Typography, Shape. Let's add them one by one

**Note:** the Empty Compose Activity generates a default theme for your project that allows you to customize MaterialTheme. If you named your project anything different from ComposeTutorial, you can find your custom theme in the ui.theme package.

#### Color

Styling with colors from the wrapped theme is easy, and you can use values from the theme anywhere a color is needed.

Let's style the title and add a border to the image:

#### Typography

Material Typography styles are available in the MaterialTheme, just add them to the Text composables.

#### Shape

With Shape we can add the final touches. We also add a padding to the message for a better layout.

#### Enable dark theme

[Dark theme](https://developer.android.com/guide/topics/ui/look-and-feel/darktheme) (or night mode) can be enabled to avoid a bright display especially at night, or simply to save the device battery. Thanks to the Material Design support, Jetpack Compose can handle the dark theme by default. Having used Material colors, text and backgrounds will automatically adapt to the dark background.

You can create multiple previews in your file as separate functions, or add multiple annotations to the same function.

Let's add a new preview annotation and enable night mode.

Color choices for the light and dark themes are defined in the IDE-generated `Theme.kt` file.

So far, we've created a message UI element that displays an image and two texts with different styles and it looks good both in light and dark themes!

<img src="https://developer.android.com/images/jetpack/compose-tutorial/lesson3-02.png" alt="img" style="zoom:25%;" />

+ <img src="https://developer.android.com/images/jetpack/compose-tutorial/lesson3-03.png" alt="img" style="zoom:25%;" />+++++++++

<img src="https://developer.android.com/images/jetpack/compose-tutorial/lesson3-06.png" alt="img" style="zoom:25%;" />

![img](https://developer.android.com/images/jetpack/compose-tutorial/lesson3-07.png)



## Lesson 4: Lists and animations

Lists and animations are everywhere in apps. In this lesson, you will learn how Compose makes it easy to create lists and fun to add animations.

![img](https://developer.android.com/images/jetpack/compose-tutorial/lesson4-01.svg)

#### Create a list of messages

A chat with one message feels a bit lonely, so let’s change our conversation to have more than one message. We need to create a `Conversation` function that will show multiple messages. For this use case, we can use Compose’s `LazyColumn` and `LazyRow.` These composables render only the elements that are visible on screen, so they are designed to be very efficient for long lists. At the same time, they avoid the complexity of `RecyclerView` with XML layouts.

In this code snippet, you can see that `LazyColumn` has an items child. It takes a `List` as a parameter and its lambda receives a parameter we’ve named `message` (we could have named it whatever we want) which is an instance of `Message`. In short, this lambda is called for each item of the provided `List`: Import this [sample dataset](https://gist.github.com/yrezgui/26a1060d67bf0ec2a73fa12695166436) into your project to help bootstrap the conversation quickly:

#### Animate messages while expanding

Our conversation is getting more interesting. It's time to play with animations! We will add the ability to expand a message to show a longer one, animating both the content size and the background color. To store this local UI state, we need to keep track of whether a message has been extended or not. To keep track of this state change, we have to use the functions `remember` and `mutableStateOf`.

Composable functions can store local state in memory by using `remember`, and track changes to the value passed to `mutableStateOf`. Composables (and its children) using this state will get redrawn automatically when the value is updated. We call this [recomposition](https://developer.android.com/jetpack/compose/mental-model#recomposition).

By using Compose’s state APIs like `remember` and `mutableStateOf`, any changes to state automatically update the UI:

Note: you will need to add the following imports to correctly use `by`. Alt+Enter will add them for you.

Now we can change the background of the message content based on `isExpanded` when we click on a message. We will use the `clickable` modifier to handle click events on the composable. Instead of just toggling the background color of the `Surface`, we will animate the background color by gradually modifying its value from `MaterialTheme.colors.surface` to `MaterialTheme.colors.primary` and vice versa. To do so, we will use the `animateColorAsState` function. Lastly, we will use the `animateContentSize` modifier to animate the message container size smoothly:

```kotlin

```

<img src="https://developer.android.com/images/jetpack/compose-tutorial/lesson4-02.png" alt="img" style="zoom:25%;" />

```kotlin

```

<video autoplay="" muted="" loop="" class="block dac-preview-video" style="box-sizing: inherit; border: 0px; height: auto; max-width: 100%; display: block; border-radius: 23px;"></video>

```kotlin
@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondaryVariant, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        // We keep track if the message is expanded or not in this
        // variable
        var isExpanded by remember { mutableStateOf(false) }
        // surfaceColor will be updated gradually from one color to the other
        val surfaceColor: Color by animateColorAsState(
            if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
        )

        // We toggle the isExpanded variable when we click on this Column
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = msg.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )

            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
                // surfaceColor color will be changing gradually from primary to surface
                color = surfaceColor,
                // animateContentSize will change the Surface size gradually
                modifier = Modifier.animateContentSize().padding(1.dp)
            ) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    // If the message is expanded, we display all its content
                    // otherwise we only display the first line
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

  
```

HIDE PREVIEW

<video autoplay="" muted="" loop="" class="block dac-preview-video" style="box-sizing: inherit; border: 0px; height: auto; max-width: 100%; display: block; border-radius: 23px;"></video>

## Next steps

Congratulations, you’ve finished the Compose tutorial! You’ve built a simple chat screen efficiently showing a list of expandable & animated messages containing an image and texts, designed using Material Design principles with a dark theme included and previews—all in **under 100 lines of code!**

Here’s what you've learned so far:

- Defining composable functions
- Adding different elements in your composable
- Structuring your UI component using layout composables
- Extending composables by using modifiers
- Creating an efficient list
- Keeping track of state and modifying it
- Adding user interaction on a composable
- Animating messages while expanding them

If you want to dig deeper on some of these steps, explore the resources below.

## Continue your learning