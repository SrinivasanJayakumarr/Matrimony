package com.srinivasan.matrimonyprofiles.presentation.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.srinivasan.matrimonyprofiles.R
import com.srinivasan.matrimonyprofiles.ui.theme.Primary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MatrimonyTopAppBar(
    title: String,
    backgroundColor: Color,
    titleColor: Color = Primary,
    iconColor: Color = Primary,
    isBackEnabled: Boolean,
    actions: @Composable () -> Unit = {},
    onBackClick: () -> Unit = {}
) {

    TopAppBar(
        colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = backgroundColor),
        title = {
            Text(
                text = title,
                color = titleColor,
                style = MaterialTheme.typography
                    .titleLarge
                    .copy(fontWeight = FontWeight.Black)
            )
        },
        actions = {
            actions()
        },
        navigationIcon = {
            if (isBackEnabled) {
                IconButton(
                    modifier = Modifier
                        .clip(CircleShape),
                    onClick = onBackClick
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        tint = iconColor,
                        contentDescription = "Back Icon"
                    )
                }
            }
        }
    )

}