package com.example.booksapplication.data.useCases

import com.example.booksapplication.data.entities.BookEntity
import com.example.booksapplication.exceptions.ValidationInsertBookException

/**
 * Created by Nadya N. on 20.01.2025.
 */
class ValidationInsertBookUseCase() {

    operator fun invoke(bookEntity: BookEntity): ValidationResult {
        if (bookEntity.name.isBlank()) {
            return ValidationResult.Error(ValidationInsertBookException("Name is empty"))
        }

        if (bookEntity.rating < 1 || bookEntity.rating > 10) {
            return ValidationResult.Error(ValidationInsertBookException("Rating must be between 1 and 10"))
        }

        if (!Regex("^[0-9]{4}\$").matches(bookEntity.releaseYear.toString())) {
            return ValidationResult.Error(ValidationInsertBookException("Release year must be a positive four-digit number"))
        }

        if (bookEntity.author.isBlank()) {
            return ValidationResult.Error(ValidationInsertBookException("Author is empty"))
        }

        if (bookEntity.description.isBlank()) {
            return ValidationResult.Error(ValidationInsertBookException("Description is empty"))
        }

        if (bookEntity.numberOfPages < 1) {
            ValidationResult.Error(ValidationInsertBookException("Number of pages must be at least 1"))
        }

        if (bookEntity.imageUrl.isBlank()) {
            ValidationResult.Error(ValidationInsertBookException("Image URL is empty"))
        }

        return ValidationResult.Success("Data is valid")
    }
}