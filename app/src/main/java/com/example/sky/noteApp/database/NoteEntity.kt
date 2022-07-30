package com.example.sky.noteApp.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    var id:Int = 0,
    @ColumnInfo(name = "title")
    var title: String? = null,
    @ColumnInfo(name = "description")
    var description: String? = null,
    @ColumnInfo(name = "color")
    var color: String? = null,
    @ColumnInfo(name = "date")
    var date: String = "",
    @ColumnInfo(name = "image")
    var image: String? = null
)
