package com.crownedjester.soft.waterdrinkremainder.presentation.common

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.importedFontFamily

@Composable
fun AccountSettingsTopBar(
    modifier: Modifier = Modifier,
    screenTitle: String,
    navBackImageVector: ImageVector = Icons.Default.ArrowBack,
    additionalOptionImageVector: ImageVector? = null,
    onNavigateBack: () -> Unit,
    onAdditionalOptionClick: (() -> Unit)? = null
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        elevation = 12.dp
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {

            val (navBackIcon, title, additionOptionIcon) = createRefs()

            IconButton(
                modifier = Modifier
                    .constrainAs(navBackIcon) {
                        start.linkTo(parent.start, 4.dp)
                        linkTo(parent.top, parent.bottom)
                    },
                onClick = onNavigateBack,
                content = {
                    Icon(imageVector = navBackImageVector, contentDescription = "nav back icon")
                }
            )


            Text(
                modifier = Modifier
                    .constrainAs(title) {
                        centerTo(parent)
                    },
                text = screenTitle,
                fontFamily = importedFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )


            onAdditionalOptionClick?.let { onClick ->
                IconButton(
                    modifier = Modifier
                        .constrainAs(additionOptionIcon) {
                            end.linkTo(parent.end, 4.dp)
                            linkTo(parent.top, parent.bottom)
                        },
                    onClick = onClick,
                    content = {
                        if (additionalOptionImageVector != null) {
                            Icon(
                                imageVector = additionalOptionImageVector,
                                contentDescription = "additional option icon"
                            )
                            Log.i("AccountSettingsTopBar", "Additional Option Icon is null")
                        }
                    }
                )

            }

        }

    }
}