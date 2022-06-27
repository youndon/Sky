package com.example.sky.nav

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController


// home -|
//       |- one
//       |- two -|
//               |- white
//               |- black

@SuppressLint("ComposableNavGraphInComposeScope")
@Composable
fun NavNotation() {
    val navHostController = rememberNavController()
    NavHost(
        navController = navHostController,
        startDestination = "home",
        route = "root"
    )
    {

        composable("home"){
            Home(navController = navHostController)
        }
        whiteBlack(navHostController)
        oneTwo(navHostController)

    }

}

@Composable
fun Home(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            navController.navigate("homeNav")
        }) {
            Text(text = "Go To One Screen")
        }
        Button(onClick = {
            navController.navigate("two/num/2000")
        }) {
            Text(text = "Go To Two Screen")
        }

    }
}

@Composable
fun One(navController: NavController) {

    var ss by remember { mutableStateOf("") }
    Column {
        Button(onClick = {
            navController.navigate("two/zero/10")
        }) {
            Text("Go To Screen Two!")
        }
        Spacer(modifier = Modifier.height(20.dp))
        TextField(value = ss, onValueChange = { ss = it })
        Button(onClick = {
            navController.popBackStack()
            navController.navigate("home")
        }) {
            Text(text = "Go Back Home!")
        }
    }
}

@Composable
fun Two(navController: NavController, s: String, ss:Int) {
    Column {
        Button(onClick = {
            navController.navigate("one")
        }) {
            Text("Go To Screen One!")
        }
        Text("Hi $s ,$ss")
        Button(onClick = {
            navController.popBackStack()
            navController.navigate("home")
        }) {
            Text(text = "Go Back Home!")
        }

        Row {
            Button(onClick = {
                navController.navigate("white")
            }) {
                Text(text = "Go To White Screen")
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
                navController.navigate("black")
            }) {
                Text(text = "Go To Black Screen")
            }
        }
    }
}

@Composable
fun BlackScreen(
    navController: NavController
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
    ) {
        Button(onClick = {
            navController.popBackStack()
            navController.navigate("home")
        }) {
            Text(text = "Go Back Home!")
        }
    }
}

@Composable
fun WhiteScreen(
    navController: NavController
) {
    Box(modifier = Modifier
        .fillMaxSize()
    ) {
        Button(onClick = {
            navController.popBackStack()
            navController.navigate("home")
        }) {
            Text(text = "Go Back Home!")
        }
    }
}


fun NavGraphBuilder.whiteBlack(navController: NavHostController){
    navigation("white","secondNav"){
        composable(
            route = "white"
        ){
            WhiteScreen(navController = navController)
        }
        composable("black"){
            BlackScreen(navController = navController)
        }
    }

}

fun NavGraphBuilder.oneTwo(navController: NavHostController){
    navigation(
        startDestination = "one",
        route = "homeNav"
    ) {

        composable(
            route = "one"
        ) {
            One(navController = navController)
        }

        composable(
            route = "two/{zero}/{first}",
            arguments = listOf(
                navArgument("zero") {
                    type = NavType.StringType
                },
                navArgument("first") {
                    type = NavType.IntType
                }
            )
        ) {
            Two(
                navController = navController,
                it.arguments?.getString("zero") ?: "...",
                it.arguments?.getInt("first")?.times(2) ?: 0)
        }
    }

}

