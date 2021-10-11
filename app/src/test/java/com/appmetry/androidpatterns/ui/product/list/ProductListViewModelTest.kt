package com.appmetry.androidpatterns.ui.product.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.appmetry.androidpatterns.getOrAwaitValue
import com.appmetry.androidpatterns.test.repositories.FakeProductRepository
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProductListViewModelTest {
    private lateinit var productListViewModel: ProductListViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        productListViewModel = ProductListViewModel(FakeProductRepository())
    }

    @Test
    fun fetchProductList() {
        val data = productListViewModel.productListMLD.getOrAwaitValue()
        assertTrue(data != null)
    }
}