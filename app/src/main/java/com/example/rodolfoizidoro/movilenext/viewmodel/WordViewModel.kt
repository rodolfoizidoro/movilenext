package com.example.rodolfoizidoro.movilenext.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.rodolfoizidoro.movilenext.entities.Word
import com.example.rodolfoizidoro.movilenext.repository.WordRepository

class WordViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = WordRepository(application)

    val allWords = repository.allWords

    fun insert(word: Word) {
        repository.insert(word)
    }
}
