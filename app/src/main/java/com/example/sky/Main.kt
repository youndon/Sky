package com.example.sky

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

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

fun nav(){
//    androidx.navigation.*
//    androidx.navigation.compose.
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    LinkText()
}

@Composable
fun Nevada() {
    var start by remember { mutableStateOf(false ) }
    val alphaValue by animateFloatAsState(targetValue = if (start) 1f else 0f,
    animationSpec = tween(2000))

    LaunchedEffect(key1 = true){
        start = true
        delay(3000)
    }
    Defer(alphaValue)
}

@Composable
fun Defer(alphaValue: Float) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()){
        Icon(Icons.Default.Done,null,
            modifier = Modifier
                .size(50.dp)
                .alpha(alphaValue)
        )

    }
}

@OptIn(ExperimentalTextApi::class)
@Composable
fun LinkText() {
    val uri = LocalUriHandler.current

    val s = buildAnnotatedString {
        withStyle(SpanStyle()) {
            append("Link to ")
        }
        withStyle(SpanStyle(color = Color.Cyan)) {
            append("youtube")
        }
        addStringAnnotation("youtube", "https://www.youtube.com", 10, 17)
    }

    ClickableText(text = s, onClick = {
        s.getStringAnnotations("youtube",it,it)
            .firstOrNull()?.let { link ->
                uri.openUri(link.item)
            }
    })

}



