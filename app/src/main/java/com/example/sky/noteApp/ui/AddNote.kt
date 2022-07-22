package com.example.sky.noteApp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.sky.noteApp.database.NoteEntity
import com.example.sky.noteApp.viewmodule.NoteViewModule

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteAdd(
    navController: NavController,
    viewModule: NoteViewModule
) {
    var titleState by remember { mutableStateOf("") }
    var descriptionState by remember { mutableStateOf("") }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModule.addNote(
                    NoteEntity(
                        title = titleState,
                        description = descriptionState,
                        color = 68543
                    )
                )
                navController.navigate("home")
            }) {
                Icon(Icons.Outlined.Add,null)
            }
        }
    ) {

            Column(Modifier.fillMaxSize()) {
                OutlinedTextField(value =titleState, onValueChange ={titleState = it})
                OutlinedTextField(value =descriptionState, onValueChange ={descriptionState = it})
        }
    }
}