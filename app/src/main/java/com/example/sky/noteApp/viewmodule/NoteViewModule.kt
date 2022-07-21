package com.example.sky.noteApp.viewmodule

import androidx.compose.runtime.collectAsState
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
import kotlinx.coroutines.withContext
import javax.inject.Inject

data class NoteEntityState (
    val id:Int = 1,
    val title:String ="",
    val description:String="",
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
    private val _allNotes = MutableStateFlow<List<NoteEntity>>(listOf())

    val allNotes = _allNotes.asStateFlow()

    private fun getAllNotes(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes.collect {
                _allNotes.value = it
            }
        }
    }

    private val _noteState = MutableStateFlow(NoteEntityState())
    val noteState = _noteState.asStateFlow()

    fun updateTitle(title: String){
        _noteState.update {
            it.copy(title = title)
        }
    }

    fun addNote() {
        viewModelScope.launch {
            val note = NoteEntity(
                title = noteState.value.title,
                description = noteState.value.description,
                color = noteState.value.color
            )
            repository.addNote(note)
        }
    }

    fun updating(id:Int){
        viewModelScope.launch(Dispatchers.IO){
            val note = NoteEntity(
                title = noteState.value.title,
                description = noteState.value.description,
                color = noteState.value.color,
                id = id
            )
            repository.editNote(note)
        }
    }
}