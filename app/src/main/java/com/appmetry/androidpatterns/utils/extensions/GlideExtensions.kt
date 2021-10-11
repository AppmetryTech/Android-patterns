package com.appmetry.androidpatterns.utils.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setImage(imgUrl: String?) {
    if (!imgUrl.isNullOrEmpty()) {
        Glide.with(this).load(imgUrl).into(this)
    }
}

fun ImageView.clear() {
    Glide.with(this).clear(this)
}