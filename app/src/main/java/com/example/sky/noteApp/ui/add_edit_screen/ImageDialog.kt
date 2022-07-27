package com.example.sky.noteApp.ui.home_screen

import android.Manifest.permission.CAMERA
import android.graphics.Bitmap
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalPermissionsApi::class, ExperimentalCoroutinesApi::class)
@Composable
internal fun ImageDialog(
    dialogState: MutableState<Boolean>,
    navController: NavController,
    photo: MutableState<Bitmap?>,
    imageUri: MutableState<Uri?>
    ) {
    val c = LocalContext.current

    val prCamera = rememberPermissionState(CAMERA)

    val takePhotoLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.TakePicturePreview()) {
            photo.value = it
        }
    val chooseImageLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
            imageUri.value = it
        }

    AlertDialog(
        onDismissRequest = {
            dialogState.value = false
        },
        confirmButton = {

        },
        dismissButton = {

        },
        icon = {
            Icon(Icons.Filled.Place, contentDescription = null)
        },
        title = {
            Text(text = "add image")
        },
        text = {
            Column {
                Row(
                    modifier = Modifier.clickable {
                        prCamera.launchPermissionRequest()
                        if (prCamera.status.isGranted) {
                            takePhotoLauncher.launch()
                        } else {
                            Toast.makeText(c, "permission denied", Toast.LENGTH_SHORT).show()
                        }
                        dialogState.value = false
                    }
                ) {
                    Icon(Icons.Filled.Edit, contentDescription = null)
                    Text(text = "take photo")
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.clickable {
                        chooseImageLauncher.launch("image/*")
                        dialogState.value = false
                    }
                ) {
                    Icon(Icons.Filled.Search, contentDescription = null)
                    Text(text = "choose image")

                }
            }
        },
    )
}
