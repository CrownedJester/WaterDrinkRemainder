package com.crownedjester.soft.waterdrinkremainder.presentation.user_statistics_screen.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.importedFontFamily

@Composable
fun HydrationSummary(modifier: Modifier = Modifier, summaryTitle: String, summaryData: Int) {

    SummaryDefaultShape(modifier = modifier) {

        Text(
            text = summaryTitle,
            fontFamily = importedFontFamily,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.body1
        )

        Text(
            text = "$summaryData ml",
            fontFamily = importedFontFamily,
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.body2
        )

    }
}
