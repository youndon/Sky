package com.example.sky.noteApp.ui.home_screen

import android.accounts.Account
import android.text.Layout
import androidx.compose.foundation.clickable
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

@Preview()
@Composable
fun HomeTopAppBar(
    searchNoteTitle:MutableState<String> = mutableStateOf(""),
    layoutState:MutableState<Boolean> = mutableStateOf(false)
) {
    SmallTopAppBar(
        title = {
                TopAppBarTextField(title = searchNoteTitle)
        },
        navigationIcon = {
                         Icon(Icons.Outlined.Settings, contentDescription =null)
        },
        actions = {
            SortBy()
            Layout(layoutState = layoutState)
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
private fun SortBy() {
    Icon(
        imageVector = Icons.Outlined.CheckCircle,
        contentDescription =null,
        modifier = Modifier.clickable {

        }
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
    Icon(Icons.Outlined.AccountCircle, contentDescription =null)
}