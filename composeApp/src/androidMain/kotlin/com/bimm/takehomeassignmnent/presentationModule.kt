package com.bimm.takehomeassignmnent

import com.bimm.takehomeassignmnent.di.SakeShopModule
import com.bimm.takehomeassignmnent.domain.interfaces.repository.SakeShopRepository
import com.bimm.takehomeassignmnent.ui.shopList.MainScreenViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    single<SakeShopRepository> { SakeShopModule.createShopRepository() }

    viewModel {
        MainScreenViewModel(get())
    }
}