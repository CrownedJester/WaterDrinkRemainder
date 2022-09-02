package com.crownedjester.soft.waterdrinkremainder.presentation.dashboard_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.crownedjester.soft.waterdrinkremainder.domain.model.Cup
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.importedFontFamily

@Composable
fun BottleItem(
    cup: Cup,
    onBottleClick: (Int) -> Unit
) {

    val cardHeight = with(LocalConfiguration.current.screenHeightDp) {
        this * 0.065f
    }

    val cardWidth = with(LocalConfiguration.current.screenWidthDp) {
        this * 0.4f
    }


    Card(
        modifier = Modifier
            .size(cardWidth.dp, cardHeight.dp)
            .alpha(ContentAlpha.medium)
            .clickable { onBottleClick(cup.volume) },
        shape = RoundedCornerShape(48),
        backgroundColor = cup.color,
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Icon(
                modifier = Modifier.padding(vertical = 8.dp),
                painter = painterResource(cup.iconRes),
                contentDescription = "bottle icon"
            )

            Text(
                text = "${cup.volume} ml",
                fontFamily = importedFontFamily,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Center
            )

        }
    }

}