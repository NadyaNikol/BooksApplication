package com.example.booksapplication.di

import android.content.Context
import androidx.room.Room
import com.example.booksapplication.data.database.AppRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Nadya N. on 18.03.2025.
 */

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideBooksDatabase(@ApplicationContext applicationContext: Context): AppRoomDatabase =
        Room.databaseBuilder(applicationContext, AppRoomDatabase::class.java, "books").build()
}