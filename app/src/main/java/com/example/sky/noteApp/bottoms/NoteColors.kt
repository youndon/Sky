package com.example.sky.noteApp.bottoms

import android.annotation.SuppressLint
import android.graphics.ColorSpace
import android.os.Build
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.selects.select

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("InvalidColorHexValue")
@Preview
@Composable
fun NoteColors(noteColors:Array<Color> = noteColor) {
    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth(),
        backgroundColor = Color.White

    ) {

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
        ) {
            items(items = noteColors){
                Button(
                    onClick = {

                    },
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(42.dp)
                        .padding(5.dp)
                        .drawColoredShadow(color = it, alpha = 0.3f)
                        .selectableGroup()
                        .selectable(true){

                        }
                    ,
                    shape = CircleShape,
                    border = BorderStroke(2.dp,it),
                    colors = ButtonDefaults.buttonColors(backgroundColor = it),
                    elevation = ButtonDefaults.elevation(0.dp)
                ) {
                    Icon(Icons.Default.Done, contentDescription =null,modifier = Modifier.size(5.dp))
                }
            }
        }
    }


}

val noteColor = arrayOf(
    Color.White,
    Color.Cyan,
    Color.Blue,
    Color.Red,
    Color.Magenta,
    Color.Yellow,
    Color.LightGray,
    Color.Gray,
    Color.DarkGray,
)

@RequiresApi(Build.VERSION_CODES.O)
fun Modifier.drawColoredShadow(
    color: Color,
    alpha: Float = 0.2f,
    borderRadius: Dp = 0.dp,
    shadowRadius: Dp = 20.dp,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp
) = this.drawBehind {
    val transparentColor = android.graphics.Color.toArgb(color.copy(alpha = 0.0f).value.toLong())
    val shadowColor = android.graphics.Color.toArgb(color.copy(alpha = alpha).value.toLong())
    this.drawIntoCanvas {
        val paint = Paint()
        val frameworkPaint = paint.asFrameworkPaint()
        frameworkPaint.color = transparentColor
        frameworkPaint.setShadowLayer(
            shadowRadius.toPx(),
            offsetX.toPx(),
            offsetY.toPx(),
            shadowColor
        )
        it.drawRoundRect(
            0f,
            0f,
            this.size.width,
            this.size.height,
            borderRadius.toPx(),
            borderRadius.toPx(),
            paint
        )
    }
}