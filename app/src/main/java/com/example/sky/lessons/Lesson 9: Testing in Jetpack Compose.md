# Testing in Jetpack Compose

## About this codelab

*account_circle*Written by a Googler

## [1. Introduction and setup](https://developer.android.com/codelabs/jetpack-compose-testing?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-testing#0)

In this codelab you'll learn about testing UIs created with [Jetpack Compose](https://developer.android.com/jetpack/compose). You will write your first tests while learning about testing in isolation, debugging tests, semantics trees and synchronization.

## Prerequisites

**This codelab requires the latest Android Studio Arctic Fox beta**

[Download Android Studio Arctic Fox](https://developer.android.com/studio/preview) on the beta channel.

## What you'll need

- The latest Android Studio Arctic Fox
- Knowledge of Kotlin
- Basic understanding of Compose (such as the `@Composable` annotation)
- Basic familiarity with [modifiers](https://developer.android.com/jetpack/compose/layout#modifiers)
- Optional: Consider taking the [Jetpack Compose basics codelab](https://codelabs.developers.google.com/codelabs/jetpack-compose-basics/) before this codelab

### Check out the code for this codelab (Rally)

You're going to use the [Rally Material study](https://material.io/design/material-studies/rally.html#about-rally) as the base for this codelab. You'll find it in the android-compose-codelabs Github repository. To clone, run:

```
$ git clone https://github.com/googlecodelabs/android-compose-codelabs.git
```

Once downloaded, open the `TestingCodelab` project.

Alternatively, you can download two zip files:

- [Starting point](https://github.com/googlecodelabs/android-compose-codelabs/archive/refs/heads/main.zip)
- [Solution](https://github.com/googlecodelabs/android-compose-codelabs/archive/refs/heads/end.zip)

Open the TestingCodelab folder, which contains an app called Rally.

The compose-codelabs repo contains starter code for all codelabs in the pathway.

For this codelab, use the **TestingCodelab** project.

- ![android_studio_folder.png](https://developer.android.com/codelabs/jetpack-compose-testing/img/a1beacb239657647.png) **TestingCodelab** — Project that contains the start and finished code for this codelab

The project is built in multiple git branches:

- **main** – the starter code for this project, you will make changes to this to complete the codelab
- **end** – contains the solution to this codelab

## Examine the project structure

Compose tests are instrumented tests. This means they require a device (physical device or emulator) to run on.

Rally already contains some Instrumented UI tests. You can find them in the androidTest source set:

![6f0f6fd5cd023084.png](https://developer.android.com/codelabs/jetpack-compose-testing/img/6f0f6fd5cd023084.png)

This is the directory where you'll place the new tests. Feel free to take a look at the `AnimatingCircleTests.kt` file to learn what a Compose test looks like.

Rally is already configured, but all you need to enable Compose tests in a new project is the testing dependencies in the `build.gradle` file of the relevant module, which are:

```
androidTestImplementation "androidx.compose.ui:ui-test-junit4:$version"

debugImplementation "androidx.compose.ui:ui-test-manifest:$rootProject.composeVersion"
```

## [2. What to test?](https://developer.android.com/codelabs/jetpack-compose-testing?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-testing#1)

We're going to focus on Rally's tab bar, which contains a row of [tabs](https://material.io/components/tabs) (Overview, Accounts, and Bills). It looks like this in context:

![8cb1c0adaf01b56d.gif](https://developer.android.com/codelabs/jetpack-compose-testing/img/8cb1c0adaf01b56d.gif)

In this codelab you'll test the UI of the bar.

This could mean many things:

- Test that the tabs show the intended icon and text
- Test that the animation matches the spec
- Test that the triggered navigation events are correct
- Test the placement and distances of the UI elements in different states
- Take a screenshot of the bar and compare it with a previous screenshot

There are no exact rules about how much or how to test a component. You could do all of the above! In this codelab you're going to test that the state logic is correct by verifying that:

- **A tab shows its label only when it is selected**.
- **The active screen defines the tab that is selected**

## [3. Create a simple UI test](https://developer.android.com/codelabs/jetpack-compose-testing?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-testing#2)

## Create the TopAppBarTest file

Create a new file in the same folder as `AnimatingCircleTests.kt` (`app/src/androidTest/com/example/compose/rally`) and call it `TopAppBarTest.kt`.

Compose comes with a `ComposeTestRule` that you can obtain by calling `createComposeRule()`. This rule lets you set the Compose content under test and interact with it.

## Add the ComposeTestRule

```
package com.example.compose.rally

import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule

class TopAppBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    
    // TODO: Add tests
}
```

## Testing in isolation

In a Compose test, we can start the app's main activity similarly to how you would do it in the Android View world using Espresso, for example. You can do this with `createAndroidComposeRule`.

```
// Don't copy this over

@get:Rule
val composeTestRule = createAndroidComposeRule(RallyActivity::class.java)
```

However, with Compose, we can simplify things considerably by testing a component in isolation. You can choose what Compose UI content to use in the test. This is done with the `setContent` method of the `ComposeTestRule`, and you can call it anywhere (but just once).

```
// Don't copy this over

class TopAppBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    
    @Test
    fun myTest() {
        composeTestRule.setContent { 
            Text("You can set any Compose content!")
        }
    }
}
```

We want to test the TopAppBar, so let's focus on that. Call `RallyTopAppBar` inside `setContent` and let Android Studio complete the names of the parameters.

```
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.compose.rally.ui.components.RallyTopAppBar
import org.junit.Rule
import org.junit.Test

class TopAppBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    
    @Test
    fun rallyTopAppBarTest() {
        composeTestRule.setContent { 
            RallyTopAppBar(
                allScreens = ,
                onTabSelected = { /*TODO*/ },
                currentScreen = 
            )
        }
    }
}
```

## The importance of a testable Composable

`RallyTopApBar` takes three parameters that are easy to provide so we can pass fake data that we control. For example:

```
    @Test
    fun rallyTopAppBarTest() {
        val allScreens = RallyScreen.values().toList()
        composeTestRule.setContent { 
            RallyTopAppBar(
                allScreens = allScreens,
                onTabSelected = { },
                currentScreen = RallyScreen.Accounts
            )
        }
        Thread.sleep(5000)
    }
```

We also add a `sleep()` so you can see what's going on. Right-click on the `rallyTopAppBarTest` and click on "Run `rallyTopAppBarTest()...``".`

![baca545ddc8c3fa9.png](https://developer.android.com/codelabs/jetpack-compose-testing/img/baca545ddc8c3fa9.png)

The test shows the top app bar (for 5 seconds), but it doesn't look as we expected: it has a light theme!

The reason is that the bar is built using Material Components, which expect to be within a [MaterialTheme](https://developer.android.com/reference/kotlin/androidx/compose/material/MaterialTheme), else they fall back to "baseline" styles colors.

[`MaterialTheme`](https://developer.android.com/reference/kotlin/androidx/compose/material/MaterialTheme) has good defaults so it doesn't crash. Since we're not going to test the theme or take screenshots, we can omit it and work with its default light theme. Feel free to wrap `RallyTopAppBar` with `RallyTheme` to fix it.

## Verify that the tab is selected

Finding UI elements, checking their properties and performing actions is done through the test rule, following this pattern:

```
composeTestRule{.finder}{.assertion}{.action}
```

In this test you will look for the word "Accounts" to verify that the label for the selected tab is shown.

![baca545ddc8c3fa9.png](https://developer.android.com/codelabs/jetpack-compose-testing/img/baca545ddc8c3fa9.png)

A good way to understand what tools are available is using the [Compose Testing Cheat Sheet](https://developer.android.com/jetpack/compose/testing-cheatsheet) or the [test package reference documentation](https://developer.android.com/reference/kotlin/androidx/compose/ui/test/package-summary). Look for finders and assertions that might help in our situation. For example: `onNodeWithText`, `onNodeWithContentDescription`, `isSelected`, `hasContentDescription`, `assertIsSelected`...

Each tab has a different content description:

- Overview
- Accounts
- Bills

Knowing this, replace the `Thread.sleep(5000)` with a statement that looks for a content description and asserts that it exists:

```
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.onNodeWithContentDescription
...

@Test
fun rallyTopAppBarTest_currentTabSelected() {
    val allScreens = RallyScreen.values().toList()
    composeTestRule.setContent {
        RallyTopAppBar(
            allScreens = allScreens,
            onTabSelected = { },
            currentScreen = RallyScreen.Accounts
        )
    }

    composeTestRule
        .onNodeWithContentDescription(RallyScreen.Accounts.name)
        .assertIsSelected()
}
```

Now run the test again and you should see a green test:

![251e68d36f6d08d9.png](https://developer.android.com/codelabs/jetpack-compose-testing/img/251e68d36f6d08d9.png)

**Congratulations!** You've written your first Compose test. You've learned how to test in isolation, and how to use finders and assertions.

This was straightforward, but it required some previous knowledge about the component (the content descriptions and the *selected* property). You'll learn how to inspect what properties are available in the next step.

## [4. Debugging tests](https://developer.android.com/codelabs/jetpack-compose-testing?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-testing#3)

In this step you'll verify that the label of the current tab is displayed, in upper case.

![baca545ddc8c3fa9.png](https://developer.android.com/codelabs/jetpack-compose-testing/img/baca545ddc8c3fa9.png)

A possible solution would be to try to find the text and assert that it exists:

```
import androidx.compose.ui.test.onNodeWithText
...

@Test
fun rallyTopAppBarTest_currentLabelExists() {
    val allScreens = RallyScreen.values().toList()
    composeTestRule.setContent {
        RallyTopAppBar(
            allScreens = allScreens,
            onTabSelected = { },
            currentScreen = RallyScreen.Accounts
        )
    }

    composeTestRule
        .onNodeWithText(RallyScreen.Accounts.name.toUpperCase())
        .assertExists()
}
```

However, if you run the test, it fails 😱

![2abf8cb6fa32c03a.png](https://developer.android.com/codelabs/jetpack-compose-testing/img/2abf8cb6fa32c03a.png)

In this step you'll learn how to debug this using the semantics tree.

### Semantics tree

Compose tests use a structure called the [**semantics tree**](https://developer.android.com/jetpack/compose/testing#semantics) to look for elements on the screen and read their properties. This is the structure that accessibility services use as well, as they're meant to be read by a service such as [TalkBack](https://support.google.com/accessibility/android/answer/6283677).

Warning: Layout Inspector support for Semantics properties is not available yet.

You can print the Semantics tree using the `printToLog` function on a node. Add a new line to the test:

```
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
...

fun rallyTopAppBarTest_currentLabelExists() {
    val allScreens = RallyScreen.values().toList()
    composeTestRule.setContent {
        RallyTopAppBar(
            allScreens = allScreens,
            onTabSelected = { },
            currentScreen = RallyScreen.Accounts
        )
    }

    composeTestRule.onRoot().printToLog("currentLabelExists")

    composeTestRule
        .onNodeWithText(RallyScreen.Accounts.name.toUpperCase())
        .assertExists() // Still fails
}
```

Now run the test and check out the Logcat in Android Studio (you can look for `currentLabelExists`).

```
...com.example.compose.rally D/currentLabelExists: printToLog:
    Printing with useUnmergedTree = 'false'
    Node #1 at (l=0.0, t=63.0, r=1080.0, b=210.0)px
     |-Node #2 at (l=0.0, t=63.0, r=1080.0, b=210.0)px
       [SelectableGroup]
       MergeDescendants = 'true'
        |-Node #3 at (l=42.0, t=105.0, r=105.0, b=168.0)px
        | Role = 'Tab'
        | Selected = 'false'
        | StateDescription = 'Not selected'
        | ContentDescription = 'Overview'
        | Actions = [OnClick]
        | MergeDescendants = 'true'
        | ClearAndSetSemantics = 'true'
        |-Node #6 at (l=189.0, t=105.0, r=468.0, b=168.0)px
        | Role = 'Tab'
        | Selected = 'true'
        | StateDescription = 'Selected'
        | ContentDescription = 'Accounts'
        | Actions = [OnClick]
        | MergeDescendants = 'true'
        | ClearAndSetSemantics = 'true'
        |-Node #11 at (l=552.0, t=105.0, r=615.0, b=168.0)px
          Role = 'Tab'
          Selected = 'false'
          StateDescription = 'Not selected'
          ContentDescription = 'Bills'
          Actions = [OnClick]
          MergeDescendants = 'true'
          ClearAndSetSemantics = 'true'
```

Hopefully now you understand the convenience of isolation. The semantics tree of a full app would be very long!

Warning: Composables don't have IDs and you can't use the Node numbers shown in the tree to match them. If matching a node with its semantics properties is impractical or impossible, you can use the [`testTag`](https://developer.android.com/reference/kotlin/androidx/compose/ui/platform/package-summary#testTag(androidx.compose.ui.Modifier,kotlin.String)) modifier with the [`hasTestTag`](https://developer.android.com/reference/kotlin/androidx/compose/ui/test/package-summary#hasTestTag(kotlin.String)) matcher as a last resort.

Taking a look at the Semantics tree, you can see there is a `SelectableGroup` with 3 child elements, which are the tabs of the top app bar. Turns out, there is no `text` property with a value of "ACCOUNTS" and this is why the test fails. However, there is a **content description for each tab**. You can check how this property is set in the `RallyTab` composable inside `TopAppBar.kt`:

```
private fun RallyTab(text: String...)
...
    Modifier
        .clearAndSetSemantics { contentDescription = text }
```

This modifier is clearing the properties from descendants and setting its own content description, so that's why you see "Accounts" and not "ACCOUNTS".

Replace the finder `onNodeWithText` with `onNodeWithContentDescription` and run the test again:

```
fun rallyTopAppBarTest_currentLabelExists() {
    val allScreens = RallyScreen.values().toList()
    composeTestRule.setContent {
        RallyTopAppBar(
            allScreens = allScreens,
            onTabSelected = { },
            currentScreen = RallyScreen.Accounts
        )
    }

    composeTestRule
        .onNodeWithContentDescription(RallyScreen.Accounts.name)
        .assertExists()
}
```

![3f3d9e9b90cd6cf4.png](https://developer.android.com/codelabs/jetpack-compose-testing/img/3f3d9e9b90cd6cf4.png)

Congratulations! You've fixed the test and you learned about the `ComposeTestRule`, testing in isolation, finders, assertions, and debugging with the Semantics tree.

**Bad news though**: this test is not very useful! If you look at the Semantics tree closely, the content descriptions of all three tabs are there whether or not their tab is selected. We must go deeper!

## [5. Merged and unmerged Semantics trees](https://developer.android.com/codelabs/jetpack-compose-testing?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-testing#4)

The Semantics tree always tries to be as compact as possible, showing only the information that is relevant.

For example, in our `TopAppBar`, there is no need for the icons and labels to be different nodes. Take a look at the "Overview" node:

![d20c96207c30e44a.png](https://developer.android.com/codelabs/jetpack-compose-testing/img/d20c96207c30e44a.png)

```
        |-Node #3 at (l=42.0, t=105.0, r=105.0, b=168.0)px
        | Role = 'Tab'
        | Selected = 'false'
        | StateDescription = 'Not selected'
        | ContentDescription = 'Overview'
        | Actions = [OnClick]
        | MergeDescendants = 'true'
        | ClearAndSetSemantics = 'true'
```

This node has properties (such as `Selected` and `Role`) that are defined specifically for a [`selectable`](https://developer.android.com/reference/kotlin/androidx/compose/foundation/selection/package-summary#selectable(androidx.compose.ui.Modifier,kotlin.Boolean,kotlin.Boolean,androidx.compose.ui.semantics.Role,kotlin.Function0)) component and a content description for the whole tab. These are high-level properties, very useful for simple tests. Details about the icon or the text would be redundant so they're not shown.

Compose exposes these Semantics properties automatically in some composables such as `Text`. You can also customize and **merge** them to represent a single component made up of one or multiple descendants. For example: you can represent a `Button` containing a `Text` composable. The property `MergeDescendants = 'true'` is telling us that **this node had descendants, but they have been merged into it**. In tests we oftentimes need to access all nodes.

In order to verify whether the `Text` inside the tab is displayed or not, we can query the **unmerged** Semantics tree passing `useUnmergedTree = true` to the `onRoot` finder.

```
@Test
fun rallyTopAppBarTest_currentLabelExists() {
    val allScreens = RallyScreen.values().toList()
    composeTestRule.setContent {
        RallyTopAppBar(
            allScreens = allScreens,
            onTabSelected = { },
            currentScreen = RallyScreen.Accounts
        )
    }

    composeTestRule.onRoot(useUnmergedTree = true).printToLog("currentLabelExists")


}
```

The output in Logcat is slightly longer now:

```
    Printing with useUnmergedTree = 'true'
    Node #1 at (l=0.0, t=63.0, r=1080.0, b=210.0)px
     |-Node #2 at (l=0.0, t=63.0, r=1080.0, b=210.0)px
       [SelectableGroup]
       MergeDescendants = 'true'
        |-Node #3 at (l=42.0, t=105.0, r=105.0, b=168.0)px
        | Role = 'Tab'
        | Selected = 'false'
        | StateDescription = 'Not selected'
        | ContentDescription = 'Overview'
        | Actions = [OnClick]
        | MergeDescendants = 'true'
        | ClearAndSetSemantics = 'true'
        |-Node #6 at (l=189.0, t=105.0, r=468.0, b=168.0)px
        | Role = 'Tab'
        | Selected = 'true'
        | StateDescription = 'Selected'
        | ContentDescription = 'Accounts'
        | Actions = [OnClick]
        | MergeDescendants = 'true'
        | ClearAndSetSemantics = 'true'
        |  |-Node #9 at (l=284.0, t=105.0, r=468.0, b=154.0)px
        |    Text = 'ACCOUNTS'
        |    Actions = [GetTextLayoutResult]
        |-Node #11 at (l=552.0, t=105.0, r=615.0, b=168.0)px
          Role = 'Tab'
          Selected = 'false'
          StateDescription = 'Not selected'
          ContentDescription = 'Bills'
          Actions = [OnClick]
          MergeDescendants = 'true'
          ClearAndSetSemantics = 'true'
```

Node #3 still has no descendants:

```
        |-Node #3 at (l=42.0, t=105.0, r=105.0, b=168.0)px
        | Role = 'Tab'
        | Selected = 'false'
        | StateDescription = 'Not selected'
        | ContentDescription = 'Overview'
        | Actions = [OnClick]
        | MergeDescendants = 'true'
        | ClearAndSetSemantics = 'true'
```

But node 6, the selected tab, has one and we can now see the ‘Text' property:

```
        |-Node #6 at (l=189.0, t=105.0, r=468.0, b=168.0)px
        | Role = 'Tab'
        | Selected = 'true'
        | StateDescription = 'Selected'
        | ContentDescription = 'Accounts'
        | Actions = [OnClick]
        | MergeDescendants = 'true'
        |  |-Node #9 at (l=284.0, t=105.0, r=468.0, b=154.0)px
        |    Text = 'ACCOUNTS'
        |    Actions = [GetTextLayoutResult]
```

In order to verify the correct behavior as we wanted, you'll write a matcher that finds one node with text "ACCOUNTS" whose parent is a node with content description "Accounts".

Check the [Compose Testing Cheat Sheet](https://developer.android.com/jetpack/compose/testing-cheatsheet) again and try to find a way to write that matcher. Note that you can use boolean operators such as `and` and `or` with matchers.

All finders have a parameter called `useUnmergedTree`. Set it to `true` to use the unmerged tree.

Try to write the test without looking at the solution!

#### *Solution*

```
import androidx.compose.ui.test.hasParent
import androidx.compose.ui.test.hasText
...

@Test
fun rallyTopAppBarTest_currentLabelExists() {
    val allScreens = RallyScreen.values().toList()
    composeTestRule.setContent {
        RallyTopAppBar(
            allScreens = allScreens,
            onTabSelected = { },
            currentScreen = RallyScreen.Accounts
        )
    }

    composeTestRule
        .onNode(
            hasText(RallyScreen.Accounts.name.toUpperCase()) and
            hasParent(
                hasContentDescription(RallyScreen.Accounts.name)
            ),
            useUnmergedTree = true
        )
        .assertExists()
}
```

Note: In this case, strictly, you don't have to add the parent to the matcher because it's a very isolated test. However, it's a good idea to avoid using broad finders alone (such as `hasText`) which might fail in larger tests (when other instances of the text might be found).

Go ahead and run it:

![377261a7b0db6354.png](https://developer.android.com/codelabs/jetpack-compose-testing/img/377261a7b0db6354.png)

Congratulations! In this step you've learned about property merging and the merged and unmerged Semantics trees.

## [6. Synchronization](https://developer.android.com/codelabs/jetpack-compose-testing?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-testing#5)

Any test that you write must be properly synchronized with the subject under test. For example, when you use a finder such as `onNodeWithText`, the test waits until the app is *idle* before querying the semantics tree. Without synchronization, tests could look for elements before they're displayed or they could wait unnecessarily.

We'll use the Overview screen for this step, which looks like this when you run the app:

![17e585f529a6d613.gif](https://developer.android.com/codelabs/jetpack-compose-testing/img/17e585f529a6d613.gif)

Note the repeating flashing animation of the Alerts card, drawing attention to this element.

Create another test class called `OverviewScreenTest` and add the following content:

```
package com.example.compose.rally

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.compose.rally.ui.overview.OverviewBody
import org.junit.Rule
import org.junit.Test

class OverviewScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun overviewScreen_alertsDisplayed() {
        composeTestRule.setContent {
            OverviewBody()
        }

        composeTestRule
            .onNodeWithText("Alerts")
            .assertIsDisplayed()
    }
}
```

If you run this test, you'll notice it never finishes (it times out after 30 seconds).

![880d5515b578d45e.png](https://developer.android.com/codelabs/jetpack-compose-testing/img/880d5515b578d45e.png)

The error says:

```
androidx.compose.ui.test.junit4.android.ComposeNotIdleException: Idling resource timed out: possibly due to compose being busy.
IdlingResourceRegistry has the following idling resources registered:
- [busy] androidx.compose.ui.test.junit4.android.ComposeIdlingResource@d075f91 
```

This is basically telling you that Compose is permanently busy so there is no way to synchronize the app with the test.

You might already have guessed that the problem is the infinite flashing animation. The app is never idle so the test can't continue.

Let's look at the implementation of the infinite animation:

### app/src/main/java/com/example/compose/rally/ui/overview/OverviewScreen.kt

```
var currentTargetElevation by remember {  mutableStateOf(1.dp) }
LaunchedEffect(Unit) {
    // Start the animation
    currentTargetElevation = 8.dp
}
val animatedElevation = animateDpAsState(
    targetValue = currentTargetElevation,
    animationSpec = tween(durationMillis = 500),
    finishedListener = {
        currentTargetElevation = if (currentTargetElevation > 4.dp) {
            1.dp
        } else {
            8.dp
        }
    }
)
Card(elevation = animatedElevation.value) { ... }
```

This code is essentially waiting for an animation to finish (`finishedListener`) and then runs it again.

One approach to fix this test would be to disable animations in developer options. It's one of the widely accepted ways of dealing with it in the `View` world.

In Compose, the animation APIs were designed with testability in mind, so the problem can be fixed by using the correct API. Instead of restarting the [`animateDpAsState`](https://developer.android.com/jetpack/compose/animation#animate-as-state) animation, we can use [infinite animations](https://developer.android.com/jetpack/compose/animation#rememberinfinitetransition).

**Infinite animations** are a special case that Compose tests *understand* so they're not going to keep the test busy.

Replace the code in `OverviewScreen` with the proper API:

```
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.ui.unit.Dp
...

    val infiniteElevationAnimation = rememberInfiniteTransition()
    val animatedElevation: Dp by infiniteElevationAnimation.animateValue(
        initialValue = 1.dp,
        targetValue = 8.dp,
        typeConverter = Dp.VectorConverter,
        animationSpec = infiniteRepeatable(
            animation = tween(500),
            repeatMode = RepeatMode.Reverse
        )
    )
    Card(elevation = animatedElevation) {
```

If you run the test, it will pass now:

![4381509baa58644f.png](https://developer.android.com/codelabs/jetpack-compose-testing/img/4381509baa58644f.png)

Congratulations! In this step you've learned about synchronization and how animations can affect tests.

## [7. Optional exercise](https://developer.android.com/codelabs/jetpack-compose-testing?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-testing#6)

In this step, you'll use an action (see the [Testing Cheat Sheet](https://developer.android.com/jetpack/compose/testing-cheatsheet)) to verify that clicking on the different tabs of the `RallyTopAppBar` changes the selection.

Hints:

- The scope of the test needs to include the state, which is owned by `RallyApp`.
- Verify state, not behavior. Use assertions on the state of the UI instead of relying on which objects have been called and how.

There's no provided solution for this exercise.