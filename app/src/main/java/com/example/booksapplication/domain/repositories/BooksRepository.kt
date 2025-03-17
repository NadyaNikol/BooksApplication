package com.example.booksapplication.domain.repositories

import com.example.booksapplication.domain.entities.BooksApiStatusResponse

/**
 * Created by Nadya N. on 05.03.2025.
 */
interface BooksRepository {

//    suspend fun searchBooks(query: String): Flow<List<BookUIEntity>>
    suspend fun upsertAllBooks(offset: Int, query: String?): Result<BooksApiStatusResponse>
    suspend fun getBookById(id: Long)
}