package com.project.relaxinn.presentation.ui.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.project.relaxinn.presentation.theme.AppTheme
import com.project.relaxinn.presentation.ui.bookings.MyBookingsScreen
import com.project.relaxinn.presentation.ui.explore.ExploreScreen
import com.project.relaxinn.presentation.ui.favorites.FavoritesScreen
import com.project.relaxinn.presentation.ui.home.HomeScreen
import com.project.relaxinn.presentation.ui.profile.ProfileScreen
import com.project.relaxinn.presentation.utills.BottomNavigationBar

/**
 * Main Container Screen - Manages bottom navigation and screen switching
 */
@Composable
fun MainContainer() {
    var selectedTab by rememberSaveable { mutableIntStateOf(0) }

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
