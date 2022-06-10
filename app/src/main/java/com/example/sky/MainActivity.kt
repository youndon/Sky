package com.example.sky

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.VectorConverter
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.datastore.core.DataStore
import androidx.datastore.dataStoreFile
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.sky.db.sample.AtlasModel
import com.example.sky.db.sample.AtlasNav
import com.example.sky.db.sample.AtlasStore
import com.example.sky.db.sample.tV
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

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
            Seabeds()
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


