package com.bimm.takehomeassignmnent.ui.shopList

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bimm.takehomeassignmnent.domain.interfaces.repository.SakeShopRepository
import com.bimm.takehomeassignmnent.domain.model.Shop
import kotlinx.coroutines.launch


class ShopListViewModel(private val shopRepository: SakeShopRepository) : ViewModel() {

    var shops by mutableStateOf<List<Shop>>(emptyList())
        private set

    var selectedShop by mutableStateOf<Shop?>(null)

    fun loadData() = viewModelScope.launch {
        val result = shopRepository.getShopList()
        shops = if (result.success && result.value != null) {
            result.value!!
        } else {
            emptyList()
        }
    }

}