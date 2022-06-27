package com.example.sky

import android.annotation.SuppressLint
import android.hardware.camera2.params.BlackLevelPattern
import android.net.wifi.hotspot2.pps.HomeSp
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.*
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.*
import kotlinx.coroutines.internal.RemoveFirstDesc
import kotlinx.coroutines.selects.select
import kotlin.math.sqrt

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
    Column (
        modifier = Modifier.fillMaxSize(),
horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        BottomNavigation()
    }
}

@OptIn(NavControllerVisibleEntries::class)
@Composable
fun BottomNavigation() {
    val navHostController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation {
              BottomNavigationItem(
                  selected = navHostController.currentDestination?.route == "while",
                  onClick = {
                      navHostController.navigate("white")
                  },
                  icon = { Icon(Icons.Default.Build, contentDescription = null) },
                  label = {
                      Text("White")
                  }

              )
                BottomNavigationItem(
                    selected = navHostController.currentDestination?.route == "gray",
                    onClick = { navHostController.navigate("gray") },
                    icon = { Icon(Icons.Default.Clear, contentDescription = null) })
                BottomNavigationItem(
                    selected = navHostController.currentDestination?.route == "black",
                    onClick = { navHostController.navigate("black") },
                    icon = { Icon(Icons.Default.Done, contentDescription = null) }
                )
            }
        }
    ) {
        NavHostation(navHostController)
    }
}

@Composable
fun NavHostation(navController: NavHostController) {

    NavHost(navController = navController,"white"){
        composable("white"){
            White(navController)
        }
        composable("gray"){
            Gray(navController)
        }
        composable("black"){
            Black(navController)
        }
    }
}

@Composable
fun White(navController: NavController) {

    Column(modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "White!")
    }
}

@Composable
fun Gray(navController: NavController) {

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Gray!")
    }
}
@Composable
fun Black(navController: NavController) {

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Black!")
    }
}

