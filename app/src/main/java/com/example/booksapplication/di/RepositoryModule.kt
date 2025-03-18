package com.example.booksapplication.di

import com.example.booksapplication.data.BooksRepositoryImpl
import com.example.booksapplication.domain.repositories.BooksRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Nadya N. on 17.03.2025.
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsBooksRepository(impl: BooksRepositoryImpl): BooksRepository
}