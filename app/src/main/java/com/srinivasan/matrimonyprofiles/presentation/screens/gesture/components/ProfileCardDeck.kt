package com.srinivasan.matrimonyprofiles.presentation.screens.gesture.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.srinivasan.matrimonyprofiles.data.local.room.entity.Profile
import com.srinivasan.matrimonyprofiles.presentation.components.ProfileActionDynamic
import com.srinivasan.matrimonyprofiles.presentation.components.ProfileCardDynamic
import com.srinivasan.matrimonyprofiles.ui.theme.MatrimonyProfilesTheme


///////////////////////////////////////////////////////////////////////////////////////////////

// Created by Srinivasan Jayakumar on 27/April/2024 15:46

///////////////////////////////////////////////////////////////////////////////////////////////

const val paddingOffset = 32f

@Composable
fun ProfileCardDeck(
    profiles: List<Profile>,
    current: Int = 0,
    visible: Int = 3,
    onClickAccept: () -> Unit,
    onClickReject: () -> Unit,
    onClickFavourite: () -> Unit = {},
    onClickProfile: (Int) -> Unit
) {

    val visibleCards: Int = StrictMath.min(visible, profiles.size - current)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {

        repeat(visibleCards) { idx ->

            // index in data source
            val index = current + idx
            val profile = profiles[index]
            val zIndex = 100f - idx
            val scaleX = calculateScale(idx)
            val offsetY = calculateOffset(idx)
            val cardModifier = Modifier
                .scale(scaleX, 1f)
                .offset { IntOffset(0, offsetY) }
                .align(Alignment.TopCenter)
                .zIndex(zIndex)
            // .size(cardWidth, cardHeight)

            ProfileCardDynamic(
                modifier = cardModifier
                    .fillMaxSize()
                    .padding(10.dp),
                profile = profile,
                bottomBar = {
                    ProfileActionDynamic(
                        onClickAccept = onClickAccept,
                        onClickReject = onClickReject,
                        onClickFavourite = onClickFavourite
                    )
                },
                onClickProfile = {
                    onClickProfile(current.plus(1))
                }
            )

        }

    }

}

@Preview
@Composable
fun ProfileCardDeckPreview() {

    MatrimonyProfilesTheme {
        ProfileCardDeck(
            profiles = listOf(
                Profile(),
                Profile(
                    name = "Van Test"
                ),
                Profile(
                    name = "Truck Test"
                ),
            ),
            onClickAccept = {},
            onClickReject = {},
            onClickProfile = {}
        )
    }

}

private fun calculateScale(idx: Int): Float {
    return 1f - idx * (1f / 10f)
}

private fun calculateOffset(idx: Int): Int {
    return (paddingOffset * (-idx + 1)).toInt()
}