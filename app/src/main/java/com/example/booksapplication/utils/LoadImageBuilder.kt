package com.example.booksapplication.utils

import android.widget.ImageView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy

/**
 * Created by Nadya N. on 03.02.2025.
 */
class LoadImageBuilder(private val glideRequestManager: RequestManager) {

    private var url: String? = null
    private var errorDrawable: Int? = null
    private var diskCacheStrategy: DiskCacheStrategy = DiskCacheStrategy.ALL
    private var placeholder: Int? = null

    fun url(url: String) = apply { this.url = url }
    fun errorDrawable(errorDrawable: Int) = apply { this.errorDrawable = errorDrawable }
    fun diskCacheStrategy(diskCacheStrategy: DiskCacheStrategy) =
        apply { this.diskCacheStrategy = diskCacheStrategy }

    fun placeholder(placeholder: Int) = apply { this.placeholder = placeholder }

    fun loadInto(view: ImageView) {
        val glideRequest = glideRequestManager
            .load(url)
            .diskCacheStrategy(diskCacheStrategy)

        errorDrawable?.let { glideRequest.error(it) }
        placeholder?.let { glideRequest.placeholder(it) }

        glideRequest.into(view)
    }

}