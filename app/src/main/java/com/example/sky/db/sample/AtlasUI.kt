package com.example.sky.db.sample

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.Text
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import androidx.compose.material.SnackbarHost as SnackbarHost3
import androidx.compose.material3.MaterialTheme as MaterialTheme3
import androidx.compose.material3.Scaffold as Scaffold3
import androidx.compose.material3.Snackbar as Snackbar3

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Atlasbase(
    model: AtlasModel,
    navController: NavController
) {
    var userValue by remember { uV }
    var passValue by remember { pV }
    val atlasStore = AtlasStore(LocalContext.current)
    val scope = rememberCoroutineScope()
    val get_theme = atlasStore.getTheme.collectAsState(false)
    val anyID =  model.usersList.any { it.id == iV.value }
    val findID = model.usersList.find { it.id == iV.value }
    val scaffoldS = rememberScaffoldState()
    val scaffoldV = remember { mutableStateOf(false) }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldS,
    backgroundColor = MaterialTheme3.colorScheme.background) {
        if (scaffoldV.value) LaunchedEffect(scaffoldS.snackbarHostState) {
            scaffoldS.snackbarHostState.showSnackbar(
                message = "$userValue $passValue Added!!",
                duration = SnackbarDuration.Short)
            scaffoldV.value = false
        }
        Column  (
            Modifier
                .padding(20.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = userValue,
                onValueChange = { userValue = it },
                label = { Text(text = "UserName!", color = MaterialTheme3.colorScheme.onPrimaryContainer) },
                maxLines = 1,
                colors = TextFieldDefaults.textFieldColors(
                    textColor = MaterialTheme3.colorScheme.onPrimaryContainer,
                )
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
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            androidx.compose.material3.Button(
                enabled = !anyID && userValue.isNotEmpty() && passValue.isNotEmpty(),
                onClick = {
                    model.addUser(
                        AtlasEntity(
                            id = id.invoke(),
                            userName = userValue,
                            password = passValue
                        )
                    )
                    scaffoldV.value = true
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
                    uV.value = entity.userName
                    pV.value = entity.password
                    iV.value = entity.id
                },
                style = TextStyle(MaterialTheme3.colorScheme.onPrimaryContainer))
        }
    }
}



