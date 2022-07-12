package com.example.sky.database.sample

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import androidx.compose.material3.MaterialTheme as MaterialTheme3

private val id = fun() = (1..Int.MAX_VALUE).random()
val uV = mutableStateOf("")
val pV = mutableStateOf("")
val iV = mutableStateOf(0)
val tV = mutableStateOf(true)

@Composable
fun AtlasNav(
    model: AtlasModel,
    atlasEntity: List<AtlasEntity>,
) {
    val navC = rememberNavController()

    NavHost(navController = navC , startDestination = "atlasMain"){
        this.composable("atlasMain"){
            Atlasbase(model, navController = navC)
        }
        this.composable("atlasTable"){
            UsersTable(
                atlasEntity = atlasEntity,
                navController = navC
            )
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, androidx.compose.ui.ExperimentalComposeUiApi::class)
@Composable
fun Atlasbase(
    model: AtlasModel,
    navController: NavController
) {
    var userValue by remember { uV }
    var passValue by remember { pV }
    val scaffState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val atlasStore = AtlasStore(LocalContext.current)
    val get_theme = atlasStore.getTheme.collectAsState(false)
    val anyID =  model.usersList.any { it.id == iV.value }
    val findID = model.usersList.find { it.id == iV.value }
    val ctrl = LocalSoftwareKeyboardController.current
    Scaffold(
//        modifier = com.example.sky.Modifier.fillMaxSize(),
        scaffoldState = scaffState,
        backgroundColor = MaterialTheme3.colorScheme.background) {
        Column  (
            Modifier
                .padding(20.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedTextField(
                value = userValue,
                onValueChange = { userValue = it },
                label = { Text(text = "UserName!", color = MaterialTheme3.colorScheme.onPrimaryContainer) },
                maxLines = 1,
                colors = TextFieldDefaults.textFieldColors(
                    textColor = MaterialTheme3.colorScheme.onPrimaryContainer,
                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Sentences,
                    autoCorrect = true,
                    keyboardType = KeyboardType.Uri,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        ctrl?.hide()
                    }
                ),
                isError = userValue.any { !it.isLetter() }
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = passValue,
                onValueChange = { passValue = it },
                visualTransformation = PasswordVisualTransformation(),
                label = { Text("UserPassword!", color = MaterialTheme3.colorScheme.onPrimaryContainer) },
                maxLines = 1,
                colors = TextFieldDefaults.textFieldColors(
                    textColor = MaterialTheme3.colorScheme.onPrimaryContainer
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(20.dp))

            androidx.compose.material3.Button(
                modifier = Modifier.fillMaxWidth(),
                enabled = !anyID && userValue.isNotEmpty() && passValue.isNotEmpty(),
                onClick = {
                    model.addUser(
                        AtlasEntity(
                            id = id.invoke(),
                            userName = userValue,
                            password = passValue
                        )
                    )
                    scope.launch {
                        scaffState.snackbarHostState.showSnackbar("Added User.",actionLabel = "hide")
                    }
                    userValue = ""; passValue = ""
                }) {
                Text(text = "Add User")
            }

            Spacer(Modifier.height(20.dp))

            Row {
                androidx.compose.material3.Button(
                    onClick = {
                        navController.navigate("atlasTable")
                    }) {
                    Text(text = "User List")
                }
                Spacer(modifier = Modifier.width(10.dp))
                androidx.compose.material3.Button(
                    enabled = anyID
                            &&
                            (findID?.userName != userValue
                                    || findID.password != passValue),
                    onClick = {
                        model.editUser(AtlasEntity(
                            iV.value,
                            userValue,
                            passValue
                        ))
                        scope.launch {
                            scaffState.snackbarHostState.showSnackbar("Saved!",actionLabel = "hide")
                        }
                        userValue = ""; passValue = ""; iV.value = 0
                    }) {
                    Text(text = "Save")
                }

                Spacer(modifier = Modifier.width(10.dp))

                //

                androidx.compose.material3.Button(
                    enabled = anyID,
                    onClick = {
                        model.deleteUser(AtlasEntity(iV.value, uV.value, pV.value))
                        scope.launch {
                            scaffState.snackbarHostState.showSnackbar("Deleting!",actionLabel = "Undo")
                        }
                        userValue = ""; passValue = ""
                    }
                ) {
                    Text(text = "Delete")
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Switch(
                checked = get_theme.value!!,
                onCheckedChange = {
                    scope.launch {
                        atlasStore.saveTheme(it)
                        tV.value = it
                    }
                }
            )
        }
    }
}

@Composable
fun UsersTable(
    atlasEntity: List<AtlasEntity>,
    navController: NavController
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()) {
        items(items = atlasEntity) { entity ->
            ClickableText(text = AnnotatedString("${entity.id} : ${entity.userName} : ${entity.password}"),
                onClick = {
                    navController.navigate("atlasMain")
                    // or navController.popBackStack()
                    uV.value = entity.userName
                    pV.value = entity.password
                    iV.value = entity.id
                },
                style = TextStyle(MaterialTheme3.colorScheme.onPrimaryContainer))
        }
    }
}



