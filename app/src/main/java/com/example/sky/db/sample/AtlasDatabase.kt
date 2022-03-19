package com.example.sky.db.sample

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [AtlasEntity::class], version = 1, exportSchema = false)
abstract class AtlasDatabase():RoomDatabase() {

    abstract fun userDao():AtlasDao

}