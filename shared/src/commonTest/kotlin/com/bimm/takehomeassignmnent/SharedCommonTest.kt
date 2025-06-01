package com.bimm.takehomeassignmnent

import com.bimm.takehomeassignmnent.domain.interfaces.repository.SakeShopRepository
import kotlin.test.Test
import kotlin.test.assertEquals

class SharedCommonTest {

    private val countryRepository = mock<SakeShopRepository>()

    @Test
    fun example() {
        assertEquals(3, 1 + 2)
    }
}