package com.crownedjester.soft.waterdrinkremainder.presentation.user_data_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.importedFontFamily
import com.crownedjester.soft.waterdrinkremainder.presentation.util.ProfileItemData

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProfileItem(profileItemData: ProfileItemData, navController: NavController) {

    val cardWidth = with(LocalConfiguration.current.screenWidthDp) {
        this * 0.35f
    }
    val cardHeight = with(LocalConfiguration.current.screenHeightDp) {
        this * 0.25f
    }

    Card(
        modifier = Modifier
            .size(width = cardWidth.dp, height = cardHeight.dp)
            .padding(horizontal = 16.dp),
        backgroundColor = Color.White,
        shape = RoundedCornerShape(24),
        onClick = {
            navController.navigate(profileItemData.route)
        }
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            Image(
                modifier = Modifier
                    .zIndex(90f)
                    .padding(horizontal = 8.dp, vertical = 12.dp)
                    .fillMaxWidth(0.8f)
                    .fillMaxHeight(0.6f),
                painter = rememberAsyncImagePainter(model = profileItemData.imageRes),
                contentDescription = "profile item icon"
            )

            Text(
                text = profileItemData.title,
                fontFamily = importedFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp
            )

        }

    }
}