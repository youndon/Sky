
import android.Manifest.permission.CAMERA
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color.*
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.text.*
import androidx.compose.ui.text.input.*
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import coil.decode.GifDecoder.*
import coil.transform.RoundedCornersTransformation
import com.google.accompanist.permissions.*

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
    RoundedCornersTransformation()
}

fun hilt() {
//    dagger.hilt.*
}

@Composable
fun c(){
//    LocalContext.current.*
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
}

@SuppressLint("CoroutineCreationDuringComposition")
fun main() {

    derivedStateOf() {

    }
}




