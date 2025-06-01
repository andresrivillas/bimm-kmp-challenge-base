package com.bimm.takehomeassignmnent.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter

@Composable
fun ImageView(imageUrl: String, modifier: Modifier = Modifier) {
    val painter = rememberAsyncImagePainter(
        model = imageUrl.ifEmpty { null }
    )

    val painterState = painter.state

    if (painterState is AsyncImagePainter.State.Error) {
        Icon(
            imageVector = Icons.Default.Storefront,
            contentDescription = null,
            modifier = modifier
                .size(80.dp)
                .clip(RoundedCornerShape(10.dp)),
            tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
        )
    } else {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = modifier
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop
        )
    }
}