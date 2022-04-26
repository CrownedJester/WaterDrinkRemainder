package com.crownedjester.soft.waterdrinkremainder.domain.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.crownedjester.soft.waterdrinkremainder.R
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.BigCupBackground
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.BottleBackground
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.CapBackground
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.DropBackground

data class Cup(
    val color: Color,
    @DrawableRes val iconRes: Int,
    val volume: Int
)

val cupsData
    get() = listOf(
        Cup(color = DropBackground, volume = 150, iconRes = R.drawable.ic_drop),
        Cup(color = BottleBackground, volume = 500, iconRes = R.drawable.ic_plastic_bottle),
        Cup(color = CapBackground, volume = 250, iconRes = R.drawable.ic_small_cup),
        Cup(color = BigCupBackground, volume = 350, iconRes = R.drawable.ic_big_cup),
    )