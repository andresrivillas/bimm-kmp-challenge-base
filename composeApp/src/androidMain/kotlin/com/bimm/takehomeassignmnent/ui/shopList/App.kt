package com.bimm.takehomeassignmnent.ui.shopList

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bimm.takehomeassignmnent.domain.model.Shop
import com.bimm.takehomeassignmnent.ui.common.ImageView
import com.bimm.takehomeassignmnent.ui.common.StarRatingView
import com.bimm.takehomeassignmnent.ui.shopDetail.ShopDetailBottomSheet
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.androidx.compose.koinViewModel
import java.util.UUID


@Preview
@Composable
fun App(viewModel: MainScreenViewModel = koinViewModel()) {

    LaunchedEffect(Unit) {
        viewModel.loadData()
    }

    LaunchedEffect(Unit) {
        viewModel.loadData()
    }

    viewModel.selectedShop?.let { shop ->
        ShopDetailBottomSheet(
            shop = shop,
            onDismiss = { viewModel.selectedShop = null }
        )
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(viewModel.shops, key = { it.name ?: UUID.randomUUID().toString() }) { shop ->
            ShopItem(shop = shop) {
                viewModel.selectedShop = shop
            }
        }
    }

}

@Composable
fun ShopItem(shop: Shop, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .clickable(onClick = onClick)
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ImageView(imageUrl = shop.picture ?: "", Modifier.size(80.dp))
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(shop.name.orEmpty(), style = MaterialTheme.typography.titleMedium)
            Text(
                shop.address.orEmpty(),
                style = MaterialTheme.typography.bodySmall,
                maxLines = 1,
                color = Color.Gray
            )
            StarRatingView(rating = shop.rating ?: 0.0)
        }
    }
}


