package com.example.booksapplication.domain.entities

import com.google.gson.annotations.SerializedName

/**
 * Created by Nadya N. on 05.03.2025.
 */
data class BookDetailInfoApiResponse(
    @SerializedName("status") val status: String,
    @SerializedName("id") val bookId: String,
    @SerializedName("title") val title: String,
    @SerializedName("subtitle") val subtitle: String,
    @SerializedName("description") val description: String,
    @SerializedName("authors") val authors: String,
    @SerializedName("publisher") val publisher: String,
    @SerializedName("pages") val pages: String,
    @SerializedName("year") val year: Int,
    @SerializedName("image") val image: String,
    @SerializedName("url") val url: String,
    @SerializedName("download") val download: String,
)
