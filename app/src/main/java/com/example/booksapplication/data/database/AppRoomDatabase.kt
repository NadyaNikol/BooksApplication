package com.example.booksapplication.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.booksapplication.domain.entities.BookDbEntity

/**
 * Created by Nadya N. on 10.12.2024.
 */
@Database(
    entities = [BookDbEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppRoomDatabase : RoomDatabase(){

    abstract fun getBookDao(): BookDao
}