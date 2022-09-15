package com.example.sky.components

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

interface Badge {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Others() {
        BadgedBox(
            modifier = Modifier,
            badge = @Composable {
                Badge(
                    modifier = Modifier,
                    contentColor = Color.Unspecified,
                    containerColor = Color.Unspecified
                ) {
                }
            }
        ) {

        }
    }
}