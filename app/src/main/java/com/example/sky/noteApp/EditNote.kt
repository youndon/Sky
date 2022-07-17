package com.example.sky.noteApp

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun EditNote(
    navController: NavController,
    viewModel: NoteViewModel,
    title:String,
    description:String,
    backgroundColor:MutableState<Color>
) {

    var titleState by remember { mutableStateOf(title) }
    var descriptionState by remember { mutableStateOf(description) }

    val mutableTS = MutableTransitionState(
        title != titleState || description != descriptionState
    )

    val showIcons = remember { mutableStateOf(false) }

    androidx.compose.material.Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar {
                TopBarNote(navController)
            }
        },
        floatingActionButton = {
            AnimatedVisibility(visibleState = mutableTS) {
                androidx.compose.material.FloatingActionButton(
                    onClick = {
                        navController.popBackStack()
                        navController.navigate("home")
                        backgroundColor.value = Color.Unspecified
                        viewModel.updateNote(NoteEntity(titleState, descriptionState))
                    },
                ) {
                    Icon(Icons.Default.Edit, null)
                }
            }
        },
        isFloatingActionButtonDocked = true,
        bottomBar = {
            Row(modifier = Modifier.fillMaxWidth()) {
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
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor.value)
        ) {
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
                    .height(140.dp)
            )
        }

    }

}