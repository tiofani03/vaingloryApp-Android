package com.tiooooo.vaingloryapp.data.pagingSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.tiooooo.vaingloryapp.data.implementation.remote.api.HeroApi
import com.tiooooo.vaingloryapp.data.model.Hero
import javax.inject.Inject

class SearchHeroesSource @Inject constructor(
    private val heroApi: HeroApi,
    private val query: String,
) : PagingSource<Int, Hero>() {
    override fun getRefreshKey(state: PagingState<Int, Hero>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Hero> {
        return try {
            val response = heroApi.getAllHeroes(search = query)
            val heroes = response.data
            heroes?.let {
                LoadResult.Page(
                    data = heroes,
                    prevKey = response.prevPage,
                    nextKey = response.nextPage,
                )
            } ?: kotlin.run {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null,
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}
