package com.tiooooo.vaingloryapp.ui.screen.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.tiooooo.vaingloryapp.navigation.Screen
import com.tiooooo.vaingloryapp.ui.screen.home.components.ListContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {

    val allHeroes = homeViewModel.getAllHeroes.collectAsLazyPagingItems()
    Scaffold(modifier = modifier, topBar = {
        HomeTopBar(
            modifier = Modifier.fillMaxWidth(),
        ) {
            navController.navigate(Screen.Search.route)
        }
    }) {
        ListContent(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding()),
            heroes = allHeroes,
            navController = navController
        ){
            allHeroes.refresh()
        }
    }
}

