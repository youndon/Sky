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
import kotlinx.coroutines.internal.synchronized
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import javax.inject.Inject

data class NoteEntityState (
    val id:Int = 1,
    var title:String ="",
    var description:String="",
    val color:Int = 1
)

@OptIn(InternalCoroutinesApi::class)
@HiltViewModel
class NoteViewModule @Inject constructor(
    private val repository: DefaultNoteRepository
):ViewModel() {

    init {
       getAllNotes()
    }

    // for observing the note changes.
    private val _allNotes = MutableStateFlow<List<NoteEntity>>(listOf())
    val allNotes = _allNotes.asStateFlow()

    private fun getAllNotes(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes.collect {
                _allNotes.value = it
            }
        }
    }

    // for putting the note changes on Notes EntityState (the instance of Node Entity class).
     var noteState by mutableStateOf(listOf(NoteEntity()))
    private set

    // catching any title changes to put it in NoteEntityState.
//    fun updateTitle(title: String){
//                noteState.title = title
//            }

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
    fun deleteNote(id:Int){
        viewModelScope.launch(Dispatchers.IO) {
            val note = NoteEntity(
                id = id
            )
            repository.deleteNote(note)
        }
    }
}