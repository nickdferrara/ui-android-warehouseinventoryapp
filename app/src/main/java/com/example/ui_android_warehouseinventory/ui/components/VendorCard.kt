package com.example.ui_android_warehouseinventory.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ui_android_warehouseinventory.model.POStatus
import com.example.ui_android_warehouseinventory.model.PurchaseOrder
import com.example.ui_android_warehouseinventory.model.Vendor
import java.text.SimpleDateFormat
import java.util.*

/**
 * A card component that displays vendor information and their purchase orders.
 *
 * @param vendor The vendor data to display
 * @param onVendorClick Callback when the vendor card is clicked
 * @param onPOClick Callback when a purchase order is clicked, provides the PO ID
 * @param modifier Optional modifier for the card
 */
@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun VendorCard(
    vendor: Vendor,
    onVendorClick: (Vendor) -> Unit,
    onPOClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        onClick = { onVendorClick(vendor) },
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
    ) {
        VendorCardContent(
            vendor = vendor,
            onPOClick = onPOClick,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
private fun VendorCardContent(
    vendor: Vendor,
    onPOClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        VendorHeader(
            name = vendor.name,
            receivedDate = vendor.receivedDate
        )
        
        PurchaseOrdersList(
            purchaseOrders = vendor.purchaseOrders,
            onPOClick = onPOClick
        )
    }
}

@Composable
private fun VendorHeader(
    name: String,
    receivedDate: Long,
    modifier: Modifier = Modifier
) {
    val dateFormatter = remember { SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()) }
    
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = "Received on ${dateFormatter.format(Date(receivedDate))}",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun PurchaseOrdersList(
    purchaseOrders: List<PurchaseOrder>,
    onPOClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    if (purchaseOrders.isNotEmpty()) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            purchaseOrders.forEach { po ->
                PurchaseOrderRow(
                    poNumber = po.number,
                    status = po.status,
                    dueDate = po.dueDate,
                    onClick = { onPOClick(po.id) }
                )
            }
        }
    }
}

/**
 * A row component that displays purchase order information.
 *
 * @param poNumber The purchase order number
 * @param status The current status of the purchase order
 * @param dueDate The due date timestamp
 * @param onClick Callback when the row is clicked
 */
@Composable
private fun PurchaseOrderRow(
    poNumber: String,
    status: POStatus,
    dueDate: Long,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = 1.dp,
        shape = MaterialTheme.shapes.small
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            POStatusAndNumber(
                poNumber = poNumber,
                status = status
            )
            PODueDate(dueDate = dueDate)
        }
    }
}

@Composable
private fun POStatusAndNumber(
    poNumber: String,
    status: POStatus,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        StatusIndicator(status = status)
        
        Column {
            Text(
                text = poNumber,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = status.name.lowercase()
                    .replaceFirstChar { it.uppercase() }
                    .replace("_", " "),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun StatusIndicator(
    status: POStatus,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(8.dp)
            .clip(CircleShape)
            .background(
                when (status) {
                    POStatus.PENDING -> MaterialTheme.colorScheme.error
                    POStatus.IN_PROGRESS -> MaterialTheme.colorScheme.tertiary
                    POStatus.COMPLETED -> MaterialTheme.colorScheme.primary
                }
            )
    )
}

@Composable
private fun PODueDate(
    dueDate: Long,
    modifier: Modifier = Modifier
) {
    val dateFormatter = remember { SimpleDateFormat("MMM dd", Locale.getDefault()) }
    
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.End
    ) {
        Text(
            text = "Due",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = dateFormatter.format(Date(dueDate)),
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium
        )
    }
} 