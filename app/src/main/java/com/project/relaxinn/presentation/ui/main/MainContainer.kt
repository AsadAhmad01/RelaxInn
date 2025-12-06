package com.project.relaxinn.presentation.ui.main

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.project.relaxinn.presentation.theme.AppTheme
import com.project.relaxinn.presentation.ui.bookings.MyBookingsScreen
import com.project.relaxinn.presentation.ui.explore.ExploreScreen
import com.project.relaxinn.presentation.ui.favorites.FavoritesScreen
import com.project.relaxinn.presentation.ui.home.HomeScreen
import com.project.relaxinn.presentation.ui.profile.ProfileScreen
import com.project.relaxinn.presentation.utills.BottomNavigationBar
import kotlinx.coroutines.delay

/**
 * Main Container Screen - Manages bottom navigation and screen switching with professional back handling
 */
@Composable
fun MainContainer(navController: NavController) {
    var selectedTab by rememberSaveable { mutableIntStateOf(0) }
    var showExitDialog by remember { mutableStateOf(false) }
    var lastBackPressTime by remember { mutableLongStateOf(0L) }
    val context = LocalContext.current

    // Back press handling
    BackHandler {
        when {
            // If not on home tab, navigate to home
            selectedTab != 0 -> {
                selectedTab = 0
            }
            // If on home tab, show exit dialog or exit on double press
            else -> {
                val currentTime = System.currentTimeMillis()
                if (currentTime - lastBackPressTime < 2000) {
                    // Double press within 2 seconds - exit app
                    (context as? Activity)?.finish()
                } else {
                    // First press - show dialog
                    showExitDialog = true
                    lastBackPressTime = currentTime
                }
            }
        }
    }

    // Exit confirmation dialog
    if (showExitDialog) {
        ExitConfirmationDialog(
            onConfirm = {
                (context as? Activity)?.finish()
            },
            onDismiss = {
                showExitDialog = false
            }
        )
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = AppTheme.colors.background,
        bottomBar = {
            BottomNavigationBar(
                selectedTab = selectedTab,
                onTabSelected = { selectedTab = it }
            )
        }
    ) { paddingValues ->
        when (selectedTab) {
            0 -> HomeScreen(
                navController = navController,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            )
            1 -> ExploreScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            )
            2 -> MyBookingsScreen(
                navController = navController,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            )
            3 -> ProfileScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            )
        }
    }
}

/**
 * Exit confirmation dialog
 */
@Composable
private fun ExitConfirmationDialog(
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = "Exit App",
                color = AppTheme.colors.onBackground
            )
        },
        text = {
            Text(
                text = "Are you sure you want to exit?",
                color = AppTheme.colors.onSecondarySurface
            )
        },
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text(
                    text = "Exit",
                    color = AppTheme.colors.highlightSurface
                )
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(
                    text = "Cancel",
                    color = AppTheme.colors.actionSurface
                )
            }
        },
        containerColor = AppTheme.colors.surface
    )
}
