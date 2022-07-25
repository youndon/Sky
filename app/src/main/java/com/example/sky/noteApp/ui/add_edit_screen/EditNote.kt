package com.example.sky.noteApp.ui

import android.icu.util.Calendar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.sky.noteApp.database.NoteEntity
import com.example.sky.noteApp.viewmodule.NoteViewModule
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteEdit(
    navController: NavController,
    viewModule: NoteViewModule,
    id: Int?,
    title:String,
    description:String,
    color: String,
    date:String
) {
    var titleState by remember { mutableStateOf(title) }
    var descriptionState by remember { mutableStateOf(description) }
    val colorState = remember { mutableStateOf(color) }
    val dropdownMenuState = remember { mutableStateOf(false) }
    val dateState = mutableStateOf(Calendar.getInstance().time)
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.popBackStack()
                navController.navigate("home")
                viewModule.updateNote(
                    NoteEntity(
                        id = id!!,
                        title = titleState,
                        description=descriptionState,
                        color = colorState.value,
                        date = dateState.value.toString()
                    )
                )
            }) {
                Icon(Icons.Outlined.Edit,null)
            }
        }
    ) {
        Column(Modifier.fillMaxSize()) {
            OutlinedTextField(value =titleState, onValueChange ={titleState=it})
            OutlinedTextField(value =descriptionState, onValueChange ={descriptionState=it})
            Button(onClick = {
                dropdownMenuState.value = !dropdownMenuState.value
            }) {
                NoteColors(color = colorState,dropdownMenuState)
            }
        }
    }
}