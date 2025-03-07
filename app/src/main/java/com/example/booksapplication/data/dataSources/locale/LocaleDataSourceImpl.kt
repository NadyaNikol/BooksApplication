package com.example.booksapplication.data.dataSources.locale

import com.example.booksapplication.data.database.BookDao
import com.example.booksapplication.domain.entities.BookDbEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by Nadya N. on 05.03.2025.
 */
class LocaleDataSourceImpl(
    private val dao: BookDao
):LocaleDataSource {
    override fun getAllBooks(): Flow<List<BookDbEntity>> =
        dao.getAllBooks()

    override suspend fun getBookById(id: String): Flow<BookDbEntity> =
        dao.getBookWithDetailInfoById(id)

    override suspend fun upsertBook(book: BookDbEntity) {
        dao.upsertBook(book)
    }

    override suspend fun upsertBooks(books: List<BookDbEntity>) =
        dao.insertBooks(books)

    override suspend fun insertBook(bookDbEntity: BookDbEntity) =
        dao.insertBook(bookDbEntity)
}