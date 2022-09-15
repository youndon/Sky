package com.example.sky.components

import androidx.compose.material.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.contentColorFor
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

private interface AppBars {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable fun app() {
        //
        TopAppBar(
            modifier = Modifier,
            backgroundColor = MaterialTheme.colors.primarySurface,
            contentColor = contentColorFor(backgroundColor),
            elevation = AppBarDefaults.TopAppBarElevation,
            contentPadding = AppBarDefaults.ContentPadding,
        ) {

        }

        //
        LargeTopAppBar(
            title = @Composable {},
            modifier = Modifier,
            navigationIcon = @Composable {},
            actions = @Composable {},
            colors = TopAppBarDefaults.largeTopAppBarColors(),
            scrollBehavior = null
        )
        //
        MediumTopAppBar(
            title = @Composable {},
            modifier = Modifier,
            navigationIcon = @Composable {},
            actions = @Composable {},
            colors = TopAppBarDefaults.mediumTopAppBarColors(),
            scrollBehavior = null)
        //
        SmallTopAppBar(
            title = @Composable {},
            modifier = Modifier,
            navigationIcon = @Composable {},
            actions = @Composable {},
            colors = TopAppBarDefaults.smallTopAppBarColors(),
            scrollBehavior = null
        )
        //
        CenterAlignedTopAppBar(
            title = @Composable {},
            modifier = Modifier,
            navigationIcon = @Composable {},
            actions = @Composable {},
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
            scrollBehavior = null)
        //
        BottomAppBar(
            modifier = Modifier,
            backgroundColor = MaterialTheme.colors.primarySurface,
            contentColor = contentColorFor(backgroundColor),
            cutoutShape = null,
            elevation = AppBarDefaults.BottomAppBarElevation,
            contentPadding = AppBarDefaults.ContentPadding,
        ){

        }
    }
}