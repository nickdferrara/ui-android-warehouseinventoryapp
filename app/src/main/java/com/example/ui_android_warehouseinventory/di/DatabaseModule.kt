package com.example.ui_android_warehouseinventory.di

import android.content.Context
import androidx.room.Room
import com.example.ui_android_warehouseinventory.data.local.WarehouseDatabase
import com.example.ui_android_warehouseinventory.data.local.dao.PurchaseOrderDao
import com.example.ui_android_warehouseinventory.data.local.dao.VendorDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): WarehouseDatabase {
        return Room.databaseBuilder(
            context,
            WarehouseDatabase::class.java,
            "warehouse_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideVendorDao(database: WarehouseDatabase): VendorDao {
        return database.vendorDao()
    }

    @Provides
    @Singleton
    fun providePurchaseOrderDao(database: WarehouseDatabase): PurchaseOrderDao {
        return database.purchaseOrderDao()
    }
} 