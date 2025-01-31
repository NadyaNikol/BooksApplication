package com.example.booksapplication.utils.extensions

/**
* Created by Nadya N. on 29.01.2025.
*/

fun <T : Enum<T>> T.showToLowercase(): String {
    return this.toString().lowercase()
}