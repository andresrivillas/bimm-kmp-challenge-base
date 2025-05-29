package com.bimm.takehomeassignmnent.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Shop(
    val name: String? = null,
    val description: String? = null,
    val picture: String? = null,
    val rating: Double? = null,
    val address: String? = null,
    val coordinates: List<Double>? = null,
    val google_maps_link: String? = null,
    val website: String? = null
)