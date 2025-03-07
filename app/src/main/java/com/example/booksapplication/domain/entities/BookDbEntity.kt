package com.example.booksapplication.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Nadya N. on 10.12.2024.
 */
@Entity
data class BookDbEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,

    val bookApiId:String,
    val title: String,
    val authors: String,
    val imageUrl: String,
    val url: String,
)
