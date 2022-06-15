package com.crownedjester.soft.waterdrinkremainder.presentation.user_statistics_screen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.crownedjester.soft.waterdrinkremainder.presentation.common.AccountSettingsTopBar
import com.crownedjester.soft.waterdrinkremainder.presentation.user_statistics_screen.components.HydrationSummary
import com.crownedjester.soft.waterdrinkremainder.presentation.user_statistics_screen.components.MonthSummary

@Composable
fun UserStatisticsScreen(
    modifier: Modifier = Modifier,
    screenTitle: String,
    navController: NavController
) {

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

        Row(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(50.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            HydrationSummary(
                summaryTitle = "Overall drank water",
                summaryData = 150000
            )

            HydrationSummary(
                summaryTitle = "Average per day",
                summaryData = 2600
            )

        }

        MonthSummary(modifier = Modifier.fillMaxWidth(0.9f), summaryTitle = "Goal Achieved")

    }

}