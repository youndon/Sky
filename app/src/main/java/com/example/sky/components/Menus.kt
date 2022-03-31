package com.example.sky.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.MenuDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties

interface Menus {
    @OptIn(ExperimentalFoundationApi::class)
    @Composable fun menu(){

        DropdownMenu(
            expanded = true,
            onDismissRequest = {},
            properties = PopupProperties(),
            modifier = Modifier,
            offset = DpOffset(0.dp, 0.dp),
            content = @Composable {}
        )
        DropdownMenuItem(
            onClick = {},
            modifier = Modifier,
            enabled = true,
            contentPadding = MenuDefaults.DropdownMenuItemContentPadding,
            interactionSource = remember { MutableInteractionSource() },
            content = @Composable {}
        )
    }
}