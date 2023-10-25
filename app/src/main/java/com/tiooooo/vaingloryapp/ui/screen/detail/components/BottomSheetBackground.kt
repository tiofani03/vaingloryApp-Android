package com.tiooooo.vaingloryapp.ui.screen.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.tiooooo.vaingloryapp.R
import com.tiooooo.vaingloryapp.ui.theme.INFO_ICON_SIZE
import com.tiooooo.vaingloryapp.ui.theme.SMALL_PADDING

@Composable
fun BottomSheetBackground(
    modifier: Modifier = Modifier,
    heroImage: String,
    imageFraction: Float = 1f,
    onCloseClicked: () -> Unit,
) {
    Box(
        modifier = modifier
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = imageFraction + 0.4f)
                .align(Alignment.TopStart),
            model = ImageRequest
                .Builder(context = LocalContext.current)
                .data(heroImage)
                .crossfade(true)
                .build(),
            error = painterResource(R.drawable.ic_placeholder),
            placeholder = painterResource(R.drawable.ic_placeholder),
            contentDescription = stringResource(R.string.app_logo),
            contentScale = ContentScale.Crop,
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
        ) {
            IconButton(
                modifier = Modifier.padding(all = SMALL_PADDING), onClick = onCloseClicked
            ) {
                Icon(
                    modifier = Modifier.size(INFO_ICON_SIZE),
                    imageVector = Icons.Default.Close,
                    contentDescription = stringResource(id = R.string.close_icon),
                    tint = Color.White,
                )
            }
        }
    }
}
