package com.example.sky.noteApp

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sky.noteApp.dattabase.NoteEntity
import com.example.sky.noteApp.tops.SearchBarNote
import com.example.sky.noteApp.viewmodel.NoteViewModel
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeNote(
    noteList:List<NoteEntity>,
    viewModel: NoteViewModel,
    navController: NavController
) {
    val noteSearch = remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
                SearchBarNote(noteSearch)
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("add")
            }) {
                Icon(Icons.Default.Add, contentDescription = null)
            }
        },
    ) {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(top = 70.dp)) {
            items(items = noteList.filter { it.title.contains(noteSearch.value) }) { note ->
                NoteCard(viewModel,note,navController)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteCard(
    viewModel: NoteViewModel,
    entity: NoteEntity,
    navController: NavController
) {
    val deletion = SwipeAction(
        onSwipe = {
            viewModel.deleteNote(entity)
        },
        icon = {
            Icon(Icons.Default.Delete, null)
        },
        background = Color.Red,
        isUndo = true
    )

    SwipeableActionsBox(
        startActions = listOf(deletion),
        endActions = listOf(deletion),
        backgroundUntilSwipeThreshold = Color.Transparent,
        swipeThreshold = 140.dp
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(7.dp)
                .height(200.dp)
                .clickable {
                    navController.navigate("edit/${entity.title}/${entity.description}")
                },
        ) {
            Text(entity.title)
            Text(entity.description)
        }
    }
}
