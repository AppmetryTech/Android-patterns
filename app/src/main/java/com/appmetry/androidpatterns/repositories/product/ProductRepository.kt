package com.appmetry.androidpatterns.repositories.product

import com.appmetry.androidpatterns.api.ApiResult
import com.appmetry.androidpatterns.api.BaseRepository
import com.appmetry.androidpatterns.api.ProductApiService
import com.appmetry.androidpatterns.models.ProductModel
import javax.inject.Inject

// created by Appmetry
class ProductRepository @Inject constructor(private val productApiService: ProductApiService) :
    BaseRepository(),
    ProductRepositoryInterface {

    override suspend fun getProductList(): ApiResult<ArrayList<ProductModel>> {
        return makeRequest { productApiService.getProducts() }
    }
}