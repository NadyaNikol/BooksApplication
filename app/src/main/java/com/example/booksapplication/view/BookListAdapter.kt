package com.example.booksapplication.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.booksapplication.R
import com.example.booksapplication.data.entities.BookEntity
import com.example.booksapplication.databinding.ListItemBookBinding
import com.example.booksapplication.view.utils.UrlUtil

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

        private val context: Context = binding.root.context

        fun bind(bookEntity: BookEntity) {
            binding.apply {
                tvNameBook.text = bookEntity.name
                tvGenreBook.text = context.getString(R.string.book_genre, bookEntity.genre)
                tvRatingBook.text = context.getString(R.string.book_rating, bookEntity.rating)
                tvReleaseYearBook.text = context.getString(R.string.book_release_year, bookEntity.releaseYear)
                tvAuthorBook.text = context.getString(R.string.book_author_name, bookEntity.author)
                tvDescriptionBook.text = bookEntity.description
                tvLanguageBook.text = bookEntity.language.nameLanguage
                tvNumberPagesBook.text = context.getString(R.string.book_number_pages, bookEntity.numberOfPages)

                Glide.with(context)
                    .load(UrlUtil.getRandomImage())
                    .apply(RequestOptions().placeholder(R.drawable.noun_sketchbook_224735))
                    .error(R.drawable.noun_sketchbook_224735)
                    .into(ivImageBook)
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