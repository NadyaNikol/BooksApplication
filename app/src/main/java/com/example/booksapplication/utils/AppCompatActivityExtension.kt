package com.example.booksapplication.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * Created by Nadya N. on 16.01.2025.
 */

inline fun <reified E, reified F : Flow<E>> AppCompatActivity.collect(
    flow: F,
    crossinline collector: suspend (E) -> Unit
) {
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            flow.collectLatest {
                collector(it)
            }
        }
    }
}