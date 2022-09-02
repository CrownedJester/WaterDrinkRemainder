package com.crownedjester.soft.waterdrinkremainder.presentation.dashboard_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crownedjester.soft.waterdrinkremainder.domain.model.cupsData
import com.crownedjester.soft.waterdrinkremainder.presentation.HydrationViewModel
import com.crownedjester.soft.waterdrinkremainder.presentation.dashboard_screen.components.BottleItem
import com.crownedjester.soft.waterdrinkremainder.presentation.dashboard_screen.components.CircularProgress
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.DeepBlue
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.importedFontFamily

@Composable
fun DashboardScreen(viewModel: HydrationViewModel, dailyGoalHydration: Int = 2500) {

    val currentDailyHydration by viewModel.currentDailyHydration.collectAsState()

    Column(
        modifier = Modifier.padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Current Hydration",
            textAlign = TextAlign.Center,
            fontSize = 28.sp,
            fontFamily = importedFontFamily,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.sp,
            color = DeepBlue
        )

        Spacer(modifier = Modifier.height(70.dp))

        CircularProgress(
            currentDailyHydration = currentDailyHydration,
            dailyGoalHydration = dailyGoalHydration
        )

        Spacer(modifier = Modifier.fillMaxHeight(0.35f))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(cupsData) { cup ->
                BottleItem(
                    cup = cup,
                    onBottleClick = { volume ->
                        viewModel.updateDailyHydration(volume)
                    }
                )
            }
        }

    }
}