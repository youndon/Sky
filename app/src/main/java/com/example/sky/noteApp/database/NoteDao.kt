package com.example.sky.noteApp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("select * from notes order by id asc")
    fun allNotesOrderedById():Flow<List<NoteEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNote(note:NoteEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun editNote(note: NoteEntity)

    @Delete
    suspend fun deleteNote(note: NoteEntity)
}