package com.tiooooo.vaingloryapp.presentation.screen.detail.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tiooooo.vaingloryapp.domain.model.Hero
import com.tiooooo.vaingloryapp.utils.helper.listHeroes
import com.tiooooo.vaingloryapp.presentation.components.list.ItemSkin
import com.tiooooo.vaingloryapp.ui.theme.EXTRA_SMALL_PADDING
import com.tiooooo.vaingloryapp.ui.theme.MEDIUM_PADDING

@Composable
fun SkinContent(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(start = MEDIUM_PADDING, end = MEDIUM_PADDING),
    imageWidth: Dp = 225.dp,
    imageHeight: Dp = 125.dp,
    hero: Hero,
) {
    LazyRow(
        modifier = modifier, contentPadding = contentPadding
    ) {
        items(hero.skins) { skill ->
            ItemSkin(
                modifier = Modifier
                    .padding(EXTRA_SMALL_PADDING)
                    .width(imageWidth)
                    .height(imageHeight),
                image = skill.skinImage,
                text = skill.skinName,
                type = skill.skinType,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SkinContentPrev() {
    SkinContent(
        hero = listHeroes.first()
    )
}
