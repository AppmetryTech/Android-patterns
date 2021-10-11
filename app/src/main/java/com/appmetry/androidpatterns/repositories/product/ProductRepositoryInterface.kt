package com.appmetry.androidpatterns.repositories.product

import com.appmetry.androidpatterns.api.ApiResult
import com.appmetry.androidpatterns.models.ProductModel
// created by Appmetry
interface ProductRepositoryInterface {
    suspend fun getProductList(): ApiResult<ArrayList<ProductModel>>
}