package com.tiooooo.vaingloryapp.ui.screen.detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tiooooo.vaingloryapp.data.model.Hero
import com.tiooooo.vaingloryapp.data.api.repository.HeroRepository
import com.tiooooo.vaingloryapp.utils.response.States
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val heroRepository: HeroRepository,
) : ViewModel() {

    private val _selectedHero: MutableStateFlow<Hero?> = MutableStateFlow(null)
    val selectedHero: StateFlow<Hero?> = _selectedHero

    private val _errorMessage: MutableStateFlow<String> = MutableStateFlow("")
    val errorMessage: StateFlow<String> = _errorMessage

    private var saveHeroId: Int = 0

    init {
        viewModelScope.launch(Dispatchers.IO) {
            delay(2000)
            val heroId = savedStateHandle.get<Int>("heroId")
            heroId?.let {
                saveHeroId = it
                _selectedHero.value = heroRepository.getDetailHero(heroId = it)
                if (_selectedHero.value == null) {
                    getDetailHeroRemote()
                }
            }
        }
    }

    fun getDetailHeroRemote() {
        viewModelScope.launch {
            heroRepository.getDetailHeroRemote(saveHeroId).collect {
                when (it) {
                    is States.Success -> {
                        it.data?.let { hero ->
                            _selectedHero.value = hero
                        }
                    }

                    is States.Error -> {
                        it.message?.let { error ->
                            _errorMessage.value = error
                        }
                    }

                    else -> {}
                }
            }
        }
    }


    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent = _uiEvent.asSharedFlow()

    private val _colorPalette: MutableState<Map<String, String>> = mutableStateOf(mapOf())
    val colorPalette: State<Map<String, String>> = _colorPalette


    fun generateColorPalette() {
        viewModelScope.launch {
            _uiEvent.emit(UiEvent.GenerateColorPalette)
        }
    }

    fun setColoPalette(color: Map<String, String>) {
        _colorPalette.value = color
    }

}

sealed class UiEvent {
    object GenerateColorPalette : UiEvent()
}
