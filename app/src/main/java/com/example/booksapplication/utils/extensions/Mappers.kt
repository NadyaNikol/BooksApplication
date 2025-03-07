package com.example.booksapplication.utils.extensions

import com.example.booksapplication.domain.entities.BookApiResponse
import com.example.booksapplication.domain.entities.BookDbEntity
import com.example.booksapplication.domain.entities.BookUIEntity

/**
 * Created by Nadya N. on 05.03.2025.
 */

fun BookApiResponse.mapToDBEntity() =
    BookDbEntity(
        bookApiId = this.id,
        title = this.title,
        authors = this.authors,
        imageUrl = this.image,
        url = this.url,
    )

fun List<BookDbEntity>.mapToUI() =
    this.map {
        BookUIEntity(
            name = it.title,
            imageUrl = it.imageUrl
        )
    }

//fun BookDetailInfoApiResponse.mapToDBEntity() =
//    BookDetailInfoDbEntity(
//        bookId = this.bookId,
//        title = this.title,
//        year = this.year,
//        authors = this.authors,
//        description = this.description,
//        publisher = this.publisher,
//        pages = this.pages,
//        imageUrl = this.image,
//        url = this.url,
//        downloadUrl = this.download
//    )

fun List<BookApiResponse>.mapToDBEntity() =
    this.map { it.mapToDBEntity() }

//fun List<BookDetailInfoApiResponse>.mapToDBEntity() =
//    this.map { it.mapToDBEntity() }
