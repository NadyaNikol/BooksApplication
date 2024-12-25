package com.example.booksapplication.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.booksapplication.data.entities.Genre
import com.example.booksapplication.data.entities.Language

/**
 * Created by Nadya N. on 10.12.2024.
 */
@Entity(
//    tableName = "books",
    indices = [
        Index("name", unique = true)
    ]
)
data class BookDbEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,

    @ColumnInfo(collate = ColumnInfo.NOCASE)
    val name: String,

    val genre: Genre,
    val rating: Int,
    val releaseYear: Int,
    val author: String,
    val description: String,
    val language: Language,
    val numberOfPages: Int,
)
