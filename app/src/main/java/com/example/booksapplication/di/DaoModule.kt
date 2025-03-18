package com.example.booksapplication.di

import com.example.booksapplication.data.database.AppRoomDatabase
import com.example.booksapplication.data.database.BooksDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Nadya N. on 18.03.2025.
 */

@Module
@InstallIn(SingletonComponent::class)
class DaoModule {

    @Provides
    @Singleton
    fun provideBooksDao(appRoomDatabase: AppRoomDatabase): BooksDao = appRoomDatabase.getBookDao()
}