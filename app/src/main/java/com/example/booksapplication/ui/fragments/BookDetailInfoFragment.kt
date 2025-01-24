package com.example.booksapplication.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.booksapplication.R
import com.example.booksapplication.databinding.FragmentBookDetailInfoBinding

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
            tvGenreBookDetail.text = getString(R.string.book_genre, bookEntity.genre)
            tvRatingBookDetail.text = getString(R.string.book_rating, bookEntity.rating)
            tvReleaseYearBookDetail.text =
                getString(R.string.book_release_year, bookEntity.releaseYear)
            tvAuthorBookDetail.text = getString(R.string.book_author_name, bookEntity.author)
            tvDescriptionBookDetail.text = bookEntity.description
            tvLanguageBookDetail.text = getString(
                R.string.book_language,
                bookEntity.language.toString().lowercase()
            )
            tvNumberPagesBookDetail.text =
                getString(R.string.book_number_pages, bookEntity.numberOfPages)

            //TODO rewrite it using caching Glide
            Glide.with(this@BookDetailInfoFragment)
                .load(bookEntity.imageUrl)
                .apply(RequestOptions().placeholder(R.drawable.noun_sketchbook_224735))
                .error(R.drawable.noun_sketchbook_224735)
                .into(ivImageBookDetail)
        }
    }
}