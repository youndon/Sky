package com.example.sky.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.DrawerValue
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material3.MaterialTheme as M3
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.material3.DrawerDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

interface Navigational {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable fun Navig() {

        NavigationRail(
            modifier = Modifier,
            containerColor = contentColorFor(backgroundColor = Color.Gray),
            contentColor = contentColorFor(backgroundColor),
            header = @Composable {},
        ) {
            NavigationRailItem(
                selected = true,
                onClick = {},
                icon = @Composable {},
                modifier = Modifier,
                enabled = true,
                label = @Composable {},
                alwaysShowLabel = true,
                interactionSource = remember { MutableInteractionSource() },
                colors = NavigationRailItemDefaults.colors()
            )
        }

        BottomNavigation(
            modifier = Modifier,
            backgroundColor = MaterialTheme.colors.primarySurface,
            contentColor = contentColorFor(backgroundColor),
            elevation = BottomNavigationDefaults.Elevation,
            content = {
                BottomNavigationItem(
                    selected = true,
                    onClick = { },
                    icon = @Composable { },
                    modifier = Modifier,
                    enabled = true,
                    label = @Composable { },
                    alwaysShowLabel = true,
                    interactionSource = remember { MutableInteractionSource() },
                    selectedContentColor = M3.colorScheme.surface,
                    unselectedContentColor = M3.colorScheme.surface.copy(alpha = ContentAlpha.medium)
                )
            }
        )
        NavigationBar {
            NavigationBarItem(
                selected = true,
                onClick = { },
                icon = @Composable {},
                modifier = Modifier,
                enabled = true,
                label = @Composable { },
                alwaysShowLabel = true,
                interactionSource = remember { MutableInteractionSource() },
                colors = NavigationBarItemDefaults.colors()
            )
        }
        DismissibleNavigationDrawer(
            drawerContent = @Composable { },
            modifier = Modifier,
            drawerState = rememberDrawerState(androidx.compose.material3.DrawerValue.Closed),
            gesturesEnabled = true,
            drawerShape = RectangleShape,
            drawerTonalElevation = DrawerDefaults.DismissibleDrawerElevation,
            drawerContainerColor = M3.colorScheme.surface,
            drawerContentColor = contentColorFor(M3.colorScheme.surface)
        ) {

            }
        ModalNavigationDrawer(
            drawerContent = @Composable { },
            modifier = Modifier,
            drawerState = rememberDrawerState(androidx.compose.material3.DrawerValue.Closed),
            gesturesEnabled = true,
            drawerShape = RoundedCornerShape(0.dp, 16.dp, 16.dp, 0.dp),
            drawerTonalElevation = DrawerDefaults.ModalDrawerElevation,
            drawerContainerColor = M3.colorScheme.surface,
            drawerContentColor = contentColorFor(M3.colorScheme.surface),
            scrimColor = DrawerDefaults.scrimColor
        ) {

        }
        PermanentNavigationDrawer(
            drawerContent = @Composable {},
            modifier = Modifier,
            drawerShape = RectangleShape,
            drawerTonalElevation = DrawerDefaults.PermanentDrawerElevation,
            drawerContainerColor = M3.colorScheme.surface,
            drawerContentColor = contentColorFor(M3.colorScheme.surface)
        ) {

        }
    }
}