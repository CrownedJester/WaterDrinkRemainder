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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crownedjester.soft.waterdrinkremainder.presentation.status_screen.components.CustomHydrationDialog
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.deepBlue
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.fontFamily

@Composable
fun StatusScreen(drankAmount: Int, dailyGoalAmount: Int) {

    var isDialogShown by remember { mutableStateOf(false) }

    CustomHydrationDialog(
        isDialogShown = isDialogShown,
        onAccept = { /*TODO*/ },
        onCancel = {/*todo*/ }
    ) {
        isDialogShown = it
    }

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
            })

        Spacer(modifier = Modifier.height(96.dp))

        Text(modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = buildAnnotatedString {

                withStyle(
                    style = SpanStyle(
                        fontFamily = fontFamily,
                        fontWeight = FontWeight.Bold,
                        color = deepBlue,
                        fontSize = 48.sp,
                        letterSpacing = 2.sp
                    )
                ) {
                    append("%,d ml".format(drankAmount))
                }

                withStyle(
                    style = SpanStyle(
                        fontFamily = fontFamily,
                        fontWeight = FontWeight.Normal,
                        color = deepBlue,
                        fontSize = 16.sp,
                    )
                ) {
                    append("\nRemaining: %,d ml".format(dailyGoalAmount - drankAmount))
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
                    imageVector = Icons.Default.Add, contentDescription = "add custom amount water"
                )
            }
        )


    }

}
