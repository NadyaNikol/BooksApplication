package com.example.booksapplication.ui.fragments

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.booksapplication.R
import com.example.booksapplication.databinding.FragmentBookDetailInfoBinding
import com.example.booksapplication.utils.LoadImageBuilder
import com.example.booksapplication.utils.extensions.showToLowercase

class BookDetailInfoFragment :
    BaseFragment<FragmentBookDetailInfoBinding>(
        FragmentBookDetailInfoBinding::inflate
    ) {

    private val args: BookDetailInfoFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        val bookEntity = args.bookEntity
        binding.apply {
            tvNameBookDetail.text = bookEntity.name
            tvGenreBookDetail.text =
                getString(R.string.book_genre, bookEntity.genre.showToLowercase())
            tvRatingBookDetail.rating = bookEntity.rating
            tvReleaseYearBookDetail.text =
                getString(R.string.book_release_year, bookEntity.releaseYear)
            tvAuthorBookDetail.text = getString(R.string.book_author_name, bookEntity.author)
            tvLanguageBookDetail.text = getString(
                R.string.book_language,
                bookEntity.language.showToLowercase()
            )
            tvNumberPagesBookDetail.text =
                getString(R.string.book_number_pages, bookEntity.numberOfPages)

            tvDescriptionBookDetail.apply {
                text = bookEntity.description
                movementMethod = ScrollingMovementMethod()
            }

            LoadImageBuilder(Glide.with(this@BookDetailInfoFragment))
                .url(bookEntity.imageUrl)
                .errorDrawable(R.drawable.noun_sketchbook_224735)
                .placeholder(R.drawable.noun_sketchbook_224735)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .loadInto(ivImageBookDetail)
        }
    }
}