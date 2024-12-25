package com.example.booksapplication.view.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booksapplication.data.entities.BookEntity
import com.example.booksapplication.services.BookService
import kotlinx.coroutines.launch

/**
 * Created by Nadya N. on 10.12.2024.
 */
class MainViewModel : ViewModel() {

    private val service = BookService()

    private var _bookLiveData: MutableLiveData<List<BookEntity>> = MutableLiveData()
    val bookLiveData: LiveData<List<BookEntity>> = _bookLiveData

    fun initData() {
        viewModelScope.launch {
            service.getListEntities().collect {
                _bookLiveData.value = it
            }
        }
    }

    fun insert(bookEntity: BookEntity) {
        viewModelScope.launch {
            service.insertEntity(bookEntity)
        }
    }

    fun update(bookEntity: BookEntity) {
        viewModelScope.launch {
            service.updateEntity(bookEntity)
        }
    }

    fun searchByName(name:String){
        viewModelScope.launch {
            service.getBookByName(name)
        }
    }

}