package com.example.sky

import android.content.Context
import android.content.Intent
import android.os.*
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.*
import java.time.Clock
import java.util.*
import kotlin.coroutines.CoroutineContext
import kotlin.reflect.KClass

@Composable
fun MAX() {

    MaterialTheme(
        colorScheme = lightColorScheme()
    ) {
        androidx.compose.material3.Surface {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                androidx.compose.material3.Button(onClick = { }) {
                    androidx.compose.material3.Text(text = "Max!!")
                }
                OutlinedTextField(
                    value = "Max!!",
                    onValueChange = { it },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Scaf() {
    val remScope = rememberCoroutineScope()
    val remSState = rememberScaffoldState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = remSState
    ) {
        Column {
            Button(onClick = {
                remScope.launch {
                    remSState.snackbarHostState.showSnackbar("my method...", "done!")
                }
            }) {
                Text(text = "Snacked!!")
            }
            Divider()
            Plant()
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Plant() {
    val rem = remember { mutableStateOf("") }
    val keybCtrl = LocalSoftwareKeyboardController.current
    Column {
        TextField(
            value = rem.value,
            onValueChange = {
                rem.value = it
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    keybCtrl?.hide()
                },
            )
        )
        TextField(
            value = "",
            onValueChange = {}
        )
    }
}

@Composable
inline fun <reified C> Seabeds(
    context: Context,
) {
    val con = LocalContext.current
    val tent = Intent(context,C::class.java)
    Button(onClick = {
        con.startActivity(tent)
    }) {

    }

}

@Preview
@Composable
fun Milos() {
//    Handler(Looper.getMainLooper()).postDelayed({},2000)
    Column(verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally,modifier = Modifier.fillMaxSize()) {
        Button(onClick = { /*TODO*/ }) {
            Text(text = "AirplaneMode!")
        }
    }
}

//androidx.activity.compose.*
//androidx.constraintlayout.compose.*
//androidx.navigation.compose.*
//androidx.paging.compose.*

