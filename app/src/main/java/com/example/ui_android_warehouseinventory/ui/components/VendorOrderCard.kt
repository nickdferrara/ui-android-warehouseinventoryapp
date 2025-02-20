package com.example.ui_android_warehouseinventory.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ui_android_warehouseinventory.model.OrderPriority
import com.example.ui_android_warehouseinventory.model.OrderStatus
import com.example.ui_android_warehouseinventory.model.VendorOrder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VendorOrderCard(
    vendorOrder: VendorOrder,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            // Header with Vendor Name and Priority
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = vendorOrder.vendorName,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                PriorityChip(priority = vendorOrder.priority)
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Order Details
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "PO: ${vendorOrder.purchaseOrderNumber}",
                    style = MaterialTheme.typography.bodyLarge
                )
                StatusChip(status = vendorOrder.status)
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Items and Delivery Date
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.AddCircle,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "${vendorOrder.totalItems} items",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = vendorOrder.expectedDeliveryDate,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}

@Composable
private fun StatusChip(status: OrderStatus) {
    val (backgroundColor, contentColor) = when (status) {
        OrderStatus.PENDING -> MaterialTheme.colorScheme.errorContainer to MaterialTheme.colorScheme.onErrorContainer
        OrderStatus.IN_PROGRESS -> MaterialTheme.colorScheme.primaryContainer to MaterialTheme.colorScheme.onPrimaryContainer
        OrderStatus.COMPLETED -> MaterialTheme.colorScheme.secondaryContainer to MaterialTheme.colorScheme.onSecondaryContainer
    }
    
    SuggestionChip(
        onClick = { },
        label = { Text(status.name) },
        colors = SuggestionChipDefaults.suggestionChipColors(
            containerColor = backgroundColor,
            labelColor = contentColor
        )
    )
}

@Composable
private fun PriorityChip(priority: OrderPriority) {
    val (backgroundColor, contentColor) = when (priority) {
        OrderPriority.HIGH -> MaterialTheme.colorScheme.errorContainer to MaterialTheme.colorScheme.onErrorContainer
        OrderPriority.NORMAL -> MaterialTheme.colorScheme.primaryContainer to MaterialTheme.colorScheme.onPrimaryContainer
        OrderPriority.LOW -> MaterialTheme.colorScheme.secondaryContainer to MaterialTheme.colorScheme.onSecondaryContainer
    }
    
    AssistChip(
        onClick = { },
        label = { Text(priority.name) },
        colors = AssistChipDefaults.assistChipColors(
            containerColor = backgroundColor,
            labelColor = contentColor
        )
    )
} 