package com.example.booksapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.booksapplication.data.entities.BookEntity
import com.example.booksapplication.data.entities.Genre
import com.example.booksapplication.data.entities.Language
import com.example.booksapplication.databinding.ActivityMainBinding
import com.example.booksapplication.view.BookListAdapter
import com.example.booksapplication.view.utils.GeneralUtil
import com.example.booksapplication.view.viewModels.MainViewModel
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()
    private lateinit var bookListAdapter: BookListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        bookListAdapter = BookListAdapter()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewModel.initData()
        initRecyclerView()
        initListeners()
        initObserves()
    }

    private fun initRecyclerView() {
        binding.rvBooks.apply {
            adapter = bookListAdapter
        }
    }

    private fun initObserves() {
        viewModel.bookLiveData.observe(this){
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
        )
}