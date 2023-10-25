package com.tiooooo.vaingloryapp.ui.components.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.tiooooo.vaingloryapp.R
import com.tiooooo.vaingloryapp.data.model.Hero
import com.tiooooo.vaingloryapp.utils.helper.hero
import com.tiooooo.vaingloryapp.ui.theme.LARGE_PADDING
import com.tiooooo.vaingloryapp.ui.theme.SMALL_PADDING

@Composable
fun ItemHero(
    modifier: Modifier = Modifier,
    hero: Hero,
    onClick: (heroId: Int) -> Unit,
) {
    Box(
        modifier = modifier.clickable {
            onClick(hero.id)
        }, contentAlignment = Alignment.BottomCenter
    ) {
        Surface(shape = RoundedCornerShape(size = LARGE_PADDING)) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = ImageRequest
                    .Builder(
                        context = LocalContext.current
                    )
                    .data(hero.image)
                    .crossfade(true)
                    .build(),
                error = painterResource(R.drawable.ic_placeholder),
                placeholder = painterResource(R.drawable.ic_placeholder),
                contentDescription = stringResource(R.string.app_logo),
                contentScale = ContentScale.Crop
            )
        }

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Black.copy(alpha = 0.4f),
            shape = RoundedCornerShape(
                bottomEnd = LARGE_PADDING,
                bottomStart = LARGE_PADDING,
            ),
        ) {
            Column(
                modifier = Modifier
                    .padding(bottom = LARGE_PADDING),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom,
            ) {
                Text(
                    modifier = Modifier.padding(top = SMALL_PADDING),
                    text = hero.name.uppercase(),
                    color = Color.White,
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    modifier = Modifier,
                    text = "${hero.role}, ${hero.position}".uppercase(),
                    color = Color.White.copy(alpha = ContentAlpha.medium),
                    fontSize = MaterialTheme.typography.labelSmall.fontSize,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}


@Preview
@Composable
fun ItemHeroPreview() {
    ItemHero(
        modifier = Modifier.height(400.dp), hero = hero
    ) {

    }
}
