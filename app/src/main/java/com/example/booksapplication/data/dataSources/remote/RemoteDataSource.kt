package com.example.booksapplication.data.dataSources.remote

import com.example.booksapplication.domain.entities.BookDetailInfoApiResponse
import com.example.booksapplication.domain.entities.BooksApiStatusResponse

/**
 * Created by Nadya N. on 05.03.2025.
 */
interface RemoteDataSource {
    suspend fun getAllBooks(): BooksApiStatusResponse
    suspend fun getBookById(bookId: String): BookDetailInfoApiResponse
}