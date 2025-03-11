package com.example.booksapplication.domain.repositories

import com.example.booksapplication.domain.entities.BookDbEntity
import com.example.booksapplication.domain.entities.BookUIEntity
import com.example.booksapplication.domain.entities.BooksApiStatusResponse
import kotlinx.coroutines.flow.Flow

/**
 * Created by Nadya N. on 05.03.2025.
 */
interface BookRepository {

    suspend fun searchBooks(query: String): Flow<List<BookUIEntity>>
    suspend fun upsertAllBooks(offset: Int, query: String?): Result<BooksApiStatusResponse>
    suspend fun getBookById(id: Long)
}