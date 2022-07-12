package com.example.sky.noteApp.dattabase

import androidx.room.*
import androidx.room.Dao

@Dao
interface NoteDao {

    @Query("select * from notes order by id")
    suspend fun listOfNotes():List<NoteEntity>

    @Insert
    suspend fun addNote(note: NoteEntity)

    @Update
    suspend fun editNote(note: NoteEntity)
}