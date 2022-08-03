package com.example.sky.noteApp.ui.add_edit_screen.bottoms

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddEditBottomBar(
    dialogState: MutableState<Boolean>,
    actionButton : @Composable () -> Unit,
) {
    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth(),
        floatingActionButton = {
            actionButton()
        },
        icons = {
            Icon(
                imageVector = Icons.Filled.Build,
                contentDescription = null,
                modifier = Modifier.clickable {

                }
            )
            Icon(
                imageVector = Icons.Filled.Create,
                contentDescription = null,
                modifier = Modifier.clickable {

                }
            )
            Icon(
                imageVector = Icons.Filled.Lock,
                contentDescription = null,
                modifier = Modifier.clickable {
                    dialogState.value = true
                }
            )
        }
    )
}





