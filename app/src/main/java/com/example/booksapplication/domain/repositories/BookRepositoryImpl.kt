package com.example.booksapplication.domain.repositories

import android.util.Log
import com.example.booksapplication.data.dataSources.locale.LocaleDataSource
import com.example.booksapplication.data.dataSources.locale.LocaleDataSourceImpl
import com.example.booksapplication.data.dataSources.remote.RemoteDataSource
import com.example.booksapplication.data.dataSources.remote.RemoteDataSourceImpl
import com.example.booksapplication.utils.extensions.mapToDBEntity
import com.example.booksapplication.utils.extensions.mapToUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

/**
 * Created by Nadya N. on 05.03.2025.
 */
class BookRepositoryImpl(
    private val localeDataSource: LocaleDataSource = LocaleDataSourceImpl(RepositoriesLocator.repository.getBookDao()),
    private val remoteDataSource: RemoteDataSource = RemoteDataSourceImpl()
): BookRepository {

    val booksFlow = localeDataSource.getAllBooks().map { it.mapToUI() }

    var isLastPage = false

    fun getBooksFlow(query: String) =
        localeDataSource.searchBooksByTitle(query).map { it.mapToUI() }

    override suspend fun searchBooks(query: String) = withContext(Dispatchers.IO) {
        localeDataSource.searchBooksByTitle(query).map { it.mapToUI() }
    }

    override suspend fun upsertAllBooks(offset: Int, query: String?) = withContext(Dispatchers.IO) {
        runCatching {
            val res = remoteDataSource.getAllBooks(offset, query)
            Log.d("INIT_BOOKS", "getAllBooks: query: ${query}, books: ${res.books}")
            res
        }.onSuccess { apiResponse ->
            localeDataSource.upsertBooks(apiResponse.books.flatten().mapToDBEntity())
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