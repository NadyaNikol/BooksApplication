package com.example.booksapplication.domain.repositories

import android.annotation.SuppressLint
import android.content.Context
import androidx.room.Room
import com.example.booksapplication.data.database.AppRoomDatabase

/**
 * Created by Nadya N. on 10.12.2024.
 */

@SuppressLint("StaticFieldLeak")
object RepositoriesLocator {

    private lateinit var context: Context

    val repository
        get() = Room.databaseBuilder(context, AppRoomDatabase::class.java, "books").build()

    fun setContext(context: Context) {
        this.context = context
    }
}