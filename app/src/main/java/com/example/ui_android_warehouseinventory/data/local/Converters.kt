package com.example.ui_android_warehouseinventory.data.local

import androidx.room.TypeConverter
import com.example.ui_android_warehouseinventory.model.POStatus

class Converters {
    @TypeConverter
    fun fromPOStatus(status: POStatus): String {
        return status.name
    }

    @TypeConverter
    fun toPOStatus(status: String): POStatus {
        return POStatus.valueOf(status)
    }
} 