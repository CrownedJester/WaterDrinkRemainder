package com.crownedjester.soft.waterdrinkremainder.presentation.profile_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.compose.rememberAsyncImagePainter
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.importedFontFamily
import com.crownedjester.soft.waterdrinkremainder.presentation.util.ProfileItemData

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProfileItem(profileItemData: ProfileItemData, onClick: () -> Unit) {

    Card(
        modifier = Modifier
            .size(width = 128.dp, height = 172.dp)
            .padding(horizontal = 16.dp),
        backgroundColor = Color.White,
        shape = RoundedCornerShape(24),
        onClick = onClick
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                modifier = Modifier.zIndex(90f).size(width = 82.dp, height = 128.dp),
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