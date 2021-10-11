package com.appmetry.androidpatterns.ui.product.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.appmetry.androidpatterns.models.ProductModel

class ProductDetailViewModel : ViewModel() {
    val productDetail = MutableLiveData<ProductModel>()
}