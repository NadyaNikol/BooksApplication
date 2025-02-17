package com.example.booksapplication.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import androidx.fragment.app.viewModels
import com.example.booksapplication.databinding.FragmentMainBinding
import com.example.booksapplication.utils.extensions.collect
import com.example.booksapplication.utils.extensions.setGravity
import com.example.booksapplication.utils.extensions.setMargins
import com.example.booksapplication.ui.adapters.BookListAdapter
import com.example.booksapplication.ui.viewModels.MainViewModel
import com.google.android.material.snackbar.Snackbar

class MainFragment :
    BaseFragment<FragmentMainBinding>(
        FragmentMainBinding::inflate
    ) {

    private val viewModel by viewModels<MainViewModel>()
    private lateinit var bookListAdapter: BookListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bookListAdapter = BookListAdapter()

        initRecyclerView()
        initListeners()
        initObserves(view)
    }

    override fun onStart() {
        super.onStart()
        viewModel.clearInsertResult()
    }

    private fun initRecyclerView() {
        binding.rvBooks.apply {
            adapter = bookListAdapter
//            addItemDecoration(SpaceDecoration(OFFSET))
        }
    }

    private fun initObserves(view: View) {
        collect(viewModel.bookFlow) { books ->
            bookListAdapter.submitList(books)
        }

        collect(viewModel.insertResult) {

            if (it != null) {
                val snackbarMessage = if (it) {
                    "The book has been successfully added"
                } else {
                    "Sorry, an error occurred. Repeat the action after a few seconds"
                }

                val snackBar = Snackbar.make(view, snackbarMessage, Snackbar.LENGTH_SHORT)
                snackBar.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL)
                snackBar.setMargins(0, 100, 0, 0)

                snackBar.show()
            } else {
                Log.d(this::class.java.simpleName, "initObserves: it null")
            }
        }
    }

    private fun initListeners() {
        binding.fabAddBook.setOnClickListener {
            viewModel.insertRandomBook()
        }
    }

    companion object {
        private const val OFFSET = 20
    }

}