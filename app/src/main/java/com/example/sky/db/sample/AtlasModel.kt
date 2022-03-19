package com.example.sky.db.sample

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
class AtlasModel(application: Application):AndroidViewModel(application) {

    private val db = Room.databaseBuilder(
        application.applicationContext,
        AtlasDatabase::class.java,
        "atlas-db"
    ).build()

    var usersList by mutableStateOf(listOf<AtlasEntity>())
        private set

    init {
        GlobalScope.launch(Dispatchers.IO) {
            val users = db.userDao().readUser()
            viewModelScope.launch { usersList = users }
        }
    }

    fun addUser(user: AtlasEntity) {
        usersList = usersList + listOf(user)
        GlobalScope.launch(Dispatchers.IO) {

            db.userDao().addUser(user)
        }
    }

    fun deleteUser(user: AtlasEntity) {
        usersList = usersList - user
        GlobalScope.launch(Dispatchers.IO) {

            db.userDao().deleteUser(user)
        }
    }

    fun editUser(user: AtlasEntity) {
        GlobalScope.launch(Dispatchers.IO) {
            db.userDao().editUser(user)
        }
    }
}