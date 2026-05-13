
package com.example.kreedaankana.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.*
import com.example.kreedaankana.ui.screens.*
import com.example.kreedaankana.viewmodel.AppViewModel

sealed class Screen(val route: String, val label: String) {
    data object Calendar : Screen("calendar", "Ground")
    data object Challenges : Screen("challenges", "Challenge")
    data object Scores : Screen("scores", "Scores")
    data object Team : Screen("team", "My Team")
    data object Auth : Screen("auth", "Login")
}

@Composable
fun AppRoot(viewModel: AppViewModel) {
    val state by viewModel.ui.collectAsState()

    if (!state.loggedIn) {
        AuthScreen(
            loading = state.loading,
            error = state.error,
            onLogin = viewModel::login,
            onRegister = viewModel::register
        )
        return
    }

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar {
                val current = navController.currentBackStackEntryAsState().value?.destination?.route
                listOf(Screen.Calendar, Screen.Challenges, Screen.Scores, Screen.Team).forEach { screen ->
                    NavigationBarItem(
                        selected = current == screen.route,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        label = { Text(screen.label) },
                        icon = {}
                    )
                }
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Calendar.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(Screen.Calendar.route) {
                CalendarScreen(
                    state = state,
                    onGroundSelected = viewModel::selectGround,
                    onDateSelected = viewModel::selectDate,
                    onBook = viewModel::bookSlot
                )
            }
            composable(Screen.Challenges.route) {
                ChallengeScreen(
                    state = state,
                    onPost = viewModel::postChallenge,
                    onReply = viewModel::replyToChallenge
                )
            }
            composable(Screen.Scores.route) {
                ScoreScreen(
                    state = state,
                    onPost = viewModel::postScore
                )
            }
            composable(Screen.Team.route) {
                TeamScreen(
                    state = state,
                    onSave = viewModel::saveTeam,
                    onSignOut = viewModel::signOut
                )
            }
        }
    }
}
