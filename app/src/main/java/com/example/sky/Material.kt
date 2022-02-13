package com.example.sky

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun <T> Material() {
    LocalAbsoluteElevation
    LocalContentAlpha
    LocalContentColor
    LocalElevationOverlay
    LocalTextStyle
    Button({}){}
    MaterialTheme {  }
    Text("")
    AlertDialog({},{})
    BackdropScaffold({},{},{})
    BottomAppBar {  }
    BottomDrawer({}){}
    BottomNavigation {  }
    BottomSheetScaffold({}){}
    Card {  }
    Checkbox(false,{b: Boolean -> b })
    CircularProgressIndicator()
    Divider()
    DropdownMenu(false,{}){}
    DropdownMenuItem({}){}
    ExtendedFloatingActionButton({},{})
    FloatingActionButton({}){}
//    Icon() // FIXME: 15/07/2021
    IconButton({}){}
    IconToggleButton(false,{b: Boolean -> b }){}
    LeadingIconTab(false,{},{},{})
    LinearProgressIndicator()
    ListItem {  }
    ModalBottomSheetLayout({}){}
    ModalDrawer({}){}
    OutlinedButton({}){}
    OutlinedTextField("",{})
    ProvideTextStyle(TextStyle()){}
    RadioButton(false,{})
    Scaffold {  }
    ScrollableTabRow(1){}
    Slider(1f,{})
    Snackbar {  }
    SnackbarHost(SnackbarHostState())
    Surface {  }
//    SwipeToDismiss() // FIXME: 15/07/2021
    Switch(false,{})
    Tab(false,{})
    TabRow(1){}
    TopAppBar({})
    darkColors()
    TextField("",{})
    contentColorFor(Color.Gray)
    rememberBackdropScaffoldState(BackdropValue.Concealed)
    rememberBottomDrawerState(BottomDrawerValue.Expanded)
    rememberBottomSheetScaffoldState()
    rememberBottomSheetState(BottomSheetValue.Expanded)
    rememberDismissState { dismissValue: DismissValue -> false}
    rememberModalBottomSheetState(ModalBottomSheetValue.Expanded)
    rememberDrawerState(DrawerValue.Open)
    rememberScaffoldState()
    rememberSwipeableState(1)
    TextButton({}){}
    TriStateCheckbox(ToggleableState.Indeterminate,{})
    lightColors()
    materialIcon(""){ImageVector.Builder("", Dp.Hairline,Dp.Hairline,1f,1f)}
    Icons
    LocalRippleTheme
    rememberRipple()
}