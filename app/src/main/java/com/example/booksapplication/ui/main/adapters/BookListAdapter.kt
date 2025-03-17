package com.example.booksapplication.ui.main.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.booksapplication.R
import com.example.booksapplication.databinding.ListItemBookBinding
import com.example.booksapplication.domain.entities.BookUIEntity


/**
 * Created by Nadya N. on 10.12.2024.
 */
class BookListAdapter(private val onClick: (Long) -> Unit) :
    ListAdapter<BookUIEntity, RecyclerView.ViewHolder>(BookItemsCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BookItemHolder(
            binding = ListItemBookBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            listener = onClick
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as BookItemHolder).bind(currentList[position])
    }

    private class BookItemHolder(
        private val binding: ListItemBookBinding,
        private val listener: (Long) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        private val context: Context = binding.root.context

        fun bind(bookUIEntity: BookUIEntity) {
            itemView.setOnClickListener {
                listener(bookUIEntity.id)
            }

            binding.apply {
                tvTitleBook.text = bookUIEntity.title
//                tvGenreBook.text =
//                    context.getString(R.string.book_genre, bookUIEntity.genre.showToLowercase())
//                tvAuthorBook.text = context.getString(R.string.book_author_name, bookUIEntity.author)
//                tvLanguageBook.text = context.getString(
//                    R.string.book_language,
//                    bookUIEntity.language.toString().lowercase()
//                )


                // callback
//                this@BookItemHolder.itemView.setOnClickListener { view ->
//                    view.findNavController()
//                        .navigate(
//                            MainFragmentDirections.actionMainFragmentToBookDetailInfoFragment(
//                                bookEntity = bookUIEntity
//                            )
//                        )
//                }

                Glide.with(context)
                    .load(bookUIEntity.imageUrl)
                    .error(R.drawable.noun_sketchbook_224735)
                    .placeholder(R.drawable.noun_sketchbook_224735)
                    .diskCacheStrategy(DiskCacheStrategy.DATA)
                    .into(ivImageBook)
            }
        }
    }

    private object BookItemsCallback : DiffUtil.ItemCallback<BookUIEntity>() {
        override fun areItemsTheSame(oldItem: BookUIEntity, newItem: BookUIEntity): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: BookUIEntity, newItem: BookUIEntity): Boolean {
            return oldItem == newItem
        }

    }
}