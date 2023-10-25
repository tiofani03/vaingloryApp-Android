package com.tiooooo.vaingloryapp.ui.screen.welcome

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.tiooooo.vaingloryapp.navigation.Screen
import com.tiooooo.vaingloryapp.ui.components.common.PagerScreen
import com.tiooooo.vaingloryapp.ui.theme.BUTTON_SIZE
import com.tiooooo.vaingloryapp.ui.theme.EXTRA_SMALL_PADDING
import com.tiooooo.vaingloryapp.ui.theme.MEDIUM_PADDING
import com.tiooooo.vaingloryapp.ui.theme.PAGING_INDICATOR_SPACING
import com.tiooooo.vaingloryapp.ui.theme.PAGING_INDICATOR_WIDTH

@OptIn(ExperimentalPagerApi::class)
@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    pages: List<OnBoardingPage>,
    welcomeViewModel: WelcomeViewModel = hiltViewModel(),
) {
    val pagerState = rememberPagerState()

    Column(
        modifier = modifier,
    ) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            count = pages.size,
            state = pagerState,
            verticalAlignment = Alignment.Top,
        ) { position ->
            PagerScreen(
                modifier = Modifier.fillMaxSize(),
                onBoardingPage = pages[position]
            )
        }
        HorizontalPagerIndicator(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            pagerState = pagerState,
            activeColor = MaterialTheme.colorScheme.primary,
            inactiveColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
            indicatorWidth = PAGING_INDICATOR_WIDTH,
            spacing = PAGING_INDICATOR_SPACING,
        )

        Row(
            modifier = Modifier.padding(MEDIUM_PADDING),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center,
        ) {
            AnimatedVisibility(
                modifier = Modifier.fillMaxWidth(),
                visible = pagerState.currentPage == pagerState.pageCount - 1
            ) {
                Button(
                    modifier = Modifier.height(BUTTON_SIZE),
                    onClick = {
                        navController.popBackStack()
                        navController.navigate(Screen.Home.route)
                        welcomeViewModel.saveOnBoardingState(true)
                    },
                    shape = RoundedCornerShape(EXTRA_SMALL_PADDING),
                ) {
                    Text(
                        text = "Finish!",
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview() {
    val pages = listOf(OnBoardingPage.First, OnBoardingPage.Second, OnBoardingPage.Third)
    val modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colorScheme.surface)
    WelcomeScreen(
        modifier = modifier,
        navController = rememberNavController(),
        pages = pages,
    )
}
