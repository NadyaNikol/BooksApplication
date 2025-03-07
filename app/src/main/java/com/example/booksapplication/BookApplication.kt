package com.example.booksapplication

import android.app.Application
import com.example.booksapplication.domain.repositories.RepositoriesLocator

/**
 * Created by Nadya N. on 10.12.2024.
 */
class BookApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        RepositoriesLocator.setContext(applicationContext)
    }
}