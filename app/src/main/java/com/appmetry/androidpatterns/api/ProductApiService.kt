package com.appmetry.androidpatterns.api

import com.appmetry.androidpatterns.models.ProductModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApiService {
    @GET("/products")
    suspend fun getProducts(@Query("limit") limit: Int = 20): Response<ArrayList<ProductModel>>
}