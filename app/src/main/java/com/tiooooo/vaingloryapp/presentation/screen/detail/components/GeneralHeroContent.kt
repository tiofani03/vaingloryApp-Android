package com.tiooooo.vaingloryapp.presentation.screen.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ContentAlpha
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.tiooooo.vaingloryapp.domain.model.Hero
import com.tiooooo.vaingloryapp.ui.theme.MEDIUM_PADDING
import com.tiooooo.vaingloryapp.ui.theme.SMALL_PADDING
import com.tiooooo.vaingloryapp.utils.helper.listHeroes

@Composable
fun GeneralHeroContent(
    modifier: Modifier = Modifier,
    hero: Hero,
    textColor: Color = MaterialTheme.colorScheme.onTertiary,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = hero.name,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.displayMedium.fontSize,
            color = textColor,
        )
        Text(
            modifier = Modifier
                .alpha(ContentAlpha.medium)
                .fillMaxWidth(),
            text = "${hero.role}, ${hero.position}".uppercase(),
            fontSize = MaterialTheme.typography.labelSmall.fontSize,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = textColor,
        )
        Text(
            modifier = Modifier
                .padding(top = SMALL_PADDING)
                .fillMaxWidth(),
            text = hero.desc,
            fontSize = MaterialTheme.typography.labelSmall.fontSize,
            overflow = TextOverflow.Ellipsis,
            lineHeight = 12.sp,
            color = textColor,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GeneralHeroContentPrev() {
    GeneralHeroContent(
        modifier = Modifier
            .padding(vertical = SMALL_PADDING, horizontal = MEDIUM_PADDING)
            .background(MaterialTheme.colorScheme.tertiary),
        hero = listHeroes.first()
    )
}
