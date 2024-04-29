package com.srinivasan.matrimonyprofiles.presentation.screens.gesture

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.srinivasan.matrimonyprofiles.R
import com.srinivasan.matrimonyprofiles.navigation.MatrimonyScreens
import com.srinivasan.matrimonyprofiles.presentation.components.MatrimonyTopAppBar
import com.srinivasan.matrimonyprofiles.presentation.screens.gesture.components.ProfileCardDeck
import com.srinivasan.matrimonyprofiles.util.CommonUtil.showShortToast


///////////////////////////////////////////////////////////////////////////////////////////////

// Created by Srinivasan Jayakumar on 27/April/2024 18:40

///////////////////////////////////////////////////////////////////////////////////////////////

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GestureScreen(
    navHostController: NavHostController,
    viewModel: GestureViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val profiles by viewModel.profiles.collectAsStateWithLifecycle()

    var current by remember {
        mutableIntStateOf(0)
    }

    val visible by remember {
        mutableIntStateOf(5)
    }

    Scaffold(
        containerColor = Color.White,
        topBar = {
            MatrimonyTopAppBar(
                title = stringResource(id = R.string.gesture_screen_title),
                isBackEnabled = true,
                backgroundColor = Color.White,
                onBackClick = {
                    navHostController.navigate(MatrimonyScreens.Home.route) {
                        popUpTo(MatrimonyScreens.Gesture.route) {
                            inclusive = true
                        }
                    }
                },
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            ProfileCardDeck(
                profiles = profiles,
                current = current,
                visible = visible,
                onClickFavourite = {
                    showShortToast(context = context, message = "Added to Favourite")
                },
                onClickAccept = {
                    if (current < profiles.lastIndex) {
                        viewModel.deleteProfile(index = current)
                        current += 1
                        showShortToast(context = context, message = "Profile Accepted")
                    } else {
                        current = 0
                    }
                },
                onClickReject = {
                    if (current < profiles.lastIndex) {
                        viewModel.deleteProfile(index = current)
                        current += 1
                        showShortToast(context = context, message = "Profile Rejected")
                    } else {
                        current = 0
                    }
                },
                onClickProfile = { profileId ->
                    navHostController.navigate(
                        MatrimonyScreens.ProfileDetails.passProfileId(
                            profileId = profileId
                        )
                    )
                }
            )

        }

    }

}