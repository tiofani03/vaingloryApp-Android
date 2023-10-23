package com.tiooooo.vaingloryapp.presentation.screen.detail.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tiooooo.vaingloryapp.domain.model.Hero
import com.tiooooo.vaingloryapp.ui.theme.MEDIUM_PADDING
import com.tiooooo.vaingloryapp.ui.theme.SMALL_PADDING
import com.tiooooo.vaingloryapp.utils.helper.listHeroes

@Composable
fun BottomSheetContent(
    modifier: Modifier = Modifier,
    hero: Hero,
    vibrant: Color = MaterialTheme.colorScheme.primary,
    darkVibrant: Color = MaterialTheme.colorScheme.tertiary,
    onDarkVibrant: Color = MaterialTheme.colorScheme.surface,
) {
    LazyColumn(
        modifier = modifier,
    ) {
        item {
            GeneralHeroContent(
                modifier = Modifier.padding(vertical = SMALL_PADDING, horizontal = MEDIUM_PADDING),
                hero = hero,
                textColor = onDarkVibrant
            )
        }
        item {
            PowerContent(
                modifier = Modifier
                    .padding(vertical = SMALL_PADDING, horizontal = MEDIUM_PADDING)
                    .heightIn(max = 500.dp),
                hero = hero,
                textColor = onDarkVibrant,
                progressIndicatorColor = vibrant,
            )
        }

        item {
            SkillContent(
                modifier = Modifier
                    .animateContentSize()
                    .padding(vertical = SMALL_PADDING, horizontal = MEDIUM_PADDING),
                hero = hero,
                textColor = onDarkVibrant,
                activeColor = vibrant.copy(alpha = 0.6f),
                backgroundColor = darkVibrant,
            )
        }
        item {
            Column(
                modifier.background(darkVibrant)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = SMALL_PADDING, start = MEDIUM_PADDING),
                    text = "Skin",
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 12.sp,
                    color = onDarkVibrant,
                )

                SkinContent(
                    modifier = Modifier.background(darkVibrant), hero = hero
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BottomSheetContentPreview() {
    BottomSheetContent(
        modifier = Modifier.background(MaterialTheme.colorScheme.tertiary), hero = listHeroes.first()
    )
}