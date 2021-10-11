package com.appmetry.androidpatterns.bindingAdapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.appmetry.androidpatterns.utils.extensions.setImage

object ImageBindingAdapter {

    @JvmStatic
    @BindingAdapter("setImageUrl")
    fun setImage(view: ImageView, imgUrl: String?) {
        view.setImage(imgUrl)
    }
}