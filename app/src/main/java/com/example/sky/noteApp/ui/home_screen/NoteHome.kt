package com.example.sky.noteApp.ui.home_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.sky.noteApp.ui.NoteCard
import com.example.sky.noteApp.viewmodule.NoteViewModule

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteHome(
    navController: NavController ,
    viewModule: NoteViewModule ,
) {
    // to observer data while changing immediately.
    val observerNotes by viewModule.allNotesById.collectAsState()

    val e = rememberDrawerState(DrawerValue.Closed)
    Scaffold(
        topBar = {
                 HomeTopAppBar()
        },
        bottomBar = {

        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("add")
            }) {
                Icon(Icons.Filled.Add, null)
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            items(items = observerNotes) { note ->
                NoteCard(note = note, navController,viewModule)
            }
        }
    }
}

