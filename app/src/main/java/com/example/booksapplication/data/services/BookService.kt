package com.example.booksapplication.data.services

import android.util.Log
import com.example.booksapplication.data.entities.BookEntity
import com.example.booksapplication.data.repositories.RepositoriesLocator
import com.example.booksapplication.data.room.BookDbEntity
import com.example.booksapplication.data.useCases.ValidationInsertBookUseCase
import com.example.booksapplication.utils.extensions.fromEntity
import com.example.booksapplication.utils.extensions.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Created by Nadya N. on 22.12.2024.
 */
class BookService {
    private val repository = RepositoriesLocator.repository

    suspend fun getListEntities(): Flow<List<BookEntity>> {
        return repository.getListEntities().map { bookList: List<BookDbEntity> ->
            bookList.map {
                it.toEntity()
            }
        }
    }

    suspend fun insertEntity(bookEntity: BookEntity): Boolean {
        val validationResult = ValidationInsertBookUseCase().execute(bookEntity)
        if (!validationResult.success) {
            Log.d(
                this::class.java.simpleName,
                "validation book error: ${validationResult.errorMessage}"
            )
            return false
        }
        repository.insertEntity(bookEntity.fromEntity())
        return true
    }

    suspend fun updateEntity(bookEntity: BookEntity) {
        return repository.updateEntity(bookEntity.fromEntity())
    }

    suspend fun getBookByName(name: String): Flow<List<BookEntity>> {
        return repository.getBookByName(name).map { bookList: List<BookDbEntity> ->
            bookList.map {
                it.toEntity()
            }
        }
    }
}