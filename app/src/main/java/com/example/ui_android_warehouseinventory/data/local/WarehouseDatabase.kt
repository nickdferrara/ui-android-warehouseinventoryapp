package com.example.ui_android_warehouseinventory.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.ui_android_warehouseinventory.data.local.dao.PurchaseOrderDao
import com.example.ui_android_warehouseinventory.data.local.dao.VendorDao
import com.example.ui_android_warehouseinventory.data.local.entity.PurchaseOrderEntity
import com.example.ui_android_warehouseinventory.data.local.entity.VendorEntity

@Database(
    entities = [
        VendorEntity::class,
        PurchaseOrderEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class WarehouseDatabase : RoomDatabase() {
    abstract fun vendorDao(): VendorDao
    abstract fun purchaseOrderDao(): PurchaseOrderDao
} 