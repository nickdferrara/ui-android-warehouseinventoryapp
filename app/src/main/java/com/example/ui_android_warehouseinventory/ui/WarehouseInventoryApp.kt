package com.example.ui_android_warehouseinventory.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.ui_android_warehouseinventory.navigation.WarehouseBottomNavigation
import com.example.ui_android_warehouseinventory.navigation.WarehouseScreens
import com.example.ui_android_warehouseinventory.ui.screens.HomeScreen
import com.example.ui_android_warehouseinventory.ui.screens.SettingsScreen

@Composable
fun WarehouseInventoryApp() {
    var currentScreen by remember { mutableStateOf(WarehouseScreens.HOME) }
    
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            WarehouseBottomNavigation(
                currentScreen = currentScreen,
                onScreenSelected = { screen -> currentScreen = screen }
            )
        }
    ) { innerPadding ->
        when (currentScreen) {
            WarehouseScreens.HOME -> HomeScreen(
                modifier = Modifier.padding(innerPadding)
            )
            WarehouseScreens.SETTINGS -> SettingsScreen(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
} 