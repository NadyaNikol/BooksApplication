package com.example.booksapplication.data.useCases

import com.example.booksapplication.BaseTest
import com.example.booksapplication.data.DataInit.generateRandomBook
import com.example.booksapplication.data.DataInit.generateRandomBookValidationError
import com.example.booksapplication.data.dataSources.BookDataSource
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock

/**
 * Created by Nadya N. on 20.01.2025.
 */
class InsertBookUseCaseTest: BaseTest() {

    private lateinit var bookDataSource: BookDataSource

    @Before
    fun setUp() {
        bookDataSource = mock<BookDataSource>()
    }

    @Test
    fun `add book successfully`() = runBlocking {
        val insertBook = InsertBookUseCase(bookDataSource)
        val book = generateRandomBook()

        val result = insertBook.invoke(book)
        assertThat(result).isTrue()
    }

    @Test
    fun `add book error`() = runBlocking {
        val insertBook = InsertBookUseCase(bookDataSource)
        val book = generateRandomBookValidationError()

        val result = insertBook.invoke(book)
        assertThat(result).isFalse()
    }
}