package com.example.booksapplication.data.api

import com.example.booksapplication.domain.entities.BookDetailInfoApiResponse
import com.example.booksapplication.domain.entities.BooksApiStatusResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Nadya N. on 05.03.2025.
 */
interface BookApi {

    @GET("recent")
    suspend fun getAllBooks(): Response<BooksApiStatusResponse>

    @GET("book/{id}")
    suspend fun getBookById(@Path("id") id: String): Response<BookDetailInfoApiResponse>

    companion object{
        const val BASE_URL = "https://www.dbooks.org/api/"
    }
}