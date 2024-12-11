package com.example.booksapplication.view.utils

/**
 * Created by Nadya N. on 11.12.2024.
 */
object UrlUtil {

    private val urls: List<String> = listOf(
        "https://cdn.kobo.com/book-images/6aeddaea-e470-46a9-9c22-ac30b1a8fb5c/353/569/90/False/book-of-names-2.jpg",
        "https://patrickrothfuss.com/images/page/NarrowRoadBetweenDesiresHiRes.jpg",
        "https://apps.lib.umich.edu/online-exhibits/files/fullsize/5201c9bf8961435432b66d8828de237b.jpg",
        "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1546096879i/2956._SX50_.jpg",
        "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1546103428i/5297._SY75_.jpg",
        "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1337714526i/34268._SX50_.jpg",
        "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1461452762i/58696.jpg",
        "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1474169725i/15881.jpg",
        "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1554006152i/6.jpg",
        "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1630547330i/5.jpg"

    )

    fun getRandomImage(): String {
        return urls.random()
    }
}