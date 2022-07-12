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

//    val list = listOf(
//        CardInfo("navHostController","Creates a NavHostController that handles the adding of the ComposeNavigator and DialogNavigator. Additional Navigator instances can be passed through navigators to be applied to the returned"),
//        CardInfo("composable","Params:\n" +
//                "route - route for the destination\n" +
//                "arguments - list of arguments to associate with destination\n" +
//                "deepLinks - list of deep links to associate with the destinations\n" +
//                "content - composable for the destination"),
//        CardInfo("navHost","Provides in place in the Compose hierarchy for self contained navigation to occur.\n" +
//                "Once this is called, any Composable within the given NavGraphBuilder can be navigated to from the provided navController."),
//        CardInfo("NavType","Parse an argType string into a NavType.\n" +
//                "Params:\n" +
//                "type - argType string, usually parsed from the Navigation XML file\n" +
//                "packageName - package name of the R file, used for parsing relative class names starting with a dot."),
//        CardInfo("preview","Preview can be applied to @Composable methods with no parameters to show them in the Android Studio preview.\n" +
//                "The annotation contains a number of parameters that allow to define the way the @Composable will be rendered within the preview.")
//    )
    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = "home"){
        composable("home"){
            HomeNote(noteList = noteViewModel.notes, navController = navHostController)
        }
        composable("add"){
            AddNote(navController = navHostController,noteViewModel)
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
                title = it.arguments?.getString("title") ?: "" ,
                description =it.arguments?.getString("description") ?: ""
            )
        }
    }
}