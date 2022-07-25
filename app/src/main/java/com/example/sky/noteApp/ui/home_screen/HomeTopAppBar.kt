package com.example.sky.noteApp.ui.home_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties

@Composable
fun HomeTopAppBar(
    searchNoteTitle: MutableState<String>,
    currentOrder: MutableState<String>,
    layoutState: MutableState<Boolean>
) {
    val showSortMenu = remember { mutableStateOf(false) }
    SmallTopAppBar(
        title = {
                TopAppBarTextField(
                    title = searchNoteTitle
                )
        },
        navigationIcon = {
                         Icon(
                             imageVector = Icons.Outlined.Settings,
                             contentDescription = null
                         )
        },
        actions = {
            SortBy(
                isShow = showSortMenu,
                order = currentOrder
            )
            Layout(
                layoutState = layoutState
            )
            Account()
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.Gray
        ),
        modifier = Modifier
    )
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun TopAppBarTextField(
    title: MutableState<String>
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    OutlinedTextField(
        modifier = Modifier,
        value = title.value,
        onValueChange = { title.value = it },
        maxLines = 1,
        placeholder = {
            Text(text = "Search for note..")
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                keyboardController?.hide()
            }
        )
    )
}

@Composable
private fun Layout(layoutState: MutableState<Boolean>) {
    Icon(
        imageVector = if (layoutState.value) Icons.Outlined.List else Icons.Outlined.Info,
        contentDescription = null,
        modifier = Modifier.clickable {
            layoutState.value = !layoutState.value
        }
    )
}

@Composable
private fun Account() {
    Icon(
        imageVector = Icons.Outlined.AccountCircle,
        contentDescription = null
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun SortBy(
    isShow:MutableState<Boolean>,
    order:MutableState<String>
) {
    Icon(
        imageVector = Icons.Outlined.CheckCircle,
        contentDescription = null,
        modifier = Modifier.clickable {
            isShow.value = true
        }
    )

    DropdownMenu(
        expanded = isShow.value,
        onDismissRequest = { },
        properties = PopupProperties()
    ) {
        DropdownMenuItem(
            text = { Text("Default") },
            onClick = {
                isShow.value = false
                order.value = "order_by_default"
            }
        )
        DropdownMenuItem(
            text = { Text("Lasts") },
            onClick = {
                isShow.value = false
                order.value = "order_by_lasts"
            }
        )
    }
}