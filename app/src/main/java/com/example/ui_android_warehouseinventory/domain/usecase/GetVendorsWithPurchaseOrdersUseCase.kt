package com.example.ui_android_warehouseinventory.domain.usecase

import com.example.ui_android_warehouseinventory.domain.repository.PurchaseOrderRepository
import com.example.ui_android_warehouseinventory.domain.repository.VendorRepository
import com.example.ui_android_warehouseinventory.model.PurchaseOrder
import com.example.ui_android_warehouseinventory.model.Vendor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class GetVendorsWithPurchaseOrdersUseCase @Inject constructor(
    private val vendorRepository: VendorRepository,
    private val purchaseOrderRepository: PurchaseOrderRepository
) {
    operator fun invoke(): Flow<List<Vendor>> {
        return combine(
            vendorRepository.getAllVendors(),
            purchaseOrderRepository.getAllPurchaseOrders()
        ) { vendors, purchaseOrders ->
            vendors.map { vendorEntity ->
                Vendor(
                    id = vendorEntity.id,
                    name = vendorEntity.name,
                    receivedDate = vendorEntity.receivedDate,
                    purchaseOrders = purchaseOrders
                        .filter { it.vendorId == vendorEntity.id }
                        .map { poEntity ->
                            PurchaseOrder(
                                id = poEntity.id,
                                number = poEntity.orderNumber,
                                status = poEntity.status,
                                dueDate = poEntity.date
                            )
                        }
                )
            }
        }
    }
} 