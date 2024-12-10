package com.example.booksapplication.data.repositories

import com.example.booksapplication.data.entities.BookEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by Nadya N. on 10.12.2024.
 */
interface BookRepository {

    suspend fun getBooksList(): Flow<List<BookEntity>>

    suspend fun insertBook(bookEntity: BookEntity)

    suspend fun updateBook(bookEntity: BookEntity)

    suspend fun getBookByName(name: String): Flow<List<BookEntity>>
}