package com.crownedjester.soft.waterdrinkremainder.presentation.reminder_settings_screen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.importedFontFamily

@Composable
fun SpecifyTimeAlarmItem(modifier: Modifier = Modifier, time: String) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Text(
            text = time,
            fontFamily = importedFontFamily,
            textAlign = TextAlign.End,
            fontSize = FONT_SIZE.sp
        )

        IconButton(onClick = { }) {

            Icon(
                modifier = Modifier
                    .size(
                        (FONT_SIZE * 2.25f).dp
                    )
                    .graphicsLayer {
                        rotationZ = 45f
                    }, imageVector = Icons.Default.AddCircleOutline, contentDescription = ""
            )

        }
    }
}

private const val FONT_SIZE = 14