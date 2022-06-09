package com.crownedjester.soft.waterdrinkremainder.presentation.app_settings_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.importedFontFamily

@Composable
fun SettingsItem(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    title: String,
    imageVectorTint: Color = Color.Black,
    additionalContent: @Composable (RowScope.() -> Unit)? = null
) {

    Card(
        modifier = modifier
            .fillMaxWidth(0.95f)
            .height(52.dp),
        shape = RoundedCornerShape(8),
        elevation = 10.dp
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp, vertical = 2.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(0.8f),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    modifier = Modifier.size(28.dp),
                    imageVector = imageVector,
                    contentDescription = "settings item icon",
                    tint = imageVectorTint
                )

                Text(
                    modifier = Modifier.height(32.dp),
                    text = title,
                    fontFamily = importedFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )

            }

            additionalContent?.let { it() }

        }
    }

}