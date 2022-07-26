package com.example.sky.noteApp.viewmodule

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sky.noteApp.database.NoteEntity
import com.example.sky.noteApp.database.repository.DefaultNoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(InternalCoroutinesApi::class)
@HiltViewModel
class NoteViewModule @Inject constructor(
    private val repository: DefaultNoteRepository
):ViewModel() {

    // for observing the note changes.
    private val _allNotesById = MutableStateFlow<List<NoteEntity>>(listOf())
    val allNotesById = _allNotesById

    private val _allNotesByOldest = MutableStateFlow<List<NoteEntity>>(listOf())
    val allNotesByOldest = _allNotesByOldest

    private val _allNotesByNewest = MutableStateFlow<List<NoteEntity>>(listOf())
    val allNotesByNewest = _allNotesByNewest

    private val _allNotesByName = MutableStateFlow<List<NoteEntity>>(listOf())
    val allNotesByName = _allNotesByName

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotesById.collect {
                _allNotesById.value = it
            }
        }
        viewModelScope.launch(Dispatchers.IO){
            repository.getAllNotesByName.collect {
                _allNotesByName.value = it
            }
        }
        viewModelScope.launch(Dispatchers.IO){
            repository.getAllNotesByNewest.collect {
                _allNotesByNewest.value = it
            }
        }
        viewModelScope.launch(Dispatchers.IO){
            repository.getAllNotesByOldest.collect {
                _allNotesByOldest.value = it
            }
        }
    }

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