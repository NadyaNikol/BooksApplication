package com.example.booksapplication.domain.entities

import com.google.gson.annotations.SerializedName

/**
 * Created by Nadya N. on 05.03.2025.
 */
data class BookDetailInfoApiResponse(
    @SerializedName("id") val id: Long,
    @SerializedName("title") val title: String,
    @SerializedName("image") val image: String,
    @SerializedName("description") val description: String,

)
