package com.crownedjester.soft.waterdrinkremainder.presentation.reminder_settings_screen.components

import androidx.compose.animation.*
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateInt
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.DeepBlue
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.LightBlue
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.ThinBlue
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.importedFontFamily

@Composable
fun ReminderSettingsItem(
    modifier: Modifier = Modifier,
    optionTitle: String,
    isOptionActive: Boolean = false,
    onSwitchChanged: (Boolean) -> Unit,
    additionalContent: @Composable (ColumnScope.() -> Unit)? = null,
) {

    var isActive by remember { mutableStateOf(false) }

    val transition = updateTransition(targetState = isActive, label = "")

    var cardHeight by remember { mutableStateOf(0) }

    val cornersTransition by transition.animateInt(label = "") {
        if (additionalContent == null || !it) SHAPE_CORNERS_PERCENTAGE
        else if (it && additionalContent != null) {

            when {
                cardHeight < 60 ->
                    SHAPE_CORNERS_PERCENTAGE
                cardHeight < 108 ->
                    (SHAPE_CORNERS_PERCENTAGE * 0.85f).toInt()
                cardHeight < 196 ->
                    (SHAPE_CORNERS_PERCENTAGE * 0.60f).toInt()
                cardHeight <= 356 ->
                    (SHAPE_CORNERS_PERCENTAGE * 0.45f).toInt()
                else ->
                    (SHAPE_CORNERS_PERCENTAGE * 0.25f).toInt()
            }
        } else 0

    }


    val contentAlpha by transition.animateFloat(label = "card alpha") {
        if (it) 1f
        else 0.3f
    }


    Card(
        modifier = modifier
            .alpha(contentAlpha),
        shape = RoundedCornerShape(cornersTransition),
        border = BorderStroke(width = 1.dp, color = Color.Black)
    ) {

        Column(modifier = Modifier
            .fillMaxWidth()
            .onSizeChanged {
                cardHeight = it.height
            }) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = optionTitle,
                    fontFamily = importedFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )

                Switch(
                    checked = isActive,
                    onCheckedChange = { isActive = !isActive },
                    colors = SwitchDefaults.colors(
                        checkedTrackColor = DeepBlue,
                        uncheckedTrackColor = LightBlue,
                        checkedThumbColor = ThinBlue,
                        uncheckedThumbColor = Color.White
                    )
                )
            }

            AnimatedVisibility(
                modifier = Modifier,
                visible = isActive && additionalContent != null,
                enter = expandVertically(animationSpec = tween(400)) + fadeIn(
                    animationSpec = tween(
                        400
                    )
                ),
                exit = shrinkVertically(animationSpec = tween(400)) + fadeOut(
                    animationSpec = tween(
                        400
                    )
                )
            ) {

                Column(
                    content = additionalContent!!
                )

            }

        }
    }
}

private const val SHAPE_CORNERS_PERCENTAGE = 20
private const val CARD_DEFAULT_HEIGHT = 48