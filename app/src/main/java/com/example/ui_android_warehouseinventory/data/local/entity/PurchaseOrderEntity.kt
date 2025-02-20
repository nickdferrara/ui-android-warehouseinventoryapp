package com.example.ui_android_warehouseinventory.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.ui_android_warehouseinventory.model.POStatus

@Entity(
    tableName = "purchase_orders",
    foreignKeys = [
        ForeignKey(
            entity = VendorEntity::class,
            parentColumns = ["id"],
            childColumns = ["vendorId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class PurchaseOrderEntity(
    @PrimaryKey
    val id: String,
    val vendorId: String,
    val orderNumber: String,
    val status: POStatus,
    val date: Long
) 