# Jetpack Compose Navigation

## About this codelab

*account_circle*Written by a Googler

## [1. Introduction](https://developer.android.com/codelabs/jetpack-compose-navigation?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-navigation#0)

**Last Updated:** 2021-03-17

## **What you'll need**

- The latest [Android Studio Arctic Fox](https://developer.android.com/studio)
- Knowledge of Kotlin
- Basic understanding of Compose (such as the `@Composable` annotation)
- Consider taking the [Jetpack Compose basics codelab](https://codelabs.developers.google.com/codelabs/jetpack-compose-basics/) before this codelab

## **Navigating with Compose**

[Navigation](https://developer.android.com/guide/navigation) is a Jetpack library that enables navigating from one destination within your app to another, along specific routes. The Navigation library also provides a specific artifact to enable consistent and idiomatic navigation within screens built with Jetpack Compose. This artifact (`navigation-compose`) is the focal point of this codelab.

## **What you'll do**

You're going to use the [Rally Material study](https://material.io/design/material-studies/rally.html#about-rally) as the base for this codelab. You'll migrate the existing navigation code to use the Jetpack Navigation component to navigate between screens in Jetpack Compose.

## **What you'll learn**

- Basics of using Jetpack Navigation with Jetpack Compose
- Navigating between composables
- Navigating with required and optional arguments
- Navigating using deep links
- Integrating a TabBar into your navigation hierarchy
- Testing navigation

## [2. Setup](https://developer.android.com/codelabs/jetpack-compose-navigation?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-navigation#1)

You can follow along this codelab on your machine.

To follow along on your own, clone the starting point for the codelab.

```
$ git clone https://github.com/googlecodelabs/android-compose-codelabs.git
```



## [3. Migrate to Navigation](https://developer.android.com/codelabs/jetpack-compose-navigation?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-navigation#2)

Rally is an existing app which initially doesn't use Navigation. The migration follows several steps:

1. Add the Navigation dependency
2. Set up the NavController and NavHost
3. Prepare routes for destinations
4. Replace the original destination mechanism with navigation routes

## **Add the Navigation dependency**

Open the app's build file, found at `app/build.gradle`. In the dependencies section, add the `navigation-compose` dependency.

```
dependencies {
  implementation "androidx.navigation:navigation-compose:2.4.0-alpha04"
  // other dependencies
}
```

Now, sync the project and you're ready to start using Navigation in Compose.

## **Set up the NavController**

The [`NavController`](https://developer.android.com/reference/androidx/navigation/NavController) is the central component when using Navigation in Compose; it keeps track of back stack entries, moves the stack forward, enables back stack manipulation, and navigating between screen states. Because `NavController` is central to navigation it has to be created first in order to navigate to destinations.

Within Compose you're working with a [`NavHostController`](https://developer.android.com/reference/androidx/navigation/NavHostController), which is a subclass of `NavController`. Obtain a `NavController` by using the [`rememberNavController()`](https://developer.android.com/reference/kotlin/androidx/navigation/compose/package-summary#rememberNavController()) function; this creates and [remembers](https://developer.android.com/jetpack/compose/state#remember) a `NavController` which survives configuration changes (using [`rememberSavable`](https://developer.android.com/reference/kotlin/androidx/compose/runtime/saveable/package-summary#rememberSaveable(kotlin.Array,androidx.compose.runtime.saveable.Saver,kotlin.String,kotlin.Function0))). The `NavController` is associated with a single [`NavHost`](https://developer.android.com/jetpack/compose/navigation#create-navhost) composable. The `NavHost` links the `NavController` with a navigation graph where composable destinations are specified.

For this codelab, obtain and store your `NavController` within `RallyApp`. It is the root composable for the entire application. You can find it in `RallyActivity.kt`.

```
import androidx.navigation.compose.rememberNavController
...

@Composable
fun RallyApp() {
    RallyTheme {
        val allScreens = RallyScreen.values().toList()
        var currentScreen by rememberSaveable { mutableStateOf(RallyScreen.Overview) }
        val navController = rememberNavController()
        Scaffold(...
}
```

## **Prepare routes for destinations**

### **Overview**

Rally App has three screens:

1. Overview — Overview of all financial transactions and alerts
2. Accounts — Insights into existing accounts
3. Bills — Scheduled expenses

![Screenshot of the overview screen containing information on Alerts, Accounts and Bills.](https://developer.android.com/codelabs/jetpack-compose-navigation/img/87e7dfa76ef51d50.png) ![Screenshot of the Accounts Screen, containing information on several accounts.](https://developer.android.com/codelabs/jetpack-compose-navigation/img/a7c8a51fe2503409.png) ![Screenshot of the Bills Screen, containing information on several outgoing bills.](https://developer.android.com/codelabs/jetpack-compose-navigation/img/9e4c38a6bff0fdbb.png)

All three screens are built using composables. Take a look at `RallyScreen.kt`. The three screens are declared in this file. You will later map these screens to navigation destinations, with `Overview` as the start destination. You will also move the composables away from `RallyScreen` and into a `NavHost`. For now, you can leave `RallyScreen` untouched.

When using Navigation within Compose, routes are represented as strings. You can think of these strings as being similar to URLs or deep links. In this codelab we'll use the `name` property of each `RallyScreen` item as the route, for example, `RallyScreen.Overview.name`.

### **Preparation**

Go back to the `RallyApp` composable in `RallyActivity.kt` and replace `Box` containing the screen's contents with a newly created `NavHost`. Pass in the `navController` we created in the previous step. The `NavHost` also needs a `startDestination`. Set it to `RallyScreen.Overview.name`. Also, create a `Modifier` to pass the padding into the `NavHost`.

```
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Scaffold
import androidx.navigation.compose.NavHost
...

Scaffold(...) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = RallyScreen.Overview.name,
            modifier = Modifier.padding(innerPadding)
        ) { ... }
```

Now we can define our nav graph. The destinations that the `NavHost` can navigate to are ready to accept destinations. We do this using a [`NavGraphBuilder`](https://developer.android.com/reference/kotlin/androidx/navigation/NavGraphBuilder), which is provided to the last parameter of NavHost; a lambda for defining your graph. As this parameter expects a function you can declare destinations in a [trailing lambda](https://developer.android.com/jetpack/compose/kotlin#trailing-lambdas). The Navigation Compose artifact provides the [`NavGraphBuilder.composable`](https://developer.android.com/reference/kotlin/androidx/navigation/compose/package-summary#(androidx.navigation.NavGraphBuilder).composable(kotlin.String, kotlin.collections.List, kotlin.collections.List, kotlin.Function1)) extension function. Use it to define navigation destinations in your graph.

```
import androidx.navigation.compose.NavHost
...

NavHost(
    navController = navController,
    startDestination = RallyScreen.Overview.name,
    modifier = Modifier.padding(innerPadding)

) { 
    composable(RallyScreen.Overview.name) { ... }
}
```

For now, we'll temporarily set a `Text` with the screen's name as content of the composable. In the following step we'll use the existing composables.

```
import androidx.compose.material.Text
import androidx.navigation.compose.composable
...

NavHost(
    navController = navController,
    startDestination = RallyScreen.Overview.name
    modifier = Modifier.padding(innerPadding)
) { 
    composable(RallyScreen.Overview.name) {
      Text(text = RallyScreen.Overview.name)
    }

    // TODO: Add the other two screens
}
```

Now remove the `currentScreen.content` call from the `Scaffold` and run the app; you will see the name of your start destination and the tabs above.

You should end up with a NavHost similar to this one:

```
NavHost(
    navController = navController,
    startDestination = RallyScreen.Overview.name,
    modifier = Modifier.padding(innerPadding)
) {
    composable(RallyScreen.Overview.name) { 
      Text(RallyScreen.Overview.name)
    }
    composable(RallyScreen.Accounts.name) {
        Text(RallyScreen.Accounts.name) 
    }
    composable(RallyScreen.Bills.name) { 
        Text(RallyScreen.Bills.name) 
    }
}
```

The `NavHost` now can replace the `Box` within `Scaffold`. Pass the `Modifier` into NavHost to keep the `innerPadding` intact.

```
@Composable
fun RallyApp() {
    RallyTheme {
        val allScreens = RallyScreen.values().toList()
        // FIXME: This duplicate source of truth
        //  will be removed later.
        var currentScreen by rememberSaveable {
            mutableStateOf(RallyScreen.Overview)
        }
        val navController = rememberNavController()
        Scaffold(
            topBar = {
                RallyTabRow(
                    allScreens = allScreens,
                    onTabSelected = { screen -> currentScreen = screen },
                    currentScreen = currentScreen
                )
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = RallyScreen.Overview.name,
                modifier = Modifier.padding(innerPadding)) {
            }
        }
    }
}
```

At this point the top bar is not yet wired up, so clicking on the tabs won't change the displayed composable. In the next step you'll take care of this.

## Fully integrate navigation bar state changes

In this step you'll wire up the `RallyTabRow` and will get to delete the current manual navigation code. After you have finished this step, the navigation component will completely take care of routing.

**Note:** To make your code testable, we recommend not passing around the navController. In this codelab, you will be providing callbacks to enable navigating from a single point of responsibility.

Still in `RallyActivity`, you'll find that the `RallyTabRow` composable has a callback when a tab has been clicked, called `onTabSelected`. Update the selection code to use `navController` for navigating to the selected screen.

This is all that's necessary to navigate to a screen via the `TabRow` using navigation:

```
@Composable
fun RallyApp() {
    RallyTheme {
        val allScreens = RallyScreen.values().toList()
        // FIXME: This duplicate source of truth
        //  will be removed later.
        var currentScreen by rememberSaveable {
            mutableStateOf(RallyScreen.Overview)
        }
        val navController = rememberNavController()
        Scaffold(
            topBar = {
                RallyTabRow(
                    allScreens = allScreens,
                    onTabSelected = { screen ->
                        navController.navigate(screen.name)
                },
                    currentScreen = currentScreen,
                )
            }
```

With this change, `currentScreen` will no longer be updated. This means that expanding and collapsing of selected items won't work. To re-enable this behavior, the `currentScreen` property needs to be updated as well. Luckily Navigation holds on to the back stack for you and can provide you with the current back stack entry as a [`State`](https://developer.android.com/jetpack/compose/state). With this `State` you can react to changes to the back stack. You can even query the current back stack entry for its route.

To finish migrating the `TabRow` screen selection to Navigation, update `currentScreen` to use the navigation backstack like this.

```
import androidx.navigation.compose.currentBackStackEntryAsState
...

@Composable
fun RallyApp() {
    RallyTheme {
        val allScreens = RallyScreen.values().toList()
        val navController = rememberNavController()
        val backstackEntry = navController.currentBackStackEntryAsState()
        val currentScreen = RallyScreen.fromRoute(
            backstackEntry.value?.destination?.route
        )
        ...
    }
}
```

At this point, when you run the app you're able to switch between screens using the tabs but all that's shown is the screen's name. Before the screen can be displayed, `RallyScreen` needs to be migrated to navigation.

## Migrate RallyScreen to Navigation

After you have completed this step, the composable will be completely decoupled from `RallyScreen` enum and moved into the `NavHost`. `RallyScreen` will only exist to provide an icon and title for the screen.

Open RallyScreen.kt. Move each screen's implementation of `body` into the corresponding composables within your `NavHost` in `RallyApp`.

```
import com.example.compose.rally.data.UserData
import com.example.compose.rally.ui.accounts.AccountsBody
import com.example.compose.rally.ui.bills.BillsBody
import com.example.compose.rally.ui.overview.OverviewBody
...

NavHost(
    navController = navController,
    startDestination = Overview.name,
    modifier = Modifier.padding(innerPadding)
) {
    
    composable(Overview.name) {
        OverviewBody()
    }
    composable(Accounts.name) {
        AccountsBody(accounts = UserData.accounts)
    }
    composable(Bills.name) {
        BillsBody(bills = UserData.bills)
    }
}
```

At this point you can safely remove the `content` function and `body` parameter and its usages from `RallyScreen` which will leave you with this code:

```
enum class RallyScreen(
    val icon: ImageVector,
) {
    Overview(
        icon = Icons.Filled.PieChart,
    ),
    Accounts(
        icon = Icons.Filled.AttachMoney,
    ),
    Bills(
        icon = Icons.Filled.MoneyOff,
    );

    companion object {
        ...
    }
}
```

Run the app again. You'll see the original three screens and can navigate between them through the TabRow.

**Note:** With the above changes, back navigation is now supported through the Navigation Component. Switching between the screens and then pressing the back button will result in popping the stack and bringing you to the previous destination.

## **Enable clicks on OverviewScreen**

In this codelab, click events on `OverviewBody` were initially ignored. This means that the "SEE ALL" button was clickable, but did not go anywhere.

![Screen recording of the overview screen, scrolling to eventual click destinations, and attempting to click. Clicks don't work as they aren't implemented yet.](https://developer.android.com/codelabs/jetpack-compose-navigation/img/29dc1e26aa33faf3.gif)

Let's fix that!

`OverviewBody` can accept several functions as callbacks to click events. Let's implement `onClickSeeAllAccounts` and `onClickSeeAllBills` to navigate to relevant destinations.

To enable navigation when the "see all" button is clicked, use the `navController` and navigate to either the Accounts or Bills screen. Open `RallyActivity.kt`, find `OverviewBody` within `NavHost` and add the navigation calls.

```
OverviewBody(
    onClickSeeAllAccounts = { navController.navigate(Accounts.name) },
    onClickSeeAllBills = { navController.navigate(Bills.name) },
)
```

Now it has become possible to easily change the behavior of click events for `OverviewBody`. Keeping the `navController` at the top level of your navigation hierarchy and not passing it directly into `OverviewBody` makes it easy to preview or test `OverviewBody` in isolation, without having to rely on an actual `navController` being present when doing so.

## [4. Navigating with arguments](https://developer.android.com/codelabs/jetpack-compose-navigation?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-navigation#3)

Let's add some new functionality to Rally! We'll add an Accounts screen which shows details of an individual account when a row is clicked.

A navigation argument makes the route dynamic. Navigation arguments are a very powerful tool to make routing behavior dynamic by passing one or more arguments into a route and adjusting argument types or default values.

**Note:** A named argument is provided inside routes in curly braces like this `{argument}`. It is a syntax that looks similar to Kotlin's string template syntax, using the dollar sign `$` to escape variable names.

In `RallyActivity` add a new destination to the graph by adding a new composable to the existing `NavHost` with the argument `Accounts/{name}`. For this destination we'll also specify a list of `navArgument`s. We'll define a single argument called "name" of type `String`.

```
import androidx.navigation.NavType
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navArgument
...

val accountsName = RallyScreen.Accounts.name

composable(
    route = "$accountsName/{name}",
    arguments = listOf(
        navArgument("name") {
            // Make argument type safe
            type = NavType.StringType
        }
    )
) { 
    // TODO
}
```

The body of each `composable` destination receives a parameter (which we haven't used so far) of the current [`NavBackStackEntry`](https://developer.android.com/reference/kotlin/androidx/navigation/NavBackStackEntry) which models the route and arguments of the current destination. We can use `arguments` to retrieve the argument i.e. the name of the selected account, and look this up in `UserData` and pass it into the `SingleAccountBody` composable.

You also could provide a default value to use if the argument has not been provided. We'll skip that because it's not necessary here.

Your code should now look like this:

```
import androidx.navigation.NavType
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navArgument
...

val accountsName = RallyScreen.Accounts.name
NavHost(...) {
    ...
    composable(
        "$accountsName/{name}",
        arguments = listOf(
            navArgument("name") {
                // Make argument type safe
                type = NavType.StringType
            }
        )
    ) { entry -> // Look up "name" in NavBackStackEntry's arguments
        val accountName = entry.arguments?.getString("name")
        // Find first name match in UserData
        val account = UserData.getAccount(accountName)
        // Pass account to SingleAccountBody
        SingleAccountBody(account = account)
    }
}
```

## **Navigate to SingleAccountBody**

Now that the composable is set up with the argument, you can navigate to it, using the `navController` like this: `navController.navigate("${RallyScreen.Accounts.name}/$accountName")`.

Add this function to the `onAccountClick` parameter of `OverviewBody`'s declaration in `NavHost` and to `onAccountClick` of `AccountsBody`.

To keep things reusable you could create a private helper function like below.

```
fun RallyNavHost(
    ...
) {
    NavHost(
        ...
    ) {
        composable(Overview.name) {
            OverviewBody(
                ...
                onAccountClick = { name ->
                    navigateToSingleAccount(navController, name)
                },
            )
        }
        composable(Accounts.name) {
            AccountsBody(accounts = UserData.accounts) { name ->
                navigateToSingleAccount(
                    navController = navController,
                    accountName = name
                )
            }
        }
        ...
    }
}

private fun navigateToSingleAccount(
    navController: NavHostController,
    accountName: String
) {
    navController.navigate("${Accounts.name}/$accountName")
}
```

When you run the app at this point, you're able to click on each account and will be taken into a screen, displaying data for the given account.

![Screen recording of the overview screen, scrolling to eventual click destinations, and attempting to click. Clicks lead to destinations now.](https://developer.android.com/codelabs/jetpack-compose-navigation/img/738904c865885b3b.gif)

## [5. Enable deep link support](https://developer.android.com/codelabs/jetpack-compose-navigation?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-navigation#4)

In addition to arguments you can also use [deep links](https://developer.android.com/training/app-links/deep-linking) to expose destinations in your app to third party apps. In this section you'll add a new deep link to the route created in the previous section, enabling deep links from outside your app to individual accounts directly by name.

## **Add the intent filter**

To start, add the deep link to the `AndroidManifest.xml`. You need to create a new intent filter for `RallyActivity` with the action `VIEW` and categories `BROWSABLE` and `DEFAULT`.

Then, using the `data` tag, add a `scheme`, `host` and `pathPrefix`.

This codelab will use `rally://accounts/{name}` as a deep link URL.

You don't need to declare the "name" argument in the AndroidManifest. It will be parsed as an argument by Navigation.

```
<activity
    android:name=".RallyActivity"
    android:windowSoftInputMode="adjustResize"
    android:label="@string/app_name"
    android:exported="true">
    <intent-filter>
        <action android:name="android.intent.action.MAIN" />
        <category android:name="android.intent.category.LAUNCHER" />
    </intent-filter>
    <intent-filter>
        <action android:name="android.intent.action.VIEW" />
        <category android:name="android.intent.category.DEFAULT" />
        <category android:name="android.intent.category.BROWSABLE" />
        <data android:scheme="rally" android:host="accounts" />
    </intent-filter>
</activity>
```

## React to the deep link

Now you can react to the incoming intent from within `RallyActivity`.

The composable you created earlier to accept arguments can also accept the newly created deep link.

Add a list of `deepLinks` using the `navDeepLink` function. Pass the `uriPattern` and provide the matching uri for the `intent-filter` above. Pass the created deep link into the composable, using the `deepLinks` parameter.

```
val accountsName = RallyScreen.Accounts.name

composable(
    "$accountsName/{name}",
    arguments = listOf(
        navArgument("name") {
            type = NavType.StringType
        },
    ),
    deepLinks =  listOf(navDeepLink {
        uriPattern = "rally://$accountsName/{name}"
    })
)
```

## Test the deep link using adb

Now your app is ready to handle deep links. To test that it behaves correctly, install a current version of Rally on an emulator or device, open a command line and execute the following command:

```
adb shell am start -d "rally://accounts/Checking" -a android.intent.action.VIEW
```

This will take you directly into the checking account and works for all account names in the app.

## [6. Extract finished NavHost](https://developer.android.com/codelabs/jetpack-compose-navigation?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-navigation#5)

Now your `NavHost` is complete. You can extract it from the `RallyApp` composable to its own function and call it `RallyNavHost`. This is the one and only composable you should work directly with the `navController`. By not creating the `navController` within `RallyNavHost`, you can still use it to make tab selection, which is part of the higher structure, within `RallyApp`.

```
@Composable
fun RallyNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Overview.name,
        modifier = modifier
    ) {
        composable(Overview.name) {
            OverviewBody(
                onClickSeeAllAccounts = { navController.navigate(Accounts.name) },
                onClickSeeAllBills = { navController.navigate(Bills.name) },
                onAccountClick = { name ->
                    navController.navigate("${Accounts.name}/$name")
                },
            )
        }
        composable(Accounts.name) {
            AccountsBody(accounts = UserData.accounts) { name ->
                navController.navigate("Accounts/${name}")
            }
        }
        composable(Bills.name) {
            BillsBody(bills = UserData.bills)
        }
        val accountsName = Accounts.name
        composable(
            "$accountsName/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                },
            ),
            deepLinks = listOf(navDeepLink {
                uriPattern = "example://rally/$accountsName/{name}"
            }),
        ) { entry ->
            val accountName = entry.arguments?.getString("name")
            val account = UserData.getAccount(accountName)
            SingleAccountBody(account = account)
        }
    }
}
```

Also, make sure to replace the original call site with `RallyNavHost(navController)` to keep things working as intended.

```
fun RallyApp() {
    RallyTheme {
    ...
        Scaffold(
        ...
        ) { innerPadding ->
            RallyNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
            
        }
     }
}
```

## [7. Testing Navigation in Compose](https://developer.android.com/codelabs/jetpack-compose-navigation?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-navigation#6)

**Note:** This codelab does not teach the Compose testing basics. To learn these, visit the Compose Testing [docs](https://developer.android.com/jetpack/compose/testing) or [codelab](https://developer.android.com/codelabs/jetpack-compose-testing). To learn more about advanced testing of navigation code, such as using the `TestNavHostController`, visit the [Test Navigation](https://developer.android.com/guide/navigation/navigation-testing) guide.

From the beginning of this codelab we made sure not to pass the `navController` directly into any composables, but instead you passed callbacks as parameters. This means that all your composables are individually testable. But you also can test the entire `NavHost`, and that's what this step is all about. To test individual Composable functions, make sure to check out the [Testing in Jetpack Compose](https://developer.android.com/codelabs/jetpack-compose-testing) codelab.

## Prepare the test class

Your NavHost can be tested in isolation from the Activity itself.

As this test still will run on an Android device you'll need to create your test file in the `androidTest` directory under `/app/src/androidTest/java/com/example/compose/rally`.

Do this and name it `RallyNavHostTest`.

And then, to use the compose testing APIs, create the compose test rule like below.

```
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule

class RallyNavHostTest {

    @get:Rule
    val composeTestRule = createComposeRule()

}
```

Now you're set to write an actual test.

## **Write your first test**

Create a test function, which has to be public and annotated with `@Test`. In that function, you have to set the content that you want to test. Do this, using `composeTestRule`'s `setContent`. It takes a Composable parameter and enables you to write Compose code, as if you were in a regular app. Set up the `RallyNavHost` like you did in `RallyActivity`.

```
import androidx.navigation.compose.rememberNavController
import org.junit.Assert.fail
import org.junit.Test
...

class RallyNavHostTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    lateinit var navController: NavHostController

    @Test
    fun rallyNavHost() {
        composeTestRule.setContent {
            navController = rememberNavController()
            RallyNavHost(navController = navController)
        }
        fail()
    }
}
```

If you copied above code, the `fail()` call will ensure that your test fails until there is an actual assertion made. It serves as a reminder to finish implementing the test.

**Note:** To check that your `NavHost` is working correctly, the hierarchy will have to be composed first. This means that your assertions will have to be written **outside** of the `setContent` function.

You can verify that the correct screen is displayed using content description. In this codelab, content descriptions for `"Accounts Screen"` and `"Overview Screen"` are provided for you to use for test verification. Create a `lateinit` property in the test class itself, so you can use it in future tests as well.

For an easy start, check that the `OverviewScreen` is displayed.

```
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.navigation.NavHostController
...

class RallyNavHostTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    lateinit var navController: NavHostController

    @Test
    fun rallyNavHost() {
        composeTestRule.setContent {
            navController = rememberNavController()
            RallyNavHost(navController = navController)
        }
        composeTestRule
            .onNodeWithContentDescription("Overview Screen")
            .assertIsDisplayed()
    }
}
```

Remove the `fail()` call, run the test again, and it passes. Rightfully so.

In each of the following tests, `RallyNavHost` will be set up the same way. So you can extract this into a function annotated with `@Before` to keep your code clean.

```
import org.junit.Before
...

class RallyNavHostTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    lateinit var navController: NavHostController

    @Before
    fun setupRallyNavHost() {
        composeTestRule.setContent {
            navController = rememberNavController()
            RallyNavHost(navController = navController)
        }
    }

    @Test
    fun rallyNavHost() {
        composeTestRule
            .onNodeWithContentDescription("Overview Screen")
            .assertIsDisplayed()
    }
}
```

## Navigating in tests

You can test your navigation implementation in multiple ways, by performing clicks on the UI elements that should lead to a new destination or by calling `navigate` with the corresponding route name.

### **Test via UI and test rule**

As you want to test your app's implementation, clicks on the UI are preferable. Write a test to click on the "All Accounts" button that leads to the "Accounts Screen" and verify that the right screen is displayed.

```
import androidx.compose.ui.test.performClick
...

@Test
fun rallyNavHost_navigateToAllAccounts_viaUI() {
    composeTestRule
        .onNodeWithContentDescription("All Accounts")
        .performClick()
    composeTestRule
        .onNodeWithContentDescription("Accounts Screen")
        .assertIsDisplayed()
}
```

### Test via UI and navController

You also can use the `navController` to check your assertions. To do this perform a click on the UI and then, compare the current route to the one you expect, using `backstackEntry.value?.destination?.route`.

```
import androidx.compose.ui.test.performScrollTo
import org.junit.Assert.assertEquals
...

@Test
fun rallyNavHost_navigateToBills_viaUI() {
    // When click on "All Bills"
    composeTestRule.onNodeWithContentDescription("All Bills").apply {
        performScrollTo()
        performClick()
    }
    // Then the route is "Bills"
    val route = navController.currentBackStackEntry?.destination?.route
    assertEquals(route, "Bills")
}
```

### **Test via navController**

A third option is to call `navController.navigate` directly — there's one caveat here. Calls to `navController.navigate` need to be made on the UI thread. You can achieve this by using `Coroutines` with the `Main` thread dispatcher. And since the call needs to happen **before** you can make an assertion about a new state, it needs to be wrapped in a `runBlocking` call.

```
runBlocking {
    withContext(Dispatchers.Main) {
        navController.navigate(RallyScreen.Accounts.name)
    }
}
```

With this you can navigate around the app and assert that the route takes you where you expect it to.

```
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
...

@Test
fun rallyNavHost_navigateToAllAccounts_callingNavigate() {
    runBlocking {
        withContext(Dispatchers.Main) {
            navController.navigate(RallyScreen.Accounts.name)
        }
    }
    composeTestRule
        .onNodeWithContentDescription("Accounts Screen")
        .assertIsDisplayed()
}
```

To learn more about testing in Compose, check out the codelab linked in the "What's next?" section of the following step.

## [8. Congratulations](https://developer.android.com/codelabs/jetpack-compose-navigation?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-navigation#7)

Congratulations, you've successfully completed this codelab!

You added Navigation to the Rally app and now know the key concepts of using navigation in Jetpack Compose. You learned how to create a nav graph of composable destinations, add arguments to routes, add deep links, and test your implementation in multiple ways.