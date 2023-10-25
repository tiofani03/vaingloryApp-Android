package com.tiooooo.vaingloryapp.ui.screen.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tiooooo.vaingloryapp.data.api.repository.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val dataStoreRepository: DataStoreRepository,
) : ViewModel() {
    fun saveOnBoardingState(completed: Boolean) {
        viewModelScope.launch {
            dataStoreRepository.saveOnBoardingState(completed)
        }
    }
}
