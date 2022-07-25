package com.example.sky.noteApp.database.repository

import androidx.lifecycle.LiveData
import com.example.sky.noteApp.database.NoteEntity
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    val getAllNotesById:Flow<List<NoteEntity>>

    suspend fun addNote(noteEntity: NoteEntity)

    suspend fun editNote(noteEntity: NoteEntity)

    suspend fun deleteNote(noteEntity: NoteEntity)

}