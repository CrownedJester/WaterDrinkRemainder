package com.crownedjester.soft.waterdrinkremainder.presentation.status_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import com.crownedjester.soft.waterdrinkremainder.presentation.HydrationViewModel
import com.crownedjester.soft.waterdrinkremainder.presentation.status_screen.components.CustomHydrationDialog
import com.crownedjester.soft.waterdrinkremainder.presentation.status_screen.components.WavesCanvas
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.DeepBlue
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.importedFontFamily
import com.crownedjester.soft.waterdrinkremainder.presentation.util.Formats
import com.crownedjester.soft.waterdrinkremainder.presentation.util.Formats.calculateRemaining
import com.crownedjester.soft.waterdrinkremainder.presentation.util.Formats.toSeparatedDecimalString

@Composable
fun StatusScreen(
    modifier: Modifier = Modifier,
    viewModel: HydrationViewModel,
    dailyGoalHydration: Int = 2500
) {

    var isDialogShown by remember { mutableStateOf(false) }
    val currentDailyHydration by viewModel.currentDailyHydration.collectAsState()

    CustomHydrationDialog(
        isDialogShown = isDialogShown,
        onAccept = {
            viewModel.updateDailyHydration(it)
        },
        onCancel = {/*todo*/ }
    ) {
        isDialogShown = it
    }

    val screenHeightDp = LocalConfiguration.current.screenHeightDp

    val topMargin = screenHeightDp.toFloat() * Formats.calculateProgress(
        currentDailyHydration,
        dailyGoalHydration
    )

    val remainingHydration = calculateRemaining(currentDailyHydration, dailyGoalHydration)

    Box(
        modifier = modifier.fillMaxSize()
    ) {

        ConstraintLayout(modifier = Modifier.fillMaxSize()) {

            val (waves) = createRefs()

            WavesCanvas(
                wavesHeight = WAVES_HEIGHT,
                modifier = Modifier
                    .fillMaxSize()
                    .zIndex(0f)
                    .constrainAs(waves) {

                        top.linkTo(
                            parent.top,
                            topMargin.dp
                        )

                        linkTo(start = parent.start, end = parent.end)

                        bottom.linkTo(parent.bottom)
                    }
            )

            Column(modifier = Modifier.fillMaxSize()) {

                Spacer(modifier = Modifier.height(48.dp))

                IconButton(modifier = Modifier
                    .background(color = Color.Transparent, shape = CircleShape)
                    .offset((-32).dp)
                    .align(Alignment.End)
                    .size(32.dp),
                    onClick = { /*TODO*/ },
                    content = {
                        Icon(
                            imageVector = Icons.Default.Alarm, contentDescription = "alarm icon"
                        )
                    }
                )

                Spacer(modifier = Modifier.height(96.dp))

                Text(modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = buildAnnotatedString {

                        withStyle(
                            style = SpanStyle(
                                fontFamily = importedFontFamily,
                                fontWeight = FontWeight.Bold,
                                color = DeepBlue,
                                fontSize = 48.sp,
                                letterSpacing = 2.sp
                            )
                        ) {
                            append(currentDailyHydration.toSeparatedDecimalString(textAfter = " ml"))
                        }

                        withStyle(
                            style = SpanStyle(
                                fontFamily = importedFontFamily,
                                fontWeight = FontWeight.Normal,
                                color = DeepBlue,
                                fontSize = 16.sp,
                            )
                        ) {
                            append(
                                (remainingHydration).toSeparatedDecimalString(
                                    textBefore = "\nRemaining: ", textAfter = " ml"
                                )
                            )
                        }

                    })

                Spacer(modifier = Modifier.height(200.dp))

                FloatingActionButton(modifier = Modifier.align(Alignment.CenterHorizontally),
                    backgroundColor = Color.White,
                    onClick = {
                        isDialogShown = true
                    },
                    content = {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "add custom amount water"
                        )
                    }
                )

            }
        }
    }
}

private const val WAVES_HEIGHT = 60f