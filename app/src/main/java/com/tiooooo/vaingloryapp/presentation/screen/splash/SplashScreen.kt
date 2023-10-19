package com.tiooooo.vaingloryapp.presentation.screen.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.tiooooo.vaingloryapp.R
import com.tiooooo.vaingloryapp.ui.theme.md_theme_dark_onPrimary
import com.tiooooo.vaingloryapp.ui.theme.md_theme_light_primary

@Composable
fun SplashScreen(
    navController: NavHostController,
) {
    val rotateDegrees = remember { Animatable(0f) }
    LaunchedEffect(key1 = true) {
        rotateDegrees.animateTo(
            targetValue = 180f,
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 200,
            )
        )
        navController.popBackStack()

    }
    Splash(rotateDegrees.value)
}

@Composable
fun Splash(rotateDegrees: Float) {
    val logoResId = R.drawable.ic_logo
    val logoContentDesc = stringResource(R.string.app_logo)
    val modifier = if (!isSystemInDarkTheme()) Modifier.background(
        Brush.verticalGradient(
            listOf(
                md_theme_light_primary, md_theme_dark_onPrimary
            )
        )
    ) else Modifier.background(Color.Black)
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.rotate(rotateDegrees),
            painter = painterResource(logoResId),
            contentDescription = logoContentDesc
        )
    }
}

@Composable
@Preview
fun PreviewSplash() {
    Splash(0f)
}

@Composable
@Preview(uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
fun PreviewSplashNightMode() {
    Splash(0f)
}
