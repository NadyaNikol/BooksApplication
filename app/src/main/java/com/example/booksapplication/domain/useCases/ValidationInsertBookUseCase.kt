//package com.example.booksapplication.domain.useCases
//
//import com.example.booksapplication.domain.entities.BookUIEntity
//import com.example.booksapplication.exceptions.ValidationInsertBookException
//
///**
// * Created by Nadya N. on 20.01.2025.
// */
//class ValidationInsertBookUseCase() {
//
//    operator fun invoke(bookUIEntity: BookUIEntity): ValidationResult {
//        if (bookUIEntity.name.isBlank()) {
//            return ValidationResult.Error(ValidationInsertBookException("Name is empty"))
//        }
//
//        if (bookUIEntity.rating < 1 || bookUIEntity.rating > 10) {
//            return ValidationResult.Error(ValidationInsertBookException("Rating must be between 1 and 10"))
//        }
//
//        if (!Regex("^[0-9]{4}\$").matches(bookUIEntity.releaseYear.toString())) {
//            return ValidationResult.Error(ValidationInsertBookException("Release year must be a positive four-digit number"))
//        }
//
//        if (bookUIEntity.author.isBlank()) {
//            return ValidationResult.Error(ValidationInsertBookException("Author is empty"))
//        }
//
//        if (bookUIEntity.description.isBlank()) {
//            return ValidationResult.Error(ValidationInsertBookException("Description is empty"))
//        }
//
//        if (bookUIEntity.numberOfPages < 1) {
//            ValidationResult.Error(ValidationInsertBookException("Number of pages must be at least 1"))
//        }
//
//        if (bookUIEntity.imageUrl.isBlank()) {
//            ValidationResult.Error(ValidationInsertBookException("Image URL is empty"))
//        }
//
//        return ValidationResult.Success("Data is valid")
//    }
//}