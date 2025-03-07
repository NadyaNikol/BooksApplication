package com.example.booksapplication.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Nadya N. on 10.12.2024.
 */
@Entity(
//    foreignKeys =
//    @ForeignKey(
//        entity = BookDbEntity::class,
//        parentColumns = arrayOf("id"),
//        childColumns = arrayOf("bookId")
//    )
)
data class BookDetailInfoDbEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,

    val bookId: Long,
    val bookApiId: String,
    val title: String,
    val year: Int,
    val authors: String,
    val description: String,
    val publisher: String,
    val pages: String,
    val imageUrl: String,
    val url: String,
    val downloadUrl: String,
)
