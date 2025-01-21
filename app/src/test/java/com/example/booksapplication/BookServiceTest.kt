package com.example.booksapplication

import com.example.booksapplication.data.DataInit.generateRandomBook
import com.example.booksapplication.data.DataInit.generateRandomBookValidationError
import com.example.booksapplication.data.useCases.InsertBookUseCase
import com.example.booksapplication.services.BookService
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock

/**
 * Created by Nadya N. on 20.01.2025.
 */
class BookServiceTest: BaseTest() {

    private lateinit var service: BookService

    @Before
    fun setUp() {
        service = mock<BookService>()
    }

    @Test
    fun `add book successfully`() = runBlocking {
        val insertBook = InsertBookUseCase(service)
        val book = generateRandomBook()

        val result = insertBook.invoke(book)
        assertThat(result).isTrue()
    }

    @Test
    fun `add book error`() = runBlocking {
        val insertBook = InsertBookUseCase(service)
        val book = generateRandomBookValidationError()

        val result = insertBook.invoke(book)
        assertThat(result).isFalse()
    }
}