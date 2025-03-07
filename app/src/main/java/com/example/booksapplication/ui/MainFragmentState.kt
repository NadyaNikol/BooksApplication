package com.example.booksapplication.ui

import com.example.booksapplication.domain.entities.BookUIEntity

/**
 * Created by Nadya N. on 06.03.2025.
 */
data class MainFragmentState(
    val isLoading: Boolean = false,
    val books: List<BookUIEntity> = listOf(),
)