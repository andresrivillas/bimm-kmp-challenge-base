package com.bimm.takehomeassignmnent.ui.shopDetail

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Map
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.bimm.takehomeassignmnent.domain.model.Shop
import com.bimm.takehomeassignmnent.ui.common.ImageView
import com.bimm.takehomeassignmnent.ui.common.StarRatingView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopDetailBottomSheet(shop: Shop, onDismiss: () -> Unit) {
    val context = LocalContext.current
    fun openUrl(url: String?) {
        url?.takeIf { it.isNotBlank() }?.let {
            try {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it))
                context.startActivity(intent)
            } catch (e: Exception) {
            }
        }
    }



    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    LaunchedEffect(Unit) {
        sheetState.show()
    }

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ImageView(imageUrl = shop.picture ?: "", Modifier.fillMaxWidth())
            Text(shop.name.orEmpty(), style = MaterialTheme.typography.headlineSmall)
            Text(
                shop.address.orEmpty(),
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
            StarRatingView(rating = shop.rating ?: 0.0)

            Button(
                onClick = {
                    openUrl(shop.google_maps_link)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Default.Map, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text(shop.address.orEmpty(), maxLines = 1)
            }

            Button(
                onClick = {
                    openUrl(shop.website)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            ) {
                Text("Visit Website", color = Color.White)
            }
        }
    }
}