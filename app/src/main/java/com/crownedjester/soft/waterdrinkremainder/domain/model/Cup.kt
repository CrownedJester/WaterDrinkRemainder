package com.crownedjester.soft.waterdrinkremainder.domain.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.crownedjester.soft.waterdrinkremainder.R
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.bigCupBackground
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.bottleBackground
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.capBackground
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.dropBackground

data class Cup(
    val color: Color,
    @DrawableRes val iconRes: Int,
    val volume: Int
)

val cupsData
    get() = listOf(
        Cup(color = dropBackground, volume = 150, iconRes = R.drawable.ic_drop),
        Cup(color = bottleBackground, volume = 500, iconRes = R.drawable.ic_plastic_bottle),
        Cup(color = capBackground, volume = 250, iconRes = R.drawable.ic_small_cup),
        Cup(color = bigCupBackground, volume = 350, iconRes = R.drawable.ic_big_cup),
    )