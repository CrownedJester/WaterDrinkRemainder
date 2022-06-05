package com.crownedjester.soft.waterdrinkremainder.presentation.edit_profile_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.crownedjester.soft.waterdrinkremainder.R
import com.crownedjester.soft.waterdrinkremainder.presentation.common.AccountSettingsTopBar
import com.crownedjester.soft.waterdrinkremainder.presentation.edit_profile_screen.components.InputArea

@Composable
fun EditProfileScreen(
    modifier: Modifier = Modifier,
    screenTitle: String,
    navController: NavController
) {

    Column(modifier = modifier.fillMaxSize()) {

        AccountSettingsTopBar(
            screenTitle = screenTitle,
            onNavigateBack = {
                navController.navigateUp()
            },
            additionalOptionImageVector = Icons.Default.Check,
            onAdditionalOptionClick = { navController.navigateUp() }
        )

        Spacer(modifier = Modifier.height(30.dp))

        InputArea(modifier = Modifier.fillMaxWidth())

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            painter = painterResource(id = R.drawable.picture_edit_user_data),
            contentDescription = null
        )
    }
}