package com.example.sky.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.LocalImageLoader
import coil.request.ImageRequest
import com.example.sky.R

interface Images {
    @SuppressLint("NotConstructor")
    @Composable
    fun Image() {

        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "",
            modifier = Modifier,
            alignment = Alignment.Center,
            contentScale = ContentScale.Fit,
            // Crop, Inside, None, FillBounds, FillHeight, FillWidth
            alpha = DefaultAlpha,
            colorFilter = null
        )
    }
}