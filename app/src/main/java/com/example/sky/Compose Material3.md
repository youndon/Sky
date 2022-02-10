[![Android Developers](https://www.gstatic.cn/devrel-devsite/prod/v9a7f09bb7f4c184c1c51854c0e49b9781e5080168a451bfdb66303a8ed0ad46f/android/images/lockup.svg)](https://developer.android.google.cn/)

# androidx.compose.material3

**Kotlin** |Java

Build Jetpack Compose UIs with [Material Design 3](https://m3.material.io/), the next evolution of Material Design. Material 3 includes updated theming and components and Material You personalization features like dynamic color, and is designed to be cohesive with the new Android 12 visual style and system UI.

![Material You image](https://developer.android.google.cn/images/reference/androidx/compose/material3/material-you.png)

In this page, you'll find documentation for types, properties, and functions available in the `androidx.compose.material3` package.

For more information, check out the [Material Design 3 and Material You](https://developer.android.google.cn/jetpack/compose/themes/material#material3) section in the Material Theming in Compose guide.

## Overview

### Theming

Material 3 makes brand expression in an interface simpler and more beautiful than ever before, with [color](https://m3.material.io/styles/color/overview) and [typography](https://m3.material.io/styles/typography/overview) theming.

|                      | **APIs**                  | **Description**            |
| -------------------- | ------------------------- | -------------------------- |
| **Material Theming** | `MaterialTheme`           | M3 theme                   |
| **Color scheme**     | `ColorScheme`             | M3 color scheme            |
| **Dynamic color**    | `dynamicLightColorScheme` | Dynamic light color scheme |
|                      | `dynamicDarkColorScheme`  | Dynamic dark color scheme  |
| **Typography**       | `Typography`              | M3 type scale              |

### Components

Material 3 Components are interactive building blocks for creating a user interface.

|                       | **APIs**                       | **Description**               |
| --------------------- | ------------------------------ | ----------------------------- |
| **Buttons**           | `Button`                       | M3 filled button              |
|                       | `ElevatedButton`               | M3 elevated button            |
|                       | `FilledTonalButton`            | M3 filled tonal button        |
|                       | `OutlinedButton`               | M3 outlined button            |
|                       | `TextButton`                   | M3 text button                |
| **FAB**               | `FloatingActionButton`         | M3 FAB                        |
|                       | `SmallFloatingActionButton`    | M3 small FAB                  |
|                       | `LargeFloatingActionButton`    | M3 large FAB                  |
| **Extended FAB**      | `ExtendedFloatingActionButton` | M3 extended FAB               |
| **Dialogs**           | `AlertDialog`                  | M3 basic dialog               |
| **Navigation bar**    | `NavigationBar`                | M3 navigation bar             |
| **Navigation drawer** | `NavigationDrawer`             | M3 navigation drawer          |
| **Navigation rail**   | `NavigationRail`               | M3 navigation rail            |
| **Top app bar**       | `SmallTopAppBar`               | M3 small top app bar          |
|                       | `CenterAlignedTopAppBar`       | M3 center-aligned top app bar |
|                       | `MediumTopAppBar`              | M3 medium top app bar         |
|                       | `LargeTopAppBar`               | M3 large top app bar          |

### Surfaces and layout

Material 3 defines the qualities that can be expressed by UI regions, surfaces, and components.

|              | **APIs**   | **Description**                  |
| ------------ | ---------- | -------------------------------- |
| **Surfaces** | `Surface`  | M3 surface                       |
| **Layout**   | `Scaffold` | Basic M3 visual layout structure |

## Interfaces

| `ButtonColors`                  | Represents the container and content colors used in a button in different states. |
| ------------------------------- | ------------------------------------------------------------ |
| `ButtonElevation`               | Represents the elevation for a button in different states.   |
| `CheckboxColors`                | Represents the colors used by the three different sections (checkmark, box, and border) of a `Checkbox` or `TriStateCheckbox` in different states. |
| `FloatingActionButtonElevation` | Represents the tonal and shadow elevation for a floating action button in different states. |
| `NavigationBarItemColors`       | Represents the colors of the various elements of a navigation item. |
| `NavigationRailItemColors`      | Represents the colors of the various elements of a navigation item. |
| `RadioButtonColors`             | Represents the color used by a `RadioButton` in different states. |
| `SnackbarData`                  | Interface to represent the data of one particular `Snackbar` as a piece of the `SnackbarHostState`. |
| `SnackbarVisuals`               | Interface to represent the visuals of one particular `Snackbar` as a piece of the `SnackbarData`. |
| `TopAppBarColors`               | Represents the colors used by a top app bar in different states. |
| `TopAppBarScrollBehavior`       | A TopAppBarScrollBehavior defines how an app bar should behave when the content under it is scrolled. |

## Classes

| `ColorScheme`       | A color scheme holds all the named color parameters for a `MaterialTheme`. |
| ------------------- | ------------------------------------------------------------ |
| `DrawerState`       | State of the `NavigationDrawer` composable.                  |
| `FabPosition`       | The possible positions for a `FloatingActionButton` attached to a `Scaffold`. |
| `SnackbarHostState` | State of the `SnackbarHost`, controls the queue and the current `Snackbar` being shown inside the `SnackbarHost`. |
| `Typography`        | The Material Design type scale includes a range of contrasting styles that support the needs of your product and its content. |

## Annotations

| `ExperimentalMaterial3Api` |      |
| -------------------------- | ---- |
|                            |      |

## Enums

| `DrawerValue`      | Possible values of `DrawerState`.                            |
| ------------------ | ------------------------------------------------------------ |
| `SnackbarDuration` | Possible durations of the `Snackbar` in `SnackbarHost`       |
| `SnackbarResult`   | Possible results of the `SnackbarHostState.showSnackbar` call |

## Top-level functions summary

| `@Composable Unit`                                  | `AlertDialog(  onDismissRequest: (() -> Unit)?,  confirmButton: (@Composable () -> Unit)?,  modifier: Modifier?,  dismissButton: (@Composable () -> Unit)?,  icon: (@Composable () -> Unit)?,  title: (@Composable () -> Unit)?,  text: (@Composable () -> Unit)?,  shape: Shape?,  containerColor: Color?,  tonalElevation: Dp?,  iconContentColor: Color?,  titleContentColor: Color?,  textContentColor: Color?,  properties: DialogProperties?)`![Basic dialog image](https://developer.android.google.cn/images/reference/androidx/compose/material3/basic-dialog.png) |
| --------------------------------------------------- | ------------------------------------------------------------ |
| `@Composable Unit`                                  | `Badge(  modifier: Modifier?,  containerColor: Color?,  contentColor: Color?,  content: (@Composable @ExtensionFunctionType RowScope.() -> Unit)?)`Badge is a component that can contain dynamic information, such as the presence of a new notification or a number of pending requests. |
| `@Composable Unit`                                  | `BadgedBox(  badge: (@Composable @ExtensionFunctionType BoxScope.() -> Unit)?,  modifier: Modifier?,  content: (@Composable @ExtensionFunctionType BoxScope.() -> Unit)?)`A BadgeBox is used to decorate `content` with a `badge` that can contain dynamic information, such as the presence of a new notification or a number of pending requests. |
| `@Composable Unit`                                  | `Button(  onClick: (() -> Unit)?,  modifier: Modifier?,  enabled: Boolean?,  interactionSource: MutableInteractionSource?,  elevation: ButtonElevation?,  shape: Shape?,  border: BorderStroke?,  colors: ButtonColors?,  contentPadding: PaddingValues?,  content: (@Composable @ExtensionFunctionType RowScope.() -> Unit)?)`![Filled button image](https://developer.android.google.cn/images/reference/androidx/compose/material3/filled-button.png) |
| `@Composable Unit`                                  | `CenterAlignedTopAppBar(  title: (@Composable () -> Unit)?,  modifier: Modifier?,  navigationIcon: (@Composable () -> Unit)?,  actions: (@Composable @ExtensionFunctionType RowScope.() -> Unit)?,  colors: TopAppBarColors?,  scrollBehavior: TopAppBarScrollBehavior?)`![Center-aligned top app bar image](https://developer.android.google.cn/images/reference/androidx/compose/material3/center-aligned-top-app-bar.png) |
| `@Composable Unit`                                  | `Checkbox(  checked: Boolean?,  onCheckedChange: ((Boolean) -> Unit)?,  modifier: Modifier?,  enabled: Boolean?,  interactionSource: MutableInteractionSource?,  colors: CheckboxColors?)`Material Design checkbox. |
| `@Composable Unit`                                  | `ElevatedButton(  onClick: (() -> Unit)?,  modifier: Modifier?,  enabled: Boolean?,  interactionSource: MutableInteractionSource?,  elevation: ButtonElevation?,  shape: Shape?,  border: BorderStroke?,  colors: ButtonColors?,  contentPadding: PaddingValues?,  content: (@Composable @ExtensionFunctionType RowScope.() -> Unit)?)`![Elevated button image](https://developer.android.google.cn/images/reference/androidx/compose/material3/elevated-button.png) |
| `@Composable Unit`                                  | `ExtendedFloatingActionButton(  text: (@Composable () -> Unit)?,  onClick: (() -> Unit)?,  modifier: Modifier?,  icon: (@Composable () -> Unit)?,  interactionSource: MutableInteractionSource?,  shape: Shape?,  containerColor: Color?,  contentColor: Color?,  elevation: FloatingActionButtonElevation?)`![Extended FAB image](https://developer.android.google.cn/images/reference/androidx/compose/material3/extended-fab.png) |
| `@Composable Unit`                                  | `FilledTonalButton(  onClick: (() -> Unit)?,  modifier: Modifier?,  enabled: Boolean?,  interactionSource: MutableInteractionSource?,  elevation: ButtonElevation?,  shape: Shape?,  border: BorderStroke?,  colors: ButtonColors?,  contentPadding: PaddingValues?,  content: (@Composable @ExtensionFunctionType RowScope.() -> Unit)?)`![Filled tonal button image](https://developer.android.google.cn/images/reference/androidx/compose/material3/filled-tonal-button.png) |
| `@Composable Unit`                                  | `FloatingActionButton(  onClick: (() -> Unit)?,  modifier: Modifier?,  interactionSource: MutableInteractionSource?,  shape: Shape?,  containerColor: Color?,  contentColor: Color?,  elevation: FloatingActionButtonElevation?,  content: (@Composable () -> Unit)?)`![FAB image](https://developer.android.google.cn/images/reference/androidx/compose/material3/fab.png) |
| `@Composable Unit`                                  | `Icon(  imageVector: ImageVector?,  contentDescription: String?,  modifier: Modifier?,  tint: Color?)`Icon component that draws `imageVector` using `tint`, defaulting to `LocalContentColor`. |
| `@Composable Unit`                                  | `Icon(  bitmap: ImageBitmap?,  contentDescription: String?,  modifier: Modifier?,  tint: Color?)`Icon component that draws `bitmap` using `tint`, defaulting to `LocalContentColor`. |
| `@Composable Unit`                                  | `Icon(  painter: Painter?,  contentDescription: String?,  modifier: Modifier?,  tint: Color?)`Icon component that draws a `painter` using `tint`, defaulting to `LocalContentColor`. |
| `@Composable Unit`                                  | `IconButton(  onClick: (() -> Unit)?,  modifier: Modifier?,  enabled: Boolean?,  interactionSource: MutableInteractionSource?,  content: (@Composable () -> Unit)?)`IconButton is a clickable icon, used to represent actions. |
| `@Composable Unit`                                  | `IconToggleButton(  checked: Boolean?,  onCheckedChange: ((Boolean) -> Unit)?,  modifier: Modifier?,  enabled: Boolean?,  interactionSource: MutableInteractionSource?,  content: (@Composable () -> Unit)?)`An `IconButton` with two states, for icons that can be toggled 'on' and 'off', such as a bookmark icon, or a navigation icon that opens a drawer. |
| `@Composable Unit`                                  | `LargeFloatingActionButton(  onClick: (() -> Unit)?,  modifier: Modifier?,  interactionSource: MutableInteractionSource?,  shape: Shape?,  containerColor: Color?,  contentColor: Color?,  elevation: FloatingActionButtonElevation?,  content: (@Composable () -> Unit)?)`![Large FAB image](https://developer.android.google.cn/images/reference/androidx/compose/material3/large-fab.png) |
| `@Composable Unit`                                  | `LargeTopAppBar(  title: (@Composable () -> Unit)?,  modifier: Modifier?,  navigationIcon: (@Composable () -> Unit)?,  actions: (@Composable @ExtensionFunctionType RowScope.() -> Unit)?,  colors: TopAppBarColors?,  scrollBehavior: TopAppBarScrollBehavior?)`![Large top app bar image](https://developer.android.google.cn/images/reference/androidx/compose/material3/large-top-app-bar.png) |
| `@Composable Unit`                                  | `MaterialTheme(  colorScheme: ColorScheme?,  typography: Typography?,  content: (@Composable () -> Unit)?)`Material Theming refers to the customization of your Material Design app to better reflect your product’s brand. |
| `@Composable Unit`                                  | `MediumTopAppBar(  title: (@Composable () -> Unit)?,  modifier: Modifier?,  navigationIcon: (@Composable () -> Unit)?,  actions: (@Composable @ExtensionFunctionType RowScope.() -> Unit)?,  colors: TopAppBarColors?,  scrollBehavior: TopAppBarScrollBehavior?)`![Medium top app bar image](https://developer.android.google.cn/images/reference/androidx/compose/material3/medium-top-app-bar.png) |
| `@Composable Unit`                                  | `NavigationBar(  modifier: Modifier?,  containerColor: Color?,  contentColor: Color?,  tonalElevation: Dp?,  content: (@Composable @ExtensionFunctionType RowScope.() -> Unit)?)`![Navigation bar image](https://developer.android.google.cn/images/reference/androidx/compose/material3/navigation-bar.png) |
| `@Composable @ExperimentalMaterial3Api Unit`        | `NavigationDrawer(  drawerContent: (@Composable @ExtensionFunctionType ColumnScope.() -> Unit)?,  modifier: Modifier?,  drawerState: DrawerState?,  gesturesEnabled: Boolean?,  drawerShape: Shape?,  drawerTonalElevation: Dp?,  drawerContainerColor: Color?,  drawerContentColor: Color?,  scrimColor: Color?,  content: (@Composable () -> Unit)?)`![Navigation drawer image](https://developer.android.google.cn/images/reference/androidx/compose/material3/navigation-drawer.png) |
| `@Composable Unit`                                  | `NavigationRail(  modifier: Modifier?,  containerColor: Color?,  contentColor: Color?,  header: (@Composable @ExtensionFunctionType ColumnScope.() -> Unit)?,  content: (@Composable @ExtensionFunctionType ColumnScope.() -> Unit)?)`![Navigation rail image](https://developer.android.google.cn/images/reference/androidx/compose/material3/navigation-rail.png) |
| `@Composable Unit`                                  | `NavigationRailItem(  selected: Boolean?,  onClick: (() -> Unit)?,  icon: (@Composable () -> Unit)?,  modifier: Modifier?,  enabled: Boolean?,  label: (@Composable () -> Unit)?,  alwaysShowLabel: Boolean?,  interactionSource: MutableInteractionSource?,  colors: NavigationRailItemColors?)`Material Design navigation rail item. |
| `@Composable Unit`                                  | `OutlinedButton(  onClick: (() -> Unit)?,  modifier: Modifier?,  enabled: Boolean?,  interactionSource: MutableInteractionSource?,  elevation: ButtonElevation?,  shape: Shape?,  border: BorderStroke?,  colors: ButtonColors?,  contentPadding: PaddingValues?,  content: (@Composable @ExtensionFunctionType RowScope.() -> Unit)?)`![Outlined button image](https://developer.android.google.cn/images/reference/androidx/compose/material3/outlined-button.png) |
| `@Composable Unit`                                  | `ProvideTextStyle(value: TextStyle?, content: (@Composable () -> Unit)?)`This function is used to set the current value of `LocalTextStyle`, merging the given style with the current style values for any missing attributes. |
| `@Composable Unit`                                  | `RadioButton(  selected: Boolean?,  onClick: (() -> Unit)?,  modifier: Modifier?,  enabled: Boolean?,  interactionSource: MutableInteractionSource?,  colors: RadioButtonColors?)`Material Design radio button. |
| `@ExperimentalMaterial3Api @Composable Unit`        | `Scaffold(  modifier: Modifier?,  topBar: (@Composable () -> Unit)?,  bottomBar: (@Composable () -> Unit)?,  snackbarHost: (@Composable () -> Unit)?,  floatingActionButton: (@Composable () -> Unit)?,  floatingActionButtonPosition: FabPosition?,  containerColor: Color?,  contentColor: Color?,  content: (@Composable (PaddingValues) -> Unit)?)`[Material Design layout](https://material.io/design/layout/understanding-layout.html). |
| `@Composable Unit`                                  | `SmallFloatingActionButton(  onClick: (() -> Unit)?,  modifier: Modifier?,  interactionSource: MutableInteractionSource?,  shape: Shape?,  containerColor: Color?,  contentColor: Color?,  elevation: FloatingActionButtonElevation?,  content: (@Composable () -> Unit)?)`![Small FAB image](https://developer.android.google.cn/images/reference/androidx/compose/material3/small-fab.png) |
| `@Composable Unit`                                  | `SmallTopAppBar(  title: (@Composable () -> Unit)?,  modifier: Modifier?,  navigationIcon: (@Composable () -> Unit)?,  actions: (@Composable @ExtensionFunctionType RowScope.() -> Unit)?,  colors: TopAppBarColors?,  scrollBehavior: TopAppBarScrollBehavior?)`![Small top app bar image](https://developer.android.google.cn/images/reference/androidx/compose/material3/small-top-app-bar.png) |
| `@Composable Unit`                                  | `Snackbar(  modifier: Modifier?,  action: (@Composable () -> Unit)?,  dismissAction: (@Composable () -> Unit)?,  actionOnNewLine: Boolean?,  shape: Shape?,  containerColor: Color?,  contentColor: Color?,  content: (@Composable () -> Unit)?)`Material Design snackbar. |
| `@Composable Unit`                                  | `Snackbar(  snackbarData: SnackbarData?,  modifier: Modifier?,  actionOnNewLine: Boolean?,  shape: Shape?,  containerColor: Color?,  contentColor: Color?,  actionColor: Color?)`Material Design snackbar. |
| `@Composable Unit`                                  | `SnackbarHost(  hostState: SnackbarHostState?,  modifier: Modifier?,  snackbar: (@Composable (SnackbarData) -> Unit)?)`Host for `Snackbar`s to be used in `Scaffold` to properly show, hide and dismiss items based on material specification and the `hostState`. |
| `@Composable Unit`                                  | `Surface(  modifier: Modifier?,  shape: Shape?,  color: Color?,  contentColor: Color?,  tonalElevation: Dp?,  shadowElevation: Dp?,  border: BorderStroke?,  content: (@Composable () -> Unit)?)`Material surface is the central metaphor in material design. |
| `@Composable Unit`                                  | `Surface(  onClick: (() -> Unit)?,  modifier: Modifier?,  shape: Shape?,  color: Color?,  contentColor: Color?,  tonalElevation: Dp?,  shadowElevation: Dp?,  border: BorderStroke?,  interactionSource: MutableInteractionSource?,  indication: Indication?,  enabled: Boolean?,  onClickLabel: String?,  role: Role?,  content: (@Composable () -> Unit)?)`Material surface is the central metaphor in material design. |
| `@Composable Unit`                                  | `Text(  text: String?,  modifier: Modifier?,  color: Color?,  fontSize: TextUnit?,  fontStyle: FontStyle?,  fontWeight: FontWeight?,  fontFamily: FontFamily?,  letterSpacing: TextUnit?,  textDecoration: TextDecoration?,  textAlign: TextAlign?,  lineHeight: TextUnit?,  overflow: TextOverflow?,  softWrap: Boolean?,  maxLines: Int?,  onTextLayout: ((TextLayoutResult) -> Unit)?,  style: TextStyle?)`High level element that displays text and provides semantics / accessibility information. |
| `@Composable Unit`                                  | `Text(  text: AnnotatedString?,  modifier: Modifier?,  color: Color?,  fontSize: TextUnit?,  fontStyle: FontStyle?,  fontWeight: FontWeight?,  fontFamily: FontFamily?,  letterSpacing: TextUnit?,  textDecoration: TextDecoration?,  textAlign: TextAlign?,  lineHeight: TextUnit?,  overflow: TextOverflow?,  softWrap: Boolean?,  maxLines: Int?,  inlineContent: Map<String?, InlineTextContent?>?,  onTextLayout: ((TextLayoutResult) -> Unit)?,  style: TextStyle?)`High level element that displays text and provides semantics / accessibility information. |
| `@Composable Unit`                                  | `TextButton(  onClick: (() -> Unit)?,  modifier: Modifier?,  enabled: Boolean?,  interactionSource: MutableInteractionSource?,  elevation: ButtonElevation?,  shape: Shape?,  border: BorderStroke?,  colors: ButtonColors?,  contentPadding: PaddingValues?,  content: (@Composable @ExtensionFunctionType RowScope.() -> Unit)?)`![Text button image](https://developer.android.google.cn/images/reference/androidx/compose/material3/text-button.png) |
| `@Composable Unit`                                  | `TriStateCheckbox(  state: ToggleableState?,  onClick: (() -> Unit)?,  modifier: Modifier?,  enabled: Boolean?,  interactionSource: MutableInteractionSource?,  colors: CheckboxColors?)`Material Design checkbox parent. |
| `@Composable Color`                                 | `contentColorFor(backgroundColor: Color?)`The Material color system contains pairs of colors that are typically used for the background and content color inside a component. |
| `ColorScheme`                                       | `darkColorScheme(  primary: Color?,  onPrimary: Color?,  primaryContainer: Color?,  onPrimaryContainer: Color?,  inversePrimary: Color?,  secondary: Color?,  onSecondary: Color?,  secondaryContainer: Color?,  onSecondaryContainer: Color?,  tertiary: Color?,  onTertiary: Color?,  tertiaryContainer: Color?,  onTertiaryContainer: Color?,  background: Color?,  onBackground: Color?,  surface: Color?,  onSurface: Color?,  surfaceVariant: Color?,  onSurfaceVariant: Color?,  inverseSurface: Color?,  inverseOnSurface: Color?,  error: Color?,  onError: Color?,  errorContainer: Color?,  onErrorContainer: Color?,  outline: Color?)`Returns a dark Material color scheme. |
| `@RequiresApi(value = 31) ColorScheme`              | `dynamicDarkColorScheme(context: Context?)`Creates a dark dynamic color scheme. |
| `@RequiresApi(value = 31) ColorScheme`              | `dynamicLightColorScheme(context: Context?)`Creates a light dynamic color scheme. |
| `ColorScheme`                                       | `lightColorScheme(  primary: Color?,  onPrimary: Color?,  primaryContainer: Color?,  onPrimaryContainer: Color?,  inversePrimary: Color?,  secondary: Color?,  onSecondary: Color?,  secondaryContainer: Color?,  onSecondaryContainer: Color?,  tertiary: Color?,  onTertiary: Color?,  tertiaryContainer: Color?,  onTertiaryContainer: Color?,  background: Color?,  onBackground: Color?,  surface: Color?,  onSurface: Color?,  surfaceVariant: Color?,  onSurfaceVariant: Color?,  inverseSurface: Color?,  inverseOnSurface: Color?,  error: Color?,  onError: Color?,  errorContainer: Color?,  onErrorContainer: Color?,  outline: Color?)`Returns a light Material color scheme. |
| `@Composable @ExperimentalMaterial3Api DrawerState` | `rememberDrawerState(  initialValue: DrawerValue?,  confirmStateChange: ((DrawerValue) -> Boolean)?)`Create and `remember` a `DrawerState`. |

## Extension functions summary

| `@Composable Unit` | `RowScope?.NavigationBarItem(  selected: Boolean?,  onClick: (() -> Unit)?,  icon: (@Composable () -> Unit)?,  modifier: Modifier?,  enabled: Boolean?,  label: (@Composable () -> Unit)?,  alwaysShowLabel: Boolean?,  interactionSource: MutableInteractionSource?,  colors: NavigationBarItemColors?)`Material Design navigation bar item. |
| ------------------ | ------------------------------------------------------------ |
| `Color`            | `ColorScheme?.contentColorFor(backgroundColor: Color?)`The Material color system contains pairs of colors that are typically used for the background and content color inside a component. |

## Top-level properties summary

| `ProvidableCompositionLocal<Dp>`        | `LocalAbsoluteTonalElevation`CompositionLocal containing the current absolute elevation provided by `Surface` components. |
| --------------------------------------- | ------------------------------------------------------------ |
| `ProvidableCompositionLocal<Color>`     | `LocalContentColor`CompositionLocal containing the preferred content color for a given position in the hierarchy. |
| `ProvidableCompositionLocal<Boolean>`   | `@ExperimentalMaterial3ApiLocalMinimumTouchTargetEnforcement`CompositionLocal that configures whether Material components that have a visual size that is lower than the minimum touch target size for accessibility (such as Button) will include extra space outside the component to ensure that they are accessible. |
| `ProvidableCompositionLocal<TextStyle>` | `LocalTextStyle`CompositionLocal containing the preferred `TextStyle` that will be used by `Text` components by default. |

## Top-level functions



### AlertDialog

```
@Composablefun AlertDialog(    onDismissRequest: (() -> Unit)?,    confirmButton: (@Composable () -> Unit)?,    modifier: Modifier? = Modifier,    dismissButton: (@Composable () -> Unit)? = null,    icon: (@Composable () -> Unit)? = null,    title: (@Composable () -> Unit)? = null,    text: (@Composable () -> Unit)? = null,    shape: Shape? = androidx.compose.material3.tokens.Dialog.ContainerShape,    containerColor: Color? = MaterialTheme.colorScheme.fromToken(
            androidx.compose.material3.tokens.Dialog.ContainerColor
        ),    tonalElevation: Dp? = androidx.compose.material3.tokens.Dialog.ContainerElevation,    iconContentColor: Color? = MaterialTheme.colorScheme.fromToken(
        androidx.compose.material3.tokens.Dialog.WithIconIconColor
    ),    titleContentColor: Color? = MaterialTheme.colorScheme.fromToken(
        androidx.compose.material3.tokens.Dialog.SubheadColor
    ),    textContentColor: Color? = MaterialTheme.colorScheme.fromToken(
        androidx.compose.material3.tokens.Dialog.SupportingTextColor
    ),    properties: DialogProperties? = DialogProperties()): Unit
```

![Basic dialog image](https://developer.android.google.cn/images/reference/androidx/compose/material3/basic-dialog.png)

Material Design basic dialog.

Dialogs interrupt users with urgent information, details, or actions.

The dialog will position its buttons, typically `TextButton`s, based on the available space. By default it will try to place them horizontally next to each other and fallback to horizontal placement if not enough space is available.

Simple usage:

```
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

val openDialog = remember { mutableStateOf(true) }

if (openDialog.value) {
    AlertDialog(
        onDismissRequest = {
            // Dismiss the dialog when the user clicks outside the dialog or on the back
            // button. If you want to disable that functionality, simply use an empty
            // onDismissRequest.
            openDialog.value = false
        },
        title = {
            Text(text = "Title")
        },
        text = {
            Text(text = "Turned on by default")
        },
        confirmButton = {
            TextButton(
                onClick = {
                    openDialog.value = false
                }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    openDialog.value = false
                }
            ) {
                Text("Dismiss")
            }
        }
    )
}
```

Usage with a "Hero" icon:

```
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

val openDialog = remember { mutableStateOf(true) }

if (openDialog.value) {
    AlertDialog(
        onDismissRequest = {
            // Dismiss the dialog when the user clicks outside the dialog or on the back
            // button. If you want to disable that functionality, simply use an empty
            // onDismissRequest.
            openDialog.value = false
        },
        icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
        title = {
            Text(text = "Title")
        },
        text = {
            Text(
                "This area typically contains the supportive text " +
                    "which presents the details regarding the Dialog's purpose."
            )
        },
        confirmButton = {
            TextButton(
                onClick = {
                    openDialog.value = false
                }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    openDialog.value = false
                }
            ) {
                Text("Dismiss")
            }
        }
    )
}
```

| Parameters                                                   |                                                              |
| :----------------------------------------------------------- | ------------------------------------------------------------ |
| `onDismissRequest: (() -> Unit)?`                            | Executes when the user tries to dismiss the Dialog by clicking outside or pressing the back button. This is not called when the dismiss button is clicked. |
| `confirmButton: (@Composable () -> Unit)?`                   | A button which is meant to confirm a proposed action, thus resolving what triggered the dialog. The dialog does not set up any events for this button so they need to be set up by the caller. |
| `modifier: Modifier? = Modifier`                             | Modifier to be applied to the layout of the dialog.          |
| `dismissButton: (@Composable () -> Unit)? = null`            | A button which is meant to dismiss the dialog. The dialog does not set up any events for this button so they need to be set up by the caller. |
| `icon: (@Composable () -> Unit)? = null`                     | An optional icon that will appear above the `title` or above the `text`, in case a title was not provided. |
| `title: (@Composable () -> Unit)? = null`                    | The title of the Dialog which should specify the purpose of the Dialog. The title is not mandatory, because there may be sufficient information inside the `text`. |
| `text: (@Composable () -> Unit)? = null`                     | The text which presents the details regarding the Dialog's purpose. |
| `shape: Shape? = androidx.compose.material3.tokens.Dialog.ContainerShape` | Defines the Dialog's shape                                   |
| `containerColor: Color? = MaterialTheme.colorScheme.fromToken(androidx.compose.material3.tokens.Dialog.ContainerColor )` | The container color of the dialog.                           |
| `tonalElevation: Dp? = androidx.compose.material3.tokens.Dialog.ContainerElevation` | When `containerColor` is `ColorScheme.surface`, a higher tonal elevation value will result in a darker dialog color in light theme and lighter color in dark theme. See also `Surface`. |
| `iconContentColor: Color? = MaterialTheme.colorScheme.fromToken(androidx.compose.material3.tokens.Dialog.WithIconIconColor )` | The content color used for the icon.                         |
| `titleContentColor: Color? = MaterialTheme.colorScheme.fromToken(androidx.compose.material3.tokens.Dialog.SubheadColor )` | The content color used for the title.                        |
| `textContentColor: Color? = MaterialTheme.colorScheme.fromToken(androidx.compose.material3.tokens.Dialog.SupportingTextColor )` | The content color used for the text.                         |
| `properties: DialogProperties? = DialogProperties()`         | Typically platform specific properties to further configure the dialog. |



### Badge

```
@Composable
fun Badge(
    modifier: Modifier? = Modifier,
    containerColor: Color? = MaterialTheme.colorScheme.fromToken(NavigationBar.BadgeColor),
    contentColor: Color? = contentColorFor(containerColor),
    content: (@Composable @ExtensionFunctionType RowScope.() -> Unit)? = null
): Unit
```

Badge is a component that can contain dynamic information, such as the presence of a new notification or a number of pending requests. Badges can be icon only or contain short text.

See `BadgedBox` for a top level layout that will properly place the badge relative to content such as text or an icon.

| Parameters                                                   |                                                  |
| :----------------------------------------------------------- | ------------------------------------------------ |
| `modifier: Modifier? = Modifier`                             | optional `Modifier` for this item                |
| `containerColor: Color? = MaterialTheme.colorScheme.fromToken(NavigationBar.BadgeColor)` | the background color for the badge               |
| `contentColor: Color? = contentColorFor(containerColor)`     | the color of label text rendered in the badge    |
| `content: (@Composable @ExtensionFunctionType RowScope.() -> Unit)? = null` | optional content to be rendered inside the badge |



### BadgedBox

```
@Composable
fun BadgedBox(
    badge: (@Composable @ExtensionFunctionType BoxScope.() -> Unit)?,
    modifier: Modifier? = Modifier,
    content: (@Composable @ExtensionFunctionType BoxScope.() -> Unit)?
): Unit
```

A BadgeBox is used to decorate `content` with a `badge` that can contain dynamic information, such as the presence of a new notification or a number of pending requests. Badges can be icon only or contain short text.

A common use case is to display a badge with navigation bar items. For more information, see [Navigation Bar](https://material.io/components/bottom-navigation#behavior)

A simple icon with badge example looks like:

```
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text

NavigationBar {
    NavigationBarItem(
        icon = {
            BadgedBox(badge = { Badge { Text("8") } }) {
                Icon(
                    Icons.Filled.Star,
                    contentDescription = "Favorite"
                )
            }
        },
        selected = false,
        onClick = {}
    )
}
```

| Parameters                                                   |                                                   |
| :----------------------------------------------------------- | ------------------------------------------------- |
| `badge: (@Composable @ExtensionFunctionType BoxScope.() -> Unit)?` | the badge to be displayed - typically a `Badge`   |
| `modifier: Modifier? = Modifier`                             | optional `Modifier` for this item                 |
| `content: (@Composable @ExtensionFunctionType BoxScope.() -> Unit)?` | the anchor to which this badge will be positioned |



### Button

```
@Composable
fun Button(
    onClick: (() -> Unit)?,
    modifier: Modifier? = Modifier,
    enabled: Boolean? = true,
    interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() },
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    shape: Shape? = FilledButton.ContainerShape,
    border: BorderStroke? = null,
    colors: ButtonColors? = ButtonDefaults.buttonColors(),
    contentPadding: PaddingValues? = ButtonDefaults.ContentPadding,
    content: (@Composable @ExtensionFunctionType RowScope.() -> Unit)?
): Unit
```

![Filled button image](https://developer.android.google.cn/images/reference/androidx/compose/material3/filled-button.png)

A default Material button, which is also known as a Filled button. Buttons contain actions for your app.

Filled buttons are high-emphasis buttons. Filled buttons have the most visual impact after the `FloatingActionButton`, and should be used for important, final actions that complete a flow, like "Save", "Join now", or "Confirm".

```
import androidx.compose.material3.Button
import androidx.compose.material3.Text

Button(onClick = { /* Do something! */ }) { Text("Button") }
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text

Button(onClick = { /* Do something! */ }) {
    Icon(
        Icons.Filled.Favorite,
        contentDescription = "Localized description",
        modifier = Modifier.size(ButtonDefaults.IconSize)
    )
    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
    Text("Like")
}
```

Choose the best button for an action based on the amount of emphasis it needs. The more important an action is, the higher emphasis its button should be.

- See `OutlinedButton` for a medium-emphasis button with a border.
- See `ElevatedButton` for an `OutlinedButton` with a shadow.
- See `TextButton` for a low-emphasis button with no border.
- See `FilledTonalButton` for a middle ground between `OutlinedButton` and `Button`.

The default text style for internal `Text` components will be set to `Typography.LabelLarge`.

| Parameters                                                   |                                                              |
| :----------------------------------------------------------- | ------------------------------------------------------------ |
| `onClick: (() -> Unit)?`                                     | Will be called when the user clicks the button.              |
| `modifier: Modifier? = Modifier`                             | Modifier to be applied to the button.                        |
| `enabled: Boolean? = true`                                   | Controls the enabled state of the button. When `false`, this button will not be clickable. |
| `interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() }` | the `MutableInteractionSource` representing the stream of `Interaction`s for this Button. You can create and pass in your own remembered `MutableInteractionSource` if you want to observe `Interaction`s and customize the appearance / behavior of this Button in different `Interaction`s. |
| `elevation: ButtonElevation? = ButtonDefaults.buttonElevation()` | `ButtonElevation` used to resolve the elevation for this button in different states. This controls the size of the shadow below the button. When the container color is `ColorScheme.surface`, a higher elevation (surface blended with more primary) will result in a darker surface color in light theme and lighter color in dark theme. |
| `shape: Shape? = FilledButton.ContainerShape`                | Defines the button's shape as well as its shadow.            |
| `border: BorderStroke? = null`                               | Border to draw around the button. Pass `null` here for no border. |
| `colors: ButtonColors? = ButtonDefaults.buttonColors()`      | `ButtonColors` that will be used to resolve the container and content color for this button in different states. See `ButtonDefaults.buttonColors`. |
| `contentPadding: PaddingValues? = ButtonDefaults.ContentPadding` | The spacing values to apply internally between the container and the content. |



### CenterAlignedTopAppBar

```
@Composable
fun CenterAlignedTopAppBar(
    title: (@Composable () -> Unit)?,
    modifier: Modifier? = Modifier,
    navigationIcon: (@Composable () -> Unit)? = {},
    actions: (@Composable @ExtensionFunctionType RowScope.() -> Unit)? = {},
    colors: TopAppBarColors? = TopAppBarDefaults.centerAlignedTopAppBarColors(),
    scrollBehavior: TopAppBarScrollBehavior? = null
): Unit
```

![Center-aligned top app bar image](https://developer.android.google.cn/images/reference/androidx/compose/material3/center-aligned-top-app-bar.png)

Material Design small top app bar with a header title that is horizontally aligned to the center.

The top app bar displays information and actions relating to the current screen.

This CenterAlignedTopAppBar has slots for a title, navigation icon, and actions.

A center aligned top app bar that uses a `scrollBehavior` to customize its nested scrolling behavior when working in conjunction with a scrolling content looks like:

```
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

Scaffold(
    topBar = {
        CenterAlignedTopAppBar(
            title = { Text("Centered TopAppBar") },
            navigationIcon = {
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Localized description"
                    )
                }
            },
            actions = {
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Localized description"
                    )
                }
            }
        )
    },
    content = { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val list = (0..75).map { it.toString() }
            items(count = list.size) {
                Text(
                    text = list[it],
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
                )
            }
        }
    }
)
```

| Parameters                                                   |                                                              |
| :----------------------------------------------------------- | ------------------------------------------------------------ |
| `title: (@Composable () -> Unit)?`                           | the title to be displayed in the top app bar                 |
| `modifier: Modifier? = Modifier`                             | the `Modifier` to be applied to this top app bar             |
| `navigationIcon: (@Composable () -> Unit)? = {}`             | The navigation icon displayed at the start of the top app bar. This should typically be an `IconButton` or `IconToggleButton`. |
| `actions: (@Composable @ExtensionFunctionType RowScope.() -> Unit)? = {}` | the actions displayed at the end of the top app bar. This should typically be `IconButton`s. The default layout here is a `Row`, so icons inside will be placed horizontally. |
| `colors: TopAppBarColors? = TopAppBarDefaults.centerAlignedTopAppBarColors()` | a `TopAppBarColors` that will be used to resolve the colors used for this top app bar in different states. See `TopAppBarDefaults.centerAlignedTopAppBarColors`. |
| `scrollBehavior: TopAppBarScrollBehavior? = null`            | a `TopAppBarScrollBehavior` which holds various offset values that will be applied by this top app bar to set up its height and colors. A scroll behavior is designed to work in conjunction with a scrolled content to change the top app bar appearance as the content scrolls. See `TopAppBarScrollBehavior.nestedScrollConnection`. |



### Checkbox

```
@Composable
fun Checkbox(
    checked: Boolean?,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier? = Modifier,
    enabled: Boolean? = true,
    interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() },
    colors: CheckboxColors? = CheckboxDefaults.colors()
): Unit
```

Material Design checkbox.

Checkboxes allow users to select one or more items from a set. Checkboxes can turn an option on or off.

```
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

val checkedState = remember { mutableStateOf(true) }
Checkbox(
    checked = checkedState.value,
    onCheckedChange = { checkedState.value = it }
)
```

| Parameters                                                   |                                                              |
| :----------------------------------------------------------- | ------------------------------------------------------------ |
| `checked: Boolean?`                                          | whether this Checkbox is checked or unchecked                |
| `onCheckedChange: ((Boolean) -> Unit)?`                      | callback to be invoked when checkbox is being clicked, therefore the change of checked state in requested. If null, then this is passive and relies entirely on a higher-level component to control the "checked" state |
| `modifier: Modifier? = Modifier`                             | Modifier to be applied to the layout of this `Checkbox`      |
| `enabled: Boolean? = true`                                   | controls the enabled state of the `Checkbox`. When `false`, this `Checkbox` will not be clickable/selectable |
| `interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() }` | the `MutableInteractionSource` representing the stream of `Interaction`s for this `Checkbox`. You can create and pass in your own remembered `MutableInteractionSource` if you want to observe `Interaction`s and customize the appearance / behavior of this `Checkbox` in different `Interaction`s |
| `colors: CheckboxColors? = CheckboxDefaults.colors()`        | `CheckboxColors` that will be used to resolve the color used for this `Checkbox` in different states. See `CheckboxDefaults.colors` |

| See also           |                                                    |
| :----------------- | -------------------------------------------------- |
| `TriStateCheckbox` | if you require support for an indeterminate state. |



### ElevatedButton

```
@Composable
fun ElevatedButton(
    onClick: (() -> Unit)?,
    modifier: Modifier? = Modifier,
    enabled: Boolean? = true,
    interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() },
    elevation: ButtonElevation? = ButtonDefaults.elevatedButtonElevation(),
    shape: Shape? = ElevatedButton.ContainerShape,
    border: BorderStroke? = null,
    colors: ButtonColors? = ButtonDefaults.elevatedButtonColors(),
    contentPadding: PaddingValues? = ButtonDefaults.ContentPadding,
    content: (@Composable @ExtensionFunctionType RowScope.() -> Unit)?
): Unit
```

![Elevated button image](https://developer.android.google.cn/images/reference/androidx/compose/material3/elevated-button.png)

A Material Elevated button. Buttons contain actions for your app.

Elevated buttons are high-emphasis buttons that are essentially `FilledTonalButton`s with a shadow. To prevent shadow creep, only use them when absolutely necessary, such as when the button requires visual separation from patterned container.

```
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text

ElevatedButton(onClick = { /* Do something! */ }) { Text("Elevated Button") }
```

Choose the best button for an action based on the amount of emphasis it needs. The more important an action is, the higher emphasis its button should be.

- See `Button` for a high-emphasis button without a shadow, also known as a filled button.
- See `FilledTonalButton` for a middle ground between `OutlinedButton` and `Button`.
- See `OutlinedButton` for a medium-emphasis button with a border.
- See `TextButton` for a low-emphasis button with no border.

The default text style for internal `Text` components will be set to `Typography.LabelLarge`.

| Parameters                                                   |                                                              |
| :----------------------------------------------------------- | ------------------------------------------------------------ |
| `onClick: (() -> Unit)?`                                     | Will be called when the user clicks the button.              |
| `modifier: Modifier? = Modifier`                             | Modifier to be applied to the button.                        |
| `enabled: Boolean? = true`                                   | Controls the enabled state of the button. When `false`, this button will not be clickable. |
| `interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() }` | the `MutableInteractionSource` representing the stream of `Interaction`s for this Button. You can create and pass in your own remembered `MutableInteractionSource` if you want to observe `Interaction`s and customize the appearance / behavior of this Button in different `Interaction`s. |
| `elevation: ButtonElevation? = ButtonDefaults.elevatedButtonElevation()` | `ButtonElevation` used to resolve the elevation for this button in different states. This controls the size of the shadow below the button. When the container color is `ColorScheme.surface`, a higher elevation (surface blended with more primary) will result in a darker surface color in light theme and lighter color in dark theme. `ButtonDefaults.elevatedButtonElevation`. |
| `shape: Shape? = ElevatedButton.ContainerShape`              | Defines the button's shape as well as its shadow.            |
| `border: BorderStroke? = null`                               | Border to draw around the button. Pass `null` here for no border. |
| `colors: ButtonColors? = ButtonDefaults.elevatedButtonColors()` | `ButtonColors` that will be used to resolve the container and content color for this button in different states. See `ButtonDefaults.elevatedButtonColors`. |
| `contentPadding: PaddingValues? = ButtonDefaults.ContentPadding` | The spacing values to apply internally between the container and the content. |



### ExtendedFloatingActionButton

```
@Composablefun ExtendedFloatingActionButton(    text: (@Composable () -> Unit)?,    onClick: (() -> Unit)?,    modifier: Modifier? = Modifier,    icon: (@Composable () -> Unit)? = null,    interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() },    shape: Shape? = ExtendedFabPrimary.PrimaryContainerShape,    containerColor: Color? = MaterialTheme.colorScheme.fromToken(
        ExtendedFabPrimary.PrimaryContainerColor
    ),    contentColor: Color? = contentColorFor(containerColor),    elevation: FloatingActionButtonElevation? = FloatingActionButtonDefaults.elevation()): Unit
```

![Extended FAB image](https://developer.android.google.cn/images/reference/androidx/compose/material3/extended-fab.png)

The extended FAB is wider than a regular FAB, and it includes a text label.

```
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text

ExtendedFloatingActionButton(
    onClick = { /* do something */ },
    icon = { Icon(Icons.Filled.Add, "Localized description") },
    text = { Text(text = "Extended FAB") },
)
```

| Parameters                                                   |                                                              |
| :----------------------------------------------------------- | ------------------------------------------------------------ |
| `text: (@Composable () -> Unit)?`                            | Text label displayed inside this FAB                         |
| `onClick: (() -> Unit)?`                                     | callback invoked when this FAB is clicked                    |
| `modifier: Modifier? = Modifier`                             | `Modifier` to be applied to this FAB                         |
| `icon: (@Composable () -> Unit)? = null`                     | Optional icon for this FAB, typically this will be a `Icon`. |
| `interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() }` | the `MutableInteractionSource` representing the stream of `Interaction`s for this FAB. You can create and pass in your own remembered `MutableInteractionSource` if you want to observe `Interaction`s and customize the appearance / behavior of this FAB in different `Interaction`s. |
| `shape: Shape? = ExtendedFabPrimary.PrimaryContainerShape`   | The `Shape` of this FAB                                      |
| `containerColor: Color? = MaterialTheme.colorScheme.fromToken(ExtendedFabPrimary.PrimaryContainerColor )` | The container color. Use `Color.Transparent` to have no color |
| `contentColor: Color? = contentColorFor(containerColor)`     | The preferred content color for content inside this FAB      |
| `elevation: FloatingActionButtonElevation? = FloatingActionButtonDefaults.elevation()` | `FloatingActionButtonElevation` used to resolve the elevation for this FAB in different states. This controls the size of the shadow below the FAB. When `containerColor` is `ColorScheme.surface`, a higher elevation (surface blended with more primary) will result in a darker surface color in light theme and lighter color in dark theme. |



### FilledTonalButton

```
@Composable
fun FilledTonalButton(
    onClick: (() -> Unit)?,
    modifier: Modifier? = Modifier,
    enabled: Boolean? = true,
    interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() },
    elevation: ButtonElevation? = ButtonDefaults.filledTonalButtonElevation(),
    shape: Shape? = FilledButtonTonal.TonalContainerShape,
    border: BorderStroke? = null,
    colors: ButtonColors? = ButtonDefaults.filledTonalButtonColors(),
    contentPadding: PaddingValues? = ButtonDefaults.ContentPadding,
    content: (@Composable @ExtensionFunctionType RowScope.() -> Unit)?
): Unit
```

![Filled tonal button image](https://developer.android.google.cn/images/reference/androidx/compose/material3/filled-tonal-button.png)

A Material Filled tonal button. Buttons contain actions for your app.

Filled tonal buttons are medium-emphasis buttons that is an alternative middle ground between default `Button`s (filled) and `OutlinedButton`s. They can be used in contexts where lower-priority button requires slightly more emphasis than an outline would give, such as "Next" in an onboarding flow. Tonal buttons use the secondary color mapping.

```
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text

FilledTonalButton(onClick = { /* Do something! */ }) { Text("Filled Tonal Button") }
```

Choose the best button for an action based on the amount of emphasis it needs. The more important an action is, the higher emphasis its button should be.

- See `Button` for a high-emphasis button without a shadow, also known as a filled button.
- See `ElevatedButton` for a `FilledTonalButton` with a shadow.
- See `OutlinedButton` for a medium-emphasis button with a border.
- See `TextButton` for a low-emphasis button with no border.

The default text style for internal `Text` components will be set to `Typography.LabelLarge`.

| Parameters                                                   |                                                              |
| :----------------------------------------------------------- | ------------------------------------------------------------ |
| `onClick: (() -> Unit)?`                                     | Will be called when the user clicks the button.              |
| `modifier: Modifier? = Modifier`                             | Modifier to be applied to the button.                        |
| `enabled: Boolean? = true`                                   | Controls the enabled state of the button. When `false`, this button will not be clickable. |
| `interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() }` | the `MutableInteractionSource` representing the stream of `Interaction`s for this Button. You can create and pass in your own remembered `MutableInteractionSource` if you want to observe `Interaction`s and customize the appearance / behavior of this Button in different `Interaction`s. |
| `elevation: ButtonElevation? = ButtonDefaults.filledTonalButtonElevation()` | `ButtonElevation` used to resolve the elevation for this button in different states. This controls the size of the shadow below the button. When the container color is `ColorScheme.surface`, a higher elevation (surface blended with more primary) will result in a darker surface color in light theme and lighter color in dark theme. |
| `shape: Shape? = FilledButtonTonal.TonalContainerShape`      | Defines the button's shape as well as its shadow.            |
| `border: BorderStroke? = null`                               | Border to draw around the button. Pass `null` here for no border. |
| `colors: ButtonColors? = ButtonDefaults.filledTonalButtonColors()` | `ButtonColors` that will be used to resolve the container and content color for this button in different states. See `ButtonDefaults.elevatedButtonColors`. |
| `contentPadding: PaddingValues? = ButtonDefaults.ContentPadding` | The spacing values to apply internally between the container and the content. |



### FloatingActionButton

```
@Composable
fun FloatingActionButton(
    onClick: (() -> Unit)?,
    modifier: Modifier? = Modifier,
    interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() },
    shape: Shape? = FabPrimary.PrimaryContainerShape,
    containerColor: Color? = MaterialTheme.colorScheme.fromToken(FabPrimary.PrimaryContainerColor),
    contentColor: Color? = contentColorFor(containerColor),
    elevation: FloatingActionButtonElevation? = FloatingActionButtonDefaults.elevation(),
    content: (@Composable () -> Unit)?
): Unit
```

![FAB image](https://developer.android.google.cn/images/reference/androidx/compose/material3/fab.png)

A floating action button (FAB) represents the primary action of a screen.

```
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon

FloatingActionButton(
    onClick = { /* do something */ },
) {
    Icon(Icons.Filled.Add, "Localized description")
}
```

| Parameters                                                   |                                                              |
| :----------------------------------------------------------- | ------------------------------------------------------------ |
| `onClick: (() -> Unit)?`                                     | callback invoked when this FAB is clicked                    |
| `modifier: Modifier? = Modifier`                             | `Modifier` to be applied to this FAB.                        |
| `interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() }` | the `MutableInteractionSource` representing the stream of `Interaction`s for this FAB. You can create and pass in your own remembered `MutableInteractionSource` if you want to observe `Interaction`s and customize the appearance / behavior of this FAB in different `Interaction`s. |
| `shape: Shape? = FabPrimary.PrimaryContainerShape`           | The `Shape` of this FAB                                      |
| `containerColor: Color? = MaterialTheme.colorScheme.fromToken(FabPrimary.PrimaryContainerColor)` | The container color. Use `Color.Transparent` to have no color |
| `contentColor: Color? = contentColorFor(containerColor)`     | The preferred content color for content inside this FAB      |
| `elevation: FloatingActionButtonElevation? = FloatingActionButtonDefaults.elevation()` | `FloatingActionButtonElevation` used to resolve the elevation for this FAB in different states. This controls the size of the shadow below the FAB. When `containerColor` is `ColorScheme.surface`, a higher elevation (surface blended with more primary) will result in a darker surface color in light theme and lighter color in dark theme. |
| `content: (@Composable () -> Unit)?`                         | the content of this FAB - this is typically an `Icon`.       |



### Icon

```
@Composable
fun Icon(
    imageVector: ImageVector?,
    contentDescription: String?,
    modifier: Modifier? = Modifier,
    tint: Color? = LocalContentColor.current
): Unit
```

Icon component that draws `imageVector` using `tint`, defaulting to `LocalContentColor`. For a clickable icon, see `IconButton`.

| Parameters                                 |                                                              |
| :----------------------------------------- | ------------------------------------------------------------ |
| `imageVector: ImageVector?`                | `ImageVector` to draw inside this Icon                       |
| `contentDescription: String?`              | text used by accessibility services to describe what this icon represents. This should always be provided unless this icon is used for decorative purposes, and does not represent a meaningful action that a user can take. This text should be localized, such as by using `androidx.compose.ui.res.stringResource` or similar |
| `modifier: Modifier? = Modifier`           | optional `Modifier` for this Icon                            |
| `tint: Color? = LocalContentColor.current` | tint to be applied to `imageVector`. If `Color.Unspecified` is provided, then no tint is applied |



### Icon

```
@Composable
fun Icon(
    bitmap: ImageBitmap?,
    contentDescription: String?,
    modifier: Modifier? = Modifier,
    tint: Color? = LocalContentColor.current
): Unit
```

Icon component that draws `bitmap` using `tint`, defaulting to `LocalContentColor`. For a clickable icon, see `IconButton`.

| Parameters                                 |                                                              |
| :----------------------------------------- | ------------------------------------------------------------ |
| `bitmap: ImageBitmap?`                     | `ImageBitmap` to draw inside this Icon                       |
| `contentDescription: String?`              | text used by accessibility services to describe what this icon represents. This should always be provided unless this icon is used for decorative purposes, and does not represent a meaningful action that a user can take. This text should be localized, such as by using `androidx.compose.ui.res.stringResource` or similar |
| `modifier: Modifier? = Modifier`           | optional `Modifier` for this Icon                            |
| `tint: Color? = LocalContentColor.current` | tint to be applied to `bitmap`. If `Color.Unspecified` is provided, then no tint is applied |



### Icon

```
@Composable
fun Icon(
    painter: Painter?,
    contentDescription: String?,
    modifier: Modifier? = Modifier,
    tint: Color? = LocalContentColor.current
): Unit
```

Icon component that draws a `painter` using `tint`, defaulting to `LocalContentColor`. For a clickable icon, see `IconButton`.

| Parameters                                 |                                                              |
| :----------------------------------------- | ------------------------------------------------------------ |
| `painter: Painter?`                        | `Painter` to draw inside this Icon                           |
| `contentDescription: String?`              | text used by accessibility services to describe what this icon represents. This should always be provided unless this icon is used for decorative purposes, and does not represent a meaningful action that a user can take. This text should be localized, such as by using `androidx.compose.ui.res.stringResource` or similar |
| `modifier: Modifier? = Modifier`           | optional `Modifier` for this Icon                            |
| `tint: Color? = LocalContentColor.current` | tint to be applied to `painter`. If `Color.Unspecified` is provided, then no tint is applied |



### IconButton

```
@Composable
fun IconButton(
    onClick: (() -> Unit)?,
    modifier: Modifier? = Modifier,
    enabled: Boolean? = true,
    interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() },
    content: (@Composable () -> Unit)?
): Unit
```

IconButton is a clickable icon, used to represent actions. An IconButton has an overall minimum touch target size of 48 x 48dp, to meet accessibility guidelines. `content` is centered inside the IconButton.

This component is typically used inside an App Bar for the navigation icon / actions. See App Bar documentation for samples of this.

`content` should typically be an `Icon`, using an icon from `androidx.compose.material.icons.Icons`. If using a custom icon, note that the typical size for the internal icon is 24 x 24 dp.

```
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

IconButton(onClick = { /* doSomething() */ }) {
    Icon(Icons.Filled.Favorite, contentDescription = "Localized description")
}
```

| Parameters                                                   |                                                              |
| :----------------------------------------------------------- | ------------------------------------------------------------ |
| `onClick: (() -> Unit)?`                                     | the lambda to be invoked when this icon is pressed           |
| `modifier: Modifier? = Modifier`                             | optional `Modifier` for this IconButton                      |
| `enabled: Boolean? = true`                                   | whether or not this IconButton will handle input events and appear enabled for semantics purposes |
| `interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() }` | the `MutableInteractionSource` representing the stream of `Interaction`s for this IconButton. You can create and pass in your own remembered `MutableInteractionSource` if you want to observe `Interaction`s and customize the appearance / behavior of this IconButton in different `Interaction`s. |
| `content: (@Composable () -> Unit)?`                         | the content (icon) to be drawn inside the IconButton. This is typically an `Icon`. |



### IconToggleButton

```
@Composable
fun IconToggleButton(
    checked: Boolean?,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier? = Modifier,
    enabled: Boolean? = true,
    interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() },
    content: (@Composable () -> Unit)?
): Unit
```

An `IconButton` with two states, for icons that can be toggled 'on' and 'off', such as a bookmark icon, or a navigation icon that opens a drawer.

```
import androidx.compose.animation.animateColorAsState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color

var checked by remember { mutableStateOf(false) }

IconToggleButton(checked = checked, onCheckedChange = { checked = it }) {
    val tint by animateColorAsState(if (checked) Color(0xFFEC407A) else Color(0xFFB0BEC5))
    Icon(Icons.Filled.Favorite, contentDescription = "Localized description", tint = tint)
}
```

| Parameters                                                   |                                                              |
| :----------------------------------------------------------- | ------------------------------------------------------------ |
| `checked: Boolean?`                                          | whether this IconToggleButton is currently checked           |
| `onCheckedChange: ((Boolean) -> Unit)?`                      | callback to be invoked when this icon is selected            |
| `modifier: Modifier? = Modifier`                             | optional `Modifier` for this IconToggleButton                |
| `enabled: Boolean? = true`                                   | enabled whether or not this `IconToggleButton` will handle input events and appear enabled for semantics purposes |
| `interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() }` | the `MutableInteractionSource` representing the stream of `Interaction`s for this IconToggleButton. You can create and pass in your own remembered `MutableInteractionSource` if you want to observe `Interaction`s and customize the appearance / behavior of this IconToggleButton in different `Interaction`s. |
| `content: (@Composable () -> Unit)?`                         | the content (icon) to be drawn inside the IconToggleButton. This is typically an `Icon`. |



### LargeFloatingActionButton

```
@Composablefun LargeFloatingActionButton(    onClick: (() -> Unit)?,    modifier: Modifier? = Modifier,    interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() },    shape: Shape? = FabPrimaryLarge.PrimaryLargeContainerShape,    containerColor: Color? = MaterialTheme.colorScheme.fromToken(
        FabPrimaryLarge.PrimaryLargeContainerColor
    ),    contentColor: Color? = contentColorFor(containerColor),    elevation: FloatingActionButtonElevation? = FloatingActionButtonDefaults.elevation(),    content: (@Composable () -> Unit)?): Unit
```

![Large FAB image](https://developer.android.google.cn/images/reference/androidx/compose/material3/large-fab.png)

A large circular floating action button.

```
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton

LargeFloatingActionButton(
    onClick = { /* do something */ },
) {
    Icon(
        Icons.Filled.Add,
        contentDescription = "Localized description",
        modifier = Modifier.size(FloatingActionButtonDefaults.LargeIconSize),
    )
}
```

| Parameters                                                   |                                                              |
| :----------------------------------------------------------- | ------------------------------------------------------------ |
| `onClick: (() -> Unit)?`                                     | callback invoked when this FAB is clicked                    |
| `modifier: Modifier? = Modifier`                             | `Modifier` to be applied to this FAB.                        |
| `interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() }` | the `MutableInteractionSource` representing the stream of `Interaction`s for this FAB. You can create and pass in your own remembered `MutableInteractionSource` if you want to observe `Interaction`s and customize the appearance / behavior of this FAB in different `Interaction`s. |
| `shape: Shape? = FabPrimaryLarge.PrimaryLargeContainerShape` | The `Shape` of this FAB                                      |
| `containerColor: Color? = MaterialTheme.colorScheme.fromToken(FabPrimaryLarge.PrimaryLargeContainerColor )` | The container color. Use `Color.Transparent` to have no color |
| `contentColor: Color? = contentColorFor(containerColor)`     | The preferred content color for content inside this FAB      |
| `elevation: FloatingActionButtonElevation? = FloatingActionButtonDefaults.elevation()` | `FloatingActionButtonElevation` used to resolve the elevation for this FAB in different states. This controls the size of the shadow below the FAB. When `containerColor` is `ColorScheme.surface`, a higher elevation (surface blended with more primary) will result in a darker surface color in light theme and lighter color in dark theme. |
| `content: (@Composable () -> Unit)?`                         | the content of this FAB - this is typically an `Icon`.       |



### LargeTopAppBar

```
@Composable
fun LargeTopAppBar(
    title: (@Composable () -> Unit)?,
    modifier: Modifier? = Modifier,
    navigationIcon: (@Composable () -> Unit)? = {},
    actions: (@Composable @ExtensionFunctionType RowScope.() -> Unit)? = {},
    colors: TopAppBarColors? = TopAppBarDefaults.largeTopAppBarColors(),
    scrollBehavior: TopAppBarScrollBehavior? = null
): Unit
```

![Large top app bar image](https://developer.android.google.cn/images/reference/androidx/compose/material3/large-top-app-bar.png)

Material Design large top app bar.

The top app bar displays information and actions relating to the current screen.

This LargeTopAppBar has slots for a title, navigation icon, and actions. In its default expanded state, the title is displayed in a second row under the navigation and actions.

A large top app bar that uses a `scrollBehavior` to customize its nested scrolling behavior when working in conjunction with scrolling content looks like:

```
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.input.nestedscroll.nestedScroll

val decayAnimationSpec = rememberSplineBasedDecay<Float>()
val scrollBehavior = remember(decayAnimationSpec) {
    TopAppBarDefaults.exitUntilCollapsedScrollBehavior(decayAnimationSpec)
}
Scaffold(
    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
    topBar = {
        LargeTopAppBar(
            title = { Text("Large TopAppBar") },
            navigationIcon = {
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Localized description"
                    )
                }
            },
            actions = {
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Localized description"
                    )
                }
            },
            scrollBehavior = scrollBehavior
        )
    },
    content = { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val list = (0..75).map { it.toString() }
            items(count = list.size) {
                Text(
                    text = list[it],
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
                )
            }
        }
    }
)
```

| Parameters                                                   |                                                              |
| :----------------------------------------------------------- | ------------------------------------------------------------ |
| `title: (@Composable () -> Unit)?`                           | the title to be displayed in the top app bar. This title will be used in the app bar's expanded and collapsed states, although in its collapsed state it will be composed with a smaller sized `TextStyle` |
| `modifier: Modifier? = Modifier`                             | The `Modifier` to be applied to this top app bar             |
| `navigationIcon: (@Composable () -> Unit)? = {}`             | The navigation icon displayed at the start of the top app bar. This should typically be an `IconButton` or `IconToggleButton`. |
| `actions: (@Composable @ExtensionFunctionType RowScope.() -> Unit)? = {}` | The actions displayed at the end of the top app bar. This should typically be `IconButton`s. The default layout here is a `Row`, so icons inside will be placed horizontally. |
| `colors: TopAppBarColors? = TopAppBarDefaults.largeTopAppBarColors()` | a `TopAppBarColors` that will be used to resolve the colors used for this top app bar in different states. See `TopAppBarDefaults.largeTopAppBarColors`. |
| `scrollBehavior: TopAppBarScrollBehavior? = null`            | a `TopAppBarScrollBehavior` which holds various offset values that will be applied by this top app bar to set up its height and colors. A scroll behavior is designed to work in conjunction with a scrolled content to change the top app bar appearance as the content scrolls. See `TopAppBarScrollBehavior.nestedScrollConnection`. |



### MaterialTheme

```
@Composable
fun MaterialTheme(
    colorScheme: ColorScheme? = MaterialTheme.colorScheme,
    typography: Typography? = MaterialTheme.typography,
    content: (@Composable () -> Unit)?
): Unit
```

Material Theming refers to the customization of your Material Design app to better reflect your product’s brand.

Material components such as `Button` and `Checkbox` use values provided here when retrieving default values.

All values may be set by providing this component with the `colorScheme`, `typography` attributes. Use this to configure the overall theme of elements within this MaterialTheme.

Any values that are not set will inherit the current value from the theme, falling back to the defaults if there is no parent MaterialTheme. This allows using a MaterialTheme at the top of your application, and then separate MaterialTheme(s) for different screens / parts of your UI, overriding only the parts of the theme definition that need to change.

| Parameters                                              |                                                              |
| :------------------------------------------------------ | ------------------------------------------------------------ |
| `colorScheme: ColorScheme? = MaterialTheme.colorScheme` | A complete definition of the Material Color theme for this hierarchy |
| `typography: Typography? = MaterialTheme.typography`    | A set of text styles to be used as this hierarchy's typography system |



### MediumTopAppBar

```
@Composable
fun MediumTopAppBar(
    title: (@Composable () -> Unit)?,
    modifier: Modifier? = Modifier,
    navigationIcon: (@Composable () -> Unit)? = {},
    actions: (@Composable @ExtensionFunctionType RowScope.() -> Unit)? = {},
    colors: TopAppBarColors? = TopAppBarDefaults.mediumTopAppBarColors(),
    scrollBehavior: TopAppBarScrollBehavior? = null
): Unit
```

![Medium top app bar image](https://developer.android.google.cn/images/reference/androidx/compose/material3/medium-top-app-bar.png)

Material Design medium top app bar.

The top app bar displays information and actions relating to the current screen.

This MediumTopAppBar has slots for a title, navigation icon, and actions. In its default expanded state, the title is displayed in a second row under the navigation and actions.

A medium top app bar that uses a `scrollBehavior` to customize its nested scrolling behavior when working in conjunction with scrolling content looks like:

```
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.input.nestedscroll.nestedScroll

val decayAnimationSpec = rememberSplineBasedDecay<Float>()
val scrollBehavior = remember(decayAnimationSpec) {
    TopAppBarDefaults.exitUntilCollapsedScrollBehavior(decayAnimationSpec)
}
Scaffold(
    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
    topBar = {
        MediumTopAppBar(
            title = { Text("Medium TopAppBar") },
            navigationIcon = {
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Localized description"
                    )
                }
            },
            actions = {
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Localized description"
                    )
                }
            },
            scrollBehavior = scrollBehavior
        )
    },
    content = { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val list = (0..75).map { it.toString() }
            items(count = list.size) {
                Text(
                    text = list[it],
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
                )
            }
        }
    }
)
```

| Parameters                                                   |                                                              |
| :----------------------------------------------------------- | ------------------------------------------------------------ |
| `title: (@Composable () -> Unit)?`                           | the title to be displayed in the top app bar. This title will be used in the app bar's expanded and collapsed states, although in its collapsed state it will be composed with a smaller sized `TextStyle` |
| `modifier: Modifier? = Modifier`                             | the `Modifier` to be applied to this top app bar             |
| `navigationIcon: (@Composable () -> Unit)? = {}`             | the navigation icon displayed at the start of the top app bar. This should typically be an `IconButton` or `IconToggleButton`. |
| `actions: (@Composable @ExtensionFunctionType RowScope.() -> Unit)? = {}` | the actions displayed at the end of the top app bar. This should typically be `IconButton`s. The default layout here is a `Row`, so icons inside will be placed horizontally. |
| `colors: TopAppBarColors? = TopAppBarDefaults.mediumTopAppBarColors()` | a `TopAppBarColors` that will be used to resolve the colors used for this top app bar in different states. See `TopAppBarDefaults.mediumTopAppBarColors`. |
| `scrollBehavior: TopAppBarScrollBehavior? = null`            | a `TopAppBarScrollBehavior` which holds various offset values that will be applied by this top app bar to set up its height and colors. A scroll behavior is designed to work in conjunction with a scrolled content to change the top app bar appearance as the content scrolls. See `TopAppBarScrollBehavior.nestedScrollConnection`. |



### NavigationBar

```
@Composable
fun NavigationBar(
    modifier: Modifier? = Modifier,
    containerColor: Color? = MaterialTheme.colorScheme.fromToken(NavigationBar.ContainerColor),
    contentColor: Color? = MaterialTheme.colorScheme.contentColorFor(containerColor),
    tonalElevation: Dp? = NavigationBar.ContainerElevation,
    content: (@Composable @ExtensionFunctionType RowScope.() -> Unit)?
): Unit
```

![Navigation bar image](https://developer.android.google.cn/images/reference/androidx/compose/material3/navigation-bar.png)

Material Design bottom navigation bar.

A bottom navigation bar allows switching between primary destinations in an app.

`NavigationBar` should contain three to five `NavigationBarItem`s, each representing a singular destination.

A simple example looks like:

```
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

var selectedItem by remember { mutableStateOf(0) }
val items = listOf("Songs", "Artists", "Playlists")

NavigationBar {
    items.forEachIndexed { index, item ->
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
            label = { Text(item) },
            selected = selectedItem == index,
            onClick = { selectedItem = index }
        )
    }
}
```

See `NavigationBarItem` for configuration specific to each item, and not the overall `NavigationBar` component.

| Parameters                                                   |                                                              |
| :----------------------------------------------------------- | ------------------------------------------------------------ |
| `modifier: Modifier? = Modifier`                             | optional `Modifier` for this NavigationBar                   |
| `containerColor: Color? = MaterialTheme.colorScheme.fromToken(NavigationBar.ContainerColor)` | the container color for this NavigationBar                   |
| `contentColor: Color? = MaterialTheme.colorScheme.contentColorFor(containerColor)` | the preferred content color provided by this NavigationBar to its children. Defaults to either the matching content color for `containerColor`, or if `containerColor` is not a color from the theme, this will keep the same value set above this NavigationBar. |
| `tonalElevation: Dp? = NavigationBar.ContainerElevation`     | When `containerColor` is `ColorScheme.surface`, a higher tonal elevation value will result in a darker color in light theme and lighter color in dark theme. See also: `Surface`. |
| `content: (@Composable @ExtensionFunctionType RowScope.() -> Unit)?` | destinations inside this NavigationBar. This should contain multiple `NavigationBarItem`s |



### NavigationDrawer

```
@Composable
@ExperimentalMaterial3Api
fun NavigationDrawer(
    drawerContent: (@Composable @ExtensionFunctionType ColumnScope.() -> Unit)?,
    modifier: Modifier? = Modifier,
    drawerState: DrawerState? = rememberDrawerState(DrawerValue.Closed),
    gesturesEnabled: Boolean? = true,
    drawerShape: Shape? = RoundedCornerShape(0.dp, 16.dp, 16.dp, 0.dp),
    drawerTonalElevation: Dp? = DrawerDefaults.Elevation,
    drawerContainerColor: Color? = MaterialTheme.colorScheme.fromToken(NavigationDrawer.ContainerColor),
    drawerContentColor: Color? = contentColorFor(drawerContainerColor),
    scrimColor: Color? = DrawerDefaults.scrimColor,
    content: (@Composable () -> Unit)?
): Unit
```

![Navigation drawer image](https://developer.android.google.cn/images/reference/androidx/compose/material3/navigation-drawer.png)

Material Design navigation drawer.

Modal navigation drawers block interaction with the rest of an app’s content with a scrim. They are elevated above most of the app’s UI and don’t affect the screen’s layout grid.

```
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.NavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope

val drawerState = rememberDrawerState(DrawerValue.Closed)
val scope = rememberCoroutineScope()
NavigationDrawer(
    drawerState = drawerState,
    drawerContent = {
        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 16.dp),
            onClick = { scope.launch { drawerState.close() } },
            content = { Text("Close Drawer") }
        )
    },
    content = {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = if (drawerState.isClosed) ">>> Swipe >>>" else "<<< Swipe <<<")
            Spacer(Modifier.height(20.dp))
            Button(onClick = { scope.launch { drawerState.open() } }) {
                Text("Click to open")
            }
        }
    }
)
```

| Parameters                                                   |                                                              |
| :----------------------------------------------------------- | ------------------------------------------------------------ |
| `drawerContent: (@Composable @ExtensionFunctionType ColumnScope.() -> Unit)?` | composable that represents content inside the drawer         |
| `modifier: Modifier? = Modifier`                             | optional modifier for the drawer                             |
| `drawerState: DrawerState? = rememberDrawerState(DrawerValue.Closed)` | state of the drawer                                          |
| `gesturesEnabled: Boolean? = true`                           | whether or not drawer can be interacted by gestures          |
| `drawerShape: Shape? = RoundedCornerShape(0.dp, 16.dp, 16.dp, 0.dp)` | shape of the drawer sheet                                    |
| `drawerTonalElevation: Dp? = DrawerDefaults.Elevation`       | Affects the alpha of the color overlay applied on the container color of the drawer sheet. |
| `drawerContainerColor: Color? = MaterialTheme.colorScheme.fromToken(NavigationDrawer.ContainerColor)` | container color to be used for the drawer sheet              |
| `drawerContentColor: Color? = contentColorFor(drawerContainerColor)` | color of the content to use inside the drawer sheet. Defaults to either the matching content color for `drawerContainerColor`, or, if it is not a color from the theme, this will keep the same value set above this Surface. |
| `scrimColor: Color? = DrawerDefaults.scrimColor`             | color of the scrim that obscures content when the drawer is open |
| `content: (@Composable () -> Unit)?`                         | content of the rest of the UI                                |

| Throws                         |                                                 |
| :----------------------------- | ----------------------------------------------- |
| `kotlin.IllegalStateException` | when parent has `Float.POSITIVE_INFINITY` width |



### NavigationRail

```
@Composable
fun NavigationRail(
    modifier: Modifier? = Modifier,
    containerColor: Color? = MaterialTheme.colorScheme.fromToken(NavigationRail.ContainerColor),
    contentColor: Color? = contentColorFor(containerColor),
    header: (@Composable @ExtensionFunctionType ColumnScope.() -> Unit)? = null,
    content: (@Composable @ExtensionFunctionType ColumnScope.() -> Unit)?
): Unit
```

![Navigation rail image](https://developer.android.google.cn/images/reference/androidx/compose/material3/navigation-rail.png)

Material Design navigation rail.

`NavigationRail` is a side navigation component that allows movement between primary destinations in an app. The navigation rail should be used to display three to seven app destinations and, optionally, a Floating Action Button or a logo header. Each destination is typically represented by an icon and an optional text label.

`NavigationRail` should contain multiple `NavigationRailItem`s, each representing a singular destination.

A simple example looks like:

```
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

var selectedItem by remember { mutableStateOf(0) }
val items = listOf("Home", "Search", "Settings")
val icons = listOf(Icons.Filled.Home, Icons.Filled.Search, Icons.Filled.Settings)
NavigationRail {
    items.forEachIndexed { index, item ->
        NavigationRailItem(
            icon = { Icon(icons[index], contentDescription = item) },
            label = { Text(item) },
            selected = selectedItem == index,
            onClick = { selectedItem = index }
        )
    }
}
```

See `NavigationRailItem` for configuration specific to each item, and not the overall NavigationRail component.

| Parameters                                                   |                                                              |
| :----------------------------------------------------------- | ------------------------------------------------------------ |
| `modifier: Modifier? = Modifier`                             | optional `Modifier` for this NavigationRail                  |
| `containerColor: Color? = MaterialTheme.colorScheme.fromToken(NavigationRail.ContainerColor)` | the container color for this NavigationRail                  |
| `contentColor: Color? = contentColorFor(containerColor)`     | the preferred content color provided by this NavigationRail to its children. Defaults to either the matching content color for `containerColor`, or if `containerColor` is not a color from the theme, this will keep the same value set above this NavigationRail |
| `header: (@Composable @ExtensionFunctionType ColumnScope.() -> Unit)? = null` | optional header that may hold a Floating Action Button or a logo |
| `content: (@Composable @ExtensionFunctionType ColumnScope.() -> Unit)?` | destinations inside this NavigationRail. This should contain multiple `NavigationRailItem`s |



### NavigationRailItem

```
@Composable
fun NavigationRailItem(
    selected: Boolean?,
    onClick: (() -> Unit)?,
    icon: (@Composable () -> Unit)?,
    modifier: Modifier? = Modifier,
    enabled: Boolean? = true,
    label: (@Composable () -> Unit)? = null,
    alwaysShowLabel: Boolean? = true,
    interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() },
    colors: NavigationRailItemColors? = NavigationRailItemDefaults.colors()
): Unit
```

Material Design navigation rail item.

A `NavigationRailItem` represents a destination within a `NavigationRail`.

The text label is always shown (if it exists) when selected. Showing text labels if not selected is controlled by `alwaysShowLabel`.

| Parameters                                                   |                                                              |
| :----------------------------------------------------------- | ------------------------------------------------------------ |
| `selected: Boolean?`                                         | whether this item is selected                                |
| `onClick: (() -> Unit)?`                                     | the callback to be invoked when this item is selected        |
| `icon: (@Composable () -> Unit)?`                            | icon for this item, typically an `Icon`                      |
| `modifier: Modifier? = Modifier`                             | optional `Modifier` for this item                            |
| `enabled: Boolean? = true`                                   | controls the enabled state of this item. When false, this item will not be clickable and will appear disabled to accessibility services |
| `label: (@Composable () -> Unit)? = null`                    | optional text label for this item                            |
| `alwaysShowLabel: Boolean? = true`                           | whether to always show the label for this item. If false, the label will only be shown when this item is selected. |
| `interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() }` | the `MutableInteractionSource` representing the stream of `Interaction`s for this NavigationRailItem. You can create and pass in your own remembered `MutableInteractionSource` if you want to observe `Interaction`s and customize the appearance / behavior of this NavigationRailItem in different `Interaction`s. |
| `colors: NavigationRailItemColors? = NavigationRailItemDefaults.colors()` | the various colors used in elements of this item             |



### OutlinedButton

```
@Composable
fun OutlinedButton(
    onClick: (() -> Unit)?,
    modifier: Modifier? = Modifier,
    enabled: Boolean? = true,
    interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() },
    elevation: ButtonElevation? = null,
    shape: Shape? = OutlinedButton.ContainerShape,
    border: BorderStroke? = ButtonDefaults.outlinedButtonBorder,
    colors: ButtonColors? = ButtonDefaults.outlinedButtonColors(),
    contentPadding: PaddingValues? = ButtonDefaults.ContentPadding,
    content: (@Composable @ExtensionFunctionType RowScope.() -> Unit)?
): Unit
```

![Outlined button image](https://developer.android.google.cn/images/reference/androidx/compose/material3/outlined-button.png)

A Material Outlined button. Buttons contain actions for your app.

Outlined buttons are medium-emphasis buttons. They contain actions that are important, but are not the primary action in an app. Outlined buttons pair well with `Button`s to indicate an alternative, secondary action.

```
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text

OutlinedButton(onClick = { /* Do something! */ }) { Text("Outlined Button") }
```

Choose the best button for an action based on the amount of emphasis it needs. The more important an action is, the higher emphasis its button should be.

- See `Button` for a high-emphasis button without a shadow, also known as a filled button.
- See `FilledTonalButton` for a middle ground between `OutlinedButton` and `Button`.
- See `OutlinedButton` for a medium-emphasis button with a border.
- See `TextButton` for a low-emphasis button with no border.

The default text style for internal `Text` components will be set to `Typography.LabelLarge`.

| Parameters                                                   |                                                              |
| :----------------------------------------------------------- | ------------------------------------------------------------ |
| `onClick: (() -> Unit)?`                                     | Will be called when the user clicks the button.              |
| `modifier: Modifier? = Modifier`                             | Modifier to be applied to the button.                        |
| `enabled: Boolean? = true`                                   | Controls the enabled state of the button. When `false`, this button will not be clickable. |
| `interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() }` | the `MutableInteractionSource` representing the stream of `Interaction`s for this Button. You can create and pass in your own remembered `MutableInteractionSource` if you want to observe `Interaction`s and customize the appearance / behavior of this Button in different `Interaction`s. |
| `elevation: ButtonElevation? = null`                         | `ButtonElevation` used to resolve the elevation for this button in different states. This controls the size of the shadow below the button. When the container color is `ColorScheme.surface`, a higher elevation (surface blended with more primary) will result in a darker surface color in light theme and lighter color in dark theme. |
| `shape: Shape? = OutlinedButton.ContainerShape`              | Defines the button's shape as well as its shadow.            |
| `border: BorderStroke? = ButtonDefaults.outlinedButtonBorder` | Border to draw around the button. Pass `null` here for no border. |
| `colors: ButtonColors? = ButtonDefaults.outlinedButtonColors()` | `ButtonColors` that will be used to resolve the container and content color for this button in different states. See `ButtonDefaults.elevatedButtonColors`. |
| `contentPadding: PaddingValues? = ButtonDefaults.ContentPadding` | The spacing values to apply internally between the container and the content. |



### ProvideTextStyle

```
@Composable
fun ProvideTextStyle(value: TextStyle?, content: (@Composable () -> Unit)?): Unit
```

This function is used to set the current value of `LocalTextStyle`, merging the given style with the current style values for any missing attributes. Any `Text` components included in this component's `content` will be styled with this style unless styled explicitly.

| See also         |      |
| :--------------- | ---- |
| `LocalTextStyle` |      |



### RadioButton

```
@Composable
fun RadioButton(
    selected: Boolean?,
    onClick: (() -> Unit)?,
    modifier: Modifier? = Modifier,
    enabled: Boolean? = true,
    interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() },
    colors: RadioButtonColors? = RadioButtonDefaults.colors()
): Unit
```

Material Design radio button.

Radio buttons allow users to select one option from a set.

```
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

// We have two radio buttons and only one can be selected
var state by remember { mutableStateOf(true) }
// Note that Modifier.selectableGroup() is essential to ensure correct accessibility behavior
Row(Modifier.selectableGroup()) {
    RadioButton(
        selected = state,
        onClick = { state = true }
    )
    RadioButton(
        selected = !state,
        onClick = { state = false }
    )
}
```

`RadioButton`s can be combined together with `Text` in the desired layout (e.g. `Column` or `Row`) to achieve radio group-like behaviour, where the entire layout is selectable:

```
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

val radioOptions = listOf("Calls", "Missed", "Friends")
val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }
// Note that Modifier.selectableGroup() is essential to ensure correct accessibility behavior
Column(Modifier.selectableGroup()) {
    radioOptions.forEach { text ->
        Row(
            Modifier
                .fillMaxWidth()
                .height(56.dp)
                .selectable(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) },
                    role = Role.RadioButton
                )
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = (text == selectedOption),
                onClick = null // null recommended for accessibility with screenreaders
            )
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}
```

| Parameters                                                   |                                                              |
| :----------------------------------------------------------- | ------------------------------------------------------------ |
| `selected: Boolean?`                                         | whether this radio button is selected or not                 |
| `onClick: (() -> Unit)?`                                     | callback to be invoked when the RadioButton is clicked. If null, then this RadioButton will not handle input events, and only act as a visual indicator of `selected` state |
| `modifier: Modifier? = Modifier`                             | Modifier to be applied to the radio button                   |
| `enabled: Boolean? = true`                                   | Controls the enabled state of the `RadioButton`. When `false`, this button will not be selectable and appears disabled |
| `interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() }` | the `MutableInteractionSource` representing the stream of `Interaction`s for this RadioButton. You can create and pass in your own remembered `MutableInteractionSource` if you want to observe `Interaction`s and customize the appearance / behavior of this RadioButton in different `Interaction`s. |
| `colors: RadioButtonColors? = RadioButtonDefaults.colors()`  | `RadioButtonColors` that will be used to resolve the color used for this RadioButton in different states. See `RadioButtonDefaults.colors`. |



### Scaffold

```
@ExperimentalMaterial3Api
@Composable
fun Scaffold(
    modifier: Modifier? = Modifier,
    topBar: (@Composable () -> Unit)? = {},
    bottomBar: (@Composable () -> Unit)? = {},
    snackbarHost: (@Composable () -> Unit)? = {},
    floatingActionButton: (@Composable () -> Unit)? = {},
    floatingActionButtonPosition: FabPosition? = FabPosition.End,
    containerColor: Color? = MaterialTheme.colorScheme.background,
    contentColor: Color? = contentColorFor(containerColor),
    content: (@Composable (PaddingValues) -> Unit)?
): Unit
```

[Material Design layout](https://material.io/design/layout/understanding-layout.html).

Scaffold implements the basic material design visual layout structure.

This component provides API to put together several material components to construct your screen, by ensuring proper layout strategy for them and collecting necessary data so these components will work together correctly.

Simple example of a Scaffold with `SmallTopAppBar`, `FloatingActionButton`:

```
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color

val colors = listOf(
    Color(0xFFffd7d7.toInt()),
    Color(0xFFffe9d6.toInt()),
    Color(0xFFfffbd0.toInt()),
    Color(0xFFe3ffd9.toInt()),
    Color(0xFFd0fff8.toInt())
)

Scaffold(
    topBar = {
        SmallTopAppBar(
            title = { Text("Simple Scaffold Screen") },
            navigationIcon = {
                IconButton(
                    onClick = { /* "Open nav drawer" */ }
                ) {
                    Icon(Icons.Filled.Menu, contentDescription = "Localized description")
                }
            }
        )
    },
    floatingActionButtonPosition = FabPosition.End,
    floatingActionButton = {
        ExtendedFloatingActionButton(
            text = { Text("Inc") },
            onClick = { /* fab click handler */ }
        )
    },
    content = { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            items(count = 100) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(colors[it % colors.size])
                )
            }
        }
    }
)
```

To show a `Snackbar`, use `SnackbarHostState.showSnackbar`.

```
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope

val snackbarHostState = remember { SnackbarHostState() }
val scope = rememberCoroutineScope()
Scaffold(
    snackbarHost = { SnackbarHost(snackbarHostState) },
    floatingActionButton = {
        var clickCount by remember { mutableStateOf(0) }
        ExtendedFloatingActionButton(
            text = { Text("Show snackbar") },
            onClick = {
                // show snackbar as a suspend function
                scope.launch {
                    snackbarHostState.showSnackbar(
                        "Snackbar # ${++clickCount}"
                    )
                }
            }
        )
    },
    content = { innerPadding ->
        Text(
            text = "Body content",
            modifier = Modifier.padding(innerPadding).fillMaxSize().wrapContentSize()
        )
    }
)
```

| Parameters                                                   |                                                              |
| :----------------------------------------------------------- | ------------------------------------------------------------ |
| `modifier: Modifier? = Modifier`                             | optional Modifier for the root of the `Scaffold`.            |
| `topBar: (@Composable () -> Unit)? = {}`                     | top app bar of the screen. Consider using `SmallTopAppBar`.  |
| `bottomBar: (@Composable () -> Unit)? = {}`                  | bottom bar of the screen. Consider using `NavigationBar`.    |
| `snackbarHost: (@Composable () -> Unit)? = {}`               | component to host `Snackbar`s that are pushed to be shown via `SnackbarHostState.showSnackbar`. Usually it's a `SnackbarHost`. |
| `floatingActionButton: (@Composable () -> Unit)? = {}`       | Main action button of your screen. Consider using `FloatingActionButton` for this slot. |
| `floatingActionButtonPosition: FabPosition? = FabPosition.End` | position of the FAB on the screen. See `FabPosition` for possible options available. |
| `containerColor: Color? = MaterialTheme.colorScheme.background` | background of the scaffold body                              |
| `contentColor: Color? = contentColorFor(containerColor)`     | color of the content in scaffold body. Defaults to either the matching content color for `containerColor`, or, if it is not a color from the theme, this will keep the same value set above this Surface. |
| `content: (@Composable (PaddingValues) -> Unit)?`            | content of your screen. The lambda receives an `PaddingValues` that should be applied to the content root via Modifier.padding to properly offset top and bottom bars. If you're using Modifier.VerticalScroll, apply this modifier to the child of the scroll, and not on the scroll itself. |



### SmallFloatingActionButton

```
@Composable
fun SmallFloatingActionButton(
    onClick: (() -> Unit)?,
    modifier: Modifier? = Modifier,
    interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() },
    shape: Shape? = FabPrimarySmall.PrimarySmallContainerShape,
    containerColor: Color? = MaterialTheme.colorScheme.fromToken(FabPrimary.PrimaryContainerColor),
    contentColor: Color? = contentColorFor(containerColor),
    elevation: FloatingActionButtonElevation? = FloatingActionButtonDefaults.elevation(),
    content: (@Composable () -> Unit)?
): Unit
```

![Small FAB image](https://developer.android.google.cn/images/reference/androidx/compose/material3/small-fab.png)

A small floating action button.

```
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallFloatingActionButton

SmallFloatingActionButton(
    onClick = { /* do something */ },
) {
    Icon(Icons.Filled.Add, contentDescription = "Localized description")
}
```

| Parameters                                                   |                                                              |
| :----------------------------------------------------------- | ------------------------------------------------------------ |
| `onClick: (() -> Unit)?`                                     | callback invoked when this FAB is clicked                    |
| `modifier: Modifier? = Modifier`                             | `Modifier` to be applied to this FAB.                        |
| `interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() }` | the `MutableInteractionSource` representing the stream of `Interaction`s for this FAB. You can create and pass in your own remembered `MutableInteractionSource` if you want to observe `Interaction`s and customize the appearance / behavior of this FAB in different `Interaction`s. |
| `shape: Shape? = FabPrimarySmall.PrimarySmallContainerShape` | The `Shape` of this FAB                                      |
| `containerColor: Color? = MaterialTheme.colorScheme.fromToken(FabPrimary.PrimaryContainerColor)` | The container color. Use `Color.Transparent` to have no color |
| `contentColor: Color? = contentColorFor(containerColor)`     | The preferred content color for content inside this FAB      |
| `elevation: FloatingActionButtonElevation? = FloatingActionButtonDefaults.elevation()` | `FloatingActionButtonElevation` used to resolve the elevation for this FAB in different states. This controls the size of the shadow below the FAB. When `containerColor` is `ColorScheme.surface`, a higher elevation (surface blended with more primary) will result in a darker surface color in light theme and lighter color in dark theme. |
| `content: (@Composable () -> Unit)?`                         | the content of this FAB - this is typically an `Icon`.       |



### SmallTopAppBar

```
@Composable
fun SmallTopAppBar(
    title: (@Composable () -> Unit)?,
    modifier: Modifier? = Modifier,
    navigationIcon: (@Composable () -> Unit)? = {},
    actions: (@Composable @ExtensionFunctionType RowScope.() -> Unit)? = {},
    colors: TopAppBarColors? = TopAppBarDefaults.smallTopAppBarColors(),
    scrollBehavior: TopAppBarScrollBehavior? = null
): Unit
```

![Small top app bar image](https://developer.android.google.cn/images/reference/androidx/compose/material3/small-top-app-bar.png)

Material Design small top app bar.

The top app bar displays information and actions relating to the current screen.

This SmallTopAppBar has slots for a title, navigation icon, and actions.

A simple top app bar looks like:

```
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text

Scaffold(
    topBar = {
        SmallTopAppBar(
            title = { Text("Simple TopAppBar") },
            navigationIcon = {
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Localized description"
                    )
                }
            },
            actions = {
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Localized description"
                    )
                }
            }
        )
    },
    content = { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val list = (0..75).map { it.toString() }
            items(count = list.size) {
                Text(
                    text = list[it],
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
                )
            }
        }
    }
)
```

A top app bar that uses a `scrollBehavior` to customize its nested scrolling behavior when working in conjunction with a scrolling content looks like:

```
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.input.nestedscroll.nestedScroll

val scrollBehavior = remember { TopAppBarDefaults.pinnedScrollBehavior() }
Scaffold(
    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
    topBar = {
        SmallTopAppBar(
            title = { Text("Small TopAppBar") },
            navigationIcon = {
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Localized description"
                    )
                }
            },
            actions = {
                // RowScope here, so these icons will be placed horizontally
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Localized description"
                    )
                }
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Localized description"
                    )
                }
            },
            scrollBehavior = scrollBehavior
        )
    },
    content = { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val list = (0..75).map { it.toString() }
            items(count = list.size) {
                Text(
                    text = list[it],
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
                )
            }
        }
    }
)
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.input.nestedscroll.nestedScroll

val scrollBehavior = remember { TopAppBarDefaults.enterAlwaysScrollBehavior() }
Scaffold(
    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
    topBar = {
        SmallTopAppBar(
            title = { Text("Small TopAppBar") },
            navigationIcon = {
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Localized description"
                    )
                }
            },
            actions = {
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Localized description"
                    )
                }
            },
            scrollBehavior = scrollBehavior
        )
    },
    content = { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val list = (0..75).map { it.toString() }
            items(count = list.size) {
                Text(
                    text = list[it],
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
                )
            }
        }
    }
)
```

| Parameters                                                   |                                                              |
| :----------------------------------------------------------- | ------------------------------------------------------------ |
| `title: (@Composable () -> Unit)?`                           | the title to be displayed in the top app bar                 |
| `modifier: Modifier? = Modifier`                             | the `Modifier` to be applied to this top app bar             |
| `navigationIcon: (@Composable () -> Unit)? = {}`             | The navigation icon displayed at the start of the top app bar. This should typically be an `IconButton` or `IconToggleButton`. |
| `actions: (@Composable @ExtensionFunctionType RowScope.() -> Unit)? = {}` | the actions displayed at the end of the top app bar. This should typically be `IconButton`s. The default layout here is a `Row`, so icons inside will be placed horizontally. |
| `colors: TopAppBarColors? = TopAppBarDefaults.smallTopAppBarColors()` | a `TopAppBarColors` that will be used to resolve the colors used for this top app bar in different states. See `TopAppBarDefaults.smallTopAppBarColors`. |
| `scrollBehavior: TopAppBarScrollBehavior? = null`            | a `TopAppBarScrollBehavior` which holds various offset values that will be applied by this top app bar to set up its height and colors. A scroll behavior is designed to work in conjunction with a scrolled content to change the top app bar appearance as the content scrolls. See `TopAppBarScrollBehavior.nestedScrollConnection`. |



### Snackbar

```
@Composable
fun Snackbar(
    modifier: Modifier? = Modifier,
    action: (@Composable () -> Unit)? = null,
    dismissAction: (@Composable () -> Unit)? = null,
    actionOnNewLine: Boolean? = false,
    shape: Shape? = SnackbarTokens.ContainerShape,
    containerColor: Color? = MaterialTheme.colorScheme.fromToken(SnackbarTokens.ContainerColor),
    contentColor: Color? = MaterialTheme.colorScheme.fromToken(SnackbarTokens.SupportingTextColor),
    content: (@Composable () -> Unit)?
): Unit
```

Material Design snackbar.

Snackbars provide brief messages about app processes at the bottom of the screen.

Snackbars inform users of a process that an app has performed or will perform. They appear temporarily, towards the bottom of the screen. They shouldn’t interrupt the user experience, and they don’t require user input to disappear.

A Snackbar can contain a single action. "Dismiss" or "cancel" actions are optional.

Snackbars with an action should not timeout or self-dismiss until the user performs another action. Here, moving the keyboard focus indicator to navigate through interactive elements in a page is not considered an action.

This component provides only the visuals of the Snackbar. If you need to show a Snackbar with defaults on the screen, use `SnackbarHostState.showSnackbar`:

```
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope

val snackbarHostState = remember { SnackbarHostState() }
val scope = rememberCoroutineScope()
Scaffold(
    snackbarHost = { SnackbarHost(snackbarHostState) },
    floatingActionButton = {
        var clickCount by remember { mutableStateOf(0) }
        ExtendedFloatingActionButton(
            text = { Text("Show snackbar") },
            onClick = {
                // show snackbar as a suspend function
                scope.launch {
                    snackbarHostState.showSnackbar(
                        "Snackbar # ${++clickCount}"
                    )
                }
            }
        )
    },
    content = { innerPadding ->
        Text(
            text = "Body content",
            modifier = Modifier.padding(innerPadding).fillMaxSize().wrapContentSize()
        )
    }
)
```

If you want to customize appearance of the Snackbar, you can pass your own version as a child of the `SnackbarHost` to the `Scaffold`:

```
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope

class SnackbarVisualsWithError(
    override val message: String,
    val isError: Boolean
) : SnackbarVisuals {
    override val actionLabel: String
        get() = if (isError) "Error" else "OK"
    override val withDismissAction: Boolean
        get() = false
    override val duration: SnackbarDuration
        get() = SnackbarDuration.Long
}

val snackbarHostState = remember { SnackbarHostState() }
val scope = rememberCoroutineScope()
Scaffold(
    snackbarHost = {
        // reuse default SnackbarHost to have default animation and timing handling
        SnackbarHost(snackbarHostState) { data ->
            // custom snackbar with the custom action button color and border
            val isError = (data.visuals as? SnackbarVisualsWithError)?.isError ?: false
            val buttonColor = if (isError) {
                ButtonDefaults.textButtonColors(
                    containerColor = MaterialTheme.colorScheme.errorContainer,
                    contentColor = MaterialTheme.colorScheme.error
                )
            } else {
                ButtonDefaults.textButtonColors(
                    contentColor = MaterialTheme.colorScheme.inversePrimary
                )
            }

            Snackbar(
                modifier = Modifier
                    .border(2.dp, MaterialTheme.colorScheme.secondary)
                    .padding(12.dp),
                action = {
                    TextButton(
                        onClick = { if (isError) data.dismiss() else data.performAction() },
                        colors = buttonColor
                    ) { Text(data.visuals.actionLabel ?: "") }
                }
            ) {
                Text(data.visuals.message)
            }
        }
    },
    floatingActionButton = {
        var clickCount by remember { mutableStateOf(0) }
        ExtendedFloatingActionButton(
            text = { Text("Show snackbar") },
            onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar(
                        SnackbarVisualsWithError(
                            "Snackbar # ${++clickCount}",
                            isError = clickCount % 2 != 0
                        )
                    )
                }
            }
        )
    },
    content = { innerPadding ->
        Text(
            text = "Custom Snackbar Demo",
            modifier = Modifier.padding(innerPadding).fillMaxSize().wrapContentSize()
        )
    }
)
```

| Parameters                                                   |                                                              |
| :----------------------------------------------------------- | ------------------------------------------------------------ |
| `modifier: Modifier? = Modifier`                             | modifiers for the Snackbar layout                            |
| `action: (@Composable () -> Unit)? = null`                   | action / button component to add as an action to the snackbar. Consider using `ColorScheme.inversePrimary` as the color for the action, if you do not have a predefined color you wish to use instead. |
| `dismissAction: (@Composable () -> Unit)? = null`            | action / button component to add as an additional close affordance action when a snackbar is non self-dismissive. Consider using `ColorScheme.inverseOnSurface` as the color for the action, if you do not have a predefined color you wish to use instead. |
| `actionOnNewLine: Boolean? = false`                          | whether or not action should be put on the separate line. Recommended for action with long action text |
| `shape: Shape? = SnackbarTokens.ContainerShape`              | defines the Snackbar's shape (as well as its shadow when using `shadowElevation`) |
| `containerColor: Color? = MaterialTheme.colorScheme.fromToken(SnackbarTokens.ContainerColor)` | background color of the Snackbar                             |
| `contentColor: Color? = MaterialTheme.colorScheme.fromToken(SnackbarTokens.SupportingTextColor)` | the preferred color for content inside this Snackbar. Also see `LocalContentColor` which is used by `Text` and `Icon` by default. |
| `content: (@Composable () -> Unit)?`                         | content to show information about a process that an app has performed or will perform |



### Snackbar

```
@Composable
fun Snackbar(
    snackbarData: SnackbarData?,
    modifier: Modifier? = Modifier,
    actionOnNewLine: Boolean? = false,
    shape: Shape? = SnackbarTokens.ContainerShape,
    containerColor: Color? = MaterialTheme.colorScheme.fromToken(SnackbarTokens.ContainerColor),
    contentColor: Color? = MaterialTheme.colorScheme.fromToken(SnackbarTokens.SupportingTextColor),
    actionColor: Color? = MaterialTheme.colorScheme.fromToken(SnackbarTokens.ActionLabelTextColor)
): Unit
```

Material Design snackbar.

Snackbars provide brief messages about app processes at the bottom of the screen.

Snackbars inform users of a process that an app has performed or will perform. They appear temporarily, towards the bottom of the screen. They shouldn’t interrupt the user experience, and they don’t require user input to disappear.

A Snackbar can contain a single action. "Dismiss" or "cancel" actions are optional.

Snackbars with an action should not timeout or self-dismiss until the user performs another action. Here, moving the keyboard focus indicator to navigate through interactive elements in a page is not considered an action.

This version of snackbar is designed to work with `SnackbarData` provided by the `SnackbarHost`, which is usually used inside of the `Scaffold`.

This components provides only the visuals of the Snackbar. If you need to show a Snackbar with defaults on the screen, use `SnackbarHostState.showSnackbar`:

```
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope

val snackbarHostState = remember { SnackbarHostState() }
val scope = rememberCoroutineScope()
Scaffold(
    snackbarHost = { SnackbarHost(snackbarHostState) },
    floatingActionButton = {
        var clickCount by remember { mutableStateOf(0) }
        ExtendedFloatingActionButton(
            text = { Text("Show snackbar") },
            onClick = {
                // show snackbar as a suspend function
                scope.launch {
                    snackbarHostState.showSnackbar(
                        "Snackbar # ${++clickCount}"
                    )
                }
            }
        )
    },
    content = { innerPadding ->
        Text(
            text = "Body content",
            modifier = Modifier.padding(innerPadding).fillMaxSize().wrapContentSize()
        )
    }
)
```

If you want to customize appearance of the Snackbar, you can pass your own version as a child of the `SnackbarHost` to the `Scaffold`:

```
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope

class SnackbarVisualsWithError(
    override val message: String,
    val isError: Boolean
) : SnackbarVisuals {
    override val actionLabel: String
        get() = if (isError) "Error" else "OK"
    override val withDismissAction: Boolean
        get() = false
    override val duration: SnackbarDuration
        get() = SnackbarDuration.Long
}

val snackbarHostState = remember { SnackbarHostState() }
val scope = rememberCoroutineScope()
Scaffold(
    snackbarHost = {
        // reuse default SnackbarHost to have default animation and timing handling
        SnackbarHost(snackbarHostState) { data ->
            // custom snackbar with the custom action button color and border
            val isError = (data.visuals as? SnackbarVisualsWithError)?.isError ?: false
            val buttonColor = if (isError) {
                ButtonDefaults.textButtonColors(
                    containerColor = MaterialTheme.colorScheme.errorContainer,
                    contentColor = MaterialTheme.colorScheme.error
                )
            } else {
                ButtonDefaults.textButtonColors(
                    contentColor = MaterialTheme.colorScheme.inversePrimary
                )
            }

            Snackbar(
                modifier = Modifier
                    .border(2.dp, MaterialTheme.colorScheme.secondary)
                    .padding(12.dp),
                action = {
                    TextButton(
                        onClick = { if (isError) data.dismiss() else data.performAction() },
                        colors = buttonColor
                    ) { Text(data.visuals.actionLabel ?: "") }
                }
            ) {
                Text(data.visuals.message)
            }
        }
    },
    floatingActionButton = {
        var clickCount by remember { mutableStateOf(0) }
        ExtendedFloatingActionButton(
            text = { Text("Show snackbar") },
            onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar(
                        SnackbarVisualsWithError(
                            "Snackbar # ${++clickCount}",
                            isError = clickCount % 2 != 0
                        )
                    )
                }
            }
        )
    },
    content = { innerPadding ->
        Text(
            text = "Custom Snackbar Demo",
            modifier = Modifier.padding(innerPadding).fillMaxSize().wrapContentSize()
        )
    }
)
```

When a `SnackbarData.visuals` sets the Snackbar's duration as `SnackbarDuration.Indefinite`, it's recommended to display an additional close affordance action. See `SnackbarVisuals.withDismissAction`:

```
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope

val snackbarHostState = remember { SnackbarHostState() }
val scope = rememberCoroutineScope()
Scaffold(
    snackbarHost = { SnackbarHost(snackbarHostState) },
    floatingActionButton = {
        var clickCount by remember { mutableStateOf(0) }
        ExtendedFloatingActionButton(
            text = { Text("Show snackbar") },
            onClick = {
                // show snackbar as a suspend function
                scope.launch {
                    snackbarHostState.showSnackbar(
                        message = "Snackbar # ${++clickCount}",
                        actionLabel = "Action",
                        withDismissAction = true,
                        duration = SnackbarDuration.Indefinite
                    )
                }
            }
        )
    },
    content = { innerPadding ->
        Text(
            text = "Body content",
            modifier = Modifier.padding(innerPadding).fillMaxSize().wrapContentSize()
        )
    }
)
```

| Parameters                                                   |                                                              |
| :----------------------------------------------------------- | ------------------------------------------------------------ |
| `snackbarData: SnackbarData?`                                | data about the current snackbar showing via `SnackbarHostState` |
| `modifier: Modifier? = Modifier`                             | modifiers for the Snackbar layout                            |
| `actionOnNewLine: Boolean? = false`                          | whether or not the Snackbar's action should be put on the separate line (recommended for action with long action text) |
| `shape: Shape? = SnackbarTokens.ContainerShape`              | defines the Snackbar's shape (as well as its shadow when using `shadowElevation`) |
| `containerColor: Color? = MaterialTheme.colorScheme.fromToken(SnackbarTokens.ContainerColor)` | background color of the Snackbar                             |
| `contentColor: Color? = MaterialTheme.colorScheme.fromToken(SnackbarTokens.SupportingTextColor)` | the preferred color for content inside this Snackbar. Also see `LocalContentColor` which is used by `Text` and `Icon` by default. |
| `actionColor: Color? = MaterialTheme.colorScheme.fromToken(SnackbarTokens.ActionLabelTextColor)` | color of the Snackbar's action                               |



### SnackbarHost

```
@Composable
fun SnackbarHost(
    hostState: SnackbarHostState?,
    modifier: Modifier? = Modifier,
    snackbar: (@Composable (SnackbarData) -> Unit)? = { Snackbar(it) }
): Unit
```

Host for `Snackbar`s to be used in `Scaffold` to properly show, hide and dismiss items based on material specification and the `hostState`.

This component with default parameters comes build-in with `Scaffold`, if you need to show a default `Snackbar`, use `SnackbarHostState.showSnackbar`.

```
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope

val snackbarHostState = remember { SnackbarHostState() }
val scope = rememberCoroutineScope()
Scaffold(
    snackbarHost = { SnackbarHost(snackbarHostState) },
    floatingActionButton = {
        var clickCount by remember { mutableStateOf(0) }
        ExtendedFloatingActionButton(
            text = { Text("Show snackbar") },
            onClick = {
                // show snackbar as a suspend function
                scope.launch {
                    snackbarHostState.showSnackbar(
                        "Snackbar # ${++clickCount}"
                    )
                }
            }
        )
    },
    content = { innerPadding ->
        Text(
            text = "Body content",
            modifier = Modifier.padding(innerPadding).fillMaxSize().wrapContentSize()
        )
    }
)
```

If you want to customize appearance of the `Snackbar`, you can pass your own version as a child of the `SnackbarHost` to the `Scaffold`:

```
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope

class SnackbarVisualsWithError(
    override val message: String,
    val isError: Boolean
) : SnackbarVisuals {
    override val actionLabel: String
        get() = if (isError) "Error" else "OK"
    override val withDismissAction: Boolean
        get() = false
    override val duration: SnackbarDuration
        get() = SnackbarDuration.Long
}

val snackbarHostState = remember { SnackbarHostState() }
val scope = rememberCoroutineScope()
Scaffold(
    snackbarHost = {
        // reuse default SnackbarHost to have default animation and timing handling
        SnackbarHost(snackbarHostState) { data ->
            // custom snackbar with the custom action button color and border
            val isError = (data.visuals as? SnackbarVisualsWithError)?.isError ?: false
            val buttonColor = if (isError) {
                ButtonDefaults.textButtonColors(
                    containerColor = MaterialTheme.colorScheme.errorContainer,
                    contentColor = MaterialTheme.colorScheme.error
                )
            } else {
                ButtonDefaults.textButtonColors(
                    contentColor = MaterialTheme.colorScheme.inversePrimary
                )
            }

            Snackbar(
                modifier = Modifier
                    .border(2.dp, MaterialTheme.colorScheme.secondary)
                    .padding(12.dp),
                action = {
                    TextButton(
                        onClick = { if (isError) data.dismiss() else data.performAction() },
                        colors = buttonColor
                    ) { Text(data.visuals.actionLabel ?: "") }
                }
            ) {
                Text(data.visuals.message)
            }
        }
    },
    floatingActionButton = {
        var clickCount by remember { mutableStateOf(0) }
        ExtendedFloatingActionButton(
            text = { Text("Show snackbar") },
            onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar(
                        SnackbarVisualsWithError(
                            "Snackbar # ${++clickCount}",
                            isError = clickCount % 2 != 0
                        )
                    )
                }
            }
        )
    },
    content = { innerPadding ->
        Text(
            text = "Custom Snackbar Demo",
            modifier = Modifier.padding(innerPadding).fillMaxSize().wrapContentSize()
        )
    }
)
```

| Parameters                                                   |                                                              |
| :----------------------------------------------------------- | ------------------------------------------------------------ |
| `hostState: SnackbarHostState?`                              | state of this component to read and show `Snackbar`s accordingly |
| `modifier: Modifier? = Modifier`                             | optional modifier for this component                         |
| `snackbar: (@Composable (SnackbarData) -> Unit)? = { Snackbar(it) }` | the instance of the `Snackbar` to be shown at the appropriate time with appearance based on the `SnackbarData` provided as a param |



### Surface

```
@Composable
fun Surface(
    modifier: Modifier? = Modifier,
    shape: Shape? = RectangleShape,
    color: Color? = MaterialTheme.colorScheme.surface,
    contentColor: Color? = contentColorFor(color),
    tonalElevation: Dp? = 0.dp,
    shadowElevation: Dp? = 0.dp,
    border: BorderStroke? = null,
    content: (@Composable () -> Unit)?
): Unit
```

Material surface is the central metaphor in material design. Each surface exists at a given elevation, which influences how that piece of surface visually relates to other surfaces and how that surface is modified by tonal variance.

If you want to have a `Surface` that handles clicks, consider using another overload.

The `Surface` is responsible for:

1. Clipping: Surface clips its children to the shape specified by `shape`
2. Borders: If `shape` has a border, then it will also be drawn.
3. Background: Surface fills the shape specified by `shape` with the `color`. If `color` is `ColorScheme.surface` a color overlay will be applied. The color of the overlay depends on the `tonalElevation` of this Surface, and the `LocalAbsoluteTonalElevation` set by any parent surfaces. This ensures that a Surface never appears to have a lower elevation overlay than its ancestors, by summing the elevation of all previous Surfaces.
4. Content color: Surface uses `contentColor` to specify a preferred color for the content of this surface - this is used by the `Text` and `Icon` components as a default color.

If no `contentColor` is set, this surface will try and match its background color to a color defined in the theme `ColorScheme`, and return the corresponding content color. For example, if the `color` of this surface is `ColorScheme.surface`, `contentColor` will be set to `ColorScheme.onSurface`. If `color` is not part of the theme palette, `contentColor` will keep the same value set above this Surface.

To modify these default style values used by text, use `ProvideTextStyle` or explicitly pass a new `TextStyle` to your text.

To manually retrieve the content color inside a surface, use `LocalContentColor`.

1. Blocking touch propagation behind the surface.

| Parameters                                          |                                                              |
| :-------------------------------------------------- | ------------------------------------------------------------ |
| `modifier: Modifier? = Modifier`                    | Modifier to be applied to the layout corresponding to the surface |
| `shape: Shape? = RectangleShape`                    | Defines the surface's shape as well its shadow.              |
| `color: Color? = MaterialTheme.colorScheme.surface` | The background color. Use `Color.Transparent` to have no color. |
| `contentColor: Color? = contentColorFor(color)`     | The preferred content color provided by this Surface to its children. Defaults to either the matching content color for `color`, or if `color` is not a color from the theme, this will keep the same value set above this Surface. |
| `tonalElevation: Dp? = 0.dp`                        | When `color` is `ColorScheme.surface`, a higher the elevation will result in a darker color in light theme and lighter color in dark theme. |
| `shadowElevation: Dp? = 0.dp`                       | The size of the shadow below the surface. To prevent shadow creep, only apply shadow elevation when absolutely necessary, such as when the surface requires visual separation from a patterned background. Note that It will not affect z index of the Surface. If you want to change the drawing order you can use `Modifier.zIndex`. |
| `border: BorderStroke? = null`                      | Optional border to draw on top of the surface                |



### Surface

```
@Composable
fun Surface(
    onClick: (() -> Unit)?,
    modifier: Modifier? = Modifier,
    shape: Shape? = RectangleShape,
    color: Color? = MaterialTheme.colorScheme.surface,
    contentColor: Color? = contentColorFor(color),
    tonalElevation: Dp? = 0.dp,
    shadowElevation: Dp? = 0.dp,
    border: BorderStroke? = null,
    interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() },
    indication: Indication? = LocalIndication.current,
    enabled: Boolean? = true,
    onClickLabel: String? = null,
    role: Role? = null,
    content: (@Composable () -> Unit)?
): Unit
```

Material surface is the central metaphor in material design. Each surface exists at a given elevation, which influences how that piece of surface visually relates to other surfaces and how that surface is modified by tonal variance.

This version of `Surface` is responsible for a click handling as well al everything else that a regular Surface does:

This clickable `Surface` is responsible for:

1. Clipping: Surface clips its children to the shape specified by `shape`
2. Borders: If `shape` has a border, then it will also be drawn.
3. Background: Surface fills the shape specified by `shape` with the `color`. If `color` is `ColorScheme.surface` a color overlay may be applied. The color of the overlay depends on the `tonalElevation` of this Surface, and the `LocalAbsoluteTonalElevation` set by any parent surfaces. This ensures that a Surface never appears to have a lower elevation overlay than its ancestors, by summing the elevation of all previous Surfaces.
4. Content color: Surface uses `contentColor` to specify a preferred color for the content of this surface - this is used by the `Text` and `Icon` components as a default color. If no `contentColor` is set, this surface will try and match its background color to a color defined in the theme `ColorScheme`, and return the corresponding content color. For example, if the `color` of this surface is `ColorScheme.surface`, `contentColor` will be set to `ColorScheme.onSurface`. If `color` is not part of the theme palette, `contentColor` will keep the same value set above this Surface.
5. Click handling. This version of surface will react to the clicks, calling `onClick` lambda, updating the `interactionSource` when `PressInteraction` occurs, and showing `indication` (if it is not `null) in response to press events. If you don't need click handling, consider using the version that doesn't require `onClick` param.
6. Semantics for clicks. Just like with `Modifier.clickable`, clickable version of `Surface` will produce semantics to indicate that it is able to be clicked, with `onClickLabel` (if provided), announced by accessibility services.

To modify these default style values used by text, use `ProvideTextStyle` or explicitly pass a new `TextStyle` to your text.

To manually retrieve the content color inside a surface, use `LocalContentColor`.

| Parameters                                                   |                                                              |
| :----------------------------------------------------------- | ------------------------------------------------------------ |
| `onClick: (() -> Unit)?`                                     | callback to be called when the surface is clicked            |
| `modifier: Modifier? = Modifier`                             | Modifier to be applied to the layout corresponding to the surface |
| `shape: Shape? = RectangleShape`                             | Defines the surface's shape as well its shadow. A shadow is only displayed if the `tonalElevation` is greater than zero. |
| `color: Color? = MaterialTheme.colorScheme.surface`          | The background color. Use `Color.Transparent` to have no color. |
| `contentColor: Color? = contentColorFor(color)`              | The preferred content color provided by this Surface to its children. Defaults to either the matching content color for `color`, or if `color` is not a color from the theme, this will keep the same value set above this Surface. |
| `tonalElevation: Dp? = 0.dp`                                 | When `color` is `ColorScheme.surface`, a higher the elevation will result in a darker color in light theme and lighter color in dark theme. |
| `shadowElevation: Dp? = 0.dp`                                | The size of the shadow below the surface. Note that It will not affect z index of the Surface. If you want to change the drawing order you can use `Modifier.zIndex`. |
| `border: BorderStroke? = null`                               | Optional border to draw on top of the surface                |
| `interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() }` | the `MutableInteractionSource` representing the stream of `Interaction`s for this Surface. You can create and pass in your own remembered `MutableInteractionSource` if you want to observe `Interaction`s and customize the appearance / behavior of this Surface in different `Interaction`s. |
| `indication: Indication? = LocalIndication.current`          | indication to be shown when surface is pressed. By default, indication from `LocalIndication` will be used. Pass `null` to show no indication, or current value from `LocalIndication` to show theme default |
| `enabled: Boolean? = true`                                   | Controls the enabled state of the surface. When `false`, this surface will not be clickable |
| `onClickLabel: String? = null`                               | semantic / accessibility label for the `onClick` action      |
| `role: Role? = null`                                         | the type of user interface element. Accessibility services might use this to describe the element or do customizations. For example, if the Surface acts as a button, you should pass the `Role.Button` |



### Text

```kotlin
@Composable
fun Text(
    text: String?,
    modifier: Modifier? = Modifier,
    color: Color? = Color.Unspecified,
    fontSize: TextUnit? = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit? = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit? = TextUnit.Unspecified,
    overflow: TextOverflow? = TextOverflow.Clip,
    softWrap: Boolean? = true,
    maxLines: Int? = Int.MAX_VALUE,
    onTextLayout: ((TextLayoutResult) -> Unit)? = {},
    style: TextStyle? = LocalTextStyle.current
): Unit
```

High level element that displays text and provides semantics / accessibility information.

The default `style` uses the `LocalTextStyle` provided by the `MaterialTheme` / components. If you are setting your own style, you may want to consider first retrieving `LocalTextStyle`, and using `TextStyle.copy` to keep any theme defined attributes, only modifying the specific attributes you want to override.

For ease of use, commonly used parameters from `TextStyle` are also present here. The order of precedence is as follows:

- If a parameter is explicitly set here (i.e, it is *not*`null` or `TextUnit.Unspecified`), then this parameter will always be used.
- If a parameter is *not* set, (`null` or `TextUnit.Unspecified`), then the corresponding value from `style` will be used instead.

Additionally, for `color`, if `color` is not set, and `style` does not have a color, then `LocalContentColor` will be used.

| Parameters                                         |                                                              |
| :------------------------------------------------- | ------------------------------------------------------------ |
| `text: String?`                                    | The text to be displayed.                                    |
| `modifier: Modifier? = Modifier`                   | `Modifier` to apply to this layout node.                     |
| `color: Color? = Color.Unspecified`                | `Color` to apply to the text. If `Color.Unspecified`, and `style` has no color set, this will be `LocalContentColor`. |
| `fontSize: TextUnit? = TextUnit.Unspecified`       | The size of glyphs to use when painting the text. See `TextStyle.fontSize`. |
| `fontStyle: FontStyle? = null`                     | The typeface variant to use when drawing the letters (e.g., italic). See `TextStyle.fontStyle`. |
| `fontWeight: FontWeight? = null`                   | The typeface thickness to use when painting the text (e.g., `FontWeight.Bold`). |
| `fontFamily: FontFamily? = null`                   | The font family to be used when rendering the text. See `TextStyle.fontFamily`. |
| `letterSpacing: TextUnit? = TextUnit.Unspecified`  | The amount of space to add between each letter. See `TextStyle.letterSpacing`. |
| `textDecoration: TextDecoration? = null`           | The decorations to paint on the text (e.g., an underline). See `TextStyle.textDecoration`. |
| `textAlign: TextAlign? = null`                     | The alignment of the text within the lines of the paragraph. See `TextStyle.textAlign`. |
| `lineHeight: TextUnit? = TextUnit.Unspecified`     | Line height for the `Paragraph` in `TextUnit` unit, e.g. SP or EM. See `TextStyle.lineHeight`. |
| `overflow: TextOverflow? = TextOverflow.Clip`      | How visual overflow should be handled.                       |
| `softWrap: Boolean? = true`                        | Whether the text should break at soft line breaks. If false, the glyphs in the text will be positioned as if there was unlimited horizontal space. If `softWrap` is false, `overflow` and TextAlign may have unexpected effects. |
| `maxLines: Int? = Int.MAX_VALUE`                   | An optional maximum number of lines for the text to span, wrapping if necessary. If the text exceeds the given number of lines, it will be truncated according to `overflow` and `softWrap`. If it is not null, then it must be greater than zero. |
| `onTextLayout: ((TextLayoutResult) -> Unit)? = {}` | Callback that is executed when a new text layout is calculated. A `TextLayoutResult` object that callback provides contains paragraph information, size of the text, baselines and other details. The callback can be used to add additional decoration or functionality to the text. For example, to draw selection around the text. |
| `style: TextStyle? = LocalTextStyle.current`       | Style configuration for the text such as color, font, line height etc. |



### Text

```
@Composable
fun Text(
    text: AnnotatedString?,
    modifier: Modifier? = Modifier,
    color: Color? = Color.Unspecified,
    fontSize: TextUnit? = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit? = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit? = TextUnit.Unspecified,
    overflow: TextOverflow? = TextOverflow.Clip,
    softWrap: Boolean? = true,
    maxLines: Int? = Int.MAX_VALUE,
    inlineContent: Map<String?, InlineTextContent?>? = mapOf(),
    onTextLayout: ((TextLayoutResult) -> Unit)? = {},
    style: TextStyle? = LocalTextStyle.current
): Unit
```

High level element that displays text and provides semantics / accessibility information.

The default `style` uses the `LocalTextStyle` provided by the `MaterialTheme` / components. If you are setting your own style, you may want to consider first retrieving `LocalTextStyle`, and using `TextStyle.copy` to keep any theme defined attributes, only modifying the specific attributes you want to override.

For ease of use, commonly used parameters from `TextStyle` are also present here. The order of precedence is as follows:

- If a parameter is explicitly set here (i.e, it is *not*`null` or `TextUnit.Unspecified`), then this parameter will always be used.
- If a parameter is *not* set, (`null` or `TextUnit.Unspecified`), then the corresponding value from `style` will be used instead.

Additionally, for `color`, if `color` is not set, and `style` does not have a color, then `LocalContentColor` will be used.

| Parameters                                                   |                                                              |
| :----------------------------------------------------------- | ------------------------------------------------------------ |
| `text: AnnotatedString?`                                     | The text to be displayed.                                    |
| `modifier: Modifier? = Modifier`                             | `Modifier` to apply to this layout node.                     |
| `color: Color? = Color.Unspecified`                          | `Color` to apply to the text. If `Color.Unspecified`, and `style` has no color set, this will be `LocalContentColor`. |
| `fontSize: TextUnit? = TextUnit.Unspecified`                 | The size of glyphs to use when painting the text. See `TextStyle.fontSize`. |
| `fontStyle: FontStyle? = null`                               | The typeface variant to use when drawing the letters (e.g., italic). See `TextStyle.fontStyle`. |
| `fontWeight: FontWeight? = null`                             | The typeface thickness to use when painting the text (e.g., `FontWeight.Bold`). |
| `fontFamily: FontFamily? = null`                             | The font family to be used when rendering the text. See `TextStyle.fontFamily`. |
| `letterSpacing: TextUnit? = TextUnit.Unspecified`            | The amount of space to add between each letter. See `TextStyle.letterSpacing`. |
| `textDecoration: TextDecoration? = null`                     | The decorations to paint on the text (e.g., an underline). See `TextStyle.textDecoration`. |
| `textAlign: TextAlign? = null`                               | The alignment of the text within the lines of the paragraph. See `TextStyle.textAlign`. |
| `lineHeight: TextUnit? = TextUnit.Unspecified`               | Line height for the `Paragraph` in `TextUnit` unit, e.g. SP or EM. See `TextStyle.lineHeight`. |
| `overflow: TextOverflow? = TextOverflow.Clip`                | How visual overflow should be handled.                       |
| `softWrap: Boolean? = true`                                  | Whether the text should break at soft line breaks. If false, the glyphs in the text will be positioned as if there was unlimited horizontal space. If `softWrap` is false, `overflow` and TextAlign may have unexpected effects. |
| `maxLines: Int? = Int.MAX_VALUE`                             | An optional maximum number of lines for the text to span, wrapping if necessary. If the text exceeds the given number of lines, it will be truncated according to `overflow` and `softWrap`. If it is not null, then it must be greater than zero. |
| `inlineContent: Map<String?, InlineTextContent?>? = mapOf()` | A map store composables that replaces certain ranges of the text. It's used to insert composables into text layout. Check `InlineTextContent` for more information. |
| `onTextLayout: ((TextLayoutResult) -> Unit)? = {}`           | Callback that is executed when a new text layout is calculated. A `TextLayoutResult` object that callback provides contains paragraph information, size of the text, baselines and other details. The callback can be used to add additional decoration or functionality to the text. For example, to draw selection around the text. |
| `style: TextStyle? = LocalTextStyle.current`                 | Style configuration for the text such as color, font, line height etc. |



### TextButton

```
@Composable
fun TextButton(
    onClick: (() -> Unit)?,
    modifier: Modifier? = Modifier,
    enabled: Boolean? = true,
    interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() },
    elevation: ButtonElevation? = null,
    shape: Shape? = TextButton.ContainerShape,
    border: BorderStroke? = null,
    colors: ButtonColors? = ButtonDefaults.textButtonColors(),
    contentPadding: PaddingValues? = ButtonDefaults.TextButtonContentPadding,
    content: (@Composable @ExtensionFunctionType RowScope.() -> Unit)?
): Unit
```

![Text button image](https://developer.android.google.cn/images/reference/androidx/compose/material3/text-button.png)

A Material Text button. Buttons contain actions for your app.

Text buttons are typically used for less-pronounced actions, including those located in dialogs and cards. In cards, text buttons help maintain an emphasis on card content. Text buttons are used for the lowest priority actions, especially when presenting multiple options.

```
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton

TextButton(onClick = { /* Do something! */ }) { Text("Text Button") }
```

Choose the best button for an action based on the amount of emphasis it needs. The more important an action is, the higher emphasis its button should be.

- See `Button` for a high-emphasis button without a shadow, also known as a filled button.
- See `ElevatedButton` for a `FilledTonalButton` with a shadow.
- See `FilledTonalButton` for a middle ground between `OutlinedButton` and `Button`.
- See `OutlinedButton` for a medium-emphasis button with a border.

The default text style for internal `Text` components will be set to `Typography.LabelLarge`.

| Parameters                                                   |                                                              |
| :----------------------------------------------------------- | ------------------------------------------------------------ |
| `onClick: (() -> Unit)?`                                     | Will be called when the user clicks the button.              |
| `modifier: Modifier? = Modifier`                             | Modifier to be applied to the button.                        |
| `enabled: Boolean? = true`                                   | Controls the enabled state of the button. When `false`, this button will not be clickable. |
| `interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() }` | the `MutableInteractionSource` representing the stream of `Interaction`s for this Button. You can create and pass in your own remembered `MutableInteractionSource` if you want to observe `Interaction`s and customize the appearance / behavior of this Button in different `Interaction`s. |
| `elevation: ButtonElevation? = null`                         | `ButtonElevation` used to resolve the elevation for this button in different states. This controls the size of the shadow below the button. When the container color is `ColorScheme.surface`, a higher elevation (surface blended with more primary) will result in a darker surface color in light theme and lighter color in dark theme. A TextButton typically has no elevation, and the default value is `null`. See `ElevatedButton` for a button with elevation. |
| `shape: Shape? = TextButton.ContainerShape`                  | Defines the button's shape. A TextButton typically has no elevation or shadow, but if a non-zero or non-null elevation is passed in, then the shape also defines the bounds of the shadow. |
| `border: BorderStroke? = null`                               | Border to draw around the button.                            |
| `colors: ButtonColors? = ButtonDefaults.textButtonColors()`  | `ButtonColors` that will be used to resolve the container and content color for this button in different states. See `ButtonDefaults.textButtonColors`. |
| `contentPadding: PaddingValues? = ButtonDefaults.TextButtonContentPadding` | The spacing values to apply internally between the container and the content. |



### TriStateCheckbox

```
@Composable
fun TriStateCheckbox(
    state: ToggleableState?,
    onClick: (() -> Unit)?,
    modifier: Modifier? = Modifier,
    enabled: Boolean? = true,
    interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() },
    colors: CheckboxColors? = CheckboxDefaults.colors()
): Unit
```

Material Design checkbox parent.

Checkboxes can have a parent-child relationship with other checkboxes. When the parent checkbox is checked, all child checkboxes are checked. If a parent checkbox is unchecked, all child checkboxes are unchecked. If some, but not all, child checkboxes are checked, the parent checkbox becomes an indeterminate checkbox.

```
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

Column {
    // define dependent checkboxes states
    val (state, onStateChange) = remember { mutableStateOf(true) }
    val (state2, onStateChange2) = remember { mutableStateOf(true) }

    // TriStateCheckbox state reflects state of dependent checkboxes
    val parentState = remember(state, state2) {
        if (state && state2) ToggleableState.On
        else if (!state && !state2) ToggleableState.Off
        else ToggleableState.Indeterminate
    }
    // click on TriStateCheckbox can set state for dependent checkboxes
    val onParentClick = {
        val s = parentState != ToggleableState.On
        onStateChange(s)
        onStateChange2(s)
    }

    TriStateCheckbox(
        state = parentState,
        onClick = onParentClick,
    )
    Spacer(Modifier.size(25.dp))
    Column(Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp)) {
        Checkbox(state, onStateChange)
        Spacer(Modifier.size(25.dp))
        Checkbox(state2, onStateChange2)
    }
}
```

| Parameters                                                   |                                                              |
| :----------------------------------------------------------- | ------------------------------------------------------------ |
| `state: ToggleableState?`                                    | whether TriStateCheckbox is checked, unchecked or in indeterminate state callback to be invoked when the TriStateCheckbox is clicked. |
| `onClick: (() -> Unit)?`                                     | callback to be invoked when checkbox is being clicked, therefore the change of ToggleableState state is requested. If null, then this `TriStateCheckbox` will not handle input events, and only act as a visual indicator of `state` |
| `modifier: Modifier? = Modifier`                             | Modifier to be applied to the layout of the `TriStateCheckbox` |
| `enabled: Boolean? = true`                                   | controls the enabled state of the `TriStateCheckbox`. When `false`, this `TriStateCheckbox` will not be clickable/selectable |
| `interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() }` | the `MutableInteractionSource` representing the stream of `Interaction`s for this `TriStateCheckbox`. You can create and pass in your own remembered `MutableInteractionSource` if you want to observe `Interaction`s and customize the appearance / behavior of this `TriStateCheckbox` in different `Interaction`s |
| `colors: CheckboxColors? = CheckboxDefaults.colors()`        | `CheckboxColors` that will be used to resolve the color used for this `TriStateCheckbox` in different states. See `CheckboxDefaults.colors` |

| See also   |                                                              |
| :--------- | ------------------------------------------------------------ |
| `Checkbox` | if you want a simple component that represents Boolean state |



### contentColorFor

```
@Composable
fun contentColorFor(backgroundColor: Color?): Color
```

The Material color system contains pairs of colors that are typically used for the background and content color inside a component. For example, a `Button` typically uses `primary` for its background, and `onPrimary` for the color of its content (usually text or iconography).

This function tries to match the provided `backgroundColor` to a 'background' color in this `ColorScheme`, and then will return the corresponding color used for content. For example, when `backgroundColor` is `ColorScheme.primary`, this will return `ColorScheme.onPrimary`.

If `backgroundColor` does not match a background color in the theme, this will return the current value of `LocalContentColor` as a best-effort color.

| Returns |                                                              |
| :------ | ------------------------------------------------------------ |
| `Color` | the matching content color for `backgroundColor`. If `backgroundColor` is not present in the theme's `ColorScheme`, then returns the current value of `LocalContentColor`. |

| See also          |      |
| :---------------- | ---- |
| `contentColorFor` |      |



### darkColorScheme

```
fun darkColorScheme(
    primary: Color? = ColorDark.Primary,
    onPrimary: Color? = ColorDark.OnPrimary,
    primaryContainer: Color? = ColorDark.PrimaryContainer,
    onPrimaryContainer: Color? = ColorDark.OnPrimaryContainer,
    inversePrimary: Color? = ColorDark.InversePrimary,
    secondary: Color? = ColorDark.Secondary,
    onSecondary: Color? = ColorDark.OnSecondary,
    secondaryContainer: Color? = ColorDark.SecondaryContainer,
    onSecondaryContainer: Color? = ColorDark.OnSecondaryContainer,
    tertiary: Color? = ColorDark.Tertiary,
    onTertiary: Color? = ColorDark.OnTertiary,
    tertiaryContainer: Color? = ColorDark.TertiaryContainer,
    onTertiaryContainer: Color? = ColorDark.OnTertiaryContainer,
    background: Color? = ColorDark.Background,
    onBackground: Color? = ColorDark.OnBackground,
    surface: Color? = ColorDark.Surface,
    onSurface: Color? = ColorDark.OnSurface,
    surfaceVariant: Color? = ColorDark.SurfaceVariant,
    onSurfaceVariant: Color? = ColorDark.OnSurfaceVariant,
    inverseSurface: Color? = ColorDark.InverseSurface,
    inverseOnSurface: Color? = ColorDark.InverseOnSurface,
    error: Color? = ColorDark.Error,
    onError: Color? = ColorDark.OnError,
    errorContainer: Color? = ColorDark.ErrorContainer,
    onErrorContainer: Color? = ColorDark.OnErrorContainer,
    outline: Color? = ColorDark.Outline
): ColorScheme
```

Returns a dark Material color scheme.



### dynamicDarkColorScheme

```
@RequiresApi(value = 31)
fun dynamicDarkColorScheme(context: Context?): ColorScheme
```

Creates a dark dynamic color scheme.

Use this function to create a color scheme based off the system wallpaper. If the developer changes the wallpaper this color scheme will change accordingly. This dynamic scheme is a dark theme variant.

| Parameters          |                                                   |
| :------------------ | ------------------------------------------------- |
| `context: Context?` | The context required to get system resource data. |



### dynamicLightColorScheme

```
@RequiresApi(value = 31)
fun dynamicLightColorScheme(context: Context?): ColorScheme
```

Creates a light dynamic color scheme.

Use this function to create a color scheme based off the system wallpaper. If the developer changes the wallpaper this color scheme will change accordingly. This dynamic scheme is a light theme variant.

| Parameters          |                                                   |
| :------------------ | ------------------------------------------------- |
| `context: Context?` | The context required to get system resource data. |



### lightColorScheme

```
fun lightColorScheme(
    primary: Color? = ColorLight.Primary,
    onPrimary: Color? = ColorLight.OnPrimary,
    primaryContainer: Color? = ColorLight.PrimaryContainer,
    onPrimaryContainer: Color? = ColorLight.OnPrimaryContainer,
    inversePrimary: Color? = ColorLight.InversePrimary,
    secondary: Color? = ColorLight.Secondary,
    onSecondary: Color? = ColorLight.OnSecondary,
    secondaryContainer: Color? = ColorLight.SecondaryContainer,
    onSecondaryContainer: Color? = ColorLight.OnSecondaryContainer,
    tertiary: Color? = ColorLight.Tertiary,
    onTertiary: Color? = ColorLight.OnTertiary,
    tertiaryContainer: Color? = ColorLight.TertiaryContainer,
    onTertiaryContainer: Color? = ColorLight.OnTertiaryContainer,
    background: Color? = ColorLight.Background,
    onBackground: Color? = ColorLight.OnBackground,
    surface: Color? = ColorLight.Surface,
    onSurface: Color? = ColorLight.OnSurface,
    surfaceVariant: Color? = ColorLight.SurfaceVariant,
    onSurfaceVariant: Color? = ColorLight.OnSurfaceVariant,
    inverseSurface: Color? = ColorLight.InverseSurface,
    inverseOnSurface: Color? = ColorLight.InverseOnSurface,
    error: Color? = ColorLight.Error,
    onError: Color? = ColorLight.OnError,
    errorContainer: Color? = ColorLight.ErrorContainer,
    onErrorContainer: Color? = ColorLight.OnErrorContainer,
    outline: Color? = ColorLight.Outline
): ColorScheme
```

Returns a light Material color scheme.



### rememberDrawerState

```
@Composable
@ExperimentalMaterial3Api
fun rememberDrawerState(
    initialValue: DrawerValue?,
    confirmStateChange: ((DrawerValue) -> Boolean)? = { true }
): DrawerState
```

Create and `remember` a `DrawerState`.

| Parameters                                                   |                                                              |
| :----------------------------------------------------------- | ------------------------------------------------------------ |
| `initialValue: DrawerValue?`                                 | The initial value of the state.                              |
| `confirmStateChange: ((DrawerValue) -> Boolean)? = { true }` | Optional callback invoked to confirm or veto a pending state change. |

## Extension functions



### NavigationBarItem

```
@Composable
fun RowScope?.NavigationBarItem(
    selected: Boolean?,
    onClick: (() -> Unit)?,
    icon: (@Composable () -> Unit)?,
    modifier: Modifier? = Modifier,
    enabled: Boolean? = true,
    label: (@Composable () -> Unit)? = null,
    alwaysShowLabel: Boolean? = true,
    interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() },
    colors: NavigationBarItemColors? = NavigationBarItemDefaults.colors()
): Unit
```

Material Design navigation bar item.

The recommended configuration for a `NavigationBarItem` depends on how many items there are inside a `NavigationBar`:

- Three destinations: Display icons and text labels for all destinations.
- Four destinations: Active destinations display an icon and text label. Inactive destinations display icons, and text labels are recommended.
- Five destinations: Active destinations display an icon and text label. Inactive destinations use icons, and use text labels if space permits.

A `NavigationBarItem` always shows text labels (if it exists) when selected. Showing text labels if not selected is controlled by `alwaysShowLabel`.

| Parameters                                                   |                                                              |
| :----------------------------------------------------------- | ------------------------------------------------------------ |
| `selected: Boolean?`                                         | whether this item is selected                                |
| `onClick: (() -> Unit)?`                                     | the callback to be invoked when this item is selected        |
| `icon: (@Composable () -> Unit)?`                            | icon for this item, typically this will be an `Icon`         |
| `modifier: Modifier? = Modifier`                             | optional `Modifier` for this item                            |
| `enabled: Boolean? = true`                                   | controls the enabled state of this item. When `false`, this item will not be clickable and will appear disabled to accessibility services. |
| `label: (@Composable () -> Unit)? = null`                    | optional text label for this item                            |
| `alwaysShowLabel: Boolean? = true`                           | whether to always show the label for this item. If false, the label will only be shown when this item is selected. |
| `interactionSource: MutableInteractionSource? = remember { MutableInteractionSource() }` | the `MutableInteractionSource` representing the stream of `Interaction`s for this NavigationBarItem. You can create and pass in your own remembered `MutableInteractionSource` if you want to observe `Interaction`s and customize the appearance / behavior of this NavigationBarItem in different `Interaction`s. |
| `colors: NavigationBarItemColors? = NavigationBarItemDefaults.colors()` | the various colors used in elements of this item             |



### contentColorFor

```
fun ColorScheme?.contentColorFor(backgroundColor: Color?): Color
```

The Material color system contains pairs of colors that are typically used for the background and content color inside a component. For example, a `Button` typically uses `primary` for its background, and `onPrimary` for the color of its content (usually text or iconography).

This function tries to match the provided `backgroundColor` to a 'background' color in this `ColorScheme`, and then will return the corresponding color used for content. For example, when `backgroundColor` is `ColorScheme.primary`, this will return `ColorScheme.onPrimary`.

If `backgroundColor` does not match a background color in the theme, this will return `Color.Unspecified`.

| Returns |                                                              |
| :------ | ------------------------------------------------------------ |
| `Color` | the matching content color for `backgroundColor`. If `backgroundColor` is not present in the theme's `ColorScheme`, then returns `Color.Unspecified`. |

## Top-level properties



### LocalAbsoluteTonalElevation

```
val LocalAbsoluteTonalElevation: ProvidableCompositionLocal<Dp>
```

CompositionLocal containing the current absolute elevation provided by `Surface` components. This absolute elevation is a sum of all the previous elevations. Absolute elevation is only used for calculating surface tonal colors, and is *not* used for drawing the shadow in a `Surface`.



### LocalContentColor

```
val LocalContentColor: ProvidableCompositionLocal<Color>
```

CompositionLocal containing the preferred content color for a given position in the hierarchy. This typically represents the `on` color for a color in `ColorScheme`. For example, if the background color is `ColorScheme.surface`, this color is typically set to `ColorScheme.onSurface`.

This color should be used for any typography / iconography, to ensure that the color of these adjusts when the background color changes. For example, on a dark background, text should be light, and on a light background, text should be dark.

Defaults to `Color.Black` if no color has been explicitly set.



### LocalMinimumTouchTargetEnforcement

```
@ExperimentalMaterial3Api
val LocalMinimumTouchTargetEnforcement: ProvidableCompositionLocal<Boolean>
```

CompositionLocal that configures whether Material components that have a visual size that is lower than the minimum touch target size for accessibility (such as Button) will include extra space outside the component to ensure that they are accessible. If set to false there will be no extra space, and so it is possible that if the component is placed near the edge of a layout / near to another component without any padding, there will not be enough space for an accessible touch target.



### LocalTextStyle

```
val LocalTextStyle: ProvidableCompositionLocal<TextStyle>
```

CompositionLocal containing the preferred `TextStyle` that will be used by `Text` components by default. To set the value for this CompositionLocal, see `ProvideTextStyle` which will merge any missing `TextStyle` properties with the existing `TextStyle` set in this CompositionLocal.

| See also           |      |
| :----------------- | ---- |
| `ProvideTextStyle` |      |



Content and code samples on this page are subject to the licenses described in the [Content License](https://developer.android.google.cn/license). Java is a registered trademark of Oracle and/or its affiliates.

[![Google Developers](https://www.gstatic.cn/devrel-devsite/prod/v9a7f09bb7f4c184c1c51854c0e49b9781e5080168a451bfdb66303a8ed0ad46f/android/images/lockup-developers.svg)](https://developers.google.cn/)