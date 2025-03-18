package com.example.booksapplication.data

import android.util.Log
import com.example.booksapplication.data.api.BooksApi
import com.example.booksapplication.data.database.BooksDao
import com.example.booksapplication.domain.repositories.BooksRepository
import com.example.booksapplication.utils.extensions.getBooks
import com.example.booksapplication.utils.extensions.mapToDBEntity
import com.example.booksapplication.utils.extensions.mapToUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by Nadya N. on 05.03.2025.
 */
class BooksRepositoryImpl @Inject constructor(
    private val dao: BooksDao,
    private val booksApi: BooksApi,

    ): BooksRepository {

    override val booksFlow = dao.getAllBooks().map { it.mapToUI() }

    var isLastPage = false

//    override suspend fun searchBooks(query: String) = withContext(Dispatchers.IO) {
//        localeDataSource.searchBooksByTitle(query).map { it.mapToUI() }
//    }

    override suspend fun upsertAllBooks(offset: Int, query: String?) = withContext(Dispatchers.IO) {
        runCatching {
//            val res = getAllBooksApi(offset, query)
            val res = booksApi.getAllBooks(offset , query).getBooks()
            Log.d("INIT_BOOKS", "getAllBooks: query: ${query}, books: ${res.books}")
            res
        }.onSuccess { apiResponse ->
            dao.upsertBooks(apiResponse.books.flatten().mapToDBEntity())
            isLastPage = apiResponse.available.toInt() == offset
        }.onFailure {

            isLastPage = true
        }
    }

    override suspend fun getBookById(id:Long) {
        // беру з бази, якщо немає, то витягую з апі і записую в базу
//        runCatching {
//            remoteDataSource.getBookById(id)
//        }.onSuccess {apiResponse ->
//            localeDataSource.upsertBook(apiResponse.mapToDBEntity())
//        }
    }

}