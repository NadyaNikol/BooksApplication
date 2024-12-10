package com.example.booksapplication.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

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