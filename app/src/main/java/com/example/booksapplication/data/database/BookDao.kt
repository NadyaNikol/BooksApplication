package com.example.booksapplication.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.example.booksapplication.domain.entities.BookDbEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by Nadya N. on 10.12.2024.
 */
@Dao
interface BookDao {

    @Query("SELECT * FROM Bookdbentity")
    fun getAllBooks(): Flow<List<BookDbEntity>>

    @Query("SELECT * FROM Bookdbentity WHERE ID = :id")
    fun getBookWithDetailInfoById(id: String):Flow<BookDbEntity>

    @Upsert
    fun upsertBook(bookDbEntity: BookDbEntity)

    @Insert
    fun insertBooks(books: List<BookDbEntity>)

    @Insert
    fun insertBook(bookDbEntity: BookDbEntity)

}