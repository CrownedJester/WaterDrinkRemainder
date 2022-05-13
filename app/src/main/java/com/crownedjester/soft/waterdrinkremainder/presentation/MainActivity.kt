package com.crownedjester.soft.waterdrinkremainder.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.crownedjester.soft.waterdrinkremainder.domain.model.User
import com.crownedjester.soft.waterdrinkremainder.presentation.dashboard_screen.DashboardScreen
import com.crownedjester.soft.waterdrinkremainder.presentation.profile_screen.ProfileScreen
import com.crownedjester.soft.waterdrinkremainder.presentation.status_screen.StatusScreen
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.DeepPurple
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.WaterDrinkRemainderTheme
import com.crownedjester.soft.waterdrinkremainder.presentation.util.Screen
import com.crownedjester.soft.waterdrinkremainder.presentation.util.bottomNavItems
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WaterDrinkRemainderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {

                    val viewModel: HydrationViewModel = hiltViewModel()

                    val scaffoldState = rememberScaffoldState()
                    val navController = rememberNavController()

                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        scaffoldState = scaffoldState,
                        bottomBar = {
                            BottomNavigation(
                                backgroundColor = Color.Transparent,
                                elevation = 0.dp,
                                modifier = Modifier
                                    .padding(horizontal = 20.dp, vertical = 8.dp)
                            ) {
                                val navBackStackEntry by navController.currentBackStackEntryAsState()
                                val currentRoute = navBackStackEntry?.destination?.route
                                bottomNavItems.forEach { item ->
                                    val isSelected = currentRoute == item.route
                                    BottomNavigationItem(
                                        modifier = Modifier
                                            .padding(
                                                horizontal = 22.dp,
                                                vertical = 8.dp
                                            )
                                            .background(
                                                color = if (isSelected) DeepPurple else Color.Transparent,
                                                shape = RoundedCornerShape(64)
                                            ),
                                        alwaysShowLabel = false,
                                        label = null,
                                        icon = {
                                            Icon(
                                                modifier = Modifier
                                                    .size(24.dp),
                                                painter = painterResource(id = item.iconId),
                                                contentDescription = null,
                                                tint = if (isSelected) Color.White else Color.Black
                                            )
                                        },
                                        selected = currentRoute == item.route,
                                        onClick = {
                                            navController.navigate(item.route) {
                                                popUpTo(navController.graph.findStartDestination().id) {
                                                    saveState = true
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        })

                                }

                            }
                        }
                    ) { innerPadding ->
                        NavHost(
                            modifier = Modifier
                                .background(color = Color.Transparent),
                            startDestination = Screen.StatusScreen.route,
                            navController = navController,
                        ) {
                            composable(route = Screen.StatusScreen.route) {
                                StatusScreen(dailyGoalHydration = 2500, viewModel = viewModel)
                            }
                            composable(route = Screen.DashboardScreen.route) {
                                DashboardScreen(viewModel)
                            }
                            composable(route = Screen.ProfileScreen.route) {
                                ProfileScreen(user = User("@crownedjester", "Sergey", ""))
                            }
                        }
                    }
                }
            }
        }
    }
}