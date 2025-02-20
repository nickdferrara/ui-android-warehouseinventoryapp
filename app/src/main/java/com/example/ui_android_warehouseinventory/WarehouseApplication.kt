package com.example.ui_android_warehouseinventory

import android.app.Application
import com.example.ui_android_warehouseinventory.data.repository.PurchaseOrderRepositoryImpl
import com.example.ui_android_warehouseinventory.data.repository.VendorRepositoryImpl
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class WarehouseApplication : Application() {
    @Inject
    lateinit var vendorRepository: VendorRepositoryImpl

    @Inject
    lateinit var purchaseOrderRepository: PurchaseOrderRepositoryImpl

    private val applicationScope = CoroutineScope(Dispatchers.IO)

    override fun onCreate() {
        super.onCreate()
        initializeSampleData()
    }

    private fun initializeSampleData() {
        applicationScope.launch {
            vendorRepository.populateSampleData()
            purchaseOrderRepository.populateSampleData()
        }
    }
} 