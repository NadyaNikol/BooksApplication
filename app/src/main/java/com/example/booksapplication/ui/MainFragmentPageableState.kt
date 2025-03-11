package com.example.booksapplication.ui

import com.example.booksapplication.domain.entities.BookUIEntity

/**
 * Created by Nadya N. on 06.03.2025.
 */
data class MainFragmentPageableState(
    val isLoading: Boolean = false,
    val isLastPage: Boolean = false,
    val offset: Int = 0,
    val query: String = "",
    val books: List<BookUIEntity> = listOf(),
    )