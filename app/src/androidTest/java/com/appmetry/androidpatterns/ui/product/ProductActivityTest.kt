package com.appmetry.androidpatterns.ui.product

import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.appmetry.androidpatterns.BaseHiltTest
import com.appmetry.androidpatterns.R
import com.appmetry.androidpatterns.ui.product.list.ProductListAdapter
import dagger.hilt.android.testing.HiltAndroidTest
import org.hamcrest.CoreMatchers
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class ProductActivityTest : BaseHiltTest() {

    @get:Rule(order = 1)
    val activityScenario = ActivityScenarioRule(ProductActivity::class.java)

    private lateinit var navController: NavController

    override fun startUp() {
        super.startUp()
        activityScenario.scenario.onActivity {
            navController = it.findNavController(R.id.nav_host_fragment)
        }
    }

    @Test
    fun checkProductListIsDisplayed() {

        ViewMatchers.assertThat(
            navController.currentDestination?.id,
            CoreMatchers.equalTo(R.id.productListFragment)
        )
    }

    @Test
    fun whenProductSelected_productDetailShouldBeDisplayed() {

        Espresso.onView(ViewMatchers.withId(R.id.product_list_rv)).perform(
            RecyclerViewActions.actionOnItemAtPosition<ProductListAdapter.ProductItemViewHolder>(
                1,
                ViewActions.click()
            )
        )

        ViewMatchers.assertThat(
            navController.currentDestination?.id,
            CoreMatchers.equalTo(R.id.productDetailFragment)
        )
    }

    @Test
    fun whenUserPressBackFromDetail_productListScreenShouldBeDisplayed() {

        whenProductSelected_productDetailShouldBeDisplayed()

        Espresso.pressBack()

        checkProductListIsDisplayed()
    }
}