package com.example.sky.noteApp

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sky.noteApp.bottoms.BottomBarNote
import com.example.sky.noteApp.bottoms.NoteColors
import com.example.sky.noteApp.dattabase.NoteEntity
import com.example.sky.noteApp.tops.TopBarNote
import com.example.sky.noteApp.viewmodel.NoteViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddNote(
    navController: NavController,
    viewModel: NoteViewModel,
    backgroundColor:MutableState<Color>
) {

    var titleState by remember { mutableStateOf("") }
    var descriptionState by remember { mutableStateOf("") }
    val mutableTS = MutableTransitionState(
        titleState.isNotEmpty() && descriptionState.isNotEmpty()
    )

    val showIcons = remember { mutableStateOf(false) }

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
            AnimatedVisibility(visible = !showIcons.value) {
                BottomBarNote(showIcons = showIcons)
            }
            AnimatedVisibility(visible = showIcons.value) {
                NoteColors(
                    showIcons = showIcons,
                    noteColors = noteColor,
                    backgroundColor = backgroundColor
                )
            }
        }
    ) {
        Column(modifier = Modifier.fillMaxSize().background(backgroundColor.value)) {
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


