package com.example.sky.noteApp.bottoms

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun NoteColors(
    noteColors:Array<Color> ,
    backgroundColor:MutableState<Color> ,
    showIcons : MutableState<Boolean>
) {
    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        backgroundColor = MaterialTheme.colorScheme.onSurface,
        cutoutShape = CircleShape
    ) {
        Adapting {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
            ) {
                items(items = noteColors){
                    Button(
                        onClick = {
                            backgroundColor.value = it
                            showIcons.value = false
                        },
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .size(if (backgroundColor.value == it) 50.dp else 45.dp)
                            .padding(5.dp),
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(backgroundColor = it),
                        elevation = ButtonDefaults.elevation(0.dp)
                    ) {
                        if (backgroundColor.value == it) {
                            Icon(Icons.Default.Done, contentDescription =null,modifier = Modifier.fillMaxSize())
                        }
                    }
                }
            }
        }
    }


}

//fun Modifier.drawColoredShadow(
//    color: Color,
//    alpha: Float = 0.2f,
//    borderRadius: Dp = 0.dp,
//    shadowRadius: Dp = 20.dp,
//    offsetY: Dp = 0.dp,
//    offsetX: Dp = 0.dp
//) = this.drawBehind {
//    val transparentColor = android.graphics.Color.toArgb(color.copy(alpha = 0.0f).value.toLong())
//    val shadowColor = android.graphics.Color.toArgb(color.copy(alpha = alpha).value.toLong())
//    this.drawIntoCanvas {
//        val paint = Paint()
//        val frameworkPaint = paint.asFrameworkPaint()
//        frameworkPaint.color = transparentColor
//        frameworkPaint.setShadowLayer(
//            shadowRadius.toPx(),
//            offsetX.toPx(),
//            offsetY.toPx(),
//            shadowColor
//        )
//        it.drawRoundRect(
//            0f,
//            0f,
//            this.size.width,
//            this.size.height,
//            borderRadius.toPx(),
//            borderRadius.toPx(),
//            paint
//        )
//    }
//}