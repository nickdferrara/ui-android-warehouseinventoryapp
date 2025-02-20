package com.example.ui_android_warehouseinventory.data.repository

import com.example.ui_android_warehouseinventory.data.local.dao.PurchaseOrderDao
import com.example.ui_android_warehouseinventory.data.local.entity.PurchaseOrderEntity
import com.example.ui_android_warehouseinventory.domain.repository.PurchaseOrderRepository
import com.example.ui_android_warehouseinventory.model.POStatus
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PurchaseOrderRepositoryImpl @Inject constructor(
    private val purchaseOrderDao: PurchaseOrderDao
) : PurchaseOrderRepository {
    override fun getPurchaseOrdersForVendor(vendorId: String): Flow<List<PurchaseOrderEntity>> {
        return purchaseOrderDao.getPurchaseOrdersForVendor(vendorId)
    }

    override fun getAllPurchaseOrders(): Flow<List<PurchaseOrderEntity>> {
        return purchaseOrderDao.getAllPurchaseOrders()
    }

    override suspend fun insertPurchaseOrder(purchaseOrder: PurchaseOrderEntity) {
        purchaseOrderDao.insertPurchaseOrder(purchaseOrder)
    }

    override suspend fun insertPurchaseOrders(purchaseOrders: List<PurchaseOrderEntity>) {
        purchaseOrderDao.insertPurchaseOrders(purchaseOrders)
    }

    // Add initial sample data
    suspend fun populateSampleData() {
        val samplePOs = listOf(
            PurchaseOrderEntity(
                id = "1",
                vendorId = "1",
                orderNumber = "PO-2024-001",
                status = POStatus.IN_PROGRESS,
                date = System.currentTimeMillis()
            ),
            PurchaseOrderEntity(
                id = "2",
                vendorId = "1",
                orderNumber = "PO-2024-002",
                status = POStatus.PENDING,
                date = System.currentTimeMillis() + 86400000
            ),
            PurchaseOrderEntity(
                id = "3",
                vendorId = "1",
                orderNumber = "PO-2024-003",
                status = POStatus.COMPLETED,
                date = System.currentTimeMillis() - 86400000
            ),
            PurchaseOrderEntity(
                id = "4",
                vendorId = "2",
                orderNumber = "PO-2024-004",
                status = POStatus.PENDING,
                date = System.currentTimeMillis()
            ),
            PurchaseOrderEntity(
                id = "5",
                vendorId = "2",
                orderNumber = "PO-2024-005",
                status = POStatus.IN_PROGRESS,
                date = System.currentTimeMillis()
            )
        )
        insertPurchaseOrders(samplePOs)
    }
} 