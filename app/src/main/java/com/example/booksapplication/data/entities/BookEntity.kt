package com.example.booksapplication.data.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by Nadya N. on 10.12.2024.
 */
@Parcelize
data class BookEntity(
    val id: Long = 0L,
    val name: String,
    val genre: Genre,
    val rating: Int,
    val releaseYear: Int,
    val author: String,
    val description: String,
    val language: Language,
    val numberOfPages: Int,
    val imageUrl: String
) : Parcelable