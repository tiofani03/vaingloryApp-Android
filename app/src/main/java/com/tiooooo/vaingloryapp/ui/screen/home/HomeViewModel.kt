package com.tiooooo.vaingloryapp.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.tiooooo.vaingloryapp.data.api.repository.HeroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: HeroRepository,
) : ViewModel() {
    val getAllHeroes = repository.getAllHeroes().cachedIn(viewModelScope)
}
