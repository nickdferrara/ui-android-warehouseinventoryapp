package com.example.ui_android_warehouseinventory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.ui_android_warehouseinventory.ui.WarehouseInventoryApp
import com.example.ui_android_warehouseinventory.ui.theme.WarehouseInventoryTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WarehouseInventoryTheme {
                WarehouseInventoryApp()
            }
        }
    }
}