package com.tiooooo.vaingloryapp.ui.screen.home.components

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.tiooooo.vaingloryapp.data.model.Hero
import com.tiooooo.vaingloryapp.navigation.Screen
import com.tiooooo.vaingloryapp.ui.components.common.EmptyScreen
import com.tiooooo.vaingloryapp.ui.components.common.ShimmerEffect
import com.tiooooo.vaingloryapp.ui.components.list.ItemHero
import com.tiooooo.vaingloryapp.ui.theme.EXTRA_SMALL_PADDING
import com.tiooooo.vaingloryapp.ui.theme.SMALL_PADDING
import com.tiooooo.vaingloryapp.utils.helper.parseErrorMessage

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListContent(
    modifier: Modifier = Modifier,
    heroes: LazyPagingItems<Hero>,
    navController: NavHostController,
    onRefresh: () -> Unit? = {},
) {
    val result = handlePagingResult(
        heroes = heroes,
        onRefresh = onRefresh,
    )

    if (result) {
        LazyVerticalStaggeredGrid(
            modifier = modifier,
            columns = StaggeredGridCells.Fixed(2),
            verticalItemSpacing = EXTRA_SMALL_PADDING,
            horizontalArrangement = Arrangement.spacedBy(EXTRA_SMALL_PADDING),
            contentPadding = PaddingValues(SMALL_PADDING),
            content = {
                items(heroes.itemCount) { index ->
                    val hero = heroes[index]
                    hero?.let {
                        ItemHero(modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .animateItemPlacement(
                                tween(durationMillis = 300)
                            ), hero = hero, onClick = { heroId ->
                            navController.navigate(Screen.Detail.passHeroId(heroId = heroId))
                        })
                    } ?: kotlin.run {
                        EmptyScreen {
                            onRefresh()
                        }
                    }
                }
            },
        )
    }
}

@Composable
fun handlePagingResult(
    heroes: LazyPagingItems<Hero>,
    onRefresh: () -> Unit? = {},
): Boolean {
    heroes.apply {
        val error = when {
            loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
            loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
            loadState.append is LoadState.Error -> loadState.append as LoadState.Error
            else -> null
        }

        return when {
            loadState.refresh is LoadState.Loading -> {
                ShimmerEffect()
                false
            }

            loadState.prepend is LoadState.Loading -> {
                ShimmerEffect()
                false
            }

            error != null -> {
                EmptyScreen(
                    message = parseErrorMessage(error),
                    onRefresh = { onRefresh() }
                )
                false
            }



            heroes.itemCount < 1 && loadState.prepend !is LoadState.Loading -> {
                EmptyScreen { onRefresh() }
                false
            }

            else -> true
        }
    }
}
