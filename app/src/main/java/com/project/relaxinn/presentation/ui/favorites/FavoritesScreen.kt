package com.project.relaxinn.presentation.ui.favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.relaxinn.presentation.theme.AppTheme

/**
 * Favorites Screen - View saved/favorite hotels
 */
@Composable
fun FavoritesScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(AppTheme.colors.background),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "❤️",
                style = MaterialTheme.typography.displayLarge.copy(
                    fontSize = 64.sp
                )
            )
            Text(
                text = "Favorites",
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ),
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = "Your saved hotels",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = AppTheme.colors.onSecondarySurface
                ),
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}
