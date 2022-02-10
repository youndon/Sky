package components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

interface Tabs {
    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun tab() {
        //
        TabRow(
            selectedTabIndex = 0,
            modifier = Modifier,
            backgroundColor = MaterialTheme.colors.primarySurface,
            contentColor = contentColorFor(SnackbarDefaults.backgroundColor),
            indicator = @Composable { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(tabPositions[0])
                )
            },
            divider = @Composable {
                TabRowDefaults.Divider()
            },
            tabs = @Composable {
                Tab(
                    selected = true,
                    onClick = {},
                    modifier = Modifier,
                    enabled = true,
                    interactionSource = remember { MutableInteractionSource() },
                    selectedContentColor = LocalContentColor.current,
                    unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.medium),
                    content = @Composable {
                        Text("Tab")
                    }
                )
            }
        )
        //
        ScrollableTabRow(
            selectedTabIndex = 1,
            modifier = Modifier,
            backgroundColor = MaterialTheme.colors.primarySurface,
            contentColor = contentColorFor(backgroundColor),
            edgePadding = TabRowDefaults.ScrollableTabRowPadding,
            indicator = @Composable { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(tabPositions[0])
                )
            }
        ) {
        }
        //
        LeadingIconTab(
            selected = true,
            onClick = {},
            text = @Composable {},
            icon = @Composable {},
            modifier = Modifier,
            enabled = true,
            interactionSource = remember { MutableInteractionSource() },
            selectedContentColor = LocalContentColor.current,
            unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.medium)
        )
    }
}