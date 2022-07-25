package com.example.sky.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.example.sky.jetpackCompose.material.ScaffoldWithBottomBarAndCutout

interface Surfaces {
    @Composable
    fun S() {
        Surface(
            modifier = Modifier,
            shape = RectangleShape,
            color = Color.Cyan,
            contentColor = contentColorFor(Color.Cyan),
            border = BorderStroke(1.dp, Color.White),
            elevation = 1.dp
        ) {

        }
    }
    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun SE() {
        Surface(
            onClick = {},
            modifier = Modifier,
            enabled = true,
            shape = RectangleShape,
            color = MaterialTheme.colors.surface,
            contentColor = contentColorFor(Color.Cyan),
            border = BorderStroke(1.dp, Color.Cyan),
            elevation = 0.dp,
            interactionSource = remember { MutableInteractionSource() }
        ) {

        }

        BackdropScaffold(
            appBar = @Composable {},
            backLayerContent = @Composable {},
            frontLayerContent = @Composable {},
            modifier = Modifier,
            scaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed),
            gesturesEnabled = true,
            peekHeight = BackdropScaffoldDefaults.PeekHeight,
            headerHeight = BackdropScaffoldDefaults.HeaderHeight,
            persistentAppBar = true,
            stickyFrontLayer = true,
            backLayerBackgroundColor = MaterialTheme.colors.primary,
            backLayerContentColor = contentColorFor(MaterialTheme.colors.primary),
            frontLayerShape = BackdropScaffoldDefaults.frontLayerShape,
            frontLayerElevation = BackdropScaffoldDefaults.FrontLayerElevation,
            frontLayerBackgroundColor = MaterialTheme.colors.surface,
            frontLayerContentColor = contentColorFor(MaterialTheme.colors.surface),
            frontLayerScrimColor = BackdropScaffoldDefaults.frontLayerScrimColor,
            snackbarHost = @Composable { SnackbarHost(it) }
        )
        BottomSheetScaffold(
            sheetContent = @Composable {},
            modifier = Modifier,
            scaffoldState = rememberBottomSheetScaffoldState(),
            topBar = (@Composable {}),
            snackbarHost = @Composable { SnackbarHost(it) },
            floatingActionButton = (@Composable {}),
            floatingActionButtonPosition = FabPosition.End,
            sheetGesturesEnabled = true,
            sheetShape = MaterialTheme.shapes.large,
            sheetElevation = BottomSheetScaffoldDefaults.SheetElevation,
            sheetBackgroundColor = MaterialTheme.colors.surface,
            sheetContentColor = contentColorFor(MaterialTheme.colors.surface),
            sheetPeekHeight = BottomSheetScaffoldDefaults.SheetPeekHeight,
            drawerContent = @Composable {},
            drawerGesturesEnabled = true,
            drawerShape = MaterialTheme.shapes.large,
            drawerElevation = DrawerDefaults.Elevation,
            drawerBackgroundColor = MaterialTheme.colors.surface,
            drawerContentColor = contentColorFor(MaterialTheme.colors.surface),
            drawerScrimColor = DrawerDefaults.scrimColor,
            backgroundColor = MaterialTheme.colors.background,
            contentColor = contentColorFor(MaterialTheme.colors.background)
        ) {
        }
    }
}