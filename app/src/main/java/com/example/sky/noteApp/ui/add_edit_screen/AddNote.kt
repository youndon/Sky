package com.example.sky.noteApp.ui.add_edit_screen

import android.graphics.Bitmap
import android.icu.util.Calendar
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.navigation.NavController
import com.example.sky.noteApp.database.NoteEntity
import com.example.sky.noteApp.ui.add_edit_screen.bottoms.AddEditBottomBar
import com.example.sky.noteApp.ui.home_screen.ImageDialog
import com.example.sky.noteApp.viewmodule.NoteViewModule


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteAdd(
    navController: NavController,
    viewModule: NoteViewModule
) {
    var titleState by remember { mutableStateOf("") }

    var descriptionState by remember { mutableStateOf("") }

    val colorState = remember { mutableStateOf("") }

    val dropdownMenuState = remember { mutableStateOf(false) }

    val imageDialogState = remember { mutableStateOf(false) }

    val photoState = remember { mutableStateOf<Bitmap?>(null) }

    val imageUriState = remember { mutableStateOf<Uri?>(null) }

    val dateState = mutableStateOf(Calendar.getInstance().time)

    Scaffold(
        floatingActionButton = {

        },
        bottomBar = {
            AddEditBottomBar(dialogState = imageDialogState, actionButton = {
                FloatingActionButton(onClick = {
                    viewModule.addNote(
                        NoteEntity(
                            title = titleState,
                            description = descriptionState,
                            color = colorState.value,
                            date = dateState.value.toString()
                        )
                    )
                    navController.navigate("home")
                }) {
                    Icon(Icons.Outlined.Done,null)
                }
            }
            )
        }
    ) {

            Column(Modifier.fillMaxSize()) {
                //
                photoState.value ?.let {
                    Image(bitmap = it.asImageBitmap(), contentDescription = null)
                }
                OutlinedTextField(value =titleState, onValueChange ={titleState = it})
                OutlinedTextField(value =descriptionState, onValueChange ={descriptionState = it})
                Button(onClick = {
                    dropdownMenuState.value = !dropdownMenuState.value
                }) {
                    NoteColors(color = colorState,dropdownMenuState)
                }
        }
        // image dialog.
        if (imageDialogState.value) {
            ImageDialog(
                dialogState = imageDialogState,
                navController = navController,
                photo = photoState,
                imageUri = imageUriState
            )
        }

        // recording dialog.
    }
}

