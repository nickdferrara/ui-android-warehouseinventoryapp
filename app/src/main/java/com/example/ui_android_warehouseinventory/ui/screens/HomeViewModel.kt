package com.example.ui_android_warehouseinventory.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ui_android_warehouseinventory.domain.usecase.GetVendorsWithPurchaseOrdersUseCase
import com.example.ui_android_warehouseinventory.model.Vendor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getVendorsWithPurchaseOrdersUseCase: GetVendorsWithPurchaseOrdersUseCase
) : ViewModel() {

    val vendors: StateFlow<List<Vendor>> = getVendorsWithPurchaseOrdersUseCase()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
} 