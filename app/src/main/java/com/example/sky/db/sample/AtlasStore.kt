package com.example.sky.db.sample

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AtlasStore(private val c: Context){
    companion object {
        private val Context.atlasStore : DataStore<Preferences> by preferencesDataStore(
            "Theme"
        )
        val USER_KEY = booleanPreferencesKey("lightTheme")
    }
    val getTheme : Flow<Boolean?> = c.atlasStore.data
        .map { value: Preferences ->
            value[USER_KEY] ?: true
        }
    suspend fun saveTheme(status: Boolean){
        c.atlasStore.edit {
            it[USER_KEY] = status
        }
    }
}