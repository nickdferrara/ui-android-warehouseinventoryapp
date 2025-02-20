package com.example.ui_android_warehouseinventory.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun WelcomeGreeting(
    modifier: Modifier = Modifier,
    greetingTitle: String = "Welcome",
    greetingSubtitle: String = "To get started, select a vendor or scan."
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        GreetingText(
            title = greetingTitle,
            subtitle = greetingSubtitle
        )
        ProfileIcon()
    }
} 