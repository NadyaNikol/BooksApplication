package com.example.booksapplication.data.dataSources.remote

import com.example.booksapplication.data.api.BookApi
import com.example.booksapplication.data.api.BookApi.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Nadya N. on 05.03.2025.
 */
object DataSourceLocator {

    private fun provideRetrofit(): Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun provideBookApi(): BookApi = provideRetrofit().create(BookApi::class.java)

}