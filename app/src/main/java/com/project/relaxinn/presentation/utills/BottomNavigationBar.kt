package com.project.relaxinn.presentation.utills

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.project.relaxinn.presentation.theme.AppTheme

/**
 * Bottom Navigation Bar for the app
 */
@Composable
fun BottomNavigationBar(
    selectedTab: Int,
    onTabSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp)
            .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
            .background(AppTheme.colors.surface)
            .padding(horizontal = 24.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Home Tab
        BottomNavItem(
            icon = Icons.Default.Home,
            isSelected = selectedTab == 0,
            onClick = { onTabSelected(0) }
        )

        // Explore Tab
        BottomNavItem(
            icon = Icons.Default.Explore,
            isSelected = selectedTab == 1,
            onClick = { onTabSelected(1) }
        )

        // Favorites Tab
        BottomNavItem(
            icon = Icons.Default.Favorite,
            isSelected = selectedTab == 2,
            onClick = { onTabSelected(2) }
        )

        // Profile Tab
        BottomNavItem(
            icon = Icons.Default.AccountCircle,
            isSelected = selectedTab == 3,
            onClick = { onTabSelected(3) }
        )
    }
}

@Composable
private fun BottomNavItem(
    icon: ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.size(48.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = if (isSelected) AppTheme.colors.actionSurface else AppTheme.colors.onSecondarySurface,
            modifier = Modifier.size(28.dp)
        )
    }
}
