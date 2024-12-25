package com.example.booksapplication.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.booksapplication.data.entities.BookEntity
import com.example.booksapplication.data.entities.Genre
import com.example.booksapplication.data.entities.Language
import com.example.booksapplication.databinding.FragmentMainBinding
import com.example.booksapplication.utils.GeneralUtil
import com.example.booksapplication.utils.SpaceDecoration
import com.example.booksapplication.utils.UrlUtil
import com.example.booksapplication.view.BookListAdapter
import com.example.booksapplication.view.viewModels.MainViewModel
import kotlin.random.Random

class MainFragment :
    BaseFragment<FragmentMainBinding>(
        FragmentMainBinding::inflate
    ) {

    private val viewModel by viewModels<MainViewModel>()
    private lateinit var bookListAdapter: BookListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bookListAdapter = BookListAdapter()

        viewModel.initData()
        initRecyclerView()
        initListeners()
        initObserves()
    }

    private fun initRecyclerView() {
        binding.rvBooks.apply {
            adapter = bookListAdapter
            addItemDecoration(SpaceDecoration(OFFSET))
        }
    }

    private fun initObserves() {
        viewModel.bookLiveData.observe(viewLifecycleOwner) {
            bookListAdapter.submitList(it)
        }
    }

    private fun initListeners() {
        binding.fabAddBook.setOnClickListener {
            viewModel.insert(generateRandomBook())
        }
    }

    private fun generateRandomBook(): BookEntity =
        BookEntity(
            name = "Book-${GeneralUtil.generateRandomString(10)}",
            genre = Genre.entries.toTypedArray().random(),
            rating = Random.nextInt(1, 5),
            releaseYear = Random.nextInt(1980, 2022),
            author = "Author-${GeneralUtil.generateRandomString(7)}",
            description = GeneralUtil.generateRandomString(Random.nextInt(100, 300)),
            language = Language.entries.toTypedArray().random(),
            numberOfPages = Random.nextInt(100, 1000),
            imageUrl = UrlUtil.getRandomImage()
        )

    companion object {
        private const val OFFSET = 20
    }

}