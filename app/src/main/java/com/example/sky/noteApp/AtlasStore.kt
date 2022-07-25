package com.example.sky.noteApp

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NoteDataStore (private val c: Context){
     companion object {
        private val Context.dataStore : DataStore<Preferences> by preferencesDataStore(
            "Theme"
        )
        val USER_KEY = booleanPreferencesKey("lightTheme")
    }
    val getTheme : Flow<Boolean?> = c.dataStore.data
        .map { it[USER_KEY] ?: true }
    suspend fun saveTheme(status: Boolean){
        c.dataStore.edit { it[USER_KEY] = status }
    }
}