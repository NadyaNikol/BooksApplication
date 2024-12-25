package com.example.booksapplication.utils

import kotlin.random.Random

/**
 * Created by Nadya N. on 10.12.2024.
 */
object GeneralUtil {

    fun generateRandomString(length: Int): String {
        val randomBytes = Random.nextBytes(length)
        return randomBytes.toBase64()
    }

    private fun ByteArray.toBase64(): String {
        val characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
        return this.joinToString(separator = "") {
            characters[(it.toInt() and 0xFF) % characters.length].toString()
        }
    }
}