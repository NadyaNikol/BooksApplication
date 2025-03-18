package com.example.booksapplication.data.api

import com.example.booksapplication.domain.entities.BookDetailInfoApiResponse
import com.example.booksapplication.domain.entities.BooksApiStatusResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Nadya N. on 05.03.2025.
 */
interface BooksApi {

    @GET("search-books")
    suspend fun getAllBooks(
        @Query("offset") offset: Int,
        @Query("query") query: String?,
        @Query("number") number: Int = TOTAL_ITEMS_PAGE,
        @Query("api-key") apiKey: String = API_KEY,
    ): Response<BooksApiStatusResponse>

    @GET("{id}")
    suspend fun getBookById(@Path("id") id: Long): Response<BookDetailInfoApiResponse>

    companion object{
        const val BASE_URL = "https://api.bigbookapi.com/"
        const val  TOTAL_ITEMS_PAGE = 20
        const val API_KEY = ""
    }
}