package com.example.sky.noteApp.tops

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sky.R

@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
fun SearchBarNote(noteSearch: MutableState<String> = mutableStateOf("")) {
    var appBarState by remember { mutableStateOf(false) }
    val keyBoardController = LocalSoftwareKeyboardController.current
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(5.dp)
            .clip(CircleShape),
        value = noteSearch.value,
        onValueChange = { noteSearch.value = it },
        textStyle = TextStyle(fontSize = 20.sp),
        placeholder = {
            Text(
                text = "Search note...",
                fontSize = 16.sp,
                color = Color.LightGray
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.LightGray,
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent,
            backgroundColor = Color.Gray
        ),
        leadingIcon = {
            AnimatedVisibility(visible = noteSearch.value.isEmpty()) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.LightGray,
                    modifier = Modifier.clickable {
                        appBarState = !appBarState
                    })
            }
        },
        trailingIcon = {
            AnimatedVisibility(visible = noteSearch.value.isNotEmpty()) {
                Icon(
                    imageVector = Icons.Default.Clear,
                    contentDescription = null,
                    tint = Color.LightGray,
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .clickable {
                            noteSearch.value = ""
                        },
                )
            }
            AnimatedVisibility(visible = noteSearch.value.isEmpty()) {
                Image(
                    painter = painterResource(R.drawable.pexels_designecologist_3458448),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = {
            keyBoardController?.hide()
        }) {}
    )
}
