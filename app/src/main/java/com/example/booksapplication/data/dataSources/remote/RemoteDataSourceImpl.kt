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

    override suspend fun getAllBooks(offset:Int, query:String?): BooksApiStatusResponse {
        val response = bookApi.getAllBooks(offset , query).body()
        return if (response == null || response.books.isEmpty()) throw Throwable(message = ERROR_DATA_RESPONSE) else response
    }

    override suspend fun getBookById(bookId: Long): BookDetailInfoApiResponse {
        val response = bookApi.getBookById(bookId).body()
        return if (response == null || response.description.isBlank()) throw Throwable(message = ERROR_DATA_RESPONSE) else response
    }
}