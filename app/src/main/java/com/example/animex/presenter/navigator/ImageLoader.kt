package com.example.animex.presenter.navigator

import android.view.View
import android.widget.ImageView

interface ImageLoader {

    fun showMainImage(view: View, image: String,imageView: ImageView)

    fun showPosterImage(view: View, image: String,imageView: ImageView)
}