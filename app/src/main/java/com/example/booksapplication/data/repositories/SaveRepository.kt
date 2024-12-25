package com.example.booksapplication.data.repositories

/**
 * Created by Nadya N. on 10.12.2024.
 */
interface SaveRepository<T> {

    suspend fun insertEntity(bookEntity: T)

    suspend fun updateEntity(bookEntity: T)

}