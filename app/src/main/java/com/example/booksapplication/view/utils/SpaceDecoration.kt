package com.example.booksapplication.view.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Nadya N. on 11.12.2024.
 */
class SpaceDecoration(private val offset: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State,
    ) {
        outRect.apply {
            top = if (parent.getChildAdapterPosition(view) == 0) 0 else offset
            bottom = offset
        }
    }
}