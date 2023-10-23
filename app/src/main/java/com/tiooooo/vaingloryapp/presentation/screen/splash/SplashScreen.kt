package com.tiooooo.vaingloryapp.presentation.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.tiooooo.vaingloryapp.R
import com.tiooooo.vaingloryapp.navigation.Screen
import com.tiooooo.vaingloryapp.ui.theme.EXTRA_LARGE_PADDING
import com.tiooooo.vaingloryapp.ui.theme.md_theme_dark_onPrimary
import com.tiooooo.vaingloryapp.ui.theme.md_theme_light_primary
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavHostController,
) {
    LaunchedEffect(key1 = true) {
        delay(3000)
        navController.popBackStack()
        navController.navigate(Screen.Home.route)
    }
    Splash()
}

@Composable
fun Splash() {
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
            modifier = Modifier
                .padding(horizontal = EXTRA_LARGE_PADDING),
            painter = painterResource(logoResId),
            contentDescription = logoContentDesc
        )
    }
}

@Composable
@Preview
fun PreviewSplash() {
    Splash()
}

@Composable
@Preview(uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
fun PreviewSplashNightMode() {
    Splash()
}
