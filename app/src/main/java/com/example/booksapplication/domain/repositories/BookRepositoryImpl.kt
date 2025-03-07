package com.example.booksapplication.domain.repositories

import android.util.Log
import com.example.booksapplication.data.dataSources.locale.LocaleDataSource
import com.example.booksapplication.data.dataSources.locale.LocaleDataSourceImpl
import com.example.booksapplication.data.dataSources.remote.RemoteDataSource
import com.example.booksapplication.data.dataSources.remote.RemoteDataSourceImpl
import com.example.booksapplication.utils.extensions.mapToDBEntity
import com.example.booksapplication.utils.extensions.mapToUI
import kotlinx.coroutines.flow.map

/**
 * Created by Nadya N. on 05.03.2025.
 */
class BookRepositoryImpl(
    private val localeDataSource: LocaleDataSource = LocaleDataSourceImpl(RepositoriesLocator.repository.getBookDao()),
    private val remoteDataSource: RemoteDataSource = RemoteDataSourceImpl()
): BookRepository {

    val booksFlow = localeDataSource.getAllBooks().map { it.mapToUI() }

    override suspend fun getAllBooks() {
        runCatching {
            val res = remoteDataSource.getAllBooks()
            Log.d("INIT_BOOKS", "getAllBooks: ${res.books}")
            res
        }.onSuccess {apiResponse ->
            localeDataSource.upsertBooks(apiResponse.books.mapToDBEntity())
        }.onFailure {

        }
    }

    override suspend fun getBookById(id:String) {
        // беру з бази, якщо немає, то витягую з апі і записую в базу
//        runCatching {
//            remoteDataSource.getBookById(id)
//        }.onSuccess {apiResponse ->
//            localeDataSource.upsertBook(apiResponse.mapToDBEntity())
//        }
    }

}