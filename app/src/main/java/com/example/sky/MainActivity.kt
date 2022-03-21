package com.example.sky

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.datastore.core.DataStore
import androidx.datastore.dataStoreFile
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.sky.db.sample.AtlasModel
import com.example.sky.db.sample.AtlasNav
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val atlasModule by viewModels<AtlasModel>()
        setContent {
            Land(atlasModule.themeState) {
                Surface(color = MaterialTheme.colorScheme.background) {
                    AtlasNav(atlasModule, atlasModule.usersList)
                }
            }
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
