package com.tiooooo.vaingloryapp.presentation.components.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.tiooooo.vaingloryapp.R
import com.tiooooo.vaingloryapp.ui.theme.NETWORK_ERROR_ICON_HEIGHT
import com.tiooooo.vaingloryapp.ui.theme.SMALL_PADDING

@Composable
fun EmptyScreen(
    modifier: Modifier = Modifier,
    icon: Int = R.drawable.ic_network_error,
    message: String = stringResource(id = R.string.no_data),
    alphaAnim: Float = 1f,
    swipeEnabled: Boolean = true,
    onRefresh: () -> Unit,
) {
    /*----- declarations ----- */
    var isRefreshing by remember { mutableStateOf(false) }


    /*----- Ui ----- */
    SwipeRefresh(modifier = modifier,
        swipeEnabled = swipeEnabled,
        state = rememberSwipeRefreshState(isRefreshing = isRefreshing),
        onRefresh = {
            isRefreshing = true
            onRefresh()
            isRefreshing = false
        }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Icon(
                modifier = Modifier
                    .alpha(alphaAnim)
                    .size(NETWORK_ERROR_ICON_HEIGHT),
                painter = painterResource(id = icon),
                contentDescription = "Empty Image",
                tint = MaterialTheme.colorScheme.surfaceTint
            )
            Text(
                modifier = Modifier
                    .alpha(alphaAnim)
                    .padding(top = SMALL_PADDING),
                text = message,
                color = MaterialTheme.colorScheme.surfaceTint,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EmptyScreenPreview() {
    EmptyScreen {

    }
}
