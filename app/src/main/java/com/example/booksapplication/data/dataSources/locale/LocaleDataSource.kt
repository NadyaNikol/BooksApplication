package com.example.booksapplication.data.dataSources.locale

import com.example.booksapplication.domain.entities.BookDbEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by Nadya N. on 05.03.2025.
 */
interface LocaleDataSource {

    fun getAllBooks(): Flow<List<BookDbEntity>>
    fun searchBooksByTitle(title:String): Flow<List<BookDbEntity>>
    suspend fun getBookById(id: String): Flow<BookDbEntity>
    suspend fun upsertBooks(books: List<BookDbEntity>)
    suspend fun upsertBook(book: BookDbEntity)
    suspend fun insertBook(bookDbEntity: BookDbEntity)
}