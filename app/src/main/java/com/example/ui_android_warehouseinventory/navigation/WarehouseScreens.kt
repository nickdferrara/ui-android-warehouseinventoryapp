package com.example.ui_android_warehouseinventory.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class WarehouseScreens(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    HOME(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    ),
    
    SETTINGS(
        route = "settings",
        title = "Settings", 
        icon = Icons.Default.Settings
    );

    companion object {
        fun getScreens() = entries
    }
} 