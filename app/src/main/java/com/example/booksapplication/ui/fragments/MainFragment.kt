package com.example.booksapplication.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.booksapplication.databinding.FragmentMainBinding
import com.example.booksapplication.ui.adapters.BookListAdapter
import com.example.booksapplication.ui.viewModels.MainViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

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
//        initListeners()
        initObserves()
    }

    private fun initRecyclerView() {
        binding.rvBooks.apply {
            adapter = bookListAdapter
//            addItemDecoration(SpaceDecoration(OFFSET))
        }
        // лісенер на якомі ітемі
    }

    private fun initObserves() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.onEach {
                    bookListAdapter.submitList(it.books)
                }.launchIn(this)

            }
        }
    }

}