package com.example.sky.mindorks.dialog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color

class AlertDialogActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                AlertDialogComponent()
            }
        }
    }
}

@Composable
fun AlertDialogComponent() {
    val openDialog = remember { mutableStateOf(true) }
    if (openDialog.value) {
        // AlertDialog is a Composable that is used to show a dialog with some urgent
        // information/detail on it. For example, while logging out, you can show a dialog
        // to the user "Are you sure?". If you click outside of the dialog or the back button,
        // then dialog will disappear. To disable this feature, use empty onCloseRequest
        AlertDialog(
            // onDismissRequest will be called when back button is pressed or there is some click
            // outside the AlertDialog and NOT on pressing the dismissButton
            onDismissRequest = { openDialog.value = false },
            title = { Text(text = "Alert Dialog") },
            text = { Text("Hello! I am an Alert Dialog") },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                        /* Do some other action */
                    }
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                        /* Do some other action */
                    }
                ) {
                    Text("Dismiss")
                }
            },
            backgroundColor = Color.Black,
            contentColor = Color.White
        )
    }
}
