package com.appmetry.androidpatterns.api

sealed class ApiResult<out T> {
    data class Success<out T>(val data: T?) : ApiResult<T>()
    data class Error(val errorCode: Int, val errorMessage: String?, val exception: Exception) :
        ApiResult<Nothing>()
}
