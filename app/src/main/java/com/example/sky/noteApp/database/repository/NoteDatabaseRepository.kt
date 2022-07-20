package com.example.sky.noteApp.database.repository

import com.example.sky.noteApp.database.NoteDao
import com.example.sky.noteApp.database.NoteEntity
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class NoteDatabaseRepository @Inject constructor(private val noteDao: NoteDao) {

    val getAllNotes = noteDao.allNotes()

    suspend fun addNote(noteEntity: NoteEntity){
        noteDao.addNote(noteEntity)
    }

    suspend fun editNote(noteEntity: NoteEntity){
        noteDao.editNote(noteEntity)
    }

    suspend fun deleteNote(noteEntity: NoteEntity){
        noteDao.deleteNote(noteEntity)
    }
}