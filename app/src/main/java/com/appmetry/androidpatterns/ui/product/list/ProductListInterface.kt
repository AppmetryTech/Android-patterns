package com.appmetry.androidpatterns.ui.product.list

import com.appmetry.androidpatterns.models.ProductModel

interface ProductListInterface {
    fun onProductSelected(product : ProductModel)
}