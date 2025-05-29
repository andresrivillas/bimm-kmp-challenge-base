package com.bimm.takehomeassignmnent.domain.interfaces.service

import com.bimm.takehomeassignmnent.domain.model.Shop

interface SakeShopService {
    suspend fun getShopList(): ArrayList<Shop>
}