package com.appmetry.androidpatterns.di

import com.appmetry.androidpatterns.api.ProductApiService
import com.appmetry.androidpatterns.api.RetrofitBuilder
import com.appmetry.androidpatterns.repositories.login.LoginRepository
import com.appmetry.androidpatterns.repositories.login.LoginRepositoryInterface
import com.appmetry.androidpatterns.repositories.product.ProductRepository
import com.appmetry.androidpatterns.repositories.product.ProductRepositoryInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

// created by Appmetry
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun loginRepository(): LoginRepositoryInterface {
        return LoginRepository()
    }

    @Singleton
    @Provides
    fun retrofitProvider(): Retrofit {
        return RetrofitBuilder.getRetrofit()
    }

    @Singleton
    @Provides
    fun productApiService(retrofit: Retrofit): ProductApiService {
        return retrofit.create(ProductApiService::class.java)
    }

    @Singleton
    @Provides
    fun productRepository(productApiService: ProductApiService): ProductRepositoryInterface {
        return ProductRepository(productApiService)
    }
}