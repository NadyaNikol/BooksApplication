package com.example.booksapplication.data.useCases

import com.example.booksapplication.services.BookService

/**
 * Created by Nadya N. on 16.01.2025.
 */
class GetBookByNameUseCase(
    private val bookService: BookService,
) {

    suspend operator fun invoke(name: String) {
        bookService.getBookByName(name)
    }
}