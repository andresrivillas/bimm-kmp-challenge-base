package com.bimm.takehomeassignmnent.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ResponseBase<t>(
    var value: t?,
    var errors: String?,
    var success: Boolean
)