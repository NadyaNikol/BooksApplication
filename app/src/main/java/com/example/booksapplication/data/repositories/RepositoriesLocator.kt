package com.example.booksapplication.data.repositories

import android.annotation.SuppressLint
import android.content.Context
import androidx.room.Room
import com.example.booksapplication.data.room.AppRoomDatabase

/**
 * Created by Nadya N. on 10.12.2024.
 */
@SuppressLint("StaticFieldLeak")
object RepositoriesLocator {

    private lateinit var context: Context
    private val db by lazy(mode = LazyThreadSafetyMode.NONE) {
        Room.databaseBuilder(context, AppRoomDatabase::class.java, "books").build()
    }

    val repository by lazy { RoomBookRepository(db.getBookDao()) }

    fun setContext(context: Context) {
        RepositoriesLocator.context = context
    }
}