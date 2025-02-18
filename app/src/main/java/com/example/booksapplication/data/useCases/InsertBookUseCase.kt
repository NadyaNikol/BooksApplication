package com.example.booksapplication.data.useCases

import com.example.booksapplication.data.entities.BookEntity
import com.example.booksapplication.data.dataSources.BookDataSource

/**
 * Created by Nadya N. on 16.01.2025.
 */
class InsertBookUseCase(
    private val bookDataSource: BookDataSource,
) {

    suspend operator fun invoke(bookEntity: BookEntity): Boolean {
        return bookDataSource.insertEntity(bookEntity)
    }
}