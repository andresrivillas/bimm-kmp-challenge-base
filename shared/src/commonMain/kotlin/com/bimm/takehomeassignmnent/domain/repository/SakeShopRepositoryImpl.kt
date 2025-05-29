package com.bimm.takehomeassignmnent.domain.repository

import com.bimm.takehomeassignmnent.domain.interfaces.repository.SakeShopRepository
import com.bimm.takehomeassignmnent.domain.interfaces.service.SakeShopService
import com.bimm.takehomeassignmnent.domain.model.ResponseBase
import com.bimm.takehomeassignmnent.domain.model.Shop

class SakeShopRepositoryImpl constructor(
    private val sakeShopService: SakeShopService
): SakeShopRepository {

    override suspend fun getShopList(): ResponseBase<ArrayList<Shop>> {
        return ResponseBase(value = sakeShopService.getShopList(), null, true)
    }

}