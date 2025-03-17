package com.example.booksapplication.utils.extensions

import com.example.booksapplication.domain.entities.BookDetailInfoApiResponse
import com.example.booksapplication.domain.entities.BooksApiStatusResponse
import com.example.booksapplication.utils.ERROR_DATA_RESPONSE
import retrofit2.Response
import kotlin.jvm.Throws

/**
 * Created by Nadya N. on 17.03.2025.
 */

@Throws(Throwable::class)
fun Response<BooksApiStatusResponse>.getBooks(): BooksApiStatusResponse {
    val response = this.body()
    return if (response == null || response.books.isEmpty()) throw Throwable(message = ERROR_DATA_RESPONSE) else response
}

@Throws(Throwable::class)
fun Response<BookDetailInfoApiResponse>.getBook(): BookDetailInfoApiResponse {
    val response = this.body()
    return if (response == null || response.description.isBlank()) throw Throwable(message = ERROR_DATA_RESPONSE) else response
}