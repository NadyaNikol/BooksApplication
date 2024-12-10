package com.example.booksapplication.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.booksapplication.data.entities.BookEntity
import com.example.booksapplication.databinding.ListItemBookBinding

/**
 * Created by Nadya N. on 10.12.2024.
 */
class BookListAdapter : ListAdapter<BookEntity, RecyclerView.ViewHolder>(BookItemsCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BookItemHolder(
            binding = ListItemBookBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as BookItemHolder).bind(currentList[position])
    }


    private class BookItemHolder(
        private val binding: ListItemBookBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(bookEntity: BookEntity) {
            binding.apply {
                tvNameBook.text = bookEntity.name
                tvGenreBook.text = bookEntity.genre.toString()
                tvRatingBook.text = bookEntity.rating.toString()
                tvReleaseYearBook.text = bookEntity.releaseYear.toString()
                tvAuthorBook.text = bookEntity.author
                tvDescriptionBook.text = bookEntity.description
                tvLanguageBook.text = bookEntity.language.nameLanguage
                tvNumberPagesBook.text = bookEntity.numberOfPages.toString()
            }
        }
    }


    private object BookItemsCallback : DiffUtil.ItemCallback<BookEntity>() {
        override fun areItemsTheSame(oldItem: BookEntity, newItem: BookEntity): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: BookEntity, newItem: BookEntity): Boolean {
            return oldItem == newItem
        }

    }
}