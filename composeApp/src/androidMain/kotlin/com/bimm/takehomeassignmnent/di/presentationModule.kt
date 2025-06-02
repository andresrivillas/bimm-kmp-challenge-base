package com.bimm.takehomeassignmnent.di

import com.bimm.takehomeassignmnent.domain.interfaces.repository.SakeShopRepository
import com.bimm.takehomeassignmnent.ui.shopList.ShopListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    single<SakeShopRepository> { SakeShopModule.createShopRepository() }

    viewModel {
        ShopListViewModel(get())
    }
}