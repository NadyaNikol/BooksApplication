package com.example.booksapplication.utils.extensions

import com.example.booksapplication.data.entities.BookEntity
import com.example.booksapplication.data.room.BookDbEntity

/**
 * Created by Nadya N. on 25.12.2024.
 */

fun BookDbEntity.toEntity() = BookEntity(
    id = this.id,
    name = this.name,
    genre = this.genre,
    rating = this.rating,
    releaseYear = this.releaseYear,
    author = this.author,
    description = this.description,
    language = this.language,
    numberOfPages = this.numberOfPages,
    imageUrl = this.imageUrl
)

fun BookEntity.fromEntity() = BookDbEntity(
    id = this.id,
    name = this.name,
    genre = this.genre,
    rating = this.rating,
    releaseYear = this.releaseYear,
    author = this.author,
    description = this.description,
    language = this.language,
    numberOfPages = this.numberOfPages,
    imageUrl = this.imageUrl
)