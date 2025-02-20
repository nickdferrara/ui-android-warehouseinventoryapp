package com.example.ui_android_warehouseinventory.domain.repository

import com.example.ui_android_warehouseinventory.data.local.entity.VendorEntity
import kotlinx.coroutines.flow.Flow

interface VendorRepository {
    fun getAllVendors(): Flow<List<VendorEntity>>
    suspend fun getVendorById(id: String): VendorEntity?
    suspend fun insertVendor(vendor: VendorEntity)
    suspend fun insertVendors(vendors: List<VendorEntity>)
} 