package com.tiooooo.vaingloryapp.presentation.screen.home

import android.annotation.SuppressLint
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.tiooooo.vaingloryapp.navigation.Screen
import com.tiooooo.vaingloryapp.presentation.components.list.ItemHero
import com.tiooooo.vaingloryapp.ui.theme.EXTRA_SMALL_PADDING
import com.tiooooo.vaingloryapp.ui.theme.SMALL_PADDING
import com.tiooooo.vaingloryapp.utils.helper.listHeroes

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    Scaffold(modifier = modifier, topBar = {
        HomeTopBar {
            navController.navigate(Screen.Search.route)
        }
    }) {
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            verticalItemSpacing = EXTRA_SMALL_PADDING,
            horizontalArrangement = Arrangement.spacedBy(EXTRA_SMALL_PADDING),
            contentPadding = PaddingValues(SMALL_PADDING),
            content = {
                items(listHeroes) { hero ->
                    ItemHero(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .animateItemPlacement(
                                tween(durationMillis = 300)
                            ),
                        hero = hero,
                        onClick = { heroId ->
                            navController.navigate(Screen.Detail.passHeroId(heroId = heroId))
                        }
                    )
                }
            },
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding())
        )
    }
}

