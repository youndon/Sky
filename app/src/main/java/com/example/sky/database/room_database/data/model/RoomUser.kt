package com.eslirodrigues.tutorials.room_database.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "room_user_table")
data class RoomUser(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "user_name")
    val userName: String
)
