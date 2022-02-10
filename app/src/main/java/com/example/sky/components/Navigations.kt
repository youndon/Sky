package components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.*
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

interface Navigations {
    @Composable fun navig() {
        NavigationRail(
            modifier = Modifier,
            containerColor = contentColorFor(backgroundColor = Color.Gray),
            contentColor = contentColorFor(SnackbarDefaults.backgroundColor),
            header = @Composable {},
        ) {}

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

        BottomNavigation(
            modifier = Modifier,
            backgroundColor = MaterialTheme.colors.primarySurface,
            contentColor = contentColorFor(SnackbarDefaults.backgroundColor),
            elevation = BottomNavigationDefaults.Elevation,
            content = {  }
        )
    }
}