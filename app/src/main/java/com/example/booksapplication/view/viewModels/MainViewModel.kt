package com.example.booksapplication.view.viewModels

import com.example.booksapplication.data.entities.BookEntity
import com.example.booksapplication.data.useCases.GetBookByNameUseCase
import com.example.booksapplication.data.useCases.GetBookListUseCase
import com.example.booksapplication.data.useCases.InsertBookUseCase
import com.example.booksapplication.services.BookService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * Created by Nadya N. on 10.12.2024.
 */
class MainViewModel : BaseViewModel() {

    private val service = BookService()
    private val getBookListUseCase = GetBookListUseCase(service)
    private val getBookByNameUseCase = GetBookByNameUseCase(service)
    private val insertBookUseCase = InsertBookUseCase(service)

    private val _bookFlow: MutableStateFlow<List<BookEntity>> = MutableStateFlow(emptyList())
    val bookFlow: StateFlow<List<BookEntity>> = _bookFlow

    fun initData() {
        ioScope.launch {
            getBookListUseCase.invoke().collect { books ->
                mainScope.launch {
                    _bookFlow.value = books
                }
            }
        }
    }

    fun insert(bookEntity: BookEntity) {
        ioScope.launch {
            insertBookUseCase.invoke(bookEntity)
        }
    }

//    fun update(bookEntity: BookEntity) {
//        viewModelScope.launch {
//            service.updateEntity(bookEntity)
//        }
//    }

    fun searchByName(name: String) {
        ioScope.launch {
            getBookByNameUseCase.invoke(name)
        }
    }

}