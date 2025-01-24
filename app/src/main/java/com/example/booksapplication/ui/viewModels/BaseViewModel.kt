package com.example.booksapplication.ui.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import org.jetbrains.annotations.TestOnly

/**
 * Created by Nadya N. on 16.01.2025.
 */
abstract class BaseViewModel : ViewModel() {

    private var test: Boolean = false

    private val ioJob = Job()
    private val mainJob = Job()

    private val defaultScope = CoroutineScope(Dispatchers.Main)
    private val viewModelMainScope = CoroutineScope(Dispatchers.Main + mainJob)
    private val viewModelIoScope = CoroutineScope(Dispatchers.IO + ioJob)

    protected val ioScope: CoroutineScope
        get() {
            return if (test) {
                defaultScope
            } else {
                viewModelIoScope
            }
        }

    protected val mainScope: CoroutineScope
        get() {
            return if (test) {
                defaultScope
            } else {
                viewModelMainScope
            }
        }

    override fun onCleared() {
        ioJob.cancel()
        mainJob.cancel()
        super.onCleared()
    }

    @TestOnly
    fun prepareForTest() {
        test = true
    }

}