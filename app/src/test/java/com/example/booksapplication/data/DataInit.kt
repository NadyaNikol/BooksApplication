package com.example.booksapplication.data

import com.example.booksapplication.domain.entities.BookUIEntity
import kotlin.random.Random

/**
 * Created by Nadya N. on 20.01.2025.
 */
object DataInit {

    fun generateRandomBook(): BookUIEntity = BookUIEntity(
//        id = Random.nextLong(),
        name = "Book ${Random.nextLong()}",
//        genre = Genre.entries[Random.nextInt(Genre.entries.size)],
//        rating = 1 + Random.nextFloat() * 4,
//        releaseYear = Random.nextInt(1455, 2023),
//        author = "Author ${Random.nextLong()}",
//        description = "Description ${Random.nextLong()}",
//        language = Language.entries[Random.nextInt(Language.entries.size)],
//        numberOfPages = Random.nextInt(1, 1001),
        imageUrl = "http://example.com/book/${Random.nextLong()}.jpg"
    )

    fun generateRandomBookValidationError(): BookUIEntity = BookUIEntity(
//        id = Random.nextLong(),
        name = "",
//        genre = Genre.entries[Random.nextInt(Genre.entries.size)],
//        rating = -1 + Random.nextFloat() * -4,
//        releaseYear = Random.nextInt(20, 300),
//        author = "",
//        description = "",
//        language = Language.entries[Random.nextInt(Language.entries.size)],
//        numberOfPages = Random.nextInt(-100, 0),
        imageUrl = ""
    )
}