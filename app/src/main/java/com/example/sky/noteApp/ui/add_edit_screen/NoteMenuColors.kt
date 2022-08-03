package com.example.sky.noteApp.ui.add_edit_screen

import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

@Composable
fun NoteMenuColors(
    color: MutableState<String?> = mutableStateOf("Black"),
    isShow: MutableState<Boolean>
) {
    DropdownMenu(
        expanded = isShow.value,
        onDismissRequest = { }
    )
    {
        DropdownMenuItem(
            text = { Text("Cyan") },
            onClick = {
                color.value = "Cyan"
                isShow.value = !isShow.value
            }
        )
        DropdownMenuItem(
            text = { Text("Gray") },
            onClick = {
                color.value = "Gray"
                isShow.value = !isShow.value
            }
        )
        DropdownMenuItem(
            text = { Text("Magenta") },
            onClick = {
                color.value = "Magenta"
                isShow.value = !isShow.value
            }
        )
        DropdownMenuItem(
            text = { Text("Yellow") },
            onClick = {
                color.value = "Yellow"
                isShow.value = !isShow.value
            }
        )
    }
}
