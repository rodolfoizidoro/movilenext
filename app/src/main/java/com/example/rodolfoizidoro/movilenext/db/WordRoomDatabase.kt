package com.example.rodolfoizidoro.movilenext.db

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.rodolfoizidoro.movilenext.dao.WordDAO
import com.example.rodolfoizidoro.movilenext.entities.Word

@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class WordRoomDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDAO

    companion object {
        private var instance: WordRoomDatabase? = null

        fun getDatabase(context: Context): WordRoomDatabase {
            if (instance == null) {
                synchronized(WordRoomDatabase::class.java) {
                    //Criacao do banco
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        WordRoomDatabase::class.java,
                        "word_database"
                    ).build()
                }
            }
            return instance!!
        }
    }
}
