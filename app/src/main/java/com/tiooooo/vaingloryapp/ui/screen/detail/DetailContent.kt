package com.tiooooo.vaingloryapp.ui.screen.detail

import android.graphics.Color.parseColor
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.tiooooo.vaingloryapp.data.model.Hero
import com.tiooooo.vaingloryapp.ui.screen.detail.components.BottomSheetBackground
import com.tiooooo.vaingloryapp.ui.screen.detail.components.BottomSheetContent
import com.tiooooo.vaingloryapp.ui.theme.EXPANDED_RADIUS_LEVEL
import com.tiooooo.vaingloryapp.ui.theme.EXTRA_LARGE_PADDING
import com.tiooooo.vaingloryapp.ui.theme.LARGE_PADDING
import com.tiooooo.vaingloryapp.ui.theme.MIN_SHEET_HEIGHT
import com.tiooooo.vaingloryapp.utils.toHex

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DetailContent(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    selectedHero: Hero,
    colors: Map<String, String>,
) {

    /*----- declarations ----- */
    var vibrant by remember { mutableStateOf("#000000") }
    var darkVibrant by remember { mutableStateOf("#000000") }
    var onDarkVibrant by remember { mutableStateOf("#FFFFFF") }


    val defaultVibrant = MaterialTheme.colorScheme.primary.toHex()
    val defaultDarkVibrant = MaterialTheme.colorScheme.onBackground.toHex()
    val defaultOnDarkVibrant = MaterialTheme.colorScheme.secondary.toHex()

    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color(parseColor(darkVibrant)).copy(alpha = 0.8f)
        )
    }

    /*----- Ui Prop ----- */
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Expanded)
    )

    val currentSheetFraction = scaffoldState.currentSheetFraction
    val radiusAnim by animateDpAsState(
        targetValue = if (currentSheetFraction == 1f) EXTRA_LARGE_PADDING else EXPANDED_RADIUS_LEVEL,
        label = "radiusAnimation"
    )

    /*----- Effect ----- */
    LaunchedEffect(key1 = selectedHero) {
        vibrant = colors["vibrant"] ?: defaultVibrant
        darkVibrant = colors["darkVibrant"] ?: defaultDarkVibrant
        onDarkVibrant = colors["onDarkVibrant"] ?: defaultOnDarkVibrant
    }


    /*----- Ui ----- */
    BottomSheetScaffold(modifier = modifier, sheetShape = RoundedCornerShape(
        topStart = radiusAnim,
        topEnd = radiusAnim,
    ), scaffoldState = scaffoldState, sheetPeekHeight = MIN_SHEET_HEIGHT, sheetContent = {
        BottomSheetContent(
            modifier = Modifier
                .background(Color(parseColor(darkVibrant)))
                .padding(bottom = LARGE_PADDING),
            selectedHero = selectedHero,
            vibrant = Color(parseColor(vibrant)),
            darkVibrant = Color(parseColor(darkVibrant)),
            onDarkVibrant = Color(parseColor(onDarkVibrant)),
        )
    }, content = {
        BottomSheetBackground(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(parseColor(darkVibrant)).copy(alpha = 0.8f)),
            heroImage = selectedHero.imageBackground,
        ) {
            navController.popBackStack()
        }
    })
}

@OptIn(ExperimentalMaterialApi::class)
val BottomSheetScaffoldState.currentSheetFraction: Float
    get() {
        val fraction = bottomSheetState.progress

        return when (bottomSheetState.currentValue) {
            BottomSheetValue.Collapsed -> 1f - fraction
            BottomSheetValue.Expanded -> fraction
            else -> fraction
        }
    }



