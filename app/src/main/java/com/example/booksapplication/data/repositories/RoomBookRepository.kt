package com.example.booksapplication.data.repositories

import com.example.booksapplication.data.entities.BookEntity
import com.example.booksapplication.data.room.BookDao
import com.example.booksapplication.data.room.BookDbEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

/**
 * Created by Nadya N. on 10.12.2024.
 */
class RoomBookRepository(
    private val bookDao: BookDao,

    ) : BookRepository {
    override suspend fun getBooksList(): Flow<List<BookEntity>> = withContext(Dispatchers.IO) {
        return@withContext bookDao.getBooksList().map { bookList: List<BookDbEntity> ->
            bookList.map {
                it.toEntity()
            }
        }
    }

    override suspend fun insertBook(bookEntity: BookEntity) = withContext(Dispatchers.IO) {
        bookDao.insertBook(BookDbEntity.fromEntity(bookEntity))
    }

    override suspend fun updateBook(bookEntity: BookEntity) = withContext(Dispatchers.IO) {
        bookDao.updateBook(BookDbEntity.fromEntity(bookEntity))
    }

    override suspend fun getBookByName(name: String): Flow<List<BookEntity>> = withContext(Dispatchers.IO) {
        return@withContext bookDao.getBookByName(name).map { bookList: List<BookDbEntity> ->
            bookList.map {
                it.toEntity()
            }
        }
    }
}