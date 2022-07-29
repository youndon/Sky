package com.example.sky

import android.os.Bundle
import android.os.Environment
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.sky.noteApp.ui.NoteRoot
import dagger.hilt.android.AndroidEntryPoint
import java.io.File

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            File(LocalContext.current.filesDir.path + "images").mkdirs()
//            File(LocalContext.current.filesDir.path + "records").mkdirs()
            NoteRoot()
//            Some()
        }
    }
    override fun onStart() {
        super.onStart()
    }
}

@Composable
fun CurrentTheme(
    content: @Composable () -> Unit
) {
    val theme = if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()
    MaterialTheme(colorScheme = theme, content = content)
}

