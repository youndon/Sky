package com.example.sky.noteApp

import android.accounts.AuthenticatorDescription
import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sky.noteApp.dattabase.NoteEntity
import java.io.FileDescriptor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeNote(
    noteList:List<NoteEntity>,
    navController: NavController
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.popBackStack()
                navController.navigate("add")
            }) {
                Icon(Icons.Default.Add, contentDescription = null)
            }
        },
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(items = noteList) { note ->
                NoteCard(note,navController)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteCard(
    cardInfo: NoteEntity,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(7.dp)
            .height(200.dp)
            .clickable {
                navController.navigate("edit/${cardInfo.title}/${cardInfo.description}")
            },
    ) {
            Text(cardInfo.title)
            Text(cardInfo.description)
    }
}


