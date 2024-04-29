package com.srinivasan.matrimonyprofiles.navigation


///////////////////////////////////////////////////////////////////////////////////////////////

// Created by Srinivasan Jayakumar on 27/April/2024 18:28

///////////////////////////////////////////////////////////////////////////////////////////////

const val PROFILE_ID = "profile_id"

sealed class MatrimonyScreens(
    val route: String
) {

    object Splash: MatrimonyScreens(route = ScreenRoutes.SPLASH_SCREEN_ROUTE)
    object Home: MatrimonyScreens(route = ScreenRoutes.HOME_SCREEN_ROUTE)
    object Gesture: MatrimonyScreens(route = ScreenRoutes.GESTURE_SCREEN_ROUTE)
    object ProfileDetails: MatrimonyScreens(route = "${ScreenRoutes.PROFILE_DETAILS_SCREEN_ROUTE}/{$PROFILE_ID}") {
        fun passProfileId(profileId: Int): String {
            return this.route.replace(
                oldValue = "{$PROFILE_ID}",
                newValue = profileId.toString()
            )
        }
    }

}