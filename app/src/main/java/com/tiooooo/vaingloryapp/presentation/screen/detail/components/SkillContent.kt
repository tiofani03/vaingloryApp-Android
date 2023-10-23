package com.tiooooo.vaingloryapp.presentation.screen.detail.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tiooooo.vaingloryapp.domain.model.Hero
import com.tiooooo.vaingloryapp.utils.helper.listHeroes
import com.tiooooo.vaingloryapp.presentation.components.list.ItemSkill
import com.tiooooo.vaingloryapp.ui.theme.EXTRA_SMALL_PADDING
import com.tiooooo.vaingloryapp.ui.theme.MEDIUM_PADDING
import com.tiooooo.vaingloryapp.ui.theme.SMALL_PADDING
import com.tiooooo.vaingloryapp.ui.theme.Shapes

@Composable
fun SkillContent(
    modifier: Modifier = Modifier,
    hero: Hero,
    textColor: Color = MaterialTheme.colorScheme.onTertiary,
    activeColor: Color = MaterialTheme.colorScheme.primary,
    backgroundColor: Color = MaterialTheme.colorScheme.surfaceVariant,
) {
    var selectedSkillDesc by remember { mutableStateOf("") }
    var selectedSkillName by remember { mutableStateOf("") }

    Surface(
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier.background(backgroundColor),
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Skill",
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                lineHeight = 12.sp,
                color = textColor,
            )

            LazyRow {
                items(hero.skills) { skill ->
                    ItemSkill(
                        modifier = Modifier
                            .padding(
                                top = EXTRA_SMALL_PADDING,
                                start = EXTRA_SMALL_PADDING,
                                end = EXTRA_SMALL_PADDING,
                            )
                            .width(72.dp),
                        image = skill.skillImage,
                        skillName = skill.skillName,
                        skillDesc = skill.skillDesc,
                        isActive = skill.skillDesc == selectedSkillDesc,
                        textColor = textColor,
                        backgroundColor = backgroundColor,
                        activeColor = activeColor,
                    ) { text, it ->
                        selectedSkillName = if (text == selectedSkillName) "" else text
                        selectedSkillDesc = if (it == selectedSkillDesc) "" else it
                    }
                }
            }

            if (selectedSkillDesc.isNotEmpty()) {
                Surface(
                    modifier = Modifier.animateContentSize(),
                    shape = Shapes.medium,
                    color = activeColor,
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            modifier = Modifier.padding(SMALL_PADDING),
                            text = selectedSkillName,
                            fontSize = MaterialTheme.typography.labelSmall.fontSize,
                            overflow = TextOverflow.Ellipsis,
                            lineHeight = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = textColor,
                        )
                        Text(
                            modifier = Modifier
                                .padding(SMALL_PADDING)
                                .fillMaxWidth(),
                            text = selectedSkillDesc,
                            fontSize = MaterialTheme.typography.labelSmall.fontSize,
                            overflow = TextOverflow.Ellipsis,
                            lineHeight = 12.sp,
                            color = textColor,
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SkillContentPrev() {
    SkillContent(
        modifier = Modifier.padding(MEDIUM_PADDING).background(Color.Black),
        hero = listHeroes.first()
    )
}
