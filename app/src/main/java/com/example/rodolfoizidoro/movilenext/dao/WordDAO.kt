package com.example.rodolfoizidoro.movilenext.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rodolfoizidoro.movilenext.entities.Word

@Dao
interface WordDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(word: Word)

    @Query(value = "DELETE FROM word_table")
    fun deleteAll()

    @Query("SELECT * FROM WORD_TABLE ORDER BY word ASC")
    fun getAllWords(): LiveData<List<Word>>
}
