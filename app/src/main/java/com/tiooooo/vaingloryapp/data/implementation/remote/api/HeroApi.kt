package com.tiooooo.vaingloryapp.data.implementation.remote.api

import com.tiooooo.vaingloryapp.data.model.Hero
import com.tiooooo.vaingloryapp.utils.response.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HeroApi {
    @GET("vainglory/heroes")
    suspend fun getAllHeroes(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 5,
        @Query("name") search: String? = null,
    ): ApiResponse<List<Hero>>

    @GET("vainglory/heroes/{heroId}")
    suspend fun getHeroDetail(
        @Path("heroId") heroId: Int,
    ): ApiResponse<Hero>
}
