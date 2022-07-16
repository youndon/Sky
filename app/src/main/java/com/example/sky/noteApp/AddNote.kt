package com.example.sky.noteApp

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomAppBar
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sky.noteApp.dattabase.NoteEntity
import com.example.sky.noteApp.tops.TopBarNote
import com.example.sky.noteApp.viewmodel.NoteViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddNote(
    navController: NavController,
    viewModel: NoteViewModel
) {

    var titleState by remember { mutableStateOf("") }
    var descriptionState by remember { mutableStateOf("") }
    val mutableTS = MutableTransitionState(
        titleState.isNotEmpty() && descriptionState.isNotEmpty()
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
                 TopAppBar {
                     TopBarNote(navController)
                 }
        },
        floatingActionButton = {
            AnimatedVisibility(visibleState = mutableTS) {
                FloatingActionButton(
                    onClick = {
                        navController.popBackStack()
                        navController.navigate("home")
                        viewModel.addNote(NoteEntity(titleState,descriptionState))
                    }) {
                    Icon(Icons.Default.Done, null)
                }
            }
        },
        bottomBar = {

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