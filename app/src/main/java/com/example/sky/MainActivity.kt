package com.example.sky

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

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

        }
    }
} // diesel

@Composable
fun CurrentTheme(
    content: @Composable () -> Unit
) {
    val theme = if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()
    MaterialTheme(colorScheme = theme, content = content)
}

