package com.example.sky.db.sample

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

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

@Composable
fun Atlasbase(
    model: AtlasModel,
    navController: NavController
) {
    var userValue by remember { uV }
    var passValue by remember { pV }
    val c = LocalContext.current
    val atlasStore = AtlasStore(c)
    val scope = rememberCoroutineScope()
    val get_theme = atlasStore.getTheme.collectAsState(false)
    val anyID =  model.usersList.any { it.id == iV.value }
    val findID = model.usersList.find { it.id == iV.value }
    Column(
        Modifier
            .padding(20.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = userValue,
            onValueChange = { userValue = it },
            label = { Text("UserName!") },
            maxLines = 1,
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = passValue,
            onValueChange = { passValue = it },
            visualTransformation = PasswordVisualTransformation(),
            label = { Text("UserPassword!") },
            maxLines = 1,
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            enabled = !anyID && userValue.isNotEmpty() && passValue.isNotEmpty(),
            onClick = {
                model.addUser(
                    AtlasEntity(
                        id = id.invoke(),
                        userName = userValue,
                        password = passValue
                    )
                )
                userValue = ""; passValue = ""
            }) {
            Text(text = "Add User")
        }

        Spacer(Modifier.height(20.dp))

        Row {
            Button(
                onClick = {
                    navController.navigate("atlasTable")
                }) {
                Text(text = "User List")
            }
            Spacer(modifier = Modifier.width(15.dp))
            Button(
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
            Spacer(modifier = Modifier.width(15.dp))
            Button(
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
//                    model.editThemeState(it)
                    tV.value = it
                }
            }
        )
    }
}

@Composable
fun UsersTable(
    atlasEntity: List<AtlasEntity>,
    navController: NavController
) {
    LazyColumn {
        items(items = atlasEntity) {
            TextButton(onClick = {
                navController.navigate("atlasMain")
                uV.value = it.userName
                pV.value = it.password
                iV.value = it.id
            }) {
                Text(text = "${it.id} : ${it.userName} : ${it.password}")
            }
        }
    }
}



