package com.appmetry.androidpatterns.ui.product.list

import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.appmetry.androidpatterns.BaseHiltTest
import com.appmetry.androidpatterns.R
import com.appmetry.androidpatterns.test.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidTest
import org.hamcrest.CoreMatchers
import org.junit.Test

@HiltAndroidTest
class ProductListFragmentTest : BaseHiltTest() {

    private val navController = TestNavHostController(ApplicationProvider.getApplicationContext())

    override fun startUp() {
        super.startUp()
        launchFragmentInHiltContainer<ProductListFragment> {
            navController.setGraph(R.navigation.product_nav_graph)
            Navigation.setViewNavController(requireView(), navController)
        }
    }

    @Test
    fun whenOpened_productListShouldBeDisplayed() {
        ViewMatchers.assertThat(navController.currentDestination?.id,
            CoreMatchers.equalTo(R.id.productListFragment))
    }

    @Test
    fun whenProductSelected_detailShouldBeDisplayed() {

        Espresso.onView(withId(R.id.product_list_rv)).perform(
            RecyclerViewActions.actionOnItemAtPosition<ProductListAdapter.ProductItemViewHolder>(
                1,
                ViewActions.click()
            )
        )

        ViewMatchers.assertThat(navController.currentDestination?.id,
            CoreMatchers.equalTo(R.id.productDetailFragment))
    }
}