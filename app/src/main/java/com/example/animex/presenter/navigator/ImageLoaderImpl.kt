package com.example.animex.presenter.navigator

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar

class ImageLoaderImpl : ImageLoader {


    override fun showMainImage(view: View, image: String, imageView: ImageView) {
        try {
            Glide
                .with(view)
                .load(image)
                .centerCrop()
                .into(imageView)
        } catch (e: Exception) {
            e.stackTrace
            Snackbar.make(view, "There no image", Snackbar.LENGTH_SHORT).show()
        }

    }

    override fun showPosterImage(view: View, image: String, imageView: ImageView){
        try {
            Glide
                .with(view)
                .load(image)
                .centerCrop()
                .into(imageView)
        } catch (e: Exception) {
            e.stackTrace
            Snackbar.make(view, "There no image", Snackbar.LENGTH_SHORT).show()
        }
    }

}