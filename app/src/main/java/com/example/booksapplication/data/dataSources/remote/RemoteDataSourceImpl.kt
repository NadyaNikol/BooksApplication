package com.example.booksapplication.data.dataSources.remote

import com.example.booksapplication.data.api.BookApi
import com.example.booksapplication.domain.entities.BookDetailInfoApiResponse
import com.example.booksapplication.domain.entities.BooksApiStatusResponse
import com.example.booksapplication.utils.ERROR_DATA_RESPONSE

/**
 * Created by Nadya N. on 05.03.2025.
 */
class RemoteDataSourceImpl: RemoteDataSource {

    private val bookApi: BookApi
        get() = DataSourceLocator.provideBookApi()

    override suspend fun getAllBooks(): BooksApiStatusResponse {
        val response = bookApi.getAllBooks().body()
        return if (response?.status != "ok") throw Throwable(message = ERROR_DATA_RESPONSE) else response
    }

    override suspend fun getBookById(bookId: String): BookDetailInfoApiResponse {
        val response = bookApi.getBookById(bookId).body()
        return if (response?.status != "ok") throw Throwable(message = ERROR_DATA_RESPONSE) else response
    }
}