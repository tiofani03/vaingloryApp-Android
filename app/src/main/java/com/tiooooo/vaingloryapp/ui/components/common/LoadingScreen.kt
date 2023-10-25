package com.tiooooo.vaingloryapp.ui.components.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier,
) {
    LottieAnimation(modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun LoadingScreenPrev() {
    LoadingScreen(modifier = Modifier.fillMaxSize())
}
