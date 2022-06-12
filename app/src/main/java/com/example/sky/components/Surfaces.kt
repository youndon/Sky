//package com.example.sky.components
//
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.LocalIndication
//import androidx.compose.foundation.interaction.MutableInteractionSource
//import androidx.compose.material.*
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.RectangleShape
//import androidx.compose.ui.semantics.Role
//import androidx.compose.ui.unit.dp
//import com.example.sky.jetpackCompose.material.ScaffoldWithBottomBarAndCutout
//
//interface Surfaces {
//    @Composable
//    fun S() {
//        Surface(
//            modifier = Modifier,
//            shape = RectangleShape,
//            color = Color.Cyan,
//            contentColor = contentColorFor(Color.Cyan),
//            border = BorderStroke(1.dp, Color.White),
//            elevation = 1.dp
//        ) {
//
//        }
//    }
//    @OptIn(ExperimentalMaterialApi::class)
//    @Composable
//    fun SE() {
//        Surface(
//            onClick = {},
//            modifier = Modifier,
//            shape = RectangleShape,
//            color = MaterialTheme.colors.surface,
//            contentColor = contentColorFor(Color.Cyan),
//            border = BorderStroke(1.dp, Color.Cyan),
//            elevation = 0.dp,
//            interactionSource = remember { MutableInteractionSource() },
//            indication = LocalIndication.current,
//            enabled = true,
//            onClickLabel = "click label",
//            role = Role.Button,
//        ) {
//
//        }
//
//        BackdropScaffold(
//                    appBar: @Composable () -> Unit,
//        backLayerContent: @Composable () -> Unit,
//        frontLayerContent: @Composable () -> Unit,
//        modifier: Modifier = Modifier,
//        scaffoldState: BackdropScaffoldState = rememberBackdropScaffoldState(Concealed),
//        gesturesEnabled: Boolean = true,
//        peekHeight: Dp = BackdropScaffoldDefaults.PeekHeight,
//        headerHeight: Dp = BackdropScaffoldDefaults.HeaderHeight,
//        persistentAppBar: Boolean = true,
//        stickyFrontLayer: Boolean = true,
//        backLayerBackgroundColor: Color = MaterialTheme.colors.primary,
//        backLayerContentColor: Color = contentColorFor(backLayerBackgroundColor),
//        frontLayerShape: Shape = BackdropScaffoldDefaults.frontLayerShape,
//        frontLayerElevation: Dp = BackdropScaffoldDefaults.FrontLayerElevation,
//        frontLayerBackgroundColor: Color = MaterialTheme.colors.surface,
//        frontLayerContentColor: Color = contentColorFor(frontLayerBackgroundColor),
//        frontLayerScrimColor: Color = BackdropScaffoldDefaults.frontLayerScrimColor,
//        snackbarHost: @Composable (SnackbarHostState) -> Unit = { SnackbarHost(it) }
//        ) {
//
//        }
//        BottomSheetScaffold(
//            sheetContent: @Composable ColumnScope.() -> Unit,
//        modifier: Modifier = Modifier,
//        scaffoldState: BottomSheetScaffoldState = rememberBottomSheetScaffoldState(),
//        topBar: (@Composable () -> Unit)? = null,
//        snackbarHost: @Composable (SnackbarHostState) -> Unit = { SnackbarHost(it) },
//        floatingActionButton: (@Composable () -> Unit)? = null,
//        floatingActionButtonPosition: FabPosition = FabPosition.End,
//        sheetGesturesEnabled: Boolean = true,
//        sheetShape: Shape = MaterialTheme.shapes.large,
//        sheetElevation: Dp = BottomSheetScaffoldDefaults.SheetElevation,
//        sheetBackgroundColor: Color = MaterialTheme.colors.surface,
//        sheetContentColor: Color = contentColorFor(sheetBackgroundColor),
//        sheetPeekHeight: Dp = BottomSheetScaffoldDefaults.SheetPeekHeight,
//        drawerContent: @Composable (ColumnScope.() -> Unit)? = null,
//        drawerGesturesEnabled: Boolean = true,
//        drawerShape: Shape = MaterialTheme.shapes.large,
//        drawerElevation: Dp = DrawerDefaults.Elevation,
//        drawerBackgroundColor: Color = MaterialTheme.colors.surface,
//        drawerContentColor: Color = contentColorFor(drawerBackgroundColor),
//        drawerScrimColor: Color = DrawerDefaults.scrimColor,
//        backgroundColor: Color = MaterialTheme.colors.background,
//        contentColor: Color = contentColorFor(backgroundColor),
//        content: @Composable (PaddingValues) -> Unit
//        ) {
//
//        }
//    }
//}