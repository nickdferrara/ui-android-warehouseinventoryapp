package com.example.ui_android_warehouseinventory.data.local.dao

import androidx.room.*
import com.example.ui_android_warehouseinventory.data.local.entity.PurchaseOrderEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PurchaseOrderDao {
    @Query("SELECT * FROM purchase_orders WHERE vendorId = :vendorId ORDER BY date DESC")
    fun getPurchaseOrdersForVendor(vendorId: String): Flow<List<PurchaseOrderEntity>>

    @Query("SELECT * FROM purchase_orders ORDER BY date DESC")
    fun getAllPurchaseOrders(): Flow<List<PurchaseOrderEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPurchaseOrder(purchaseOrder: PurchaseOrderEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPurchaseOrders(purchaseOrders: List<PurchaseOrderEntity>)

    @Delete
    suspend fun deletePurchaseOrder(purchaseOrder: PurchaseOrderEntity)
} 