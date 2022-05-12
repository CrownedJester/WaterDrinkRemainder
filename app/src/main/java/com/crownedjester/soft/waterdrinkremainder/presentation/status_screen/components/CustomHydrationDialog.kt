package com.crownedjester.soft.waterdrinkremainder.presentation.status_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.DeepBlue
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.importedFontFamily
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.LightBlue

@Composable
fun CustomHydrationDialog(
    isDialogShown: Boolean,
    onAccept: () -> Unit,
    onCancel: () -> Unit,
    setShownDialog: (Boolean) -> Unit
) {

    if (isDialogShown) {
        var sliderValue by remember {
            mutableStateOf(0f)
        }

        var value by remember {
            mutableStateOf(0)
        }

        AlertDialog(
            text = {
                Column {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Set amount of drank water",
                        fontSize = 20.sp,
                        fontFamily = importedFontFamily,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center,
                        color = DeepBlue,
                        letterSpacing = 1.sp
                    )

                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .alpha(0.3f)
                            .height(1.dp),
                        color = LightBlue
                    )
                }
            },

            buttons = {

                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "$value",
                    fontFamily = importedFontFamily,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center,
                    color = LightBlue
                )

                Slider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    value = sliderValue,
                    onValueChange = {
                        sliderValue = it
                        value = (it * 750).toInt() /*todo add const value*/
                    }
                )



                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                ) {

                    Button(onClick = {
                        onCancel()
                        setShownDialog(false)
                    }) {
                        Text(
                            text = "Cancel",
                            fontFamily = importedFontFamily,
                            fontWeight = FontWeight.Normal
                        )
                    }

                    Button(onClick = {
                        onAccept()
                        setShownDialog(false)
                    }) {
                        Text(
                            text = "Accept",
                            fontFamily = importedFontFamily,
                            fontWeight = FontWeight.Normal
                        )
                    }
                }
            },
            onDismissRequest = { setShownDialog(false) },
            properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true),
        )

    }
}
