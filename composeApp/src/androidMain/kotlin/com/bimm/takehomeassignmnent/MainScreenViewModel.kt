package com.bimm.takehomeassignmnent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bimm.takehomeassignmnent.di.SakeShopModule
import com.bimm.takehomeassignmnent.domain.interfaces.repository.SakeShopRepository
import kotlinx.coroutines.launch


class MainScreenViewModel( ): ViewModel() {

   var shopRepository = SakeShopModule.createShopRepository()

    fun loadData() = viewModelScope.launch {
        val result = shopRepository.getShopList()
        println("eo: $result")
    }
}