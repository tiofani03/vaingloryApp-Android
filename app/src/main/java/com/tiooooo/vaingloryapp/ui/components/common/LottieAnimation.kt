package com.tiooooo.vaingloryapp.ui.components.common

import androidx.annotation.RawRes
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.tiooooo.vaingloryapp.R

@Composable
fun LottieAnimation(
    modifier: Modifier,
    @RawRes
    rawId: Int = R.raw.lottie_loading,
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(rawId))

    LottieAnimation(
        modifier = modifier,
        composition = composition,
        iterations = LottieConstants.IterateForever,
    )
}

@Preview(showBackground = true)
@Composable
fun LottieAnimationPrev() {
    LottieAnimation(modifier = Modifier
        .fillMaxWidth(0.5f)
        .fillMaxHeight(0.7f), R.raw.lottie_power)
}
