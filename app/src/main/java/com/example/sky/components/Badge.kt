package com.example.sky.components

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

interface Badge {
    @Composable
    fun Others() {
        BadgedBox(
            modifier = Modifier,
            badge = @Composable {
                Badge(
                    modifier = Modifier,
                    contentColor = contentColorFor(Color.Unspecified)
                ) {
                }
            }
        ) {

        }
    }
}