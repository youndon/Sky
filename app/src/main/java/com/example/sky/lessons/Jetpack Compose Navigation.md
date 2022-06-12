

# Jetpack Compose: Navigation

![Banner Jetpack Compose Navigation](https://s3.ap-south-1.amazonaws.com/mindorks-server-uploads/banner-jetpack-compose-navigation-657edc7b323cafdf.png)

Navigation is one of the important features that every Android application has. We navigate from one screen to another. It can be from activity to activity or fragment to fragment or anything else. You will hardly find any application that doesn't involve some navigation into it.

We know how to implement navigation in Android. But, today, we will learn how to perform navigation in Jetpack Compose.

In this blog, we will learn how to navigate between different composable using Jetpack Navigation. So, let's get started with the setup.

## Set up

To use the navigation in the Jetpack Compose project, all you need to do is add the below dependency in your `build.gradle` file:

```groovy
implementation "androidx.navigation:navigation-compose:2.4.1"
```

Now, we are ready to use the navigation in our application.

Basically, there are two main parts of a Jetpack Compose Navigation:

1. NavController
2. NavHost

### NavController

You can think of a NavController as the central API for the Navigation Component. So to navigate to any destination, we need to use the NavController.

To create a NavController, you can use the `rememberNavController()` method. Thus, the NavController is stateful and it will have all the information about the back stack. So, you needn't handle it separately. The following is an example of NavController:

```kotlin
val navController = rememberNavController()
```

A NavController should be associated with only one NavHost. But what is this NavHost? Let's learn about it.

### NavHost

You can think of a NavHost as an area where you can draw your screen and with the help of NavController you can navigate between various screens present in your NavHost.

Every screen in the NavHost is having some route associated with it and with the help of this route, the navigation between screens is performed. The following is an example of NavHost:

```kotlin
val navController = rememberNavController()
NavHost(
        navController = navController,
        startDestination = "first_screen"
) {
    composable("first_screen") {
        // first screen
    }
    composable("second_screen") {
        // second screen
    }
}
```

As you can see in the above code, NavHost is taking two arguments i.e. `navController` and the `startDestination`. `startDestination` is the start screen of the Navigation. You can think of this as the entry point of the Navigation. Inside the NavHost, you can declare as many composable as you want.

Now, let's implement the Navigation in a project.

> **NOTE:** To use Jetpack Compose, you need to have the latest Canary version of Android Studio 4.2. So, you can move over to the [Android Studio Preview](https://developer.android.com/studio/preview) page and download the latest Canary version.

## Navigation Project

Open Android Studio and create an Empty Compose Activity.

After creating the project, you need to add the dependency of Navigation in your `build.gradle` file:

```groovy
implementation "androidx.navigation:navigation-compose:1.0.0-alpha02"
```

After adding the dependency, sync your project.

> **NOTE:** To use Navigation, you need to carefully use the Jetpack Compose version and Navigation version. In my case, the Jetpack Compose version is "1.0.0-alpha07" and Navigation version is "1.0.0-alpha02".

To keep it simple, we are going to add three screens i.e. Screen One, Screen Two, and Screen Three. Each screen will have one text on it and on clicking the text, you will navigate from one screen to another.

We know that for using Navigation we need to make `NavHost` and inside that NavHost, all our screens will be there. At the same time, we also know that NavHost requires NavController.

So, let's make a composable function named ComposeNavigation:

```kotlin
@Composable
fun ComposeNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "first_screen"
    ) {
        composable("first_screen") {
            FirstScreen(navController = navController)
        }
        composable("second_screen") {
            SecondScreen(navController = navController)
        }
        composable("third_screen") {
            ThirdScreen(navController = navController)
        }
    }
}
```

In the above code, we are using NavHost for making our screens and our first screen is "first_screen" because we are setting startDestination to "first_screen". Here, "**first_screen**", "**second_screen**", and "**third_screen**" is the route of each screen. Each destination should have a unique route because with the help of these routes one screen is differentiated from others.

Now, let's make the UI of each screen. The following is the code of the First Screen:

```kotlin
@Composable
fun FirstScreen(navController: NavController) {
    Column(
        modifier = com.example.sky.Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "First Screen\n" +
                    "Click me to go to Second Screen",
            color = Color.Green,
            style = TextStyle(textAlign = TextAlign.Center),
            modifier = com.example.sky.Modifier.padding(24.dp).clickable(onClick = {
                // this will navigate to second screen
                navController.navigate("second_screen")
            })
        )
    }
}
```

In the above code, you can see that on click of the text, we are using the navController to navigate to the "**second_screen**" using the `navigate` method.

> **NOTE:** You need to explicitly import the navigate("some_string") method(If your IDE fails to do that).

```kotlin
import androidx.navigation.compose.navigate
```

Similarly, you can make the UI of other screens like below:

```kotlin
@Composable
fun SecondScreen(navController: NavController) {
    Column(
        modifier = com.example.sky.Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Second Screen\n" +
                    "Click me to go to Third Screen",
            color = Color.Yellow,
            style = TextStyle(textAlign = TextAlign.Center),
            modifier = com.example.sky.Modifier.clickable(onClick = {
                // this will navigate to third screen
                navController.navigate("third_screen")
            })
        )
    }
}

@Composable
fun ThirdScreen(navController: NavController) {
    Column(
        modifier = com.example.sky.Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Third Screen\n" +
                    "Click me to go to First Screen",
            color = Color.Red,
            style = TextStyle(textAlign = TextAlign.Center),
            modifier = com.example.sky.Modifier.clickable(onClick = {
                // this will navigate to first screen
                navController.navigate("first_screen")
            })
        )
    }
}
```

Finally, you need to call the `ComposeNavigation` method from the `setContent` like below:

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
        ComposeNavigationTheme {
            ComposeNavigation()
        }
    }
}
```

Now, run the app and tap on the text to navigate to a different screen. Also, try to press the back button and verify if the back stack is being maintained or not.

That's it for this blog. If you want to learn more about Jetpack Compose then you should look at our **[Project to learn Jetpack Compose in Android by example](https://github.com/MindorksOpenSource/Jetpack-Compose-Android-Examples).**

**Keep Learning!**

**Sumit Mishra**