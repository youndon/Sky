package com.example.sky.atlas

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random


@Composable
fun Coloring() {
    val cr = remember { mutableStateOf(Color.Cyan) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {
        Card(
            modifier = Modifier
                .size(500.dp, 400.dp)
                .clickable {
                    cr.value = Color(
                        Random.nextFloat(),
                        Random.nextFloat(),
                        Random.nextFloat()
                    )
                },
            backgroundColor = cr.value
        ) {

        }
    }
}
@Composable
fun Snaking() {
    var textState by remember { mutableStateOf("") }
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.DarkGray)
        ) {
            TextField(
                value = textState,
                onValueChange = {
                    textState = it
                }
            )
            Spacer(Modifier.height(30.dp))
            Button({
                scope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(textState,"dismiss",SnackbarDuration.Long)
                }
            }) {
                Text("Showing!!")
            }
        }
    }
}

@Composable
fun Effect() {
    val scaffold = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffold) {
//        var c by remember { mutableStateOf(0) }
        val c = produceState(0){
            delay(1000)
            value = 12 }
        if (c.value % 2 == 0 && c.value != 0){
            LaunchedEffect(scaffold.snackbarHostState) {
                scaffold.snackbarHostState.showSnackbar("The Count's $c")
            }
        }
        Button({ }){
            Text("count! ${c.value}")
        }
    }
}
@Composable
fun Animate() {
    var size by remember { mutableStateOf(100.dp) }
    val animateSize by animateDpAsState(
        targetValue = size,
//        tween(200,300, FastOutSlowInEasing)
        animationSpec = spring(Spring.DampingRatioMediumBouncy)
    )
    val color by rememberInfiniteTransition().animateColor(
        initialValue = Color.Cyan,
        targetValue = Color.White,
        animationSpec = infiniteRepeatable(
            animation = tween(),
            repeatMode = RepeatMode.Restart
        )
    )
    Box(
        modifier = Modifier
            .size(animateSize)
            .background(color)
            .clickable {
                size += 50.dp
            }
    ) {

    }
}


@Composable
fun PasswordField() {
    var state by rememberSaveable() { mutableStateOf("") }
    var visibility by remember { mutableStateOf(false) }
    val icon = if (visibility) Icons.Outlined.Lock else Icons.Outlined.Build

    OutlinedTextField(
        value = state,
        onValueChange = { state = it },
        trailingIcon = {
            androidx.compose.material3.Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.clickable {
                    visibility = !visibility
                })
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        visualTransformation = if (visibility) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Composable
fun BrashButton() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.background(
            Brush.horizontalGradient(colors = listOf(Color.Blue,Color.Green))
        ),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
    ) {
        Text(text = "Amazing!", fontSize = 30.sp, style = TextStyle(
            color = Color.Gray
        ))

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StickyHeaderList(
    alphabets:List<Char>,
    numbers:List<Int>
) {
    LazyColumn(){
        alphabets.forEach { char ->
            stickyHeader {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = char.toString(),
                    fontSize = 30.sp,
                    style = TextStyle(background = Color.Cyan)
                )
            }
            items(items = numbers) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = it.toString(),
                    fontSize = 30.sp,
                    style = TextStyle(background = Color.LightGray)
                )
            }
        }
    }
}


@Composable
fun ForSpeed() {
    var sliderState by remember { mutableStateOf(0.1f) }

    val anime = remember { Animatable(0.0f) }

    val floatState by animateFloatAsState(targetValue = anime.value,
        animationSpec = tween(1000))

    LaunchedEffect(key1 = sliderState){
        anime.animateTo(sliderState)
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .padding(40.dp)) {
                drawArc(
                    color = Color.Gray,
                    startAngle = 150f,
                    sweepAngle = 240f,
                    useCenter = false,
                    style = Stroke(
                        width = 100f,
                        cap = StrokeCap.Round
                    )
                )
                drawArc(
                    color = Color.Yellow,
                    startAngle = 150f,
                    sweepAngle = floatState * 240,
                    useCenter = false,
                    style = Stroke(
                        width = 100f,
                        cap = StrokeCap.Round
                    )
                )

            }
            Text(text = "${(floatState * 100).toInt()}%", fontSize = 40.sp)
        }

        Slider(value =sliderState, onValueChange ={
            sliderState = it
        })

    }
}