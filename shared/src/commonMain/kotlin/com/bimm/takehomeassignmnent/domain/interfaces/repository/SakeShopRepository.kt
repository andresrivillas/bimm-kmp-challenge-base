package com.bimm.takehomeassignmnent.domain.interfaces.repository

import com.bimm.takehomeassignmnent.domain.model.ResponseBase
import com.bimm.takehomeassignmnent.domain.model.Shop

interface SakeShopRepository {

    suspend fun getShopList(): ResponseBase<ArrayList<Shop>>
}