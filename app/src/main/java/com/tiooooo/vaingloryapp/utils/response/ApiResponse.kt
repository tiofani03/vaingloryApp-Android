package com.tiooooo.vaingloryapp.utils.response

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse<T>(
    val success: Boolean,
    val message: String? = null,
    val prevPage: Int? = null,
    val nextPage: Int? = null,
    var data: T? = null,
    val lastUpdated: Long? = null,
)

