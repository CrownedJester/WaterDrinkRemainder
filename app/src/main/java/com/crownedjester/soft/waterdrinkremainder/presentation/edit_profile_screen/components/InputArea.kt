package com.crownedjester.soft.waterdrinkremainder.presentation.edit_profile_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.unit.dp
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.LightBlue
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.importedFontFamily
import com.crownedjester.soft.waterdrinkremainder.presentation.util.Formats.hidePass
import com.crownedjester.soft.waterdrinkremainder.presentation.util.Formats.trimC


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun InputArea(
    modifier: Modifier = Modifier,
    username: String = "Crowned Jester",
    password: String = "some pass",
    name: String = "Sergey"
) {

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    Column(
        modifier = modifier.clickable {
            keyboardController?.hide()
            focusManager.clearFocus(true)
        },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        InputTextField(
            value = username,
            label = "Username",
            onValueChange = {

            }
        )

        Text(
            modifier = Modifier
                .fillMaxWidth(0.80f)
                .height(24.dp)
                .padding(top = 2.dp, start = 24.dp),
            text = "@${username.trimC().toLowerCase(Locale.current)}",
            fontFamily = importedFontFamily,
            fontWeight = FontWeight.Light,
            color = LightBlue,
            fontStyle = FontStyle.Italic
        )

        Spacer(modifier = Modifier.height(SPACER_HEIGHT.dp))

        InputTextField(
            value = password.hidePass(),
            label = "Password",
            onValueChange = {

            }
        )

        Spacer(modifier = Modifier.height(SPACER_HEIGHT.dp))

        InputTextField(
            value = "".hidePass(),
            label = "Password Again",
            onValueChange = {

            }
        )

        Spacer(modifier = Modifier.height(SPACER_HEIGHT.dp))

        InputTextField(
            value = name,
            label = "First Name",
            onValueChange = {

            }
        )

    }
}

private const val SPACER_HEIGHT = 16