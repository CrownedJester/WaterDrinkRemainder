package com.crownedjester.soft.waterdrinkremainder.presentation.dashboard_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crownedjester.soft.waterdrinkremainder.domain.model.cupsData
import com.crownedjester.soft.waterdrinkremainder.presentation.dashboard_screen.components.BottleItem
import com.crownedjester.soft.waterdrinkremainder.presentation.dashboard_screen.components.CircularProgress
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.DeepBlue
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.fontFamily

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DashboardScreen() {
    Column(
        modifier = Modifier.padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Current Hydration",
            textAlign = TextAlign.Center,
            fontSize = 28.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.sp,
            color = DeepBlue
        )


        Spacer(modifier = Modifier.height(70.dp))

        CircularProgress(
            drankAmount = 1111,
            dailyGoalAmount = 2500
        )

        Spacer(modifier = Modifier.height(80.dp))

        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(cupsData) { cup ->
                BottleItem(
                    cup = cup,
                    onBottleClick = { volume ->
                        /*todo*/
                    }
                )
            }

        }

    }
}