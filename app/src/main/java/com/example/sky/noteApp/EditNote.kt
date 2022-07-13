package com.example.sky.noteApp

import android.annotation.SuppressLint
import android.content.ClipDescription
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sky.atlas.Animate
import com.example.sky.noteApp.dattabase.NoteEntity
import com.example.sky.noteApp.viewmodel.NoteViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditNote(
    navController: NavController,
    viewModel: NoteViewModel,
    title:String,
    description:String
) {

    var titleState by remember { mutableStateOf(title) }
    var descriptionState by remember { mutableStateOf(description) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            AnimatedVisibility(visible = titleState != title) {
                FloatingActionButton(onClick = {
                    navController.popBackStack()
                    navController.navigate("home")
                    viewModel.updateNote(NoteEntity(titleState,descriptionState))
                }){
                    Icon(Icons.Default.Edit, null)
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
                    .height(140.dp)
            )
        }

    }

}