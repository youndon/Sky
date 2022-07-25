package com.example.sky

import android.Manifest.permission.CAMERA
import android.content.Context
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.icu.text.AlphabeticIndex
import android.media.SoundPool
import android.media.browse.MediaBrowser
import android.net.Uri
import android.provider.Browser
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.PermissionChecker
import com.google.accompanist.permissions.*
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf

//
fun androidxActivityCompose() {
//    androidx.activity.compose.BackHandler {}
//    androidx.activity.compose.rememberLauncherForActivityResult(contract =, onResult =)
}



fun androidxConstraintlayoutCompose() {
//    androidx.constraintlayout.compose.ConstraintSet(content = )
//    androidx.constraintlayout.compose.ConstraintLayout {}
//    androidx.constraintlayout.compose.MotionLayout(motionScene =, progress =) {    }
//    androidx.constraintlayout.compose.MotionScene(content =)
//    androidx.constraintlayout.compose.Transition(content =)
}
//.*
fun androidxNavigationCompose() {
//    androidx.navigation.compose.NavHost(navController =, graph =)
//    androidx.navigation.compose.rememberNavController(navigators =)
//    androidx.navigation.compose.DialogHost(dialogNavigator =)
}

//.*
fun androidxPagingCompose() {
//    androidx.paging.compose.LazyPagingItems
}

//
fun coi() {
//    coil.compose.*
    coil.transform.GrayscaleTransformation()
    coil.transform.RoundedCornersTransformation()
}

fun hilt() {
//    dagger.hilt.*
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    Some()

}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun Some(
    context: Context = LocalContext.current
) {
    val image = remember {
        mutableStateOf<Bitmap?>(null)
    }
    var uri by remember {
        mutableStateOf<Uri?>(null)
    }
    val launcherPicturePreview =
        rememberLauncherForActivityResult(ActivityResultContracts.TakePicturePreview()) {
            image.value = it
        }
    val pr = rememberPermissionState(CAMERA)

//    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.OpenDocument()){}
//    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()){}
//    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.PickContact()) {}
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
       uri = it
    }


    Column {

        Button(
            onClick = {
                launcher.launch("picture/*")
            pr.launchPermissionRequest()
                .runCatching {
                    when(pr.status){
                        is PermissionStatus.Granted -> {
                            launcherPicturePreview.launch()
                        }
                        is PermissionStatus.Denied -> {
                            Toast.makeText(context, "0000000", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
        ) {
            Text(text = "contract!")
        }


        uri?.let {
            image.value = MediaStore.Images.Media.getBitmap(context.contentResolver,it)

            image.value?.let { img ->
                Image(img.asImageBitmap(), contentDescription = null)
            }
        }

    }
}


val tos : (Any?,Context) -> Unit = { a, con ->
    Toast.makeText(con, "$a", Toast.LENGTH_LONG).show()
}
