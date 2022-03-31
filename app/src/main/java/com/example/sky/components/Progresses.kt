package com.example.sky.components

import androidx.compose.material.ProgressIndicatorDefaults.IndicatorBackgroundOpacity
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.DefaultStrokeLineWidth
import androidx.compose.ui.unit.dp

interface Progresses {

    @Composable
    fun progs() {
        CircularProgressIndicator(
            progress = 1f,
            modifier = Modifier,
            color = MaterialTheme.colorScheme.primary,
            strokeWidth = 4.dp
        )
        LinearProgressIndicator(
            progress = 1f,
            modifier = Modifier,
            color = MaterialTheme.colorScheme.primary,
            trackColor = MaterialTheme.colorScheme.background
        )
    }
}