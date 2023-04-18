package com.crownedjester.soft.waterdrinkremainder.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.crownedjester.soft.waterdrinkremainder.presentation.app_settings_screen.AppSettingsScreen
import com.crownedjester.soft.waterdrinkremainder.presentation.dashboard_screen.DashboardScreen
import com.crownedjester.soft.waterdrinkremainder.presentation.edit_profile_screen.EditProfileScreen
import com.crownedjester.soft.waterdrinkremainder.presentation.reminder_settings_screen.ReminderSettingsScreen
import com.crownedjester.soft.waterdrinkremainder.presentation.status_screen.StatusScreen
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.DeepPurple
import com.crownedjester.soft.waterdrinkremainder.presentation.ui.theme.WaterDrinkRemainderTheme
import com.crownedjester.soft.waterdrinkremainder.presentation.user_data_screen.ProfileScreen
import com.crownedjester.soft.waterdrinkremainder.presentation.user_statistics_screen.UserStatisticsScreen
import com.crownedjester.soft.waterdrinkremainder.presentation.util.Screen
import com.crownedjester.soft.waterdrinkremainder.presentation.util.bottomNavItems
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
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
                    var isBottomNavVisible by remember { mutableStateOf(true) }

                    navController.addOnDestinationChangedListener { _, destination, _ ->
                        isBottomNavVisible = destination.route in arrayOf(
                            Screen.DashboardScreen.route,
                            Screen.ProfileScreen.route,
                            Screen.StatusScreen.route
                        )
                    }

                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        scaffoldState = scaffoldState,
                        bottomBar = {
                            AnimatedVisibility(visible = isBottomNavVisible) {

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
                        }
                    ) { _ ->

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
                                ProfileScreen(
                                    user = User("@crownedjester", "Sergey", "+375292346352"),
                                    navController = navController
                                )
                            }

                            composable(route = Screen.EditProfileScreen.route) {
                                EditProfileScreen(
                                    screenTitle = Screen.EditProfileScreen.title,
                                    navController = navController
                                )
                            }

                            composable(route = Screen.ReminderSettingsScreen.route) {
                                ReminderSettingsScreen(
                                    screenTitle = Screen.ReminderSettingsScreen.title,
                                    navController = navController
                                )
                            }

                            composable(route = Screen.AppSettingsScreen.route) {
                                AppSettingsScreen(
                                    screenTitle = Screen.AppSettingsScreen.title,
                                    navController = navController
                                )
                            }

                            composable(route = Screen.UserStatisticsScreen.route) {
                                UserStatisticsScreen(
                                    screenTitle = Screen.UserStatisticsScreen.title,
                                    navController = navController
                                )
                            }

                        }
                    }
                }
            }
        }
    }

    /*  private fun setupAlarmManager() {
          alarmManager = getSystemService(Context.ALARM_SERVICE) as? AlarmManager

          alarmIntent = Intent(this@MainActivity, HydrationReceiver::class.java).let { intent ->
              intent.action = ReceiverPreferences.HYDRATION_RECEIVER_ACTION
              intent.putExtra(
                  ReceiverPreferences.NOTIFICATION_KEY,
                  "You dried up, don't forget to drink some water!"
              )
              PendingIntent.getBroadcast(
                  this@MainActivity,
                  REQUEST_CODE,
                  intent,
                  PendingIntent.FLAG_UPDATE_CURRENT
              )
          }

          alarmManager?.set(
              AlarmManager.ELAPSED_REALTIME_WAKEUP,
              SystemClock.elapsedRealtime() + 60 * 1000L,
              alarmIntent
          )
      }
     */
}

private const val REQUEST_CODE = 0