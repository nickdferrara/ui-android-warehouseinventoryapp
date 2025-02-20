package com.example.ui_android_warehouseinventory.navigation

sealed class WarehouseScreens(val route: String) {
    object Home : WarehouseScreens("home")
    object Settings : WarehouseScreens("settings")
    object CreatePallet : WarehouseScreens("create_pallet")
} 