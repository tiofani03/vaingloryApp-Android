package com.tiooooo.vaingloryapp.ui.screen.detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.tiooooo.vaingloryapp.ui.components.common.EmptyScreen
import com.tiooooo.vaingloryapp.ui.components.common.LoadingScreen
import com.tiooooo.vaingloryapp.utils.PaletteGenerator
import com.tiooooo.vaingloryapp.utils.toHex
import kotlinx.coroutines.flow.collectLatest

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    detailViewModel: DetailViewModel = hiltViewModel(),
) {/*----- declarations ----- */
    val selectedHero by detailViewModel.selectedHero.collectAsState()
    val errorMessage by detailViewModel.errorMessage.collectAsState()

    val defaultVibrant = MaterialTheme.colorScheme.primary.toHex()
    val defaultDarkVibrant = MaterialTheme.colorScheme.background.toHex()
    val defaultOnDarkVibrant = MaterialTheme.colorScheme.secondary.toHex()

    val colorPalette by detailViewModel.colorPalette
    val context = LocalContext.current

    selectedHero?.let { hero ->
        if (colorPalette.isNotEmpty()) {
            DetailContent(
                modifier = modifier,
                navController = navController,
                selectedHero = hero,
                colors = colorPalette,
            )
        } else {
            detailViewModel.generateColorPalette()
            LoadingScreen(
                modifier = modifier.fillMaxSize(),
            )
        }
    } ?: run {
        if (errorMessage.isNotEmpty()) {
            EmptyScreen {
                detailViewModel.getDetailHeroRemote()
            }
        } else {
            LoadingScreen(
                modifier = modifier.fillMaxSize(),
            )
        }
    }


    /*----- Effect ----- */
    LaunchedEffect(key1 = true) {
        detailViewModel.uiEvent.collectLatest { event ->
            when (event) {
                is UiEvent.GenerateColorPalette -> {
                    selectedHero?.let {
                        val bitmap = PaletteGenerator.convertImageUrlToBitmap(
                            it.imageBackground, context
                        )

                        bitmap?.let { imageBitmap ->
                            detailViewModel.setColoPalette(
                                color = PaletteGenerator.extractColorFromBitmap(imageBitmap)
                            )
                        } ?: kotlin.run {
                            detailViewModel.setDefaultColorPalette(
                                mapOf(
                                    "vibrant" to defaultVibrant,
                                    "darkVibrant" to defaultDarkVibrant,
                                    "onDarkVibrant" to defaultOnDarkVibrant,
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}
