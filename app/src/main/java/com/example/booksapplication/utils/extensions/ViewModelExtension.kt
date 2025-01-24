package com.example.booksapplication.utils.extensions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * Created by Nadya N. on 16.01.2025.
 */

inline fun <reified E, reified F : Flow<E>> ViewModel.collect(
    flow: F,
    crossinline collector: suspend (E) -> Unit
) {
    viewModelScope.launch {
        flow.collectLatest {
            collector(it)
        }
    }
}