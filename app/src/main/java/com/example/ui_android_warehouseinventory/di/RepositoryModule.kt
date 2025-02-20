package com.example.ui_android_warehouseinventory.di

import com.example.ui_android_warehouseinventory.data.repository.PurchaseOrderRepositoryImpl
import com.example.ui_android_warehouseinventory.data.repository.VendorRepositoryImpl
import com.example.ui_android_warehouseinventory.domain.repository.PurchaseOrderRepository
import com.example.ui_android_warehouseinventory.domain.repository.VendorRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    
    @Binds
    @Singleton
    abstract fun bindVendorRepository(
        vendorRepositoryImpl: VendorRepositoryImpl
    ): VendorRepository

    @Binds
    @Singleton
    abstract fun bindPurchaseOrderRepository(
        purchaseOrderRepositoryImpl: PurchaseOrderRepositoryImpl
    ): PurchaseOrderRepository
} 