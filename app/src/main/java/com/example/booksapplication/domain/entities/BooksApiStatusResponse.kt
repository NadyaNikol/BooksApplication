package com.example.booksapplication.domain.entities

import com.google.gson.annotations.SerializedName

/**
 * Created by Nadya N. on 05.03.2025.
 */
data class BooksApiStatusResponse(
    @SerializedName("available") val available: Long,
    @SerializedName("number") val number: Long,
    @SerializedName("offset") val offset: Long,
    @SerializedName("books") val books: List<List<BookApiResponse>>,
)
