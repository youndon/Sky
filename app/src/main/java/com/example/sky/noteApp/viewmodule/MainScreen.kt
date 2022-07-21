package com.example.sky.noteApp.viewmodule

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


@Composable
fun RootScreen(viewModule: NoteViewModule = hiltViewModel()) {
    val navHC = rememberNavController()
    NavHost(navController = navHC, startDestination = "main/{note}/{id}"){
        composable(
            route = "main/{note}/{id}",
            arguments = listOf(
                navArgument(name = "note"){
                    type = NavType.StringType
                },
                navArgument(name = "id"){
                    type = NavType.IntType
                }
            )
        ) {
            MainScreen(
                viewModule = viewModule,
                navHC = navHC,
                note = it.arguments?.getString("note") ?: "",
                id = it.arguments?.getInt("id") ?: 0
            )
        }
        composable(
            route = "note"){
            NoteScreen(viewModule = viewModule,navHC)
        }
    }
}

@Composable
fun MainScreen(
    viewModule: NoteViewModule,
    navHC: NavHostController,
    note: String,
    id:Int
) {
    val noteState by viewModule.noteState.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {

        TextField(
            value = noteState.title,
            onValueChange = viewModule::updateTitle
        )

        Button(onClick = {
            viewModule.addNote()
        }) {
            Text(text = "add")
        }

        Button(onClick = {
            navHC.popBackStack(route = "main",inclusive = true)
            navHC.navigate("note")
        }) {
            Text(text = "notes")
        }

        Button(onClick = {
            viewModule.updating(id)
        }) {
            Text(text = "edit")
        }


    }
}

@Composable
fun NoteScreen(viewModule: NoteViewModule,navC: NavHostController) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(items = viewModule.allNotes.value){ item ->
            ClickableText(text = AnnotatedString("${item.id} / ${item.title} / ${item.description} / ${item.color}"),
                onClick = {
                    navC.popBackStack(route = "main",inclusive = true)
                    navC.navigate("main/${item.title}/${item.id}"){
                    }
                })
        }
    }
}