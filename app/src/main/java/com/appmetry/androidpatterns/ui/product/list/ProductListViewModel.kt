package com.appmetry.androidpatterns.ui.product.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appmetry.androidpatterns.api.ApiResult
import com.appmetry.androidpatterns.models.ProductModel
import com.appmetry.androidpatterns.repositories.product.ProductRepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(val repository : ProductRepositoryInterface): ViewModel() {

    val productListMLD = MutableLiveData<ArrayList<ProductModel>?>()
    val isLoadingMLD = MutableLiveData(false)
    val errorMLD = MutableLiveData<String?>()

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        viewModelScope.launch {
            isLoadingMLD.postValue(true)
            when(val result = repository.getProductList()){
                is ApiResult.Success ->{
                    productListMLD.postValue(result.data)
                }
                is ApiResult.Error -> {
                    errorMLD.postValue(result.errorMessage)
                }
            }
            isLoadingMLD.postValue(false)
        }
    }
}