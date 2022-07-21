package com.example.sky.noteApp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NoteEntity (
    @PrimaryKey(autoGenerate = true) var id:Int = 0,
    @ColumnInfo(name = "title") var title:String ="",
    @ColumnInfo(name = "description") var description:String="",
    @ColumnInfo(name = "color") var color:Int = 0,
//    @ColumnInfo(name = "date") var date :Unit
)
