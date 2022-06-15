package com.crownedjester.soft.waterdrinkremainder.presentation.user_statistics_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.importedFontFamily

@Composable
fun MonthSummary(
    modifier: Modifier = Modifier,
    summaryTitle: String,
    monthData: List<Int> = listOf(
        2500, 1000, 1500, 2000, 2250, 2500, 2500, 2500,
        2500, 1000, 1500, 2000, 2250, 3000, 3500,
        2000, 2250, 3000, 3500, 2000, 2250, 3000, 3500,
        2000, 2250, 2500, 3000, 3500, 2000, 2250
    ),
    dailyGoal: Int = 2500
) {

    val sphereProgressSize = with(LocalConfiguration.current) {
        (screenWidthDp / 2 - 16)
    }

    val count = monthData.count {
        it > dailyGoal
    }


    val completedGoalProgress = count / monthData.size.toFloat()
    val completedGoalPercentage = (count / 30f * 100).toInt()

    val textPadding = sphereProgressSize * 0.15f

    SummaryDefaultShape(
        modifier = modifier
            .height(
                (sphereProgressSize * 1.2f).dp
            )
    ) {
        Text(
            text = summaryTitle,
            fontFamily = importedFontFamily,
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Box(contentAlignment = Alignment.Center) {
                CircleProgress(
                    modifier = Modifier
                        .size(sphereProgressSize.dp)
                        .padding(8.dp),
                    progress = completedGoalProgress
                )

                Text(
                    text = "$completedGoalPercentage%",
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(
                            bottom = textPadding.dp
                        ),

                    fontFamily = importedFontFamily,
                    style = MaterialTheme.typography.h6,
                    color = if (completedGoalPercentage >= 40) Color.White else Color.Black
                )
            }

            Text(
                modifier = Modifier.padding(8.dp),
                text = "$count days\nof\n${monthData.size} days",
                fontFamily = importedFontFamily,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 22.sp
            )
        }

    }

}