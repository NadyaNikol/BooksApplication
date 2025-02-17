package com.example.booksapplication.data.useCases

/**
 * Created by Nadya N. on 20.01.2025.
 */
sealed class ValidationResult {
    data class Success(val data: String) : ValidationResult()
    data class Error(val exception: Throwable) : ValidationResult()
}