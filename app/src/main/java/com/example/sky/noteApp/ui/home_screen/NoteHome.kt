package com.example.sky.noteApp.ui.home_screen

import androidx.compose.foundation.layout.captionBarPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sky.noteApp.database.NoteEntity
import com.example.sky.noteApp.ui.NoteCard
import com.example.sky.noteApp.viewmodule.NoteViewModule

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteHome(
    navController: NavController ,
    viewModule: NoteViewModule ,
) {
    val searchNote = remember { mutableStateOf("") }
    val orderBy = remember { mutableStateOf("") }

    // the true value is 'list' layout by default and false is 'grid'.
    val currentLayout = remember { mutableStateOf(true) }

    // to observer data while changing immediately.
    val observerNotes: State<List<NoteEntity>> = when (orderBy.value) {
        "order_by_lasts" ->  viewModule.allNotesByLasts.collectAsState()
        else -> viewModule.allNotesById.collectAsState() // sort_by_default
    }

    Scaffold(
        topBar = {
                 HomeTopAppBar(
                     searchNoteTitle = searchNote,
                     currentOrder = orderBy,
                     layoutState = currentLayout
                 )
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
                .fillMaxSize()
                .padding(top = 55.dp),
        ) {
            items(
                items = observerNotes.value.filter { it.title.contains(searchNote.value) }
            ) { note ->
                NoteCard(note = note, navController,viewModule)
            }
        }
    }
}

