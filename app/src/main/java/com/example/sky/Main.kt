package com.example.sky

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun Seabeds() {
    val currency = remember {
        mutableStateOf(1.0f)
    }
    val manager = LocalFocusManager.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Yoro(currency)
        Dollar(currency)
        Divider(modifier = Modifier.padding(30.dp))
        TextField(
            value = currency.value.toString(),
            onValueChange = { currency.value = it.toFloat() },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { manager.moveFocus(FocusDirection.Down) }
            )
        )
        Spacer(modifier = Modifier.height(30.dp))
        TextField(value = "", onValueChange = { "Done" })
    }
}

@Composable
fun Dollar(currency: MutableState<Float>) {
    val d = currency.value * 18
    Text(text = "$d €", fontSize = 30.sp)

}

@Composable
fun Yoro(currency: MutableState<Float>) {
    val y = currency.value * 21
    Text(text = "$y $", fontSize = 30.sp)
}


//androidx.activity.compose.*
//androidx.constraintlayout.compose.*
//androidx.navigation.compose.*
//androidx.paging.compose.*
