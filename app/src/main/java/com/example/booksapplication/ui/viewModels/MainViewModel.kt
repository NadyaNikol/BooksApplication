package com.example.booksapplication.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booksapplication.domain.repositories.BookRepositoryImpl
import com.example.booksapplication.ui.MainFragmentState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * Created by Nadya N. on 10.12.2024.
 */
class MainViewModel : ViewModel() {

    private val repository = BookRepositoryImpl()

    private val bookFlow = repository.booksFlow.onEach { books ->
        _uiState.update {
            it.copy(
                isLoading = false,
                books = books
            )
        }
    }

    private val _uiState = MutableStateFlow(MainFragmentState())
    val uiState: StateFlow<MainFragmentState> = _uiState.asStateFlow()

    init {
        bookFlow.launchIn(viewModelScope)

        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllBooks()
        }
//            getBookListUseCase().collect { books ->
//
//                withContext(Dispatchers.Main) {
//                    Log.d("OBSERV_TEST", ": init")
//                    _bookFlow.value = books
//                }
//            }
//        }
    }

//    fun insertRandomBook() {
//        clearInsertResult()
//        viewModelScope.launch(Dispatchers.IO) {
//            withContext(Dispatchers.Main) {
//                _insertResult.update { insertBookUseCase(generateRandomBook()) }
//            }
//        }
//    }

//    fun update(bookEntity: BookEntity) {
//        viewModelScope.launch {
//            service.updateEntity(bookEntity)
//        }
//    }


//    private fun generateRandomBook(): BookUIEntity =
//        BookUIEntity(
//            name = "Book-${GeneralUtil.generateRandomString(10)}",
//            genre = Genre.entries.toTypedArray().random(),
//            rating = 1 + Random.nextFloat() * 4,
//            releaseYear = Random.nextInt(1980, 2022),
//            author = "Author-${GeneralUtil.generateRandomString(7)}",
//            description = GeneralUtil.generateRandomString(Random.nextInt(100, 3000)),
//            language = Language.entries.toTypedArray().random(),
//            numberOfPages = Random.nextInt(100, 1000),
//            imageUrl = UrlUtil.getRandomImage()
//        )

}
