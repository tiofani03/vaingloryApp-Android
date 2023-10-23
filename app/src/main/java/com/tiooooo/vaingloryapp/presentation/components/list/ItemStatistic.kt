package com.tiooooo.vaingloryapp.presentation.components.list

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tiooooo.vaingloryapp.ui.theme.PROGRESS_BAR_SIZE
import com.tiooooo.vaingloryapp.ui.theme.SMALL_PADDING
import com.tiooooo.vaingloryapp.ui.theme.Shapes

@Composable
fun ItemStatistic(
    modifier: Modifier = Modifier,
    text: String,
    currentValue: Double,
    maxValue: Double,
    textColor: Color = MaterialTheme.colorScheme.onTertiary,
    progressIndicatorColor: Color = MaterialTheme.colorScheme.primary,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier.weight(0.3f),
            text = text,
            fontSize = MaterialTheme.typography.labelSmall.fontSize,
            fontWeight = FontWeight.Bold,
            color = textColor,
        )
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(
                    vertical = SMALL_PADDING,
                    horizontal = SMALL_PADDING,
                )
                .clip(Shapes.small)
                .weight(0.7f)
            ,
            progress = (currentValue / maxValue).toFloat(),
            color = progressIndicatorColor,
            trackColor = progressIndicatorColor.copy(alpha = 0.3f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ItemStatisticPreview() {
    ItemStatistic(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = SMALL_PADDING)
            .height(PROGRESS_BAR_SIZE),
        text = "Attack",
        currentValue = 75.0,
        maxValue = 100.0,
    )
}
