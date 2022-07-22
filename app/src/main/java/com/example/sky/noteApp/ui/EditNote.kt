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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.sky.noteApp.collectAsStateWithLifecycle
import com.example.sky.noteApp.viewmodule.NoteViewModule

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteEdit(
    navController: NavController,
    viewModule: NoteViewModule,
    id:Int,
    title:String,
    description:String,
    color: Int
) {

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {

                navController.navigate("home")
            }) {
                Icon(Icons.Outlined.Add,null)
            }
        }
    ) {
        Column(Modifier.fillMaxSize()) {
//            OutlinedTextField(value =noteSt.title, onValueChange =viewModule::updateTitle)
//            OutlinedTextField(value =noteSt.description, onValueChange =viewModule::updateDescription)
        }
    }
}