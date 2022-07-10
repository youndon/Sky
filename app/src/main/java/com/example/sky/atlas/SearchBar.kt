package com.example.sky.atlas

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchBar() {
    var appBarState by remember { mutableStateOf(false) }
    var atlasState by remember { mutableStateOf("") }
    val keyBoardController = LocalSoftwareKeyboardController.current
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clip(CircleShape),
        backgroundColor = Color.DarkGray
    ) {
        AnimatedVisibility(visible = !appBarState) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Atlassian",
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.LightGray
                    ),
                    modifier = Modifier
                        .padding(start = 20.dp)
                )
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = Color.LightGray,
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .clickable {
                            appBarState = !appBarState
                        },
                )
            }
        }
        AnimatedVisibility(visible = appBarState) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = atlasState,
                    onValueChange = { atlasState = it },
                    textStyle = TextStyle(fontSize = 20.sp),
                    placeholder = {
                        Text(
                            text = "Search in ...",
                            fontSize = 20.sp,
                            color = Color.LightGray
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = Color.LightGray,
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent
                    ),
                    leadingIcon = {
                        AnimatedVisibility(visible = atlasState.isEmpty()) {
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
                        AnimatedVisibility(visible = atlasState.isNotEmpty()) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = null,
                                tint = Color.LightGray,
                                modifier = Modifier
                                    .padding(end = 20.dp)
                                    .clickable {
                                        atlasState = ""
                                    },
                            )
                        }
                    },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                    keyboardActions = KeyboardActions(onSearch = {
                        keyBoardController?.hide()
                    }) {}
                )
            }
        }
    }
}