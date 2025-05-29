package com.bimm.takehomeassignmnent.di

import com.bimm.takehomeassignmnent.data.SakeShopServiceImpl
import com.bimm.takehomeassignmnent.domain.interfaces.repository.SakeShopRepository
import com.bimm.takehomeassignmnent.domain.interfaces.service.SakeShopService
import com.bimm.takehomeassignmnent.domain.repository.SakeShopRepositoryImpl
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object SakeShopModule {

    private var sakeShopService: SakeShopService? = null

    private fun createSakeShopService(
    ): SakeShopService {
        if (sakeShopService == null) {
            sakeShopService = SakeShopServiceImpl()
        }

        return sakeShopService!!
    }

    fun createShopRepository(): SakeShopRepository {
        return SakeShopRepositoryImpl(
            createSakeShopService()
        )
    }
}