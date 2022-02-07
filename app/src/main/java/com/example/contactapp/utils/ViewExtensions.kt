package com.example.contactapp.utils

import android.view.View
import android.widget.ImageView
import com.squareup.picasso.Picasso

fun View.setVisible(
    visible: Boolean,
    useInvisible: Boolean = false
) {
    visibility = when {
        visible -> View.VISIBLE
        useInvisible -> View.INVISIBLE
        else -> View.GONE
    }
}

fun insertImage(image: String?, error: Int, imageView: ImageView) {
    Picasso.get().load(image).error(error).into(imageView)
}