package com.tiooooo.vaingloryapp.presentation.screen.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.tiooooo.vaingloryapp.domain.model.Hero
import com.tiooooo.vaingloryapp.utils.helper.listHeroes
import com.tiooooo.vaingloryapp.presentation.components.list.ItemStatistic
import com.tiooooo.vaingloryapp.ui.theme.MEDIUM_PADDING

@Composable
fun PowerContent(
    modifier: Modifier = Modifier,
    hero: Hero,
    textColor: Color = MaterialTheme.colorScheme.onTertiary,
    progressIndicatorColor: Color = MaterialTheme.colorScheme.primary,
) {
    LazyColumn(
        modifier = modifier,
    ) {
        items(hero.power) { power ->
            ItemStatistic(
                text = power.name,
                currentValue = power.currentValue.toDouble(),
                maxValue = power.maxValue.toDouble(),
                textColor = textColor,
                progressIndicatorColor = progressIndicatorColor,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PowerContentPrev() {
    PowerContent(
        modifier = Modifier.padding(MEDIUM_PADDING).background(MaterialTheme.colorScheme.tertiary),
        hero = listHeroes.first()
    )
}
