package com.example.booksapplication.data.useCases

import com.example.booksapplication.data.entities.BookEntity
import com.example.booksapplication.services.BookService

/**
 * Created by Nadya N. on 16.01.2025.
 */
class InsertBookUseCase(
    private val bookService: BookService,
) {

    suspend operator fun invoke(bookEntity: BookEntity) {
        bookService.insertEntity(bookEntity)
    }
}