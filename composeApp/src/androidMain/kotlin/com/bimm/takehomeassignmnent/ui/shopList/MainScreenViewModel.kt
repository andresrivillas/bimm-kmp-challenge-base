package com.bimm.takehomeassignmnent.ui.shopList

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bimm.takehomeassignmnent.domain.interfaces.repository.SakeShopRepository
import com.bimm.takehomeassignmnent.domain.model.Shop
import kotlinx.coroutines.launch


class MainScreenViewModel(private val shopRepository: SakeShopRepository) : ViewModel() {

    var shops by mutableStateOf<List<Shop>>(emptyList())
        private set

    var selectedShop by mutableStateOf<Shop?>(null)

    fun loadData() = viewModelScope.launch {
        val result = shopRepository.getShopList()
        shops = result.value!!
    }

    fun selectShop(shop: Shop) {
        selectedShop = shop
    }

    fun clearSelectedShop() {
        selectedShop = null
    }
}