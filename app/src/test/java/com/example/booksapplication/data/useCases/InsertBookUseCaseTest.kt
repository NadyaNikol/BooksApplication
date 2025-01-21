package com.example.booksapplication.data.useCases

import com.example.booksapplication.data.DataInit.generateRandomBook
import com.example.booksapplication.services.BookService
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.verify

/**
 * Created by Nadya N. on 20.01.2025.
 */
class InsertBookUseCaseTest{
    private lateinit var service: BookService

    @Before
    fun setUp() {
        service = BookService()
    }

    @Test
    fun `insert entity`()= runBlocking {
        val insertBook = InsertBookUseCase(service)
        val book = generateRandomBook()

        insertBook.invoke(book)

        verify(service).insertEntity(book)
    }
}