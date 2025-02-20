package com.example.ui_android_warehouseinventory.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ui_android_warehouseinventory.navigation.WarehouseScreens
import com.example.ui_android_warehouseinventory.ui.screens.CreatePalletScreen
import com.example.ui_android_warehouseinventory.ui.screens.HomeScreen

@Composable
fun WarehouseInventoryApp() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = WarehouseScreens.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(WarehouseScreens.Home.route) {
                HomeScreen(
                    onCreatePalletClick = {
                        navController.navigate(WarehouseScreens.CreatePallet.route)
                    }
                )
            }
            
            composable(WarehouseScreens.CreatePallet.route) {
                CreatePalletScreen(
                    onNavigateBack = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
} 