package com.example.sky.noteApp.ui.home_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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

    //
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    // to observer data while changing immediately.
    val observerNotes: State<List<NoteEntity>> = when (orderBy.value) {
        "order_by_name" ->  viewModule.allNotesByName.collectAsState()
        "order_by_oldest" ->  viewModule.allNotesByOldest.collectAsState()
        "order_by_newest" ->  viewModule.allNotesByNewest.collectAsState()
        else -> viewModule.allNotesById.collectAsState() // sort_by_default
    }

    ModalNavigationDrawer(
        drawerContent = {

        },
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                HomeTopAppBar(
                    searchNoteTitle = searchNote,
                    currentOrder = orderBy,
                    layoutState = currentLayout,
                    showDrawer = drawerState
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

            if (currentLayout.value){
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 55.dp),
                ) {
                    items(
                        observerNotes.value.filter { it.title.contains(searchNote.value) }
                    ) { note ->
                        NoteCard(note = note, navController,viewModule)
                    }
                }
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 55.dp),
                ){
                    items(
                        observerNotes.value.filter { it.title.contains(searchNote.value) }
                    ) { note ->
                        NoteCard(note = note, navController,viewModule)
                    }
                }
            }
        }
    }
}

