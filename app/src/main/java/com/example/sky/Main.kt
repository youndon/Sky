package com.example.sky

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


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



@Preview(showBackground = true)
@Composable
fun Preview() {
    Column (
        modifier = Modifier.fillMaxSize(),
horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
    }
}

