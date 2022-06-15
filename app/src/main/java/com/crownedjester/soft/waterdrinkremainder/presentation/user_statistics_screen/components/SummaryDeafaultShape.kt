package com.crownedjester.soft.waterdrinkremainder.presentation.user_statistics_screen.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

@Composable
fun SummaryDefaultShape(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {

    val width = with(LocalConfiguration.current) {
        screenWidthDp / 2.3
    }

    Column(
        modifier = modifier
            .height(48.dp)
            .width(width.dp)
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RectangleShape
            ),
        content = content,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    )

}