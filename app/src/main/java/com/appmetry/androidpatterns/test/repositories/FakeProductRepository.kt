package com.appmetry.androidpatterns.test.repositories

import com.appmetry.androidpatterns.api.ApiResult
import com.appmetry.androidpatterns.models.ProductModel
import com.appmetry.androidpatterns.repositories.product.ProductRepositoryInterface
import javax.inject.Inject

class FakeProductRepository @Inject constructor() : ProductRepositoryInterface {
    private val productList = arrayListOf<ProductModel>().apply {
        add(
            ProductModel(
                1,
                "Title 1",
                "Description 1",
                "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg"
            )
        )
        add(
            ProductModel(
                2,
                "Title 2",
                "Description 2",
                "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg"
            )
        )
        add(
            ProductModel(
                3,
                "Title 3",
                "Description 3",
                "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg"
            )
        )
        add(
            ProductModel(
                4,
                "Title 4",
                "Description 4",
                "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg"
            )
        )
        add(
            ProductModel(
                5,
                "Title 5",
                "Description 5",
                "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg"
            )
        )
        add(
            ProductModel(
                6,
                "Title 6",
                "Description 6",
                "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg"
            )
        )
    }

    override suspend fun getProductList(): ApiResult<ArrayList<ProductModel>> {
        return ApiResult.Success(productList)
    }

}