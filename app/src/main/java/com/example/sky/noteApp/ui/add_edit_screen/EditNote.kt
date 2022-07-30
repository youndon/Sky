package com.example.sky.noteApp.ui

import android.graphics.BitmapFactory
import android.icu.util.Calendar
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.sky.noteApp.database.NoteEntity
import com.example.sky.noteApp.ui.add_edit_screen.NoteMenuColors
import com.example.sky.noteApp.viewmodule.NoteViewModule
import java.io.File


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteEdit(
    navController: NavController,
    viewModule: NoteViewModule,
    id: Int?,
    title:String?,
    description:String?,
    color: String?,
    date:String,
    image:String?
) {
    var titleState by remember { mutableStateOf(title) }
    var descriptionState by remember { mutableStateOf(description) }
    val colorState = remember { mutableStateOf(color) }
    val dropdownMenuState = remember { mutableStateOf(false) }
    val dateState = mutableStateOf(Calendar.getInstance().time)
    val imageState = remember { mutableStateOf(image) }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.popBackStack()
                navController.navigate("home")
                viewModule.updateNote(
                    NoteEntity(
                        id = id!!,
                        title = titleState,
                        description =descriptionState,
                        color = colorState.value,
                        date = dateState.value.toString(),
                        image = imageState.value
                    )
                )
            }) {
                Icon(Icons.Outlined.Edit,null)
            }
        }
    ) {
        Column(Modifier.fillMaxSize()) {
            imageState.value ?.let {
                val path = File(LocalContext.current.filesDir.path + "images", it)
                val bitImg = BitmapFactory.decodeFile(path.absolutePath)
                runCatching {
                    Image(bitmap = bitImg.asImageBitmap(), contentDescription = null)
                }
            }
            OutlinedTextField(
                value = if (titleState=="null") "" else titleState ?: "",
                onValueChange = { titleState = it }
            )
            OutlinedTextField(
                value = if (descriptionState=="null") "" else descriptionState ?: "",
                onValueChange = { descriptionState = it }
            )
            Button(onClick = {
                dropdownMenuState.value = !dropdownMenuState.value
            }) {
                NoteMenuColors(color = colorState, dropdownMenuState)
            }
        }
    }
}