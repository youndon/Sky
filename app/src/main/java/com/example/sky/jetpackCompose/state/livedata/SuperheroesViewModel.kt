package com.example.sky.jetpackCompose.state.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.sky.jetpackCompose.core.Person
import com.example.sky.jetpackCompose.core.getSuperheroList
import kotlinx.coroutines.delay

class SuperheroesViewModel : ViewModel() {
    val superheroes: LiveData<List<Person>> = liveData {
        val superheroList = loadSuperheroes()
        emit(superheroList)
    }

    // Added a delay of 2 seconds to emulate a network request. This method just sets the list of
    // superheroes to the livedata after 2 seconds.
    suspend fun loadSuperheroes(): List<Person> {
        delay(2000)
        return getSuperheroList()
    }
}
