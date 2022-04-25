package com.crownedjester.soft.waterdrinkremainder.presentation.dashboard_screen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.deepBlue
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.fontFamily
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.lightBlue
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.thinBlue
import kotlin.math.roundToInt

@Composable
fun CircularProgress(
    drankAmount: Int,
    dailyGoalAmount: Int
) {

    Box(
        modifier = Modifier
            .size(200.dp),
        contentAlignment = Alignment.Center
    ) {

        CircularProgressIndicator(
            modifier = Modifier.fillMaxSize()
                .alpha(0.2f),
            progress = 1f,
            color = thinBlue,
            strokeWidth = 12.dp
        )

        CircularProgressIndicator(
            modifier = Modifier.fillMaxSize(),
            progress = drankAmount.toFloat() / dailyGoalAmount.toFloat(),
            color = lightBlue,
            strokeWidth = 12.dp
        )

        Text(
            textAlign = TextAlign.Center,
            color = deepBlue,
            text = buildAnnotatedString {

                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontFamily = fontFamily,
                        fontSize = 40.sp
                    )
                ) {
                    append("${(drankAmount.toFloat() / dailyGoalAmount.toFloat() * 100).roundToInt()}%")
                }

                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Normal,
                        fontFamily = fontFamily,
                        fontSize = 24.sp
                    )
                ) {
                    append("\n%,d ml\n".format(drankAmount))
                }

                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Thin,
                        fontFamily = fontFamily,
                        fontSize = 14.sp,
                    )
                ) {
                    append("%,d ml".format(drankAmount - dailyGoalAmount))
                }

            }
        )

    }

}