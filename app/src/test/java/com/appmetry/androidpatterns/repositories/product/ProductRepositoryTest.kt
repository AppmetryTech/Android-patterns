package com.appmetry.androidpatterns.repositories.product

import com.appmetry.androidpatterns.api.ApiResult
import com.appmetry.androidpatterns.test.repositories.FakeProductRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class ProductRepositoryTest {
    private val productRepository = FakeProductRepository()

    @Test
    fun `product is fetched`() = runBlocking {
        val result = productRepository.getProductList()
        if (result is ApiResult.Success) {
            Assert.assertTrue(result.data?.isNotEmpty() ?: false)
        }
    }
}