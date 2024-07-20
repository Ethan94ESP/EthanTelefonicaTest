@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.example.ethantelefonicatest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.ethantelefonicatest.ui.screen.userdetail.UserDetailScreen
import com.example.ethantelefonicatest.ui.screen.userlist.UserListScreen
import com.example.ethantelefonicatest.ui.theme.EthanTelefonicaTestTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.Serializable

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EthanTelefonicaTestTheme {
                val navController = rememberNavController()
                enableEdgeToEdge(
                    statusBarStyle = SystemBarStyle.dark(
                        android.graphics.Color.TRANSPARENT
                    )
                )
                SharedTransitionLayout {
                    NavHost(navController = navController, startDestination = UserListRoute) {
                        composable<UserListRoute> {
                            UserListScreen(
                                animatedVisibilityScope = this,
                                onUserClick = { coverUrl, id ->
                                    navController.navigate(
                                        UserRoute(coverUrl = coverUrl, id = id)
                                    )
                                }
                            )
                        }

                        composable<UserRoute> {
                            val args = it.toRoute<UserRoute>()

                            UserDetailScreen(
                                animatedVisibilityScope = this,
                                id = args.id.toInt(),
                                coverImage = args.coverUrl
                            )
                        }
                    }
                }

            }
        }
    }
}

@Serializable
data object UserListRoute

@Serializable
data class UserRoute(val coverUrl: String, val id: String)
