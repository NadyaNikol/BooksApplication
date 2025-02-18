package com.example.booksapplication.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booksapplication.data.entities.BookEntity
import com.example.booksapplication.data.entities.Genre
import com.example.booksapplication.data.entities.Language
import com.example.booksapplication.data.services.BookService
import com.example.booksapplication.data.useCases.GetBookListUseCase
import com.example.booksapplication.data.useCases.InsertBookUseCase
import com.example.booksapplication.utils.GeneralUtil
import com.example.booksapplication.utils.UrlUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.random.Random

/**
 * Created by Nadya N. on 10.12.2024.
 */
class MainViewModel : BaseViewModel() {
class MainViewModel : ViewModel() {

    private val service = BookService()
    private val getBookListUseCase = GetBookListUseCase(service)
//    private val getBookByNameUseCase = GetBookByNameUseCase(service)
    private val insertBookUseCase = InsertBookUseCase(service)

    private val _insertResult: MutableStateFlow<Boolean?> = MutableStateFlow(null)
    val insertResult: StateFlow<Boolean?> = _insertResult

    private val _bookFlow: MutableStateFlow<List<BookEntity>> = MutableStateFlow(emptyList())
    val bookFlow: StateFlow<List<BookEntity>> = _bookFlow

    fun clearInsertResult(){
        _insertResult.value = null
    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getBookListUseCase().collect { books ->

                withContext(Dispatchers.Main) {
                    _bookFlow.value = books
                }
            }
        }
    }

    fun insertRandomBook() {
        clearInsertResult()
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {
                _insertResult.update { insertBookUseCase(generateRandomBook()) }
            }
        }
    }

//    fun update(bookEntity: BookEntity) {
//        viewModelScope.launch {
//            service.updateEntity(bookEntity)
//        }
//    }

//    fun searchByName(name: String) {
//        viewModelScope.launch(Dispatchers.IO) {
//            getBookByNameUseCase.invoke(name)
//        }
//    }

    private fun generateRandomBook(): BookEntity =
        BookEntity(
            name = "Book-${GeneralUtil.generateRandomString(10)}",
            genre = Genre.entries.toTypedArray().random(),
            rating = 1 + Random.nextFloat() * 4,
            releaseYear = Random.nextInt(1980, 2022),
            author = "Author-${GeneralUtil.generateRandomString(7)}",
            description = GeneralUtil.generateRandomString(Random.nextInt(100, 3000)),
            language = Language.entries.toTypedArray().random(),
            numberOfPages = Random.nextInt(100, 1000),
            imageUrl = UrlUtil.getRandomImage()
        )

}