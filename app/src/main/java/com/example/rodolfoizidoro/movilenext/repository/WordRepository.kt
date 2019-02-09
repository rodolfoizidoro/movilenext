package com.example.rodolfoizidoro.movilenext.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.rodolfoizidoro.movilenext.dao.WordDAO
import com.example.rodolfoizidoro.movilenext.db.WordRoomDatabase
import com.example.rodolfoizidoro.movilenext.entities.Word
import org.jetbrains.anko.doAsync

class WordRepository(application: Application) {
    private val wordDAO: WordDAO
    val allWords: LiveData<List<Word>>

    init {
        val db = WordRoomDatabase.getDatabase(application)
        wordDAO = db.wordDao()
        allWords = wordDAO.getAllWords()
    }

    fun insert(word: Word){
        doAsync {
            wordDAO.insert(word)
        }
    }
}
