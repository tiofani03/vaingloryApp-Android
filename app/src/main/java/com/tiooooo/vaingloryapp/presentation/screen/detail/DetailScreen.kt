package com.tiooooo.vaingloryapp.presentation.screen.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.tiooooo.vaingloryapp.utils.PaletteGenerator
import com.tiooooo.vaingloryapp.utils.helper.listHeroes
import kotlinx.coroutines.flow.collectLatest

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    detailViewModel: DetailViewModel = hiltViewModel(),
) {
    /*----- declarations ----- */
    val selectedHero = listHeroes.first()
    val colorPalette by detailViewModel.colorPalette
    val context = LocalContext.current

    if (colorPalette.isNotEmpty()) {
        DetailContent(
            modifier = modifier,
            navController = navController,
            selectedHero = listHeroes.first(),
            colors = colorPalette,
        )
    } else {
        detailViewModel.generateColorPalette()
    }

    /*----- Effect ----- */
    LaunchedEffect(key1 = true) {
        detailViewModel.uiEvent.collectLatest { event ->
            when (event) {
                is UiEvent.GenerateColorPalette -> {
                    val bitmap = PaletteGenerator.convertImageUrlToBitmap(
                        selectedHero.image, context
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
