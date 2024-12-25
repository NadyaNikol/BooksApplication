package com.example.booksapplication.data.repositories

import com.example.booksapplication.data.entities.BookEntity
import com.example.booksapplication.data.room.BookDao
import com.example.booksapplication.data.room.BookDbEntity
import com.example.booksapplication.utils.fromEntity
import com.example.booksapplication.utils.toEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

/**
 * Created by Nadya N. on 10.12.2024.
 */
class RoomBookRepository(
    private val bookDao: BookDao,

    ) : SaveRepository<BookEntity>, GetRepository<BookEntity> {
    override suspend fun getListEntities(): Flow<List<BookEntity>> = withContext(Dispatchers.IO) {
        return@withContext bookDao.getBooksList().map { bookList: List<BookDbEntity> ->
            bookList.map {
                it.toEntity()
            }
        }
    }

    override suspend fun insertEntity(bookEntity: BookEntity) = withContext(Dispatchers.IO) {
        bookDao.insertBook(bookEntity.fromEntity())
    }

    override suspend fun updateEntity(bookEntity: BookEntity) = withContext(Dispatchers.IO) {
        bookDao.updateBook(bookEntity.fromEntity())
    }

    suspend fun getBookByName(name: String): Flow<List<BookEntity>> = withContext(Dispatchers.IO) {
        return@withContext bookDao.getBookByName(name).map { bookList: List<BookDbEntity> ->
            bookList.map {
                it.toEntity()
            }
        }
    }
}