package com.tiooooo.vaingloryapp.ui.screen.detail

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
import kotlinx.coroutines.flow.collectLatest

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    detailViewModel: DetailViewModel = hiltViewModel(),
) {/*----- declarations ----- */
    val selectedHero by detailViewModel.selectedHero.collectAsState()
    val errorMessage by detailViewModel.errorMessage.collectAsState()
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
                modifier = modifier,
            )
        }
    } ?: run {
        if (errorMessage.isNotEmpty()){
            EmptyScreen(
                message = "Data tidak ditemukan"
            ) {
                detailViewModel.getDetailHeroRemote()
            }
        } else {
            LoadingScreen(
                modifier = modifier,
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
                            it.image, context
                        )

                        bitmap?.let {
                            detailViewModel.setColoPalette(
                                color = PaletteGenerator.extractColorFromBitmap(it)
                            )
                        }
                    }
                }
            }
        }
    }
}
