package com.example.sky.noteApp.viewmodule

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.sky.noteApp.database.NoteEntity
import com.example.sky.noteApp.database.repository.DefaultNoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.internal.synchronized
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import javax.inject.Inject

@OptIn(InternalCoroutinesApi::class)
@HiltViewModel
class NoteViewModule @Inject constructor(
    private val repository: DefaultNoteRepository
):ViewModel() {

    // for observing the note changes.
    private val _allNotes = MutableStateFlow<List<NoteEntity>>(listOf())
    val allNotes = _allNotes

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes.collect {
                _allNotes.value = it
            }
        }
    }

    //


    // for putting the note changes on Notes EntityState (the instance of Node Entity class).
     var noteState by mutableStateOf(listOf(NoteEntity()))
    private set

    // for add a note from NoteEntityState as it to NoteEntity class.
    fun addNote(note: NoteEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            noteState = noteState + note
            repository.addNote(note)
        }
    }

    // for updateNote a note from NoteEntityState and put it to NoteEntity class,
    // depending on changes.
    fun updateNote(note: NoteEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.editNote(note)
        }
    }

    // for deleting a note by the id.
    fun deleteNote(note: NoteEntity){
        viewModelScope.launch(Dispatchers.IO) {
            noteState = noteState - note
            repository.deleteNote(note)
        }
    }
}