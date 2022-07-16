package com.example.sky.noteApp

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.sky.noteApp.viewmodel.NoteViewModel

@Preview(showBackground = true)
@Composable
fun RootNote() {

    val noteViewModel = viewModel<NoteViewModel>()

    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = "home"){
        composable("home"){
            HomeNote(
                noteList = noteViewModel.notes,
                navController = navHostController,
                viewModel = noteViewModel
            )
        }
        composable("add"){
            AddNote(
                navController = navHostController,
                viewModel = noteViewModel
            )
        }
        composable("edit/{title}/{description}",
            arguments = listOf(
            navArgument("title"){
                type = NavType.StringType
            },
            navArgument("description"){
                type = NavType.StringType
            }
        )){
            EditNote(navController = navHostController,
                viewModel = noteViewModel,
                title = it.arguments?.getString("title") ?: "" ,
                description =it.arguments?.getString("description") ?: ""
            )
        }
    }
}