package com.example.sky.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.ImageBitmapConfig
import androidx.compose.ui.graphics.ImageShader
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

interface Image {
    @Composable
    fun image() {
        Image(
            painter = painterResource(id = 0),
            contentDescription = "",
            modifier = Modifier,
            alignment = Alignment.Center,
            contentScale = ContentScale.Fit,
            // Fit, Crop, Inside, None, FillBounds, FillHeight, FillWidth
            alpha = DefaultAlpha,
            colorFilter = null
        )
    }
}