package com.example.sky.noteApp.di

import  android.content.Context
import androidx.room.Room
import com.example.sky.noteApp.database.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteDatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context:Context
    ) = Room.databaseBuilder(
        context.applicationContext,
        NoteDatabase::class.java,
        "noteDB.db"
    ).build()

    @Singleton
    @Provides
    fun provideDao(noteDatabase: NoteDatabase) = noteDatabase.getDao()
}