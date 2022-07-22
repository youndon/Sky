package com.example.sky.noteApp.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sky.noteApp.viewmodule.NoteViewModule

@Composable
fun NoteRoot(
    viewModule: NoteViewModule = hiltViewModel()
) {
    val navC = rememberNavController()
    NavHost(navController = navC, startDestination = "home"){
        composable(route = "home"){
            NoteHome(navController = navC, viewModule = viewModule)
        }
        composable(route = "add"){
            NoteAdd(navController = navC, viewModule = viewModule)
        }
        composable(route = "edit/{id}/{title}/{description}/{color}"){

        }

    }
}