package com.example.sky.noteApp.dattabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NoteEntity(
    @ColumnInfo(name = "titles") val title:String,
    @ColumnInfo(name = "descriptions") val description:String
){
    @PrimaryKey(autoGenerate = true) var id:Int = 0
}
