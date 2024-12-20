package com.example.booksapplication.view.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booksapplication.data.entities.BookEntity
import com.example.booksapplication.data.repositories.RepositoriesLocator
import kotlinx.coroutines.launch

/**
 * Created by Nadya N. on 10.12.2024.
 */
class MainViewModel : ViewModel() {

    private val repository = RepositoriesLocator.repository

    private var _bookLiveData: MutableLiveData<List<BookEntity>> = MutableLiveData()
    val bookLiveData: LiveData<List<BookEntity>> = _bookLiveData

    fun initData() {
        viewModelScope.launch {
            repository.getBooksList().collect {
                _bookLiveData.value = it
            }
        }
    }

    fun insert(bookEntity: BookEntity) {
        viewModelScope.launch {
            repository.insertBook(bookEntity)
        }
    }

    fun update(bookEntity: BookEntity) {
        viewModelScope.launch {
            repository.updateBook(bookEntity)
        }
    }

    fun searchByName(name:String){
        viewModelScope.launch {
            repository.getBookByName(name)
        }
    }

}