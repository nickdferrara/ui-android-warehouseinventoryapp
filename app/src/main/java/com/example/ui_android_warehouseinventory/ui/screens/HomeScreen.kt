package com.example.ui_android_warehouseinventory.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui_android_warehouseinventory.model.Vendor
import com.example.ui_android_warehouseinventory.model.PurchaseOrder
import com.example.ui_android_warehouseinventory.model.POStatus
import com.example.ui_android_warehouseinventory.ui.components.VendorCard
import com.example.ui_android_warehouseinventory.ui.components.WelcomeGreeting

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val vendors by viewModel.vendors.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            WelcomeGreeting()
        }
        
        items(vendors) { vendor ->
            VendorCard(
                vendor = vendor,
                onVendorClick = { /* Handle vendor click */ },
                onPOClick = { /* Handle PO click */ }
            )
        }
    }
}