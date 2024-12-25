package com.example.booksapplication.data.repositories

import kotlinx.coroutines.flow.Flow

/**
 * Created by Nadya N. on 10.12.2024.
 */
interface GetRepository<T> {

    suspend fun getListEntities(): Flow<List<T>>

}
