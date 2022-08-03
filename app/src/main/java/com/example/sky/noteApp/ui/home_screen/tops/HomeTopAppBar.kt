package com.example.sky.noteApp.ui.home_screen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.window.PopupProperties
import com.example.sky3.NoteDataStore
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopAppBar(
    searchNoteTitle: MutableState<String>,
    showDrawer: DrawerState,
    dataStore: NoteDataStore
) {
    val showSortMenu = remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    SmallTopAppBar(
        title = {
                TopAppBarTextField(
                    title = searchNoteTitle
                )
        },
        navigationIcon = {
                         Icon(
                             imageVector = Icons.Outlined.Settings,
                             contentDescription = null,
                             modifier = Modifier.clickable {
                                 scope.launch {
                                     showDrawer.open()
                                 }
                             }
                         )
        },
        actions = {
            SortBy(
                isShow = showSortMenu,
                dataStore = dataStore
            )
            Layout(
                dataStore = dataStore
            )
            Account()
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.Gray
        ),
        modifier = Modifier
    )
}


@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
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
private fun Layout(dataStore: NoteDataStore) {
    val layout = dataStore.getLayout.collectAsState(true)
    val scope = rememberCoroutineScope()
    Icon(
        imageVector = if (layout.value) Icons.Outlined.List else Icons.Outlined.Info,
        contentDescription = null,
        modifier = Modifier.clickable {
            scope.launch {
                dataStore.saveLayout(!layout.value)
            }
        }
    )
}

@Composable
private fun Account() {
    val c = LocalContext.current
    Icon(
        imageVector = Icons.Outlined.AccountCircle,
        contentDescription = null,
        modifier = Modifier.clickable {
            Toast.makeText(c, "soon.", Toast.LENGTH_LONG).show()
        }
    )
}

@Composable
private fun SortBy(
    isShow: MutableState<Boolean>,
    dataStore: NoteDataStore
) {
    val scope = rememberCoroutineScope()
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
        properties = PopupProperties(
            focusable = true
        )
    ) {
        DropdownMenuItem(
            text = { Text("Default") },
            onClick = {
                isShow.value = false
                scope.launch {
                    dataStore.saveOrder("order_by_default")
                }
            }
        )
        DropdownMenuItem(
            text = { Text("Newest") },
            onClick = {
                isShow.value = false
                scope.launch {
                    dataStore.saveOrder("order_by_newest")
                }
            }
        )
        DropdownMenuItem(
            text = { Text("Oldest") },
            onClick = {
                isShow.value = false
                scope.launch {
                    dataStore.saveOrder("order_by_oldest")
                }
            }
        )
        DropdownMenuItem(
            text = { Text("Name") },
            onClick = {
                isShow.value = false
                scope.launch {
                    dataStore.saveOrder("order_by_name")
                }
            }
        )
    }
}