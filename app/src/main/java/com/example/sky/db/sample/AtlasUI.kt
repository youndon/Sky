package com.example.sky.db.sample

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import kotlin.random.Random

private val id = fun() = Random.nextInt()
val uV = mutableStateOf("")
val pV = mutableStateOf("")
val iV = mutableStateOf(0)

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
            label = { Text("UserName!") }
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = passValue,
            onValueChange = { passValue = it },
            visualTransformation = PasswordVisualTransformation(),
            label = { Text("UserPassword!") }
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            model.addUser(
                AtlasEntity(
                    id = id.invoke(),
                    userName = userValue,
                    password = passValue
                )
            )
            userValue = ""; passValue = ""
        }) {
            Text(text = "Add Atlas")
        }

        Spacer(Modifier.height(20.dp))

        Row {
            Button(onClick = {
                navController.navigate("atlasTable")
            }) {
                Text(text = "User List")
            }
            Spacer(modifier = Modifier.width(15.dp))
            Button(
                enabled = model.usersList.any { it.id == iV.value }
                        &&
                        (model.usersList.find { it.id == iV.value }?.userName != userValue
                                || model.usersList.find { it.id == iV.value }?.password != passValue),
                onClick = {
                model.editUser(AtlasEntity(
                    iV.value,
                    userValue,
                    passValue
                ))
            }) {
                Text(text = "Save")
            }
            Spacer(modifier = Modifier.width(15.dp))
            Button(
                enabled = model.usersList.any { it.id == iV.value},
                onClick = {
                    model.deleteUser(AtlasEntity(iV.value, uV.value, pV.value))
                }
            ){
                Text(text = "Delete")
            }
        }
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


