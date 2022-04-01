# Dark mode with Jetpack Compose

Now that we saw how we can implement dark mode for the legacy XML way for designing UIs in Android, we take a look at how we can accomplish the same in Jetpack Compose and the new [Material Design 3 library](https://m3.material.io/).

For accomplishing our task, we will be using the `MaterialTheme`[ ](https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary#materialtheme)component.

The component allows us to define an app-wide theme for our Android app’s UI, written with Jetpack Compose. It can be seen as equivalent to the legacy XML app theme we discussed before.

As the first step, we need to include the Compose version of Material 3 into our app-level `build.gradle` dependencies. At the time of writing, the library is currently in alpha state. So if you are reading this article at a later point in time, make sure you update to the latest version.

`implementation 'androidx.compose.material3:material3:1.0.0-alpha01'`

Now that we added the dependency, we can make use of its color schemes. Because we want to support light and a dark theme, we need to declare a `lightColorScheme` and also a `darkColorScheme`:

```kotlin
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
private val ourDarkColorScheme = darkColorScheme(
    primary = Color.Black,
    secondary = Color.White
)

private val ourLightColorScheme = lightColorScheme(
    primary = Color.Yellow,
    secondary = Color.Black
)
```

Now that we have our color schemes, we can declare our actual overall app theme:

```kotlin
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun OurAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val ourColorScheme = if (darkTheme) ourDarkColorScheme else ourLightColorScheme
MaterialTheme(
    content = content,
    colorScheme = ourColorScheme
)
}
```
As you can see we use the `isSystemInDarkTheme()` function to determine if our app is currently in dark mode. Depending on which state is currently applied, we set the respective color scheme to the `MaterialTheme` component.

Because of the `isSystemInDarkTheme()` function, the app will automatically trigger a recomposition as soon as the state of the dark mode setting changes and will show the updated color scheme.

## Example usage

As an example of how to use the theme, take a look at the following code snippet:

```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OurAppTheme {
                Surface(
                    modifier = com.example.sky.Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    Text(
                        modifier = com.example.sky.Modifier.padding(16.dp),
                        text = "We are now using Material Design 3!",
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
            }
        }
    }
}
```

We just add a `Text` to a `Surface`. The surface gets the primary color of our current set color scheme as background. The text color is defined by the secondary color scheme value.

The .gif below shows the seamless transition between light and dark mode.