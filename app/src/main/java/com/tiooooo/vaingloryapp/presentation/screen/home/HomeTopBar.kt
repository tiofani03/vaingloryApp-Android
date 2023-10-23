package com.tiooooo.vaingloryapp.presentation.screen.home

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.tiooooo.vaingloryapp.R

@Composable
fun HomeTopBar(
    modifier: Modifier = Modifier,
    onSearchClick: () -> Unit,
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = "VaingloryApp",
                color = MaterialTheme.colorScheme.tertiary,
            )
        },
        actions = {
            IconButton(onClick = { onSearchClick() }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.search_icon),
                    tint = MaterialTheme.colorScheme.tertiary,
                )
            }
        },
        backgroundColor = MaterialTheme.colorScheme.background,
    )
}

@Preview
@Composable
fun HomeTopBarPreview() {
    HomeTopBar {

    }
}
