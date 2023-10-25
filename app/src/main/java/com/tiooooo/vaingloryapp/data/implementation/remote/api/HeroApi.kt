package com.tiooooo.vaingloryapp.data.implementation.remote.api

import com.tiooooo.vaingloryapp.data.model.Hero
import com.tiooooo.vaingloryapp.utils.response.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface HeroApi {
    @GET("vainglory/heroes")
    suspend fun getAllHeroes(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 10,
        @Query("name") search: String? = null,
    ): ApiResponse<List<Hero>>
}
