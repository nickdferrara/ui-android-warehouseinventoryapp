package com.example.ui_android_warehouseinventory.data.repository

import com.example.ui_android_warehouseinventory.data.local.dao.VendorDao
import com.example.ui_android_warehouseinventory.data.local.entity.VendorEntity
import com.example.ui_android_warehouseinventory.domain.repository.VendorRepository
import com.example.ui_android_warehouseinventory.model.Vendor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VendorRepositoryImpl @Inject constructor(
    private val vendorDao: VendorDao
) : VendorRepository {
    override fun getAllVendors(): Flow<List<VendorEntity>> {
        return vendorDao.getAllVendors()
    }

    override suspend fun getVendorById(id: String): VendorEntity? {
        return vendorDao.getVendorById(id)
    }

    override suspend fun insertVendor(vendor: VendorEntity) {
        vendorDao.insertVendor(vendor)
    }

    override suspend fun insertVendors(vendors: List<VendorEntity>) {
        vendorDao.insertVendors(vendors)
    }

    // Add initial sample data
    suspend fun populateSampleData() {
        val sampleVendors = listOf(
            VendorEntity(
                id = "1",
                name = "Acme Supplies",
                receivedDate = System.currentTimeMillis() - 172800000
            ),
            VendorEntity(
                id = "2",
                name = "Global Electronics",
                receivedDate = System.currentTimeMillis() - 86400000
            )
        )
        insertVendors(sampleVendors)
    }
} 