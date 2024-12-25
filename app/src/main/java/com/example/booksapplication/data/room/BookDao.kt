package com.example.booksapplication.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 * Created by Nadya N. on 10.12.2024.
 */
@Dao
interface BookDao {

    @Query("SELECT * FROM Bookdbentity")
    fun getBooksList(): Flow<List<BookDbEntity>>

    @Insert
    fun insertBook(bookDbEntity: BookDbEntity)

    @Update
    fun updateBook(bookDbEntity: BookDbEntity)

    @Query("SELECT * FROM Bookdbentity WHERE NAME LIKE :name")
    fun getBookByName(name: String):Flow<List<BookDbEntity>>
}