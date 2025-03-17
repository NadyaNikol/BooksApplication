package com.example.booksapplication.ui.main.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booksapplication.domain.repositories.BookRepositoryImpl
import com.example.booksapplication.ui.MainFragmentPageableState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * Created by Nadya N. on 10.12.2024.
 */
class MainViewModel : ViewModel() {

    private val repository = BookRepositoryImpl()

//    private val bookFlow = repository.booksFlow.onEach { books ->
//        if (books.isEmpty()) {
//            loadMoreItems()
//        }
//
//        _uiState.update {
//            it.copy(
////                isLoading = false,
//                books = books
//            )
//        }
//        _uiStatePageable.update {
//            it.copy(
//                isLoading = false,
//                isLastPage = repository.isLastPage,
//                offset = books.size
//            )
//        }
//    }

//    private val _uiState = MutableStateFlow(MainFragmentState())
    private val _uiStatePageable = MutableStateFlow(MainFragmentPageableState())
    val uiStatePageable = _uiStatePageable
//    val uiState: StateFlow<MainFragmentState> = _uiState

    private val bookFlow = repository.booksFlow
        .onEach { books ->
            Log.d("INIT_BOOKS", ": ${books.size}")
            if (books.isEmpty()) {
                loadMoreItems()
            }

            _uiStatePageable.update {
                it.copy(
                    isLoading = false,
                    isLastPage = repository.isLastPage,
                    offset = books.size,
                    books = books
                )
            }
        }

    init {
        bookFlow.launchIn(viewModelScope)
//        loadMoreItems()
    }

    fun loadMoreItems(query: String = "") {
        viewModelScope.launch {
            repository.upsertAllBooks(_uiStatePageable.value.offset, query)
            _uiStatePageable.update { it.copy(isLoading = true) }
        }
    }

//    fun insertRandomBook() {
//        clearInsertResult()
//        viewModelScope.launch(Dispatchers.IO) {
//            withContext(Dispatchers.Main) {
//                _insertResult.update { insertBookUseCase(generateRandomBook()) }
//            }
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
