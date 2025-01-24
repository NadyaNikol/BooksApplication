package com.example.booksapplication.data.useCases

import android.util.Log
import com.example.booksapplication.data.entities.BookEntity
import com.example.booksapplication.data.services.BookService

/**
 * Created by Nadya N. on 16.01.2025.
 */
class InsertBookUseCase(
    private val bookService: BookService,
) {

    suspend operator fun invoke(bookEntity: BookEntity): Boolean {
        val validationResult = ValidationInsertBookUseCase().execute(bookEntity)
        if (!validationResult.success) {
            Log.d(
                this::class.java.simpleName,
                "validation book error: ${validationResult.errorMessage}"
            )
            return false
        }

        bookService.insertEntity(bookEntity)
        return true
    }
}