package com.example.booksapplication.domain.entities

import com.google.gson.annotations.SerializedName

/**
 * Created by Nadya N. on 05.03.2025.
 */
data class BooksApiStatusResponse(
    @SerializedName("status") val status: String,
    @SerializedName("total") val total: Long,
    @SerializedName("books") val books: List<BookApiResponse>,
)
