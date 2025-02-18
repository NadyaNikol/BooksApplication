package com.example.booksapplication.data.useCases

import com.example.booksapplication.data.services.BookDataSource

/**
 * Created by Nadya N. on 16.01.2025.
 */
class GetBookByNameUseCase(
    private val bookDataSource: BookDataSource,
) {

    suspend operator fun invoke(name: String) {
        bookDataSource.getBookByName(name)
    }
}