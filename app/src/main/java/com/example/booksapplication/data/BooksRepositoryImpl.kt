package com.example.booksapplication.data

import android.util.Log
import com.example.booksapplication.data.api.BookApi
import com.example.booksapplication.data.database.BookDao
import com.example.booksapplication.domain.repositories.BooksRepository
import com.example.booksapplication.domain.repositories.RepositoriesLocator
import com.example.booksapplication.utils.extensions.getBooks
import com.example.booksapplication.utils.extensions.mapToDBEntity
import com.example.booksapplication.utils.extensions.mapToUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

/**
 * Created by Nadya N. on 05.03.2025.
 */
class BooksRepositoryImpl(
    private val dao: BookDao = RepositoriesLocator.repository.getBookDao(),
    private val bookApi: BookApi = DataSourceLocator.provideBookApi(),

    ): BooksRepository {

    val booksFlow = dao.getAllBooks().map { it.mapToUI() }

    var isLastPage = false

//    override suspend fun searchBooks(query: String) = withContext(Dispatchers.IO) {
//        localeDataSource.searchBooksByTitle(query).map { it.mapToUI() }
//    }

    override suspend fun upsertAllBooks(offset: Int, query: String?) = withContext(Dispatchers.IO) {
        runCatching {
//            val res = getAllBooksApi(offset, query)
            val res = bookApi.getAllBooks(offset , query).getBooks()
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