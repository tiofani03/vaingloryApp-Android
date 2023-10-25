package com.tiooooo.vaingloryapp.ui.components.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.tiooooo.vaingloryapp.ui.screen.welcome.OnBoardingPage
import com.tiooooo.vaingloryapp.ui.theme.EXTRA_LARGE_PADDING
import com.tiooooo.vaingloryapp.ui.theme.MEDIUM_PADDING
import com.tiooooo.vaingloryapp.ui.theme.SMALL_PADDING

@Composable
fun PagerScreen(
    modifier: Modifier = Modifier,
    onBoardingPage: OnBoardingPage,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        LottieAnimation(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f),
            onBoardingPage.image
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MEDIUM_PADDING),
            text = onBoardingPage.title,
            color = MaterialTheme.colorScheme.tertiary,
            fontSize = MaterialTheme.typography.headlineMedium.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = EXTRA_LARGE_PADDING)
                .padding(top = SMALL_PADDING),
            text = onBoardingPage.description,
            color = MaterialTheme.colorScheme.tertiary,
            fontSize = MaterialTheme.typography.labelMedium.fontSize,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PagerScreenPreview() {
    PagerScreen(
        modifier = Modifier.fillMaxSize(),
        onBoardingPage = OnBoardingPage.First,
    )

}
