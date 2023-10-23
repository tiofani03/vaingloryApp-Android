package com.tiooooo.vaingloryapp.presentation.components.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.tiooooo.vaingloryapp.R
import com.tiooooo.vaingloryapp.ui.theme.EXTRA_SMALL_PADDING
import com.tiooooo.vaingloryapp.ui.theme.SMALL_PADDING

@Composable
fun ItemSkill(
    modifier: Modifier = Modifier,
    image: String,
    imageSize: Dp = 48.dp,
    skillName: String,
    skillDesc: String = "",
    isActive: Boolean = false,
    textColor: Color = MaterialTheme.colorScheme.onTertiary,
    activeColor: Color = MaterialTheme.colorScheme.primary,
    backgroundColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    onSkillClick: (String, String) -> Unit,
) {
    var isClicked by remember { mutableStateOf(false) }

    Surface(
        modifier = modifier.clickable {
            onSkillClick(skillName, skillDesc)
            isClicked = !isClicked
        },
        shape = RoundedCornerShape(
            topStart = SMALL_PADDING,
            topEnd = SMALL_PADDING,
        ),
        color = if (isActive) activeColor else backgroundColor
    ) {
        Column(
            modifier = Modifier.padding(EXTRA_SMALL_PADDING),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AsyncImage(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(imageSize),
                model = ImageRequest.Builder(context = LocalContext.current).data(image)
                    .crossfade(true).build(),
                error = painterResource(R.drawable.ic_placeholder),
                placeholder = painterResource(R.drawable.ic_placeholder),
                contentDescription = stringResource(R.string.app_logo),
                contentScale = ContentScale.Crop,
            )
            Text(
                modifier = Modifier.padding(
                    top = EXTRA_SMALL_PADDING, bottom = EXTRA_SMALL_PADDING
                ),
                text = skillName,
                fontSize = MaterialTheme.typography.labelSmall.fontSize,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = if (isActive) FontWeight.Bold else FontWeight.Normal,
                color = textColor,
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ItemSkillPreview() {
    ItemSkill(
        modifier = Modifier.size(64.dp), image = "", skillName = "Julia Gift"
    ) { it, s ->

    }
}
