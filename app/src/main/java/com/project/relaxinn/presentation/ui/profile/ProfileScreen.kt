package com.project.relaxinn.presentation.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.relaxinn.R
import com.project.relaxinn.presentation.theme.AppTheme


/**
 * Profile Screen - Main user profile view
 */
@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        // Header Section
        ProfileHeader(
            onEditClick = { /* TODO: Navigate to edit profile */ }
        )

        Spacer(modifier = Modifier.height(30.dp))

        // User Avatar Section
        UserAvatarSection(
            name = "Lucifer",
            email = "lucifer@email.com"
        )

        Spacer(modifier = Modifier.height(40.dp))

        // Menu List Section
        MenuListSection(
            onPersonalInfoClick = { /* TODO: Navigate to personal info */ },
            onPaymentMethodsClick = { /* TODO: Navigate to payment methods */ },
            onSettingsClick = { /* TODO: Navigate to settings */ }
        )

        Spacer(modifier = Modifier.height(40.dp))

        // Logout Button
        LogoutButton(
            onLogoutClick = { /* TODO: Handle logout */ },
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(100.dp))
    }
}

/**
 * Header with title and edit button
 */
@Composable
private fun ProfileHeader(
    onEditClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Profile",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        )

        IconButton(
            onClick = onEditClick,
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Edit Profile",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

/**
 * User avatar, name, and email section
 */
@Composable
private fun UserAvatarSection(
    name: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Avatar with border
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .border(
                    width = 2.dp,
                    color = AppTheme.colors.actionSurface,
                    shape = CircleShape
                )
                .background(AppTheme.colors.surface),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "User Avatar",
                tint = AppTheme.colors.onSurface,
                modifier = Modifier.size(64.dp)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        // User Name
        Text(
            text = name,
            style = MaterialTheme.typography.titleLarge.copy(
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        )

        Spacer(modifier = Modifier.height(4.dp))

        // User Email
        Text(
            text = email,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = AppTheme.colors.onSecondarySurface
            )
        )
    }
}

/**
 * Menu list with navigation items
 */
@Composable
private fun MenuListSection(
    onPersonalInfoClick: () -> Unit,
    onPaymentMethodsClick: () -> Unit,
    onSettingsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        // Personal Information
        MenuItemCard(
            icon = Icons.Default.Person,
            title = "Personal Information",
            onClick = onPersonalInfoClick
        )

        // Payment Methods
        MenuItemCard(
            icon = Icons.Default.CreditCard,
            title = "Payment Methods",
            onClick = onPaymentMethodsClick
        )

        // Settings
        MenuItemCard(
            icon = Icons.Default.Settings,
            title = "Settings",
            onClick = onSettingsClick
        )
    }
}

/**
 * Individual menu item card
 */
@Composable
private fun MenuItemCard(
    icon: ImageVector,
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = AppTheme.colors.surface
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                // Left Icon
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    tint = AppTheme.colors.actionSurface,
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.width(15.dp))

                // Title
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Medium
                    )
                )
            }

            // Right Chevron
            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = "Navigate",
                tint = AppTheme.colors.onSecondarySurface,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

/**
 * Logout button at the bottom
 */
@Composable
private fun LogoutButton(
    onLogoutClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        onClick = onLogoutClick,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(30.dp),
        border = androidx.compose.foundation.BorderStroke(
            width = 1.dp,
            color = Color.Red
        )
    ) {
        Text(
            text = "Log Out",
            style = MaterialTheme.typography.bodyLarge.copy(
                color = Color.Red,
                fontWeight = FontWeight.Medium
            )
        )
    }
}
