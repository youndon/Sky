# Jetpack Compose Animation

## About this codelab

*account_circle*Written by Yuichi Araki

## [1. Introduction](https://developer.android.com/codelabs/jetpack-compose-animation?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-animation#0)

![ea1442f28b3c3b39.png](https://developer.android.com/codelabs/jetpack-compose-animation/img/ea1442f28b3c3b39.png)

**Last Updated:** 2021-01-25

In this codelab, you will learn how to use some Animation APIs in Jetpack Compose.

Jetpack Compose is a modern UI toolkit designed to simplify UI development. If you are new to Jetpack Compose, there are several codelabs you might want to try before this one.

- [Jetpack Compose basics](https://developer.android.com/codelabs/jetpack-compose-basics)
- [Layouts in Jetpack Compose](https://developer.android.com/codelabs/jetpack-compose-layouts)
- [Using State in Jetpack Compose](https://developer.android.com/codelabs/jetpack-compose-state)

## **What we'll learn**

- How to use several basic Animation APIs
- When to use what API

## Prerequisites

- [Basic Kotlin knowledge](https://developer.android.com/jetpack/compose/kotlin)
- Basic Compose knowledge including:
- [Simple layout](https://developer.android.com/jetpack/compose/layout) (Column, Row, Box, etc)
- Simple UI elements (Button, Text, etc)
- [States and recomposition](https://developer.android.com/jetpack/compose/state)

## [2. Getting set up](https://developer.android.com/codelabs/jetpack-compose-animation?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-animation#1)

**Download** the codelab code. You can clone the repository as follows:

```
$ git clone git@github.com:googlecodelabs/android-compose-codelabs.git
```

Or, you can download [the zip file](https://github.com/googlecodelabs/android-compose-codelabs/archive/main.zip).

**Import** the **`AnimationCodelab`** project in Android Studio.

![7a7c10526864d5c2.png](https://developer.android.com/codelabs/jetpack-compose-animation/img/7a7c10526864d5c2.png)

**Note**: If you are running a newer version of Android Studio than the sample was created with, you may see a notification asking to update the Gradle version. Feel free to do that, or skip if you are short on time.

The project has multiple modules in it:

- **`start`** is the starting state for the codelab.
- `finished` is the final state of the app after completing this codelab.

Make sure that **`start`**

**is selected** in the dropdown for the run configuration.

![39b7acb33706a9b.png](https://developer.android.com/codelabs/jetpack-compose-animation/img/39b7acb33706a9b.png)

We will start working on several animation scenarios in the next chapter. Every code snippet we work on in this codelab is marked with a `// TODO` comment. One neat trick is to open the TODO tool window in Android Studio and navigate to each of the TODO comments for the chapter.

![c4a2180b956cad9f.png](https://developer.android.com/codelabs/jetpack-compose-animation/img/c4a2180b956cad9f.png)

## [3. Animating a simple value change](https://developer.android.com/codelabs/jetpack-compose-animation?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-animation#2)

Let's start with the simplest Animation API in Compose.

Run the `start` configuration and try switching tabs by clicking on the "Home" and "Work" buttons at the top. It does not really switch the tab content, but you can see that the background color of the content changes.

| ![img](https://developer.android.com/codelabs/jetpack-compose-animation/img/337937fe2e3919a9.png) | ![img](https://developer.android.com/codelabs/jetpack-compose-animation/img/d1ad39f36c3874f0.png) |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
|                                                              |                                                              |

Click on **TODO 1** in your TODO tool window and see how this is implemented. It is in the `Home` composable.

```
val backgroundColor = if (tabPage == TabPage.Home) Purple100 else Green300
```

Here, `tabPage` is an `Int` backed by a `State` object. Depending on its value, the background color is toggled between purple and green. We want to animate this value change.

In order to animate a simple value change like this, we can use the `animate*AsState` APIs. You can create an animation value by simply wrapping the changing value with the corresponding variant of `animate*AsState` composables, `animateColorAsState` in this case. The returned value is a `State<T>` object, so we can use a [local delegated property](https://kotlinlang.org/docs/reference/delegated-properties.html#local-delegated-properties) with a `by` declaration to treat it like a normal variable.

```
val backgroundColor by animateColorAsState(if (tabPage == TabPage.Home) Purple100 else Green300)
```

Rerun the app and try switching the tabs. The color change is animated now.

![6946feb47acc2cc6.gif](https://developer.android.com/codelabs/jetpack-compose-animation/img/6946feb47acc2cc6.gif)

## [4. Animating visibility](https://developer.android.com/codelabs/jetpack-compose-animation?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-animation#3)

If you scroll the content of the app, you will notice that the floating action button expands and shrinks depending on the direction of your scroll.

| ![img](https://developer.android.com/codelabs/jetpack-compose-animation/img/169623577d25211b.png) | ![img](https://developer.android.com/codelabs/jetpack-compose-animation/img/575962f2a5bb6115.png) |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
|                                                              |                                                              |

Find **TODO 2-1** and check out how this works. It is in the `HomeFloatingActionButton` composable. The text saying "EDIT" is shown or hidden using an `if` statement.

```
if (extended) {
    Text(
        text = stringResource(R.string.edit),
        modifier = Modifier
            .padding(start = 8.dp, top = 3.dp)
    )
}
```

Animating this visibility change is as simple as replacing the `if` with an `AnimatedVisibility` composable.

```
AnimatedVisibility(extended) {
    Text(
        text = stringResource(R.string.edit),
        modifier = Modifier
            .padding(start = 8.dp, top = 3.dp)
    )
}
```

Run the app and see how the FAB expands and shrinks now.

![37a613b87156bfbe.gif](https://developer.android.com/codelabs/jetpack-compose-animation/img/37a613b87156bfbe.gif)

`AnimatedVisibility` runs its animation every time the specified `Boolean` value changes. By default, `AnimatedVisibility` shows the element by fading in and expanding it, and hides it by fading out and shrinking. This behavior works great for this example with FAB, but we can also customize the behavior.

Try clicking on the FAB, and you should see a message saying "Edit feature is not supported". It also uses `AnimatedVisibility` to animate its appearance and disappearance. Let's see how we can customize this animation so that the element slides in from the top and slides out to the top.

![11d77a9c6af0309c.png](https://developer.android.com/codelabs/jetpack-compose-animation/img/11d77a9c6af0309c.png)

Find **TODO 2-2** and check out the code in the `EditMessage` composable.

```
AnimatedVisibility(
    visible = shown
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colors.secondary,
        elevation = 4.dp
    ) {
        Text(
            text = stringResource(R.string.edit_message),
            modifier = Modifier.padding(16.dp)
        )
    }
}
```

In order to customize the animation, add the `enter` and `exit` parameters to the `AnimatedVisibility` composable.

The `enter` parameter should be an instance of `EnterTransition`. For this example, we can use the `slideInVertically` function to create an `EnterTransition`. This function allows further customization by the `initialOffsetY` and `animationSpec` parameters. The `initialOffsetY` should be a lambda returning the initial position. The lambda receives one argument, the height of the element, so we can simply return its negative value. When using `slideInVertically`, the target offset for after slide in is always `0` (pixel). `initialOffsetY` can be specified either as an absolute value or a percentage of the full height of the element via a lambda function.

`animationSpec` is a common parameter for many Animation APIs including `EnterTransition` and `ExitTransition`. We can pass one of various `AnimationSpec` types to specify how the animating value should change over time. In this example, let's use a simple duration-based `AnimationSpec`. It can be created with the `tween` function. The duration is 150 ms and the easing is `LinearOutSlowInEasing`.

Similarly, we can use the `slideOutVertically` function for the `exit` parameter. `slideOutVertically` assumes the initial offset is 0, so only `targetOffsetY` needs to be specified. Let's use the same `tween` function for the `animationSpec` parameter, but with duration of 250 ms and easing of `FastOutLinearInEasing`.

The resulting code should look like below.

```
AnimatedVisibility(
    visible = shown,
    enter = slideInVertically(
        // Enters by sliding down from offset -fullHeight to 0.
        initialOffsetY = { fullHeight -> -fullHeight },
        animationSpec = tween(durationMillis = 150, easing = LinearOutSlowInEasing)
    ),
    exit = slideOutVertically(
        // Exits by sliding up from offset 0 to -fullHeight.
        targetOffsetY = { fullHeight -> -fullHeight },
        animationSpec = tween(durationMillis = 250, easing = FastOutLinearInEasing)
    )
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colors.secondary,
        elevation = 4.dp
    ) {
        Text(
            text = stringResource(R.string.edit_message),
            modifier = Modifier.padding(16.dp)
        )
    }
}
```

Run the app and click on the FAB again. You can see that the message now slides in and out from the top.

![76895615b43b9263.gif](https://developer.android.com/codelabs/jetpack-compose-animation/img/76895615b43b9263.gif)

## [5. Animating content size change](https://developer.android.com/codelabs/jetpack-compose-animation?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-animation#4)

The app shows several topics in the content. Try clicking one of them, and it should open up and show the body text for that topic. The card containing the text expands and shrinks when the body is shown or hidden.

| ![img](https://developer.android.com/codelabs/jetpack-compose-animation/img/5088ae9a063716ba.png) | ![img](https://developer.android.com/codelabs/jetpack-compose-animation/img/1de654702522c818.png) |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
|                                                              |                                                              |

Check out the code for **TODO 3** in the `TopicRow` composable.

```
Column(
    modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
) {
    // ... the title and the body
}
```

This `Column` composable here changes its size as its content is changed. We can animate the change of its size by adding the `animateContentSize` modifier.

```
Column(
    modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .animateContentSize()
) {
    // ... the title and the body
}
```

Run the app and click one of the topics. You can see that it expands and shrinks with animation.

![c0ad7381779fcb09.gif](https://developer.android.com/codelabs/jetpack-compose-animation/img/c0ad7381779fcb09.gif)

## [6. Multiple value animation](https://developer.android.com/codelabs/jetpack-compose-animation?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-animation#5)

Now that we are familiar with some basic Animation APIs, let's see the `Transition` API that allows us to create more complex animations. For this example, we customize the tab indicator. It is a rectangle shown on the currently selected tab.

| ![img](https://developer.android.com/codelabs/jetpack-compose-animation/img/337937fe2e3919a9.png) | ![img](https://developer.android.com/codelabs/jetpack-compose-animation/img/d1ad39f36c3874f0.png) |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
|                                                              |                                                              |

Find **TODO 4** in the `HomeTabIndicator` composable, and see how the tab indicator is implemented.

```
val indicatorLeft = tabPositions[tabPage.ordinal].left
val indicatorRight = tabPositions[tabPage.ordinal].right
val color = if (tabPage == TabPage.Home) Purple700 else Green800
```

Here, `indicatorLeft` is the horizontal position of the left edge of the indicator in the tab row. `indicatorRight` is the horizontal position of the right edge of the indicator. The color is also changed between purple and green.

In order to animate these multiple values simultaneously, we can use a `Transition`. A `Transition` can be created with the `updateTransition` function. Pass the index of the tab currently selected as the `targetState` parameter.

Each animating value can be declared with the `animate*` extension functions of `Transition`. In this example, we use `animateDp` and `animateColor`. They take a lambda block and we can specify the target value for each of the states. We already know what their target values should be, so we can simply wrap the values like below. Note that we can use a `by` declaration and make it a local delegated property here again because the `animate*` functions return a `State` object.

```
val transition = updateTransition(tabPage)
val indicatorLeft by transition.animateDp { page ->
    tabPositions[page.ordinal].left
}
val indicatorRight by transition.animateDp { page ->
    tabPositions[page.ordinal].right
}
val color by transition.animateColor { page ->
    if (page == TabPage.Home) Purple700 else Green800
}
```

Run the app now and you can see that the tab switch is now much more interesting. As clicking on the tab changes the value of the `tabPage` state, all the animation values associated with the `transition` starts animating to the value specified for the target state.

![3262270d174e77bf.gif](https://developer.android.com/codelabs/jetpack-compose-animation/img/3262270d174e77bf.gif)

Additionally, we can specify the `transitionSpec` parameter to customize the animation behavior. For example, we can achieve an elastic effect for the indicator by having the edge closer to the destination move faster than the other edge. We can use the `isTransitioningTo` infix function in `transitionSpec` lambdas to determine the direction of the state change.

```
val transition = updateTransition(
    tabPage,
    label = "Tab indicator"
)
val indicatorLeft by transition.animateDp(
    transitionSpec = {
        if (TabPage.Home isTransitioningTo TabPage.Work) {
            // Indicator moves to the right.
            // The left edge moves slower than the right edge.
            spring(stiffness = Spring.StiffnessVeryLow)
        } else {
            // Indicator moves to the left.
            // The left edge moves faster than the right edge.
            spring(stiffness = Spring.StiffnessMedium)
        }
    },
    label = "Indicator left"
) { page ->
    tabPositions[page.ordinal].left
}
val indicatorRight by transition.animateDp(
    transitionSpec = {
        if (TabPage.Home isTransitioningTo TabPage.Work) {
            // Indicator moves to the right
            // The right edge moves faster than the left edge.
            spring(stiffness = Spring.StiffnessMedium)
        } else {
            // Indicator moves to the left.
            // The right edge moves slower than the left edge.
            spring(stiffness = Spring.StiffnessVeryLow)
        }
    },
    label = "Indicator right"
) { page ->
    tabPositions[page.ordinal].right
}
val color by transition.animateColor(
    label = "Border color"
) { page ->
    if (page == TabPage.Home) Purple700 else Green800
}
```

Run the app again and try switching the tabs.

![2ad4adbefce04ae2.gif](https://developer.android.com/codelabs/jetpack-compose-animation/img/2ad4adbefce04ae2.gif)

Android Studio supports inspection of Transition in Compose Preview. To use **Animation Preview**, start interactive mode by clicking on the "Start interactive mode" icon at the top right corner of a Composable in preview. You should enable this feature in the experimental settings as instructed [here](https://developer.android.com/jetpack/compose/tooling#enable-experimental-features) if you can't find the icon. Try clicking on the icon for the `PreviewHomeTabBar` composable. Then click on the "Start animation inspection" icon at the top right corner of the interactive mode. This opens a new "Animations" pane.

You can run the animation by clicking on the "Play" icon button. You can also drag on the seekbar to see each of the animation frames. For better description of the animation values, you can specify the `label` parameter in `updateTransition` and the `animate*` methods.

![2d3c5020ae28120b.png](https://developer.android.com/codelabs/jetpack-compose-animation/img/2d3c5020ae28120b.png)

## [7. Repeated animation](https://developer.android.com/codelabs/jetpack-compose-animation?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-animation#6)

Try clicking on the refresh icon button next to the current temperature. The app starts loading the latest weather information (it pretends). Until the loading is complete, you see a loading indicator, that's a gray circle and a bar. Let's animate the alpha value of this indicator to make it clearer that the process is ongoing.

![c2912ddc2d73bdfc.png](https://developer.android.com/codelabs/jetpack-compose-animation/img/c2912ddc2d73bdfc.png)

Find **TODO 5** in the `LoadingRow` composable.

```
val alpha = 1f
```

We'd like to make this value animate between 0f and 1f repeatedly. We can use `InfiniteTransition` for this purpose. This API is similar to the `Transition` API in the previous section. They both animate multiple values, but while `Transition` animates values based on state changes, `InfiniteTransition` animates values indefinitely.

To create an `InfiniteTransition`, use the `rememberInfiniteTransition` function. Then, each animating value change can be declared with one of the `animate*` extension functions of `InfiniteTransition`. In this case, we are animating an alpha value, so let's use `animatedFloat`. The `initialValue` parameter should be `0f`, and the `targetValue` `1f`. We can also specify an `AnimationSpec` for this animation, but this API only takes an `InfiniteRepeatableSpec`. Use the `infiniteRepeatable` function to create one. This `AnimationSpec` wraps any duration-based `AnimationSpec` and makes it repeatable. For example, the resulting code should look like below.

```
val infiniteTransition = rememberInfiniteTransition()
val alpha by infiniteTransition.animateFloat(
    initialValue = 0f,
    targetValue = 1f,
    animationSpec = infiniteRepeatable(
        animation = keyframes {
            durationMillis = 1000
            0.7f at 500
        },
        repeatMode = RepeatMode.Reverse
    )
)
```

Run the app and try clicking on the refresh button. You can now see the loading indicator animating.

![ca4d1d5bfe87b2a9.gif](https://developer.android.com/codelabs/jetpack-compose-animation/img/ca4d1d5bfe87b2a9.gif)

## [8. Gesture animation](https://developer.android.com/codelabs/jetpack-compose-animation?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-animation#7)

In this final section, we will learn about how to run animations based on touch inputs. There are several unique things to take into account in this scenario. First, any ongoing animation might be intercepted by a touch event. Second, the animation value might not be the only source of truth. In other words, we might need to synchronize the animation value with values coming from touch events.

Find **TODO 6-1** in the `swipeToDismiss` modifier. Here, we are trying to make a modifier that makes the element swipeable with touch. When the element is flung to the edge of the screen, we call the `onDismissed` callback so that the element can be removed.

`Animatable` is the lowest-level API we've seen so far. It has several features that are useful in gesture scenarios, so let's create an instance of `Animatable` and use it to represent the horizontal offset of the swipeable element.

```
val offsetX = remember { Animatable(0f) } // Add this line
pointerInput {
    // Used to calculate a settling position of a fling animation.
    val decay = splineBasedDecay<Float>(this)
    // Wrap in a coroutine scope to use suspend functions for touch events and animation.
    coroutineScope {
        while (true) {
            // ...
```

**TODO 6-2** is where we have just received a touch down event. We should intercept the animation if it is currently running. This can be done by calling `stop` on the `Animatable`. Note that the call is ignored if the animation is not running.

```
// Wait for a touch down event.
val pointerId = awaitPointerEventScope { awaitFirstDown().id }
offsetX.stop() // Add this line
// Prepare for drag events and record velocity of a fling.
val velocityTracker = VelocityTracker()
// Wait for drag events.
awaitPointerEventScope {
```

At **TODO 6-3**, we are continuously receiving drag events. We have to synchronize the position of the touch event into the animation value. We can use `snapTo` on the `Animatable` for this.

```
horizontalDrag(pointerId) { change ->
    // Add these 4 lines
    val horizontalDragOffset = offsetX.value + change.positionChange().x
    launch {
        offsetX.snapTo(horizontalDragOffset)
    }
    // Record the velocity of the drag.
    velocityTracker.addPosition(change.uptimeMillis, change.position)
    // Consume the gesture event, not passed to external
    change.consumePositionChange()
}
```

**TODO 6-4** is where the element has just been released and flung. We need to calculate the eventual position the fling is settling into in order to decide whether we should slide the element back to the original position, or slide it away and invoke the callback.

```
// Dragging finished. Calculate the velocity of the fling.
val velocity = velocityTracker.calculateVelocity().x
// Add this line
val targetOffsetX = decay.calculateTargetValue(offsetX.value, velocity) 
```

At **TODO 6-5**, we are about to start the animation. But before that, we want to set upper and lower value bounds to the `Animatable` so that it stops as soon as it reaches them. The `pointerInput` modifier allows us to access the size of the element by the `size` property, so let's use that to get our bounds.

```
offsetX.updateBounds(
    lowerBound = -size.width.toFloat(),
    upperBound = size.width.toFloat()
)
```

**TODO 6-6** is where we can finally start our animation. We first compare the settling position of the fling we calculated earlier and the size of the element. If the settling position is below the size, it means that the velocity of the fling was not enough. We can use `animateTo` to animate the value back to 0f. Otherwise, we use `animateDecay` to start the fling animation. When the animation is finished (most likely by the bounds we set earlier), we can call the callback.

```
launch {
    if (targetOffsetX.absoluteValue <= size.width) {
        // Not enough velocity; Slide back.
        offsetX.animateTo(targetValue = 0f, initialVelocity = velocity)
    } else {
        // Enough velocity to slide away the element to the edge.
        offsetX.animateDecay(velocity, decay)
        // The element was swiped away.
        onDismissed()
    }
}
```

Finally, see **TODO 6-7**. We have all the animations and gestures set up, so don't forget to apply the offset to the element.

```
.offset { IntOffset(offsetX.value.roundToInt(), 0) }
```

As a result of this section, you will end up with code like below:

```
private fun Modifier.swipeToDismiss(
    onDismissed: () -> Unit
): Modifier = composed {
    // This `Animatable` stores the horizontal offset for the element.
    val offsetX = remember { Animatable(0f) }
    pointerInput(Unit) {
        // Used to calculate a settling position of a fling animation.
        val decay = splineBasedDecay<Float>(this)
        // Wrap in a coroutine scope to use suspend functions for touch events and animation.
        coroutineScope {
            while (true) {
                // Wait for a touch down event.
                val pointerId = awaitPointerEventScope { awaitFirstDown().id }
                // Interrupt any ongoing animation.
                offsetX.stop()
                // Prepare for drag events and record velocity of a fling.
                val velocityTracker = VelocityTracker()
                // Wait for drag events.
                awaitPointerEventScope {
                    horizontalDrag(pointerId) { change ->
                        // Record the position after offset
                        val horizontalDragOffset = offsetX.value + change.positionChange().x
                        launch {
                            // Overwrite the `Animatable` value while the element is dragged.
                            offsetX.snapTo(horizontalDragOffset)
                        }
                        // Record the velocity of the drag.
                        velocityTracker.addPosition(change.uptimeMillis, change.position)
                        // Consume the gesture event, not passed to external
                        change.consumePositionChange()
                    }
                }
                // Dragging finished. Calculate the velocity of the fling.
                val velocity = velocityTracker.calculateVelocity().x
                // Calculate where the element eventually settles after the fling animation.
                val targetOffsetX = decay.calculateTargetValue(offsetX.value, velocity)
                // The animation should end as soon as it reaches these bounds.
                offsetX.updateBounds(
                    lowerBound = -size.width.toFloat(),
                    upperBound = size.width.toFloat()
                )
                launch {
                    if (targetOffsetX.absoluteValue <= size.width) {
                        // Not enough velocity; Slide back to the default position.
                        offsetX.animateTo(targetValue = 0f, initialVelocity = velocity)
                    } else {
                        // Enough velocity to slide away the element to the edge.
                        offsetX.animateDecay(velocity, decay)
                        // The element was swiped away.
                        onDismissed()
                    }
                }
            }
        }
    }
        // Apply the horizontal offset to the element.
        .offset { IntOffset(offsetX.value.roundToInt(), 0) }
}
```

Run the app and try swiping one of the task items. You can see that the element either slides back to the default position or slides away and gets removed depending on the velocity of your fling. You can also catch the element while it is animating.

![7cdefce823f6b9bd.png](https://developer.android.com/codelabs/jetpack-compose-animation/img/7cdefce823f6b9bd.png)

## [9. Congratulations!](https://developer.android.com/codelabs/jetpack-compose-animation?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-animation#8)

Congratulations! You have learned basic Compose Animation APIs.

We learned how to build several common animation patterns using high-level animation APIs, such as `animateContentSize` and `AnimatedVisibility`. We also learned that we can use `animate*AsState` for animating a single value, `updateTransition` for animating multiple values, and `infiniteTransition` for animating values indefinitely. We also used `Animatable` to build custom animation in combination with touch gestures.