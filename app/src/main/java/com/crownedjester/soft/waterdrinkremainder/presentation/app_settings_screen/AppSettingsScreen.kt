package com.crownedjester.soft.waterdrinkremainder.presentation.app_settings_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Switch
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Copyright
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.crownedjester.soft.waterdrinkremainder.presentation.app_settings_screen.components.SettingsItem
import com.crownedjester.soft.waterdrinkremainder.presentation.common.AccountSettingsTopBar
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.LightBlue

@Composable
fun AppSettingsScreen(
    modifier: Modifier = Modifier,
    screenTitle: String,
    navController: NavController
) {

    var isActive by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        AccountSettingsTopBar(
            screenTitle = screenTitle,
            onNavigateBack = { navController.navigateUp() }
        )

        Spacer(modifier = Modifier.size(0.dp))

        SettingsItem(imageVector = Icons.Outlined.DarkMode, title = "Dark mode") {
            Switch(checked = isActive, onCheckedChange = { isActive = !isActive})
        }


        SettingsItem(
            imageVector = Icons.Default.Copyright,
            title = "Copyright",
            imageVectorTint = LightBlue
        ) {

            IconButton(onClick = { /*TODO*/ }) {

                Icon(
                    modifier = Modifier
                        .graphicsLayer { rotationZ = 180f },
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "copyright item"
                )

            }

        }

        SettingsItem(
            imageVector = Icons.Outlined.Info,
            title = "About"
        ) {

            IconButton(onClick = { /*TODO*/ }) {

                Icon(
                    modifier = Modifier
                        .graphicsLayer { rotationZ = 180f },
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "info item"
                )

            }

        }


    }

}