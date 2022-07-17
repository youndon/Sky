package com.example.sky.noteApp.tops

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sky.R

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchBarNote(
    noteSearch: MutableState<String>,
    isGrid: MutableState<Boolean>
) {
    var appBarState by remember { mutableStateOf(false) }
    val keyBoardController = LocalSoftwareKeyboardController.current
    val mutableTS = MutableTransitionState(true)
    val context = LocalContext.current
        OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
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

        },
        trailingIcon = {
            AnimatedVisibility(visibleState = mutableTS) {
                Icon(
                    painter = if (isGrid.value) painterResource(R.drawable.grid_on)
                    else painterResource(R.drawable.horizontal_split),
                    contentDescription = null,
                    tint = Color.LightGray,
                    modifier = Modifier
                        .padding(end = 65.dp)
                        .clickable {
                            isGrid.value = !isGrid.value
                        },
                )
            }
            Row {
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
                // TODO: out of the time bug!!
                AnimatedVisibility(visible = noteSearch.value.isEmpty()) {
                    Image(
                        imageVector = Icons.Outlined.Person,
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                            .clickable {
                                Toast
                                    .makeText(context, "coming soon!", Toast.LENGTH_SHORT)
                                    .show()
                            },
                        contentScale = ContentScale.Crop
                    )
                }
            }
        },

        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = {
            keyBoardController?.hide()
        }) {}
    )
}
