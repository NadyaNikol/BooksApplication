package com.example.booksapplication.data.useCases

import com.example.booksapplication.data.entities.BookEntity

/**
 * Created by Nadya N. on 20.01.2025.
 */
class ValidationInsertBookUseCase() {

    fun execute(bookEntity: BookEntity): ValidationResult {
        if (bookEntity.name.isBlank()) {
            return ValidationResult(success = false, errorMessage = "name is empty")
        }

        if (bookEntity.genre.toString().isBlank()) {
            return ValidationResult(success = false, errorMessage = "genre is empty")
        }

        if (bookEntity.rating < 1 || bookEntity.rating > 10) {
            return ValidationResult(
                success = false,
                errorMessage = "rating must be between 1 and 10"
            )
        }

//            if (bookEntity.releaseYear > Year.now().value) {
//                return ValidationResult(success = false, errorMessage = "release year must be in the past or present")
//            }

        if (bookEntity.author.isBlank()) {
            return ValidationResult(success = false, errorMessage = "author is empty")
        }

        if (bookEntity.description.isBlank()) {
            return ValidationResult(success = false, errorMessage = "description is empty")
        }

        if (bookEntity.language.toString().isBlank()) {
            return ValidationResult(success = false, errorMessage = "language is empty")
        }

        if (bookEntity.numberOfPages < 1) {
            return ValidationResult(
                success = false,
                errorMessage = "number of pages must be at least 1"
            )
        }

        if (bookEntity.imageUrl.isBlank()) {
            return ValidationResult(success = false, errorMessage = "image URL is empty")
        }

        return ValidationResult(success = true)
    }
}