package com.example.sky.noteApp.database.repository

import androidx.lifecycle.LiveData
import com.example.sky.noteApp.database.NoteDao
import com.example.sky.noteApp.database.NoteEntity
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@ViewModelScoped
class DefaultNoteRepository @Inject constructor(private val noteDao: NoteDao):NoteRepository {
    override val getAllNotes: Flow<List<NoteEntity>>
        get() = noteDao.allNotes()

    override suspend fun addNote(noteEntity: NoteEntity) {
        coroutineScope { launch { noteDao.addNote(noteEntity) } }
    }

    override suspend fun editNote(noteEntity: NoteEntity) {
        coroutineScope { launch { noteDao.editNote(noteEntity) } }
    }

    override suspend fun deleteNote(noteEntity: NoteEntity) {
        coroutineScope { launch { noteDao.deleteNote(noteEntity) } }
    }


}