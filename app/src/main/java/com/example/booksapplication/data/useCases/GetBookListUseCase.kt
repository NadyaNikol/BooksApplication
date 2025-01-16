package com.example.booksapplication.data.useCases

import com.example.booksapplication.data.entities.BookEntity
import com.example.booksapplication.services.BookService
import kotlinx.coroutines.flow.Flow

/**
 * Created by Nadya N. on 16.01.2025.
 */
class GetBookListUseCase(
    private val bookService: BookService,
) {

    suspend operator fun invoke(): Flow<List<BookEntity>> {
        return bookService.getListEntities()
    }
}