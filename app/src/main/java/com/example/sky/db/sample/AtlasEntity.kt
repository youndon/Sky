package com.example.sky.db.sample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userTable")
data class AtlasEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo val userName: String,
    @ColumnInfo val password: String
)
