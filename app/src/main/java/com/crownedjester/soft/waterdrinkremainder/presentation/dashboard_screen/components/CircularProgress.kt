package com.crownedjester.soft.waterdrinkremainder.presentation.dashboard_screen.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.progressSemantics
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
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

        CustomProgressIndicator(
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.2f),
            progress = 1f,
            color = thinBlue,
            strokeWidth = 12.dp
        )

        CustomProgressIndicator(
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

@Composable
private fun CustomProgressIndicator(
    progress: Float,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.primary,
    strokeWidth: Dp = ProgressIndicatorDefaults.StrokeWidth
) {

    val stroke = with(LocalDensity.current) {
        Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Butt)
    }
    Canvas(
        modifier
            .progressSemantics(progress)
            .rotate(15f)
            .size(40.dp)
    ) {

        val startAngle = 270f
        val sweep = progress * 330f
        drawCircularIndicator(startAngle, sweep, color, stroke)

    }

}

private fun DrawScope.drawCircularIndicator(
    startAngle: Float,
    sweep: Float,
    color: Color,
    stroke: Stroke
) {

    val diameterOffset = stroke.width / 2
    val arcDimen = size.width - 2 * diameterOffset

    drawArc(
        color = color,
        startAngle = startAngle,
        sweepAngle = sweep,
        useCenter = false,
        topLeft = Offset(diameterOffset, diameterOffset),
        size = Size(arcDimen, arcDimen),
        style = stroke,
    )

}