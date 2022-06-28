package com.example.sky

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.VectorConverter
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavControllerVisibleEntries
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

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



    }
}

@OptIn(NavControllerVisibleEntries::class)
@Composable
fun BottomNavigation(
    items:List<NavData>,
    navHostController: NavHostController
) {
    val currentNavState = navHostController.currentBackStackEntryAsState()
    Scaffold(
        bottomBar = {
            BottomNavigation(backgroundColor = Color.Transparent, elevation = 0.dp) {
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
                            Row(horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically) {
                                Icon(navData.icon, contentDescription = null)
                                Spacer(modifier = Modifier.height(10.dp))
                                AnimatedVisibility(
                                    visible = currentNavState.value?.destination?.route==navData.route
                                ) {
                                    Text(text = navData.title)
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
    val backgroundColor:Color
)
