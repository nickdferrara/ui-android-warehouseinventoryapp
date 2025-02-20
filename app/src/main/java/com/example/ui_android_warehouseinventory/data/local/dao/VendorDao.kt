package com.example.ui_android_warehouseinventory.data.local.dao

import androidx.room.*
import com.example.ui_android_warehouseinventory.data.local.entity.VendorEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface VendorDao {
    @Query("SELECT * FROM vendors ORDER BY receivedDate DESC")
    fun getAllVendors(): Flow<List<VendorEntity>>

    @Query("SELECT * FROM vendors WHERE id = :vendorId")
    suspend fun getVendorById(vendorId: String): VendorEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVendor(vendor: VendorEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVendors(vendors: List<VendorEntity>)

    @Delete
    suspend fun deleteVendor(vendor: VendorEntity)
} 