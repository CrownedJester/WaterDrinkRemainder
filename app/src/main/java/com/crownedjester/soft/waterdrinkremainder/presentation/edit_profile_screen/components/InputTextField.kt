package com.crownedjester.soft.waterdrinkremainder.presentation.edit_profile_screen.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.DeepBlue
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.ThinBlue
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.importedFontFamily

@Composable
fun InputTextField(
    modifier: Modifier = Modifier,
    value: String,
    label: String,
    onValueChange: (String) -> Unit,
    isSingleLine: Boolean = true
) {

    TextField(
        modifier = modifier
            .fillMaxWidth(WIDTH_FRACTION)
            .border(
                width = BORDER_WIDTH.dp,
                color = Color.Black,
                shape = RoundedCornerShape(
                    CORNER_ANGLE_PERCENTAGE
                )
            ),
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = label,
                fontStyle = FontStyle.Italic,
                fontFamily = importedFontFamily,
                style = MaterialTheme.typography.body2
            )
        },
        singleLine = isSingleLine,
        shape = RoundedCornerShape(CORNER_ANGLE_PERCENTAGE),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            textColor = Color.Black,
            unfocusedLabelColor = ThinBlue,
            focusedLabelColor = DeepBlue
        )
    )

}

private const val CORNER_ANGLE_PERCENTAGE = 12
private const val BORDER_WIDTH = 1.2f
private const val WIDTH_FRACTION = 0.80f