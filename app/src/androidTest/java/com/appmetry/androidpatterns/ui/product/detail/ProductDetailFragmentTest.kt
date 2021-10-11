package com.appmetry.androidpatterns.ui.product.detail

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.appmetry.androidpatterns.R
import com.appmetry.androidpatterns.models.ProductModel
import org.hamcrest.CoreMatchers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ProductDetailFragmentTest {
    private val navController =
        TestNavHostController(ApplicationProvider.getApplicationContext())

    @Before
    fun startUp() {
        val bundle = Bundle()
        bundle.putParcelable("productDetail",
            ProductModel(1,
                "title",
                "desc",
                "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg"))

        launchFragmentInContainer<ProductDetailFragment>(bundle).onFragment {
            navController.setGraph(R.navigation.product_nav_graph)
            navController.setCurrentDestination(R.id.productDetailFragment, bundle)
            Navigation.setViewNavController(it.requireView(), navController)
        }
    }

    @Test
    fun checkIsDetailViewDisplayed() {
        ViewMatchers.assertThat(
            navController.currentDestination?.id,
            CoreMatchers.equalTo(R.id.productDetailFragment)
        )
    }

    @Test
    fun checkCorrectProductDataIsDisplayed() {
        Espresso.onView(ViewMatchers.withId(R.id.title_tv))
            .check(ViewAssertions.matches(ViewMatchers.withText("title")))

        Espresso.onView(ViewMatchers.withId(R.id.description_tv))
            .check(ViewAssertions.matches(ViewMatchers.withText("desc")))
    }
}