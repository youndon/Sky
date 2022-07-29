package com.example.sky.noteApp.database

import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NoteEntity::class], version = 3, exportSchema = false)
abstract class NoteDatabase:RoomDatabase() {
    abstract fun getDao():NoteDao
}