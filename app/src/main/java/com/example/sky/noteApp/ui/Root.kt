package com.example.sky.noteApp.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.sky.noteApp.ui.home_screen.NoteHome
import com.example.sky.noteApp.viewmodule.NoteViewModule

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
            route = "edit/{id}/{title}/{description}/{color}/{date}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                },
                navArgument("title") {
                    type = NavType.StringType
                },
                navArgument("description") {
                    type = NavType.StringType
                },
                navArgument("color") {
                    type = NavType.StringType
                },
                navArgument("date") {
                    type = NavType.StringType
                }
            )
        ) {
            NoteEdit(
                navController = navC,
                viewModule = viewModule,
                id = it.arguments?.getInt("id"),
                title = it.arguments?.getString("title") ?: "",
                description = it.arguments?.getString("description") ?: "",
                color = it.arguments?.getString("color") ?: "",
                date = it.arguments?.getString("date") ?: ""
            )
        }
    }
}