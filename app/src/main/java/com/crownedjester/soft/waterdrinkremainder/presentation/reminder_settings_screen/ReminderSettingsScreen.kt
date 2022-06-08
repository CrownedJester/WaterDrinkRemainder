package com.crownedjester.soft.waterdrinkremainder.presentation.reminder_settings_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.crownedjester.soft.waterdrinkremainder.presentation.common.AccountSettingsTopBar
import com.crownedjester.soft.waterdrinkremainder.presentation.reminder_settings_screen.components.ReminderSettingsItem
import com.crownedjester.soft.waterdrinkremainder.presentation.reminder_settings_screen.components.SpecifyTimeAlarmItem
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.LightBlue
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.importedFontFamily

@Composable
fun ReminderSettingsScreen(
    modifier: Modifier = Modifier,
    screenTitle: String,
    navController: NavController
) {

    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

        AccountSettingsTopBar(
            screenTitle = screenTitle,
            onNavigateBack = { navController.navigateUp() }
        )

        Spacer(modifier = Modifier.height(30.dp))

        ReminderSettingsItem(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(48.dp),
            optionTitle = "Wake up device when notify",
            onSwitchChanged = { /*TODO*/ }
        )

        Spacer(modifier = Modifier.height(16.dp))

        ReminderSettingsItem(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(48.dp),
            optionTitle = "Show on locked screen",
            onSwitchChanged = { /*TODO*/ }
        )

        Spacer(modifier = Modifier.height(16.dp))

        ReminderSettingsItem(
            modifier = Modifier
                .fillMaxWidth(0.9f),
            optionTitle = "Periodic notifications",
            onSwitchChanged = { /*TODO*/ }
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 12.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Period of alarms every: ",
                    fontFamily = importedFontFamily,
                    fontWeight = FontWeight.Thin
                )

                Text(
                    text = "30 m",
                    fontFamily = importedFontFamily,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.clickable {

                    }
                )

            }

        }

        Spacer(modifier = Modifier.height(16.dp))

        ReminderSettingsItem(
            modifier = Modifier
                .fillMaxWidth(0.9f),
            optionTitle = "Specify times based alarms",
            onSwitchChanged = { /*TODO*/ },
            additionalContent = {
                Button(
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(end = 12.dp),
                    shape = RoundedCornerShape(6),
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = LightBlue),
                    content = {
                        Text(text = "Add", fontFamily = importedFontFamily, color = Color.White)
                    }
                )

                LazyVerticalGrid(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                    columns = GridCells.Fixed(4),
                ) {
                    items(36) {
                        SpecifyTimeAlarmItem(time = "06:30")
                    }
                }
            })
    }

}
