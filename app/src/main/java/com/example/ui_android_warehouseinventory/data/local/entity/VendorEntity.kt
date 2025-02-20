package com.example.ui_android_warehouseinventory.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vendors")
data class VendorEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val receivedDate: Long
) 