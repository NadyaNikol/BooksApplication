package com.example.booksapplication.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.booksapplication.databinding.FragmentMainBinding
import com.example.booksapplication.ui.adapters.BookListAdapter
import com.example.booksapplication.ui.listeners.EndlessScrollListener
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
        bookListAdapter = BookListAdapter { id ->
            findNavController().navigate(
                MainFragmentDirections.actionMainFragmentToBookDetailInfoFragment(
                    bookId = id
                )
            )
        }

        initRecyclerView()
//        initListeners()
        initObserves()
    }

    private fun initRecyclerView() {
        val layoutManagerRV = LinearLayoutManager(requireContext())
        binding.rvBooks.apply {
            adapter = bookListAdapter
            layoutManager = layoutManagerRV

            addOnScrollListener(object: EndlessScrollListener(layoutManagerRV){
                override fun loadMoreItems() {
                    viewModel.loadMoreItems()
                }

                val value = viewModel.uiStatePageable.value

                override fun isLastPage()  = value.isLastPage
                override fun isLoading() =  value.isLoading
            })
//            addItemDecoration(SpaceDecoration(OFFSET))
        }
    }

    private fun initObserves() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiStatePageable.onEach {
                    bookListAdapter.submitList(it.books)
                }.launchIn(this)
            }
        }
    }

}