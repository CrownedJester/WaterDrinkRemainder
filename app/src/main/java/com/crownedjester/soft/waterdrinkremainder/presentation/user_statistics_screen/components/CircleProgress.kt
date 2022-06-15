package com.crownedjester.soft.waterdrinkremainder.presentation.user_statistics_screen.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.progressSemantics
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.LightBlue

@Composable
fun CircleProgress(modifier: Modifier = Modifier, progress: Float) {

    Canvas(
        modifier = modifier
            .progressSemantics(progress)
    ) {

        drawArc(
            color = LightBlue,
            startAngle = calculateStartAngle(progress = progress),
            sweepAngle = progress * 360f,
            useCenter = false,
            style = Fill
        )

        drawCircle(color = Color.Black, style = Stroke(width = 4f, cap = StrokeCap.Round))

    }


}


private fun calculateStartAngle(
    initAngle: Float = INIT_ANGLE,
    progress: Float,
    diffAngle: Float = DIFF_ANGLE
) =
    initAngle - progress * diffAngle

private const val INIT_ANGLE = 90f
private const val DIFF_ANGLE = 180f
