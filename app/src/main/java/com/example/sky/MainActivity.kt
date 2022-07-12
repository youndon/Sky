package com.example.sky

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.example.sky.database.sample.AtlasModel
import com.example.sky.noteApp.RootNote

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val atlasModule by viewModels<AtlasModel>()

        setContent {
//            val get_theme = AtlasStore(this).getTheme.collectAsState(false)
//                    Land(get_theme.value!!) {
//                        Surface {
//                            AtlasNav(atlasModule, atlasModule.usersList)
//                        }
//            }
            RootNote()
        }
    }
}

@Composable
fun Land(
    theme: Boolean,
    content: @Composable () -> Unit
) {
    val currentTheme =  if (theme) lightColorScheme() else darkColorScheme()

    MaterialTheme(
        colorScheme = currentTheme,
        content = content
    )
}


