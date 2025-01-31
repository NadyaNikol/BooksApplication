package com.example.booksapplication.data

import com.example.booksapplication.data.entities.BookEntity
import com.example.booksapplication.data.entities.Genre
import com.example.booksapplication.data.entities.Language
import kotlin.random.Random

/**
 * Created by Nadya N. on 20.01.2025.
 */
object DataInit {

    fun generateRandomBook(): BookEntity = BookEntity(
        id = Random.nextLong(),
        name = "Book ${Random.nextLong()}",
        genre = Genre.entries[Random.nextInt(Genre.entries.size)],
        rating = 1 + Random.nextFloat() * 4,
        releaseYear = Random.nextInt(1455, 2023),
        author = "Author ${Random.nextLong()}",
        description = "Description ${Random.nextLong()}",
        language = Language.entries[Random.nextInt(Language.entries.size)],
        numberOfPages = Random.nextInt(1, 1001),
        imageUrl = "http://example.com/book/${Random.nextLong()}.jpg"
    )

    fun generateRandomBookValidationError(): BookEntity = BookEntity(
        id = Random.nextLong(),
        name = "",
        genre = Genre.entries[Random.nextInt(Genre.entries.size)],
        rating = -1 + Random.nextFloat() * -4,
        releaseYear = Random.nextInt(20, 300),
        author = "",
        description = "",
        language = Language.entries[Random.nextInt(Language.entries.size)],
        numberOfPages = Random.nextInt(-100, 0),
        imageUrl = ""
    )
}