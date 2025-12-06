package com.project.relaxinn.presentation.ui.bookings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.relaxinn.R
import com.project.relaxinn.presentation.navigation.Screen
import com.project.relaxinn.presentation.theme.AppTheme
import androidx.navigation.NavController

/**
 * Data class for booking information
 */
data class Booking(
    val hotelName: String,
    val location: String,
    val pricePerNight: String,
    val imageRes: Int,
    val isCurrent: Boolean = true
)

/**
 * My Bookings Screen - View current and past hotel bookings
 */
@Composable
fun MyBookingsScreen(navController: NavController, modifier: Modifier = Modifier) {
    var selectedTab by remember { mutableIntStateOf(0) } // 0 = Current, 1 = History
    val scrollState = rememberScrollState()

    // Sample booking data
    val currentBookings = listOf(
        Booking(
            hotelName = "Sapphires Hotel",
            location = "Manhattan, NY",
            pricePerNight = "$75",
            imageRes = R.drawable.ic_building_one,
            isCurrent = true
        ),
        Booking(
            hotelName = "Brutalism House",
            location = "Berlin, Germany",
            pricePerNight = "$42",
            imageRes = R.drawable.ic_building_one,
            isCurrent = true
        )
    )

    val historyBookings = listOf(
        Booking(
            hotelName = "Porto Santo",
            location = "Australia",
            pricePerNight = "$120",
            imageRes = R.drawable.ic_building_one,
            isCurrent = false
        )
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AppTheme.colors.background)
    ) {
        // Header Section
        BookingsHeader(
            onFilterClick = { /* TODO: Show filter options */ }
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Tab Switcher (Segmented Control)
        SegmentedControl(
            selectedIndex = selectedTab,
            onTabSelected = { selectedTab = it },
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Booking List
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            val bookings = if (selectedTab == 0) currentBookings else historyBookings

            bookings.forEach { booking ->
                BookingCard(
                    booking = booking,
                    onViewTicketClick = {
                        navController.navigate(
                            Screen.HotelDetail.createRoute(
                                hotelName = booking.hotelName,
                                location = booking.location,
                                rating = 4.5f, // Default rating for bookings
                                price = booking.pricePerNight
                            )
                        )
                    },
                    onCancelClick = { /* TODO: Handle cancellation */ }
                )
            }

            // Bottom padding for better scrolling
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

/**
 * Header with title and filter button
 */
@Composable
private fun BookingsHeader(
    onFilterClick: () -> Unit,
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
            text = "My Bookings",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        )

        IconButton(
            onClick = onFilterClick,
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                imageVector = Icons.Default.FilterList,
                contentDescription = "Filter",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

/**
 * Segmented Control for switching between Current and History tabs
 */
@Composable
private fun SegmentedControl(
    selectedIndex: Int,
    onTabSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(50.dp))
            .background(AppTheme.colors.surface)
            .padding(4.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        // Current Tab
        SegmentedControlButton(
            text = "Current",
            isSelected = selectedIndex == 0,
            onClick = { onTabSelected(0) },
            modifier = Modifier.weight(1f)
        )

        // History Tab
        SegmentedControlButton(
            text = "History",
            isSelected = selectedIndex == 1,
            onClick = { onTabSelected(1) },
            modifier = Modifier.weight(1f)
        )
    }
}

/**
 * Individual button for segmented control
 */
@Composable
private fun SegmentedControlButton(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(50.dp))
            .background(
                if (isSelected) AppTheme.colors.actionSurface else Color.Transparent
            )
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge.copy(
                color = if (isSelected) AppTheme.colors.onActioSurface else AppTheme.colors.onSecondarySurface,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
            )
        )
    }
}

/**
 * Booking card displaying hotel information
 */
@Composable
private fun BookingCard(
    booking: Booking,
    onViewTicketClick: () -> Unit,
    onCancelClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = AppTheme.colors.surface
        )
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            // Hotel Image (30% width)
            Image(
                painter = painterResource(id = booking.imageRes),
                contentDescription = booking.hotelName,
                modifier = Modifier
                    .width(120.dp)
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp)),
                contentScale = ContentScale.Crop
            )

            // Hotel Details (70% width)
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .padding(15.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // Hotel Name and Location
                Column {
                    Text(
                        text = booking.hotelName,
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )

                    Spacer(modifier = Modifier.height(5.dp))

                    Text(
                        text = booking.location,
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontSize = 12.sp,
                            color = AppTheme.colors.onSecondarySurface
                        )
                    )
                }

                // Price and Action Button
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${booking.pricePerNight} /night",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 14.sp,
                            color = AppTheme.colors.actionSurface,
                            fontWeight = FontWeight.Medium
                        )
                    )

                    // Show different buttons based on booking type
                    if (booking.isCurrent) {
                        Button(
                            onClick = onViewTicketClick,
                            shape = RoundedCornerShape(20.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = AppTheme.colors.actionSurface,
                                contentColor = AppTheme.colors.onActioSurface
                            ),
                            modifier = Modifier.height(32.dp)
                        ) {
                            Text(
                                text = "View Ticket",
                                style = MaterialTheme.typography.labelSmall.copy(
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                    } else {
                        OutlinedButton(
                            onClick = onCancelClick,
                            shape = RoundedCornerShape(20.dp),
                            border = androidx.compose.foundation.BorderStroke(
                                width = 1.dp,
                                color = AppTheme.colors.actionSurface
                            ),
                            colors = ButtonDefaults.outlinedButtonColors(
                                contentColor = AppTheme.colors.actionSurface
                            ),
                            modifier = Modifier.height(32.dp)
                        ) {
                            Text(
                                text = "Cancel",
                                style = MaterialTheme.typography.labelSmall.copy(
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}
