package com.example.ui_android_warehouseinventory.model

data class Vendor(
    val id: String,
    val name: String,
    val receivedDate: Long,
    val purchaseOrders: List<PurchaseOrder>
)

data class PurchaseOrder(
    val id: String,
    val number: String,
    val status: POStatus,
    val dueDate: Long
)

enum class POStatus {
    PENDING,
    IN_PROGRESS,
    COMPLETED
} 