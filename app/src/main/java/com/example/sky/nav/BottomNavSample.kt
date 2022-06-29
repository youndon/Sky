package com.example.sky.nav

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavControllerVisibleEntries
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState


@Composable
fun BottomNavigation(
    items:List<NavData>,
    navHostController: NavHostController
) {
    val currentNavState = navHostController.currentBackStackEntryAsState()

    var coloration by remember {
        mutableStateOf(Color.Unspecified)
    }
    Scaffold(
        bottomBar = {
            androidx.compose.material.BottomNavigation(backgroundColor = Color.Transparent, elevation = 0.dp) {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    items.forEach { navData ->
//                    BottomNavigationItem(
//                        selected = currentNavState.value?.destination?.route == navData.route,
//                        onClick = {
//                                  navHostController.navigate(navData.route)
//                        },
//                        icon = {
//                            Icon(navData.icon,null)
//                        },
//                        label = {
//                            AnimatedVisibility(visible = true) {
//                                Text(navData.title)
//                            }
//                        },
//                        alwaysShowLabel = currentNavState.value?.destination?.route==navData.route,
//                        selectedContentColor = Color.Magenta,
//                        unselectedContentColor = Color.DarkGray
//                    )

                        IconButton(
                            onClick = {
                                navHostController.navigate(navData.route)
                                coloration = when(navData.backgroundColor){
                                    Color.White -> Color.DarkGray
                                    Color.Gray -> Color.DarkGray
                                    else -> Color.LightGray
                                }
                            },
                            modifier = Modifier
                                .width(75.dp)
                                .clip(RoundedCornerShape(50.dp))
                                .background(
                                    if (currentNavState.value?.destination?.route == navData.route)
                                        Color.Cyan
                                    else Color.Transparent
                                ),
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.background(Color.Transparent)
                            ) {
                                Icon(
                                    navData.icon,
                                    contentDescription = null,
                                    tint = coloration,
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                AnimatedVisibility(
                                    visible = currentNavState.value?.destination?.route==navData.route
                                ) {
                                    Text(
                                        text = navData.title,
                                        color = coloration
                                    )
                                }

                            }
                        }
                    }
                }
            }
        }
    ) {
        NavHostation(navHostController)
    }
}

@Composable
fun NavHostation(navController: NavHostController) {

    NavHost(navController = navController,"gray"){
        composable("white"){
            White()
        }
        composable("gray"){
            Gray()
        }
        composable("black"){
            Black()
        }
    }
}

@Composable
fun White() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "White!")
    }
}

@Composable
fun Gray() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Gray!")
    }
}
@Composable
fun Black() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Black!")
    }
}

data class NavData(
    val title:String,
    val route:String,
    val icon: ImageVector,
    val backgroundColor: Color
)