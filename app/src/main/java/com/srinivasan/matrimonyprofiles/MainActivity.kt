package com.srinivasan.matrimonyprofiles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.srinivasan.matrimonyprofiles.navigation.RootNavGraph
import com.srinivasan.matrimonyprofiles.ui.theme.MatrimonyProfilesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            MatrimonyProfilesTheme {

                val navHostController = rememberNavController()
                RootNavGraph(navHostController = navHostController)

            }
        }
    }
}