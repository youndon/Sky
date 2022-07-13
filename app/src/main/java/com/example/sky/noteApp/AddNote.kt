package com.example.sky.noteApp

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sky.noteApp.dattabase.NoteEntity
import com.example.sky.noteApp.viewmodel.NoteViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNote(
    navController: NavController,
    viewModel: NoteViewModel
) {

    var titleState by remember { mutableStateOf("") }
    var descriptionState by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {

        },
        floatingActionButton = {
            AnimatedVisibility(visible = titleState.isEmpty()) {
                FloatingActionButton(
                    onClick = {
                        navController.popBackStack()
                        navController.navigate("home")
                        viewModel.addNote(NoteEntity(titleState,descriptionState))
                    }) {
                    Icon(Icons.Default.Done, null)
                }
            }
        }
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            OutlinedTextField(
                value = titleState,
                onValueChange = { titleState = it },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = descriptionState,
                onValueChange = { descriptionState = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
        }
    }
}