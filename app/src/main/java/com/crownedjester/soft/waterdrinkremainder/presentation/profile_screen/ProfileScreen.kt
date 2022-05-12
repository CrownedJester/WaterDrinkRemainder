package com.crownedjester.soft.waterdrinkremainder.presentation.profile_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Coronavirus
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import com.crownedjester.soft.waterdrinkremainder.domain.model.User
import com.crownedjester.soft.waterdrinkremainder.presentation.profile_screen.components.ProfileItem
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.*
import com.crownedjester.soft.waterdrinkremainder.presentation.util.ProfileItemData

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfileScreen(user: User) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .zIndex(0f)
            .background(color = LightBlue)
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
            .background(color = LightBlue, shape = CircleShape)
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
                    modifier = Modifier.padding(3.dp),
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
                },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                textAlign = TextAlign.Center,
                text = buildAnnotatedString {

                    withStyle(
                        style = SpanStyle(
                            fontFamily = importedFontFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 20.sp,
                            color = DeepBlue
                        )
                    ) {
                        user.firstName.let { firstName ->
                            if (firstName == null) append("")
                            else append(firstName)
                        }
                    }

                    withStyle(
                        style = SpanStyle(
                            fontFamily = importedFontFamily,
                            fontWeight = FontWeight.Light,
                            fontSize = 14.sp,
                            color = LightBlue,
                            fontStyle = FontStyle.Italic
                        )
                    ) {
                        user.username.let { username ->
                            if (username == null) append("")
                            else append("\n$username")
                        }
                    }

                }

            )

            LazyVerticalGrid(
                cells = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(ProfileItemData.itemsList) { profileDataItem ->
                    ProfileItem(
                        profileItemData = profileDataItem,
                        onClick = { /*todo*/ }
                    )
                }
            }

        }

    }

}