package com.example.sky.noteApp.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.sky.noteApp.ui.add_edit_screen.NoteAdd
import com.example.sky.noteApp.ui.home_screen.NoteHome
import com.example.sky.noteApp.viewmodule.NoteViewModule

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun NoteRoot(
    viewModule: NoteViewModule = hiltViewModel()
) {
    val navC = rememberNavController()
    NavHost(navController = navC, startDestination = "home") {
        composable(route = "home") {
            NoteHome(navController = navC, viewModule = viewModule)
        }
        composable(route = "add") {
            NoteAdd(navController = navC, viewModule = viewModule)
        }
        composable(
            route = "edit/{id}/{title}/{description}/{color}/{image}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                },
                navArgument("title") {
                    nullable = true
                    type = NavType.StringType
                },
                navArgument("description") {
                    nullable = true
                    type = NavType.StringType
                },
                navArgument("color") {
                    nullable = true
                    type = NavType.StringType
                },
                navArgument("image") {
                    nullable = true
                    type = NavType.StringType
                }
            )
        ) {
            NoteEdit(
                navController = navC,
                viewModule = viewModule,
                id = it.arguments?.getInt("id"),
                title = it.arguments?.getString("title"),
                description = it.arguments?.getString("description"),
                color = it.arguments?.getString("color"),
                image = it.arguments?.getString("image")
            )
        }
    }
}