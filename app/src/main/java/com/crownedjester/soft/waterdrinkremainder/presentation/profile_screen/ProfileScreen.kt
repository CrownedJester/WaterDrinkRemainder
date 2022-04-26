package com.crownedjester.soft.waterdrinkremainder.presentation.profile_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Coronavirus
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import com.crownedjester.soft.waterdrinkremainder.domain.model.User
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.ColumnBackground
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.OrangeLightColor
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.CameraIconBorder

@Composable
fun ProfileScreen(user: User) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .zIndex(0f)
            .background(color = OrangeLightColor),

        ) {

        val (contentColumn, photo, imageLoaderIcon, backImageSurface) = createRefs()

        Box(modifier = Modifier
            .size(90.dp)
            .zIndex(20f)
            .background(color = Color.White, shape = RoundedCornerShape(24))
            .constrainAs(backImageSurface) {
                top.linkTo(contentColumn.top)
                bottom.linkTo(contentColumn.top)
                centerHorizontallyTo(parent)
            }
        )

        Image(
            modifier = Modifier
                .size(80.dp)
                .zIndex(30f)
                .padding(4.dp)
                .background(color = Color.Transparent, shape = RoundedCornerShape(24))
                .constrainAs(photo) {
                    linkTo(start = backImageSurface.start, end = backImageSurface.end)
                    linkTo(top = backImageSurface.top, bottom = backImageSurface.bottom)
                },
            imageVector = Icons.Outlined.Coronavirus,
            contentDescription = "user image"
        )

        IconButton(modifier = Modifier
            .size(28.dp)
            .border(width = 1.dp, color = CameraIconBorder, shape = CircleShape)
            .background(color = OrangeLightColor, shape = CircleShape)
            .zIndex(90f)
            .constrainAs(imageLoaderIcon) {
                bottom.linkTo(backImageSurface.bottom)
                end.linkTo(backImageSurface.end)
            },
            onClick = {
                /*TODO*/
            },
            content = {
                Icon(
                    modifier = Modifier,
                    imageVector = Icons.Outlined.PhotoCamera,
                    contentDescription = "image picker",
                    tint = Color.White
                )
            }
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .zIndex(10f)
                .background(
                    color = ColumnBackground,
                    shape = RoundedCornerShape(topStartPercent = 8, topEndPercent = 8)
                )
                .constrainAs(contentColumn) {
                    top.linkTo(parent.top, 256.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        ) {


        }

    }

}