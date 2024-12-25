package com.example.booksapplication.services

import com.example.booksapplication.data.entities.BookEntity
import com.example.booksapplication.data.repositories.RepositoriesLocator
import kotlinx.coroutines.flow.Flow

/**
 * Created by Nadya N. on 22.12.2024.
 */
class BookService {
    private val repository = RepositoriesLocator.repository

    suspend fun getListEntities(): Flow<List<BookEntity>> {
        return repository.getListEntities()
    }

    suspend fun insertEntity(bookEntity: BookEntity) {
        return repository.insertEntity(bookEntity)
    }

    suspend fun updateEntity(bookEntity: BookEntity) {
        return repository.updateEntity(bookEntity)
    }

    suspend fun getBookByName(name: String): Flow<List<BookEntity>> {
        return repository.getBookByName(name)
    }
}