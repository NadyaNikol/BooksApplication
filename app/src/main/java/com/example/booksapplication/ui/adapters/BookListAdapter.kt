package com.example.booksapplication.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.booksapplication.R
import com.example.booksapplication.data.entities.BookEntity
import com.example.booksapplication.databinding.ListItemBookBinding
import com.example.booksapplication.ui.fragments.MainFragmentDirections
import com.example.booksapplication.utils.LoadImageBuilder
import com.example.booksapplication.utils.extensions.showToLowercase


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
                tvGenreBook.text =
                    context.getString(R.string.book_genre, bookEntity.genre.showToLowercase())
                tvAuthorBook.text = context.getString(R.string.book_author_name, bookEntity.author)
                tvLanguageBook.text = context.getString(
                    R.string.book_language,
                    bookEntity.language.toString().lowercase()
                )

                this@BookItemHolder.itemView.setOnClickListener { view ->
                    view.findNavController()
                        .navigate(
                            MainFragmentDirections.actionMainFragmentToBookDetailInfoFragment(
                                bookEntity = bookEntity
                            )
                        )
                }

                LoadImageBuilder(Glide.with(context))
                    .url(bookEntity.imageUrl)
                    .errorDrawable(R.drawable.noun_sketchbook_224735)
                    .placeholder(R.drawable.noun_sketchbook_224735)
                    .diskCacheStrategy(DiskCacheStrategy.DATA)
                    .loadInto(ivImageBook)
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