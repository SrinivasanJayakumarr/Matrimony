package com.srinivasan.matrimonyprofiles.presentation.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.srinivasan.matrimonyprofiles.R
import com.srinivasan.matrimonyprofiles.navigation.MatrimonyScreens
import com.srinivasan.matrimonyprofiles.ui.theme.Primary
import kotlinx.coroutines.delay


///////////////////////////////////////////////////////////////////////////////////////////////

// Created by Srinivasan Jayakumar on 27/April/2024 18:38

///////////////////////////////////////////////////////////////////////////////////////////////

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SplashScreen(
    navHostController: NavHostController,
    viewModel: SplashViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = true) {

        // Inserting dummy data into DB
        viewModel.initDatabase()

        delay(1000L)

        navHostController.navigate(MatrimonyScreens.Home.route) {
            popUpTo(MatrimonyScreens.Splash.route) {
                inclusive = true
            }
        }
    }

    Scaffold { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Image(
                    painter = painterResource(id = R.drawable.matrimony),
                    contentDescription = "Matrimony Logo"
                )

                CircularProgressIndicator(
                    modifier = Modifier
                        .size(20.dp),
                    color = Primary,
                    strokeWidth = 3.dp
                )

            }

        }

    }


}