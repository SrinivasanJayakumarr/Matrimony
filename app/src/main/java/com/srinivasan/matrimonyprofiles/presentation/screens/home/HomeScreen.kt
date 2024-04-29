package com.srinivasan.matrimonyprofiles.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.srinivasan.matrimonyprofiles.R
import com.srinivasan.matrimonyprofiles.navigation.MatrimonyScreens
import com.srinivasan.matrimonyprofiles.presentation.components.HomeProfileAction
import com.srinivasan.matrimonyprofiles.presentation.components.MatrimonyTopAppBar
import com.srinivasan.matrimonyprofiles.presentation.components.ProfileCardDynamic
import com.srinivasan.matrimonyprofiles.ui.theme.Primary
import com.srinivasan.matrimonyprofiles.util.CommonUtil.showShortToast


///////////////////////////////////////////////////////////////////////////////////////////////

// Created by Srinivasan Jayakumar on 27/April/2024 18:39

///////////////////////////////////////////////////////////////////////////////////////////////

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navHostController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val profiles by viewModel.profiles.collectAsStateWithLifecycle()

    Scaffold(
        containerColor = Color.White,
        topBar = {
            MatrimonyTopAppBar(
                title = stringResource(id = R.string.home_screen_title),
                isBackEnabled = false,
                backgroundColor = Color.White,
                actions = {
                    IconButton(
                        modifier = Modifier
                            .clip(CircleShape),
                        onClick = {
                            navHostController.navigate(MatrimonyScreens.Gesture.route)
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_more),
                            tint = Primary,
                            contentDescription = "More Icon"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            
            Text(
                modifier = Modifier
                    .padding(horizontal = 20.dp),
                text = "${profiles.size} Profiles pending with me",
                color = Primary,
                style = MaterialTheme.typography
                    .titleMedium.copy(fontWeight = FontWeight.Bold)
            )

            LazyRow(
                modifier = Modifier
                    .height(300.dp)
                    .padding(10.dp),
            ) {

                itemsIndexed(profiles) { index, profile ->
                    ProfileCardDynamic(
                        modifier = Modifier
                            .width(200.dp)
                            .height(300.dp)
                            .padding(10.dp),
                        profile = profile,
                        showQualifiers = false,
                        bottomBar = {
                            HomeProfileAction(
                                onClickAccept = {
                                    viewModel.deleteProfile(index = index)
                                    showShortToast(context = context, message = "Profile Accepted")
                                },
                                onClickReject = {
                                    viewModel.deleteProfile(index = index)
                                    showShortToast(context = context, message = "Profile Rejected")
                                }
                            )
                        },
                        onClickProfile = {
                            navHostController.navigate(
                                MatrimonyScreens.ProfileDetails.passProfileId(profileId = index.plus(1))
                            )
                        }
                    )
                }

            }

        }

    }

}