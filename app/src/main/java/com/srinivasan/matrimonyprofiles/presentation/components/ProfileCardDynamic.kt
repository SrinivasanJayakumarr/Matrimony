package com.srinivasan.matrimonyprofiles.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.srinivasan.matrimonyprofiles.R
import com.srinivasan.matrimonyprofiles.data.local.room.entity.Profile
import com.srinivasan.matrimonyprofiles.data.local.room.entity.Qualifiers
import com.srinivasan.matrimonyprofiles.ui.theme.MatrimonyProfilesTheme
import com.srinivasan.matrimonyprofiles.ui.theme.Primary

@Composable
fun ProfileCardDynamic(
    modifier: Modifier,
    profile: Profile,
    showQualifiers: Boolean = true,
    bottomBar: @Composable () -> Unit,
    onClickProfile: () -> Unit = {}
) {

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.6F)
        ) {
            Image(
                modifier = Modifier
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = rememberRipple(bounded = false)
                    ) { onClickProfile() },
                contentScale = ContentScale.Crop,
                painter = painterResource(id = profile.image),
                contentDescription = "PendingProfileImage"
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color.Black.copy(alpha = 0.1F),
                                Color.Black.copy(alpha = 0.2F),
                                Color.Black.copy(alpha = 0.3F),
                            ),
                        )
                    )
                    .padding(horizontal = 10.dp, vertical = 5.dp)
                    .align(Alignment.BottomCenter)
            ) {

                Column(
                    modifier = Modifier
                        .align(Alignment.BottomEnd),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = profile.name,
                        color = Color.White,
                        style = MaterialTheme.typography
                            .bodyLarge
                            .copy(fontWeight = FontWeight.Bold)
                    )
                    Text(
                        text = "${profile.age} Yrs, ${
                            profile.height
                                .toString()
                                .replace("."," ft ")
                                .plus(" in")
                        }",
                        color = Color.White,
                        style = MaterialTheme.typography
                            .labelSmall
                            .copy(fontWeight = FontWeight.Normal)
                    )
                    Text(
                        text = profile.profession,
                        color = Color.White,
                        style = MaterialTheme.typography
                            .labelSmall
                            .copy(fontWeight = FontWeight.Normal)
                    )
                }

            }

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                // .weight(0.4F)
        ) {

            if (showQualifiers) {

                ProfileQualifiersDynamic(
                    modifier = Modifier,
                    qualifiers = profile.qualifiers
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = rememberRipple(bounded = false)
                        ) { onClickProfile() }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(2.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Education : ",
                                color = Color.Black,
                                style = MaterialTheme.typography
                                    .bodyMedium.copy(fontWeight = FontWeight.Bold)
                            )
                            Text(
                                text = profile.education,
                                color = Color.Black,
                                style = MaterialTheme.typography
                                    .bodyMedium.copy(fontWeight = FontWeight.Normal)
                            )
                        }
                        Row {
                            Text(
                                text = "Star : ",
                                color = Color.Black,
                                style = MaterialTheme.typography
                                    .bodyMedium.copy(fontWeight = FontWeight.Bold)
                            )
                            Text(
                                text = profile.horoscopeStar,
                                color = Color.Black,
                                style = MaterialTheme.typography
                                    .bodyMedium.copy(fontWeight = FontWeight.Normal)
                            )
                        }

                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(2.dp),
                    ) {

                        Row {
                            Text(
                                text = "Religion : ",
                                color = Color.Black,
                                style = MaterialTheme.typography
                                    .bodyMedium.copy(fontWeight = FontWeight.Bold)
                            )
                            Text(
                                text = profile.religionCaste,
                                color = Color.Black,
                                style = MaterialTheme.typography
                                    .bodyMedium.copy(fontWeight = FontWeight.Normal)
                            )
                        }

                        Spacer(modifier = Modifier.height(2.dp))

                        Row {
                            Text(
                                text = "Address : ",
                                color = Color.Black,
                                style = MaterialTheme.typography
                                    .bodyMedium.copy(fontWeight = FontWeight.Bold)
                            )
                            Text(
                                text = profile.address,
                                color = Color.Black,
                                style = MaterialTheme.typography
                                    .bodyMedium.copy(fontWeight = FontWeight.Normal)
                            )
                        }

                    }
                }

            } else {

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = rememberRipple(bounded = false)
                        ) { onClickProfile() },
                    text = "${profile.education}, ${profile.horoscopeStar}, ${profile.religionCaste}, ${profile.address}",
                    style = MaterialTheme.typography
                        .labelSmall.copy(fontWeight = FontWeight.Normal)
                )

            }

            bottomBar()

        }


    }

}

