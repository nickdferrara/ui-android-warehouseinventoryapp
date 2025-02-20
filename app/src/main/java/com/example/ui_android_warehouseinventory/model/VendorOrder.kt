package com.example.ui_android_warehouseinventory.model

data class VendorOrder(
    val vendorName: String,
    val purchaseOrderNumber: String,
    val totalItems: Int,
    val status: OrderStatus,
    val expectedDeliveryDate: String,
    val priority: OrderPriority = OrderPriority.NORMAL
)

enum class OrderStatus {
    PENDING,
    IN_PROGRESS,
    COMPLETED
}

enum class OrderPriority {
    HIGH,
    NORMAL,
    LOW
} 