package com.example.sky.noteApp.dattabase

import android.graphics.Color
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NoteEntity(
    @ColumnInfo(name = "titles") var title:String,
    @ColumnInfo(name = "descriptions") var description:String
//    @ColumnInfo(name = "background") var background:Color
){
    @PrimaryKey(autoGenerate = true) var id:Int = 0
}
