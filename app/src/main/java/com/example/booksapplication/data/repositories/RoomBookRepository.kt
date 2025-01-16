package com.example.booksapplication.data.repositories

import com.example.booksapplication.data.room.BookDao
import com.example.booksapplication.data.room.BookDbEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

/**
 * Created by Nadya N. on 10.12.2024.
 */
class RoomBookRepository(
    private val bookDao: BookDao,

    ) : SaveRepository<BookDbEntity>, GetRepository<BookDbEntity> {
    override suspend fun getListEntities(): Flow<List<BookDbEntity>> = withContext(Dispatchers.IO) {
        return@withContext bookDao.getBooksList()
    }

    override suspend fun insertEntity(bookEntity: BookDbEntity) = withContext(Dispatchers.IO) {
        bookDao.insertBook(bookEntity)
    }

    override suspend fun updateEntity(bookEntity: BookDbEntity) = withContext(Dispatchers.IO) {
        bookDao.updateBook(bookEntity)
    }

    suspend fun getBookByName(name: String): Flow<List<BookDbEntity>> = withContext(Dispatchers.IO) {
        return@withContext bookDao.getBookByName(name)
    }
}