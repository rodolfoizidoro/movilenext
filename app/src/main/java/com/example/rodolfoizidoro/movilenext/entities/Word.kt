package com.example.rodolfoizidoro.movilenext.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Por padrao o nome da classe é o nome da tabela
@Entity(tableName = "word_table")
data class Word(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word") // Opcional
    val word: String)
