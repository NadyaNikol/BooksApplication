package com.example.booksapplication.domain.repositories

/**
 * Created by Nadya N. on 05.03.2025.
 */
interface BookRepository {

    suspend fun getAllBooks()
    suspend fun getBookById(id: String)
}