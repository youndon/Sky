package com.example.sky.noteApp.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.sky.noteApp.dattabase.NoteDatabase
import com.example.sky.noteApp.dattabase.NoteEntity
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
class NoteViewModel(application: Application):AndroidViewModel(application) {
    private val noteDatabase = Room.databaseBuilder(
        application.applicationContext,
        NoteDatabase::class.java,
        "noteDB"
    ).build()

    var notes by mutableStateOf(listOf<NoteEntity>())
    private set

    init {
        GlobalScope.launch(Dispatchers.IO) {
            val note = noteDatabase.noteDao().listOfNotes()
            viewModelScope.launch {
                notes = note
            }
        }
    }

    fun addNote(noteEntity: NoteEntity){
        notes = notes + noteEntity
        GlobalScope.launch(Dispatchers.IO){
            noteDatabase.noteDao().addNote(noteEntity)
        }
    }

    fun updateNote(noteEntity: NoteEntity) {
        GlobalScope.launch(Dispatchers.IO) {
        notes.find { it.id == noteEntity.id }?.let {
//                it.title = noteEntity.title
//                it.description = noteEntity.description
            noteDatabase.noteDao().editNote(it)
        }
        }
    }

    fun deleteNote(noteEntity:NoteEntity) {
        notes = notes - noteEntity
        GlobalScope.launch(Dispatchers.IO){
            noteDatabase.noteDao().deleteNote(noteEntity)
        }
    }

}