package com.example.booksapplication.data.useCases

import com.example.booksapplication.data.entities.BookEntity

/**
 * Created by Nadya N. on 20.01.2025.
 */
class ValidationInsertBookUseCase() {

    fun execute(bookEntity: BookEntity): ValidationResult {
        if (bookEntity.name.isBlank()) {
            return ValidationResult(success = false, errorMessage = "Name is empty")
        }

        if (bookEntity.rating < 1 || bookEntity.rating > 10) {
            return ValidationResult(
                success = false,
                errorMessage = "Rating must be between 1 and 10"
            )
        }

        if (!Regex("^[0-9]{4}\$").matches(bookEntity.releaseYear.toString())) {
            return ValidationResult(
                success = false,
                errorMessage = "Release year must be a positive four-digit number"
            )
        }

        if (bookEntity.author.isBlank()) {
            return ValidationResult(success = false, errorMessage = "Author is empty")
        }

        if (bookEntity.description.isBlank()) {
            return ValidationResult(success = false, errorMessage = "Description is empty")
        }

        if (bookEntity.numberOfPages < 1) {
            return ValidationResult(
                success = false,
                errorMessage = "Number of pages must be at least 1"
            )
        }

        if (bookEntity.imageUrl.isBlank()) {
            return ValidationResult(success = false, errorMessage = "image URL is empty")
        }

        return ValidationResult(success = true)
    }
}