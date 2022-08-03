package com.example.sky3

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.ui.platform.LocalContext
import com.example.sky.noteApp.ui.NoteRoot
import dagger.hilt.android.AndroidEntryPoint
import java.io.File

class NoteActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            File(LocalContext.current.filesDir.path + "images").mkdirs()
//            File(LocalContext.current.filesDir.path + "records").mkdirs()
            NoteRoot()
        }
    }
}