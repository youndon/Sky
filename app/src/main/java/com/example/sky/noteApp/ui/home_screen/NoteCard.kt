package com.example.sky.noteApp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColor
import androidx.core.graphics.toColorLong
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.sky.noteApp.database.NoteEntity
import com.example.sky.noteApp.viewmodule.NoteViewModule

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteCard(
    note: NoteEntity,
    navController: NavController,
    viewModule: NoteViewModule
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                navController.navigate(
                    route = "edit/" +
                            "${note.id}/" +
                            "${note.title}/" +
                            "${note.description}/" +
                            "${note.color}/" +
                            note.date
                )
            },
        colors = CardDefaults.cardColors(
            containerColor = getColor(note.color)
        )
    ) {
        Text(text = note.id.toString())
        Text(text = note.title, fontWeight = FontWeight.SemiBold, fontSize = 20.sp)
        Text(text = note.description)
        Text(text = note.color)
        Text(text = note.date)
        IconButton(
            onClick = {
                viewModule.deleteNote(NoteEntity(id = note.id))
            }
        ) {
            Icon(Icons.Outlined.Delete, contentDescription = null)
        }
    }
}

private val getColor: (String) -> Color = { c ->
    when(c) {
        "Cyan" -> Color.Cyan
        "Gray" -> Color.Gray
        "Magenta" -> Color.Magenta
        "Yellow" -> Color.Yellow
        else -> Color.White
    }
}

