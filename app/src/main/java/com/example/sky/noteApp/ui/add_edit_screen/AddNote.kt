package com.example.sky.noteApp.ui.add_edit_screen

import android.graphics.Bitmap
import android.icu.util.Calendar
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.sky.noteApp.database.NoteEntity
import com.example.sky.noteApp.ui.add_edit_screen.bottoms.AddEditBottomBar
import com.example.sky.noteApp.ui.home_screen.ImageDialog
import com.example.sky.noteApp.viewmodule.NoteViewModule
import java.io.File
import java.io.FileOutputStream
import java.util.*


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteAdd(
    navController: NavController,
    viewModule: NoteViewModule
) {
    val c = LocalContext.current
    var titleState by remember { mutableStateOf<String?>(null) }
    var descriptionState by remember { mutableStateOf<String?>(null) }
    val colorState = remember { mutableStateOf<String?>(null) }
    val dropdownMenuState = remember { mutableStateOf(false) }
    val imageDialogState = remember { mutableStateOf(false) }
    val photoState = remember { mutableStateOf<Bitmap?>(null) }
    val imageUriState = remember { mutableStateOf<Uri?>(null) }
    val dateState = mutableStateOf(Calendar.getInstance().time)
    val takePhotoLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.TakePicturePreview()) {
            photoState.value = it
        }
    val chooseImageLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
            imageUriState.value = it
        }
    val img by remember { mutableStateOf(photoState) }

    val imagesPath = c.filesDir.path + "images"

    val uuid = UUID.randomUUID()

    Scaffold(
        bottomBar = {
            AddEditBottomBar(
                dialogState = imageDialogState,
                actionButton = {
                    FloatingActionButton(
                        onClick = {
                            // todo move it to view module
                            img.value?.let {
                                viewModule::saveImageInternally.invoke(img.value,imagesPath,uuid)
                            }
//                            img.value?.let {
//                                FileOutputStream(
//                                    File(imagesPath,"${uuid}.jpeg")
//                                ).apply {
//                                    img.value?.compress(Bitmap.CompressFormat.JPEG, 100, this)
//                                    flush()
//                                    close()
//                                }
//                            }

                            viewModule.addNote(
                                NoteEntity(
                                    title = titleState,
                                    description = descriptionState,
                                    color = colorState.value,
                                    date = dateState.value.toString(),
                                    image = if (img.value != null) "$uuid.jpeg" else null
                                )
                            )
                            navController.navigate("home")
                        }) {
                        Icon(Icons.Outlined.Done, null)
                    }
                }
            )
        }) {

        Column(Modifier.fillMaxSize()) {
            // todo move it to view module and fix the file size.
            imageUriState.value?.let {
//                    uri.buildUpon().clearQuery()
//                    photoState.value = MediaStore.Images.Media.getBitmap(c.contentResolver, uri)
//                photoState.value?.let { photo ->
//                    img.value = photo
//                }
                viewModule::displayImage.invoke(img,photoState,it,c)
            } ?: photoState.value?.let { photo ->
                img.value = photo
            }

            img.value?.let {
                Image(bitmap = it.asImageBitmap(), contentDescription = null)
            }

            OutlinedTextField(
                value = titleState ?: "",
                onValueChange = { titleState = it }
            )
            OutlinedTextField(
                value = descriptionState ?: "",
                onValueChange = { descriptionState = it }
            )
            Button(onClick = {
                dropdownMenuState.value = !dropdownMenuState.value
            }) {
                NoteMenuColors(color = colorState, dropdownMenuState)
            }
        }
        // image dialog.
        if (imageDialogState.value) {
            ImageDialog(
                dialogState = imageDialogState,
                navController = navController,
                photo = photoState,
                imageUri = imageUriState,
                photoLaunch = takePhotoLauncher,
                imageLaunch = chooseImageLauncher
            )
        }

        // recording dialog.
    }
}

