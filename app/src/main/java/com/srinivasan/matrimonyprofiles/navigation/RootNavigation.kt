package com.srinivasan.matrimonyprofiles.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.srinivasan.matrimonyprofiles.presentation.screens.gesture.GestureScreen
import com.srinivasan.matrimonyprofiles.presentation.screens.home.HomeScreen
import com.srinivasan.matrimonyprofiles.presentation.screens.profiledetails.ProfileDetailsScreen
import com.srinivasan.matrimonyprofiles.presentation.screens.splash.SplashScreen


///////////////////////////////////////////////////////////////////////////////////////////////

// Created by Srinivasan Jayakumar on 27/April/2024 18:33

///////////////////////////////////////////////////////////////////////////////////////////////

@Composable
fun RootNavGraph(
    navHostController: NavHostController
) {

    NavHost(
        navController = navHostController,
        startDestination = MatrimonyScreens.Splash.route
    ) {

        composable(
            route = MatrimonyScreens.Splash.route
        ) {
            SplashScreen(navHostController = navHostController)
        }

        composable(
            route = MatrimonyScreens.Home.route
        ) {
            HomeScreen(navHostController = navHostController)
        }

        composable(
            route = MatrimonyScreens.Gesture.route
        ) {
            GestureScreen(navHostController = navHostController)
        }

        composable(
            route = MatrimonyScreens.ProfileDetails.route,
            arguments = listOf(
                navArgument(
                    PROFILE_ID
                ){
                    type = NavType.StringType
                }
            )
        ) {
            ProfileDetailsScreen(
                navHostController = navHostController,
                profileId = it.arguments?.getString(PROFILE_ID)?.toInt() ?: 0
            )
        }

    }

}