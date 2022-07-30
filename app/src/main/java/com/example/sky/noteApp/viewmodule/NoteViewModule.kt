package com.example.sky.noteApp.viewmodule

import android.content.Context
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
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
import java.io.File
import java.io.FileOutputStream
import java.util.*
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
        viewModelScope.apply {
            launch(Dispatchers.IO) {
                repository.getAllNotesById.collect {
                    _allNotesById.value = it
                }
            }
            launch(Dispatchers.IO) {
                repository.getAllNotesByName.collect {
                    _allNotesByName.value = it
                }
            }
            launch(Dispatchers.IO) {
                repository.getAllNotesByNewest.collect {
                    _allNotesByNewest.value = it
                }
            }
            launch(Dispatchers.IO) {
                repository.getAllNotesByOldest.collect {
                    _allNotesByOldest.value = it
                }
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

    //
    fun saveImageInternally(img:Bitmap?, imagesPath:String, uuid:UUID) {
            FileOutputStream(
                File(imagesPath, "$uuid.jpeg")
            ).use {
                img?.compress(Bitmap.CompressFormat.JPEG, 100,it)
                it.flush()
            }
        }

    //
    fun displayImage (img:MutableState<Bitmap?>, photo: MutableState<Bitmap?>, uri: Uri, c:Context){
        if (Build.VERSION.SDK_INT < 28) {
            uri.buildUpon().clearQuery()
            img.value = MediaStore.Images.Media.getBitmap(c.contentResolver,uri)

        } else {
            val source = ImageDecoder
                .createSource(c.contentResolver,uri)
            img.value = ImageDecoder.decodeBitmap(source)
        }
            photo.value?.let {
                img.value = it
            }
    }

}

