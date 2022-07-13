package com.example.sky.components

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme as MT3
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

private interface Scaffolds {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun sca() {
        //
        Scaffold(
            modifier = Modifier,
            scaffoldState = rememberScaffoldState(),
            topBar = @Composable {},
            bottomBar = @Composable {},
            snackbarHost = @Composable { SnackbarHost(it) },
            floatingActionButton = @Composable {},
            floatingActionButtonPosition = FabPosition.End,
            isFloatingActionButtonDocked = false,
            drawerContent = @Composable {},
            drawerGesturesEnabled = true,
            drawerShape = MaterialTheme.shapes.large,
            drawerElevation = DrawerDefaults.Elevation,
            drawerBackgroundColor = MT3.colorScheme.surface,
            drawerContentColor = contentColorFor(MaterialTheme.colors.surface),
            drawerScrimColor = DrawerDefaults.scrimColor,
            backgroundColor = MT3.colorScheme.background,
            contentColor = contentColorFor(SnackbarDefaults.backgroundColor)
        ) {

        }

        //
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
            backLayerBackgroundColor = MT3.colorScheme.primary,
            backLayerContentColor = contentColorFor(MT3.colorScheme.primary),
            frontLayerShape = BackdropScaffoldDefaults.frontLayerShape,
            frontLayerElevation = BackdropScaffoldDefaults.FrontLayerElevation,
            frontLayerBackgroundColor = MT3.colorScheme.surface,
            frontLayerContentColor = contentColorFor(MT3.colorScheme.surface),
            frontLayerScrimColor = BackdropScaffoldDefaults.frontLayerScrimColor,
            snackbarHost = @Composable { SnackbarHost(it) })

        //
        BottomSheetScaffold(
            sheetContent = @Composable {},
            modifier = Modifier,
            scaffoldState = rememberBottomSheetScaffoldState(),
            topBar = @Composable {},
            snackbarHost = @Composable { SnackbarHost(it) },
            floatingActionButton = @Composable {},
            floatingActionButtonPosition = FabPosition.End,
            sheetGesturesEnabled = true,
            sheetShape = MaterialTheme.shapes.large,
            sheetElevation = BottomSheetScaffoldDefaults.SheetElevation,
            sheetBackgroundColor = MT3.colorScheme.surface,
            sheetContentColor = contentColorFor(MT3.colorScheme.surface),
            sheetPeekHeight = BottomSheetScaffoldDefaults.SheetPeekHeight,
            drawerContent = @Composable {},
            drawerGesturesEnabled = true,
            drawerShape = MaterialTheme.shapes.large,
            drawerElevation = DrawerDefaults.Elevation,
            drawerBackgroundColor = MT3.colorScheme.surface,
            drawerContentColor = contentColorFor(MT3.colorScheme.surface),
            drawerScrimColor = DrawerDefaults.scrimColor,
            backgroundColor = MT3.colorScheme.background,
            contentColor = contentColorFor(SnackbarDefaults.backgroundColor)
        ) {

        }
    }
}