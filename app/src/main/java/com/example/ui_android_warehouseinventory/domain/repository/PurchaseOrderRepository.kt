package com.example.ui_android_warehouseinventory.domain.repository

import com.example.ui_android_warehouseinventory.data.local.entity.PurchaseOrderEntity
import kotlinx.coroutines.flow.Flow

interface PurchaseOrderRepository {
    fun getPurchaseOrdersForVendor(vendorId: String): Flow<List<PurchaseOrderEntity>>
    fun getAllPurchaseOrders(): Flow<List<PurchaseOrderEntity>>
    suspend fun insertPurchaseOrder(purchaseOrder: PurchaseOrderEntity)
    suspend fun insertPurchaseOrders(purchaseOrders: List<PurchaseOrderEntity>)
} 