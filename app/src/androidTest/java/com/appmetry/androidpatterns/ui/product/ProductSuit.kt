package com.appmetry.androidpatterns.ui.product

import com.appmetry.androidpatterns.ui.product.detail.ProductDetailFragmentTest
import com.appmetry.androidpatterns.ui.product.list.ProductListFragmentTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    ProductActivityTest::class,
    ProductDetailFragmentTest::class,
    ProductListFragmentTest::class
)
class ProductSuit