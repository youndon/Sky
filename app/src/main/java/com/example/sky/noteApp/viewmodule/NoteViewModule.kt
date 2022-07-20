package com.example.sky.noteApp.viewmodule

import androidx.compose.runtime.referentialEqualityPolicy
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sky.noteApp.database.NoteEntity
import com.example.sky.noteApp.database.repository.NoteDatabaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModule @Inject constructor(
    private val repository: NoteDatabaseRepository
):ViewModel() {

    private val _allNotes = MutableStateFlow<List<NoteEntity>>(emptyList())
    val allNotes = _allNotes

    fun getAllNotes(){
        viewModelScope.launch {
            repository.getAllNotes.collect {
                _allNotes.value = it
            }
        }
    }
}