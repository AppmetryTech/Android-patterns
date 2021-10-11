package com.appmetry.androidpatterns.bindingAdapters

import android.view.View
import androidx.databinding.BindingAdapter

object ViewBindingAdapter {

    @JvmStatic
    @BindingAdapter("viewVisibility")
    fun viewVisibility(view: View, show: Boolean) {
        if (show) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }
}