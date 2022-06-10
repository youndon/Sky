package com.example.sky

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Indication
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.security.acl.Permission

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
        TextField(value = "", onValueChange = { "Done" },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions { manager.clearFocus(true) }
        )
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


//
fun androidxActivityCompose() {
//    androidx.activity.compose.BackHandler {}
//    androidx.activity.compose.rememberLauncherForActivityResult(contract =, onResult =)
}



fun androidxConstraintlayoutCompose() {
//    androidx.constraintlayout.compose.ConstraintSet(content = )
//    androidx.constraintlayout.compose.ConstraintLayout {}
//    androidx.constraintlayout.compose.MotionLayout(motionScene =, progress =) {    }
//    androidx.constraintlayout.compose.MotionScene(content =)
//    androidx.constraintlayout.compose.Transition(content =)
}
//.*
fun androidxNavigationCompose() {
//    androidx.navigation.compose.NavHost(navController =, graph =)
//    androidx.navigation.compose.rememberNavController(navigators =)
//    androidx.navigation.compose.DialogHost(dialogNavigator =)
}

//.*
fun androidxPagingCompose() {
//    androidx.paging.compose.LazyPagingItems
}

@Composable
fun S() {
    Surface(
        modifier = Modifier,
        shape = RectangleShape,
        color = Color.Cyan,
        contentColor = contentColorFor(Color.Cyan),
        border = BorderStroke(1.dp, Color.White),
        elevation = 1.dp
    ) {

    }
}
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SS() {
    Surface(
        onClick = {},
        modifier = Modifier,
        shape = RectangleShape,
        color = MaterialTheme.colors.surface,
        contentColor = contentColorFor(Color.Cyan),
        border = BorderStroke(1.dp, Color.Cyan),
        elevation = 0.dp,
        interactionSource = remember { MutableInteractionSource() },
        indication = LocalIndication.current,
        enabled = true,
        onClickLabel = "click label",
        role = Role.Button,
    ) {

    }
}


