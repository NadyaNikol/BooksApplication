package com.example.booksapplication.applications

import android.app.Application
import com.example.booksapplication.data.repositories.RepositoriesLocator

/**
 * Created by Nadya N. on 10.12.2024.
 */
class BookApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        RepositoriesLocator.setContext(applicationContext)
    }
}