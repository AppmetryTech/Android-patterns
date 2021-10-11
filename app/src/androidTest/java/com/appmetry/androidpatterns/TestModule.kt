package com.appmetry.androidpatterns

import com.appmetry.androidpatterns.di.AppModule
import com.appmetry.androidpatterns.repositories.login.LoginRepositoryInterface
import com.appmetry.androidpatterns.repositories.product.ProductRepositoryInterface
import com.appmetry.androidpatterns.test.repositories.FakeLoginRepository
import com.appmetry.androidpatterns.test.repositories.FakeProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@TestInstallIn(components = [SingletonComponent::class], replaces = [AppModule::class])
@Module
object TestModule {

    @Singleton
    @Provides
    fun loginRepository(): LoginRepositoryInterface {
        return FakeLoginRepository()
    }

    @Singleton
    @Provides
    fun productRepository(): ProductRepositoryInterface {
        return FakeProductRepository()
    }

}