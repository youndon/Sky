package com.example.sky3

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

class NoteDataStore (private val c:Context){
    companion object{
        private val Context.layout by preferencesDataStore("layout")
        val LAYOUT_KEY = booleanPreferencesKey("layout")

        private val Context.order by preferencesDataStore("order")
        val ORDER_KEY = stringPreferencesKey("order")
    }

    val getLayout = c.layout.data.map { it[LAYOUT_KEY] ?: true }
    suspend fun saveLayout(value:Boolean){
        c.layout.edit {
            it[LAYOUT_KEY] = value
        }
    }

    val getOrder = c.order.data.map { it[ORDER_KEY] ?: "order_by_default" }
    suspend fun saveOrder(value:String){
        c.order.edit {
            it[ORDER_KEY] = value
        }
    }
}





