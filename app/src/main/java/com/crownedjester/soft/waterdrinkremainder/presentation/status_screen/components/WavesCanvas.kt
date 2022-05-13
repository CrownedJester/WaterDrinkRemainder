package com.crownedjester.soft.waterdrinkremainder.presentation.status_screen.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.DeepBlue
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.ThinBlue

@Composable
fun WavesCanvas(modifier: Modifier = Modifier, wavesHeight: Float) {

    val deltaXAnim = rememberInfiniteTransition()

    val dx by deltaXAnim.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(WIDTH_ANIMATION_DURATION, easing = FastOutLinearInEasing)
        )
    )

    val screenWidthPx = with(LocalDensity.current) {
        (LocalConfiguration.current.screenWidthDp * density) - 150.dp.toPx()
    }

    val animTranslate by animateFloatAsState(
        targetValue = screenWidthPx,
        animationSpec = TweenSpec(ANIMATION_TRANSLATION_DURATION, easing = LinearEasing)
    )

    val waveHeight by animateFloatAsState(
        targetValue = wavesHeight,
        animationSpec = TweenSpec(WAVE_HEIGHT_ANIMATION_DURATION, easing = FastOutLinearInEasing)
    )

    val waveWidth = WAVE_WIDTH

    val originalY = ORIGINAL_Y

    val path = Path()

    Canvas(
        modifier = modifier.fillMaxSize(),
        onDraw = {
            translate(top = animTranslate) {

                drawPath(
                    path = path,
                    brush = Brush.verticalGradient(
                        listOf(
                            ThinBlue.copy(0.5f),
                            DeepBlue.copy(0.9f)
                        )
                    )
                )

                path.reset()

                val halfWaveWidth = waveWidth / 2

                path.moveTo(-waveWidth + (waveWidth * dx), originalY.dp.toPx())

                (-waveWidth..(size.width.toInt() + waveWidth) step waveWidth).forEach { _ ->
                    path.relativeQuadraticBezierTo(
                        halfWaveWidth.toFloat() / 2,
                        -waveHeight,
                        halfWaveWidth.toFloat(),
                        DEFAULT_DY2
                    )
                    path.relativeQuadraticBezierTo(
                        halfWaveWidth.toFloat() / 2,
                        waveHeight,
                        halfWaveWidth.toFloat(),
                        DEFAULT_DY2
                    )
                }

                path.lineTo(size.width, size.height)
                path.lineTo(0f, size.height)
            }

        }
    )
}

private const val ANIMATION_TRANSLATION_DURATION = 25000
private const val WAVE_HEIGHT_ANIMATION_DURATION = 25000
private const val WIDTH_ANIMATION_DURATION = 1500
private const val WAVE_WIDTH = 275
private const val ORIGINAL_Y = 150f
private const val DEFAULT_DY2 = 0f