@Composable
fun ProfileQualifiersDynamic(
    modifier: Modifier = Modifier,
    qualifiers: List<Qualifiers>
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp)
    ) {

        repeat(qualifiers.size) { index ->
            QualifierDynamic(qualifier = qualifiers[index])
        }

    }

}

@Composable
fun QualifierDynamic(
    modifier: Modifier = Modifier,
    qualifier: Qualifiers
) {

    Row(
        modifier = modifier
            .wrapContentSize()
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(16.dp),
            painter = painterResource(id = qualifier.icon),
            tint = qualifier.color,
            contentDescription = "Qualifier Icon"
        )

        Spacer(modifier = Modifier.width(5.dp))

        Text(
            text = qualifier.value,
            color = qualifier.color,
            style = MaterialTheme.typography.labelSmall
        )
    }

}

@Composable
fun ProfileActionDynamic(
    modifier: Modifier = Modifier,
    onClickFavourite: () -> Unit,
    onClickReject: () -> Unit,
    onClickAccept: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        ProfileActionButton(
            icon = R.drawable.ic_reject,
            onClick = onClickReject
        )

        FavouriteButton(
            onClick = onClickFavourite
        )

        ProfileActionButton(
            icon = R.drawable.ic_accept,
            showBackgroundColor = true,
            backgroundColor = Primary,
            onClick = onClickAccept
        )

    }
}

@Composable
fun ProfileActionButton(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    showBackgroundColor: Boolean = false,
    backgroundColor: Color = Color.Transparent,
    onClick: () -> Unit
) {

    Box(
        modifier = modifier
            .padding(5.dp)
    ) {

        OutlinedButton(
            modifier = Modifier
                .height(40.dp),
            onClick = onClick,
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
            border = BorderStroke(width = 1.dp, color = if (showBackgroundColor) backgroundColor else Color.Gray )
        ) {

            Icon(
                painter = painterResource(id = icon),
                tint = if (showBackgroundColor) Color.White else Color.Gray,
                contentDescription = "Action Button"
            )

        }

    }

}

@Composable
fun HomeProfileAction(
    modifier: Modifier = Modifier,
    onClickReject: () -> Unit,
    onClickAccept: () -> Unit,
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        ProfileTextActionButton(
            text = "Yes",
            showBackgroundColor = true,
            backgroundColor = Primary,
            onClick = onClickAccept
        )

        ProfileTextActionButton(
            text = "No",
            onClick = onClickReject
        )

    }

}

@Composable
fun ProfileTextActionButton(
    modifier: Modifier = Modifier,
    text: String,
    showBackgroundColor: Boolean = false,
    backgroundColor: Color = Color.Transparent,
    onClick: () -> Unit
) {

    Box(
        modifier = modifier
            .padding(5.dp)
    ) {

        OutlinedButton(
            modifier = Modifier
                .height(40.dp),
            onClick = onClick,
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
            border = BorderStroke(width = 1.dp, color = if (showBackgroundColor) backgroundColor else Color.Gray )
        ) {

            Text(
                text = text,
                color = if (showBackgroundColor) Color.White else Color.Gray
            )

        }

    }

}

@Composable
fun FavouriteButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .wrapContentSize()
            .padding(5.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(16.dp),
            painter = painterResource(id = R.drawable.ic_star),
            tint = Color.Gray,
            contentDescription = "Qualifier Icon"
        )

        Spacer(modifier = Modifier.width(5.dp))

        Text(
            text = "Favourite",
            color = Color.Gray,
            style = MaterialTheme.typography.labelSmall
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileQualifiersPreview() {
    MatrimonyProfilesTheme {
        ProfileQualifiersDynamic(qualifiers = Profile().qualifiers)
    }
}

@Preview(name = "Custom Size", heightDp = 350, widthDp = 200, showSystemUi = true)
@Composable
fun ProfileCardDynamicPreview() {
    MatrimonyProfilesTheme {
        ProfileCardDynamic(
            modifier = Modifier
                .height(350.dp)
                .width(200.dp)
                .padding(10.dp),
            profile = Profile(),
            showQualifiers = false,
            bottomBar = {},
            onClickProfile = {}
        )
    }
}

@Preview(name = "Full Size", showSystemUi = true)
@Composable
fun ProfileCardDynamicFullPreview() {
    MatrimonyProfilesTheme {
        ProfileCardDynamic(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            profile = Profile(),
            bottomBar = {
                ProfileActionDynamic(
                    onClickFavourite = {},
                    onClickAccept = {},
                    onClickReject = {},
                )
            },
            onClickProfile = {}
        )
    }
}