package com.example.sky.atlas

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.coroutines.delay

@Composable
fun Splashing(navHostController: NavHostController) {
    var starting by remember {
        mutableStateOf(false)
    }
    val alphaValue by animateFloatAsState(
        targetValue = if (starting) 1f else 0f,
        animationSpec = tween(2000)
    )
    LaunchedEffect(key1 = true){
        starting = true
        delay(3000)
        navHostController.popBackStack()
        navHostController.navigate("homing")
    }
    Welcoming(alphaValue)
}

@Composable
fun Welcoming(alphaValue: Float = 1f) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
        ,
        contentAlignment = Alignment.Center
    ){
        Icon(Icons.Default.Settings,null,
            modifier = Modifier
                .size(100.dp)
                .alpha(alphaValue)
        )
        AnimatedVisibility(visible = alphaValue == 1f) {
            Text(text = "This is Done!", fontSize = 30.sp)
        }
    }
}

@Composable
fun Homing() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
        ,
        contentAlignment = Alignment.Center
    ){
        Icon(Icons.Default.Home,null,
            modifier = Modifier
                .size(100.dp)
        )
    }
}

@Composable
fun NavHosting(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "welcoming"){
        composable("welcoming"){
            Splashing(navHostController = navHostController)
        }
        composable("homing"){
            Homing()
        }
    }
}