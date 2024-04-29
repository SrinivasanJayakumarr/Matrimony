package com.srinivasan.matrimonyprofiles.presentation.screens.profiledetails

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.srinivasan.matrimonyprofiles.R
import com.srinivasan.matrimonyprofiles.navigation.MatrimonyScreens
import com.srinivasan.matrimonyprofiles.presentation.components.MatrimonyTopAppBar
import com.srinivasan.matrimonyprofiles.ui.theme.Primary


///////////////////////////////////////////////////////////////////////////////////////////////

// Created by Srinivasan Jayakumar on 27/April/2024 18:41

///////////////////////////////////////////////////////////////////////////////////////////////

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun ProfileDetailsScreen(
    navHostController: NavHostController,
    profileId: Int,
    viewModel: ProfileDetailsViewModel = hiltViewModel()
) {

    val pagerData = remember {
        mutableListOf(
            R.drawable.image_1,
            R.drawable.image_2,
            R.drawable.image_3,
            R.drawable.image_4,
            R.drawable.image_5,
        )
    }

    LaunchedEffect(key1 = true) {
        viewModel.getProfileById(profileId = profileId)
    }

    val profile by viewModel.profile.collectAsStateWithLifecycle()

    val pagerState = rememberPagerState { 5 }

    Scaffold(
        containerColor = Color.White,
        topBar = {
            MatrimonyTopAppBar(
                title = "${stringResource(id = R.string.profile_details_screen_title)} ($profileId)",
                isBackEnabled = true,
                backgroundColor = Color.White,
                onBackClick = {
                    navHostController.navigateUp()
                },
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.6F)
            ) {

                HorizontalPager(
                    modifier = Modifier
                        .fillMaxWidth(),
                    state = pagerState,
                ) {

                    Image(
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = pagerData[it]),
                        contentDescription = "Profile Image $it"
                    )

                }

                HorizontalPagerIndicator(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(10.dp),
                    pagerState = pagerState,
                    pageCount = 5,
                    activeColor = Primary,
                    inactiveColor = Color.White
                )

            }

            Column(
                modifier = Modifier
                    .weight(0.4F)
                    .padding(10.dp),
            ) {

                Text(
                    modifier = Modifier
                        .padding(2.dp),
                    text = profile.name,
                    color = Color.Black,
                    style = MaterialTheme.typography
                        .bodyLarge
                        .copy(fontWeight = FontWeight.Bold)
                )

                Text(
                    modifier = Modifier
                        .padding(2.dp),
                    text = "${profile.age} Yrs, ${
                        profile.height
                            .toString()
                            .replace("."," ft ")
                            .plus(" in")
                    }",
                    color = Color.Black,
                    style = MaterialTheme.typography
                        .bodyLarge
                        .copy(fontWeight = FontWeight.Normal)
                )

                Text(
                    modifier = Modifier
                        .padding(2.dp),
                    text = "${profile.education}, ${profile.profession}, ${profile.religionCaste}, ${profile.address}",
                    color = Color.Black,
                    style = MaterialTheme.typography
                        .bodyLarge
                        .copy(fontWeight = FontWeight.Normal)
                )

            }

        }
    }

}