package com.example.sky.noteApp.bottoms

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun BottomBarNote(icon : Array<ImageVector> = icons) {
    BottomAppBar(
        modifier = Modifier,
    ) {
        Adapting {
            icons.forEach {
                Icon(
                    imageVector = it,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier
                        .clickable {
                                   actionClick(it)
                        },
                )
            }
        }
    }
}

@Composable
fun RowScope.Adapting(content : @Composable () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 70.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        content.invoke()
    }
}

fun actionClick(img:ImageVector) = when(img) {
    Icons.Outlined.Notifications -> {

    }
    Icons.Outlined.Info -> {

    }
    Icons.Outlined.Share -> {

    }
    Icons.Outlined.Info -> {

    }
    Icons.Outlined.KeyboardArrowRight -> {

    }
    else -> {
        throw Exception("...")
    }
}

val icons = arrayOf(
    Icons.Outlined.Notifications,
    Icons.Outlined.Share,
    Icons.Outlined.Info,
    Icons.Outlined.Info,
    Icons.Outlined.KeyboardArrowRight,
)

