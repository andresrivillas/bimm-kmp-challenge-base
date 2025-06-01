package com.bimm.takehomeassignmnent.ui.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material.icons.filled.StarHalf
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun StarRatingView(rating: Double, maxRating: Int = 5) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        repeat(maxRating) { index ->
            val icon = when {
                index + 1 <= rating -> Icons.Default.Star
                index + 0.5 <= rating -> Icons.Default.StarHalf
                else -> Icons.Default.StarBorder
            }
            Icon(
                icon,
                contentDescription = null,
                tint = Color.Yellow,
                modifier = Modifier.size(16.dp)
            )
        }
        Text(
            String.format("%.1f", rating),
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
    }
}