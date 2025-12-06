package com.project.relaxinn.presentation.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.relaxinn.R
import com.project.relaxinn.presentation.theme.AppTheme


data class Hotel(
    val name: String,
    val location: String,
    val rating: Float,
    val price: String,
    val imageRes: Int,
    val isFeatured: Boolean = false
)

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var searchQuery by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    // Sample data
    val topRatedHotels = listOf(
        Hotel("Porto Santo", "Australia", 4.5f, "$120", R.drawable.ic_building_one, true),
        Hotel("Kalibata", "Portugal", 4.8f, "$95", R.drawable.ic_building_one, true)
    )

    val discoverHotels = listOf(
        Hotel("Sapphires Hotel", "New York", 4.0f, "$75", R.drawable.ic_building_one)
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        // Header Section
        HomeHeader()

        Spacer(modifier = Modifier.height(24.dp))

        // Search Bar
        SearchBar(
            query = searchQuery,
            onQueryChange = { searchQuery = it },
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Top Rated Section
        SectionHeader(
            title = "Top rated",
            subtitle = "Sapphines Hotel",
            onSeeAllClick = {},
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Top Rated Hotels Carousel
        LazyRow(
            contentPadding = PaddingValues(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(topRatedHotels) { hotel ->
                TopRatedHotelCard(hotel = hotel)
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Discover Section
        SectionHeader(
            title = "Discover",
            subtitle = "",
            onSeeAllClick = {},
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Discover Hotels List
        discoverHotels.forEach { hotel ->
            DiscoverHotelCard(
                hotel = hotel,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp)
            )
        }

        // Extra bottom padding to ensure content is visible above bottom bar
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
private fun HomeHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // User Profile
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Profile Image
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(AppTheme.colors.surface),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Profile",
                    tint = AppTheme.colors.onSurface,
                    modifier = Modifier.size(32.dp)
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Greeting Text
            Text(
                text = "Hi, Lucifer!",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = AppTheme.colors.onBackground,
                    fontWeight = FontWeight.Medium
                )
            )
        }

        // Menu Button
        IconButton(
            onClick = { },
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(AppTheme.colors.surface)
        ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                tint = AppTheme.colors.onSurface
            )
        }
    }
}

@Composable
private fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        // Title
        Text(
            text = buildAnnotatedString {
                append("Discover your\n")
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("dream place")
                }
            },
            style = MaterialTheme.typography.headlineMedium.copy(
                color = AppTheme.colors.onBackground,
                lineHeight = 36.sp
            )
        )

        Spacer(modifier = Modifier.height(4.dp))

        // Location
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = android.R.drawable.ic_menu_mylocation),
                contentDescription = "Location",
                tint = AppTheme.colors.highlightSurface,
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "Manhattan, New York USA",
                style = MaterialTheme.typography.bodySmall.copy(
                    color = AppTheme.colors.onSecondarySurface
                )
            )
        }

        // Travel Agency Badge
        Text(
            text = "Travel\nAgency",
            style = MaterialTheme.typography.labelSmall.copy(
                color = AppTheme.colors.highlightSurface,
                fontWeight = FontWeight.Bold,
                lineHeight = 14.sp
            ),
            modifier = Modifier.padding(top = 4.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Search Field
        OutlinedTextField(
            value = query,
            onValueChange = onQueryChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = "Search here...",
                    color = AppTheme.colors.onSecondarySurface.copy(alpha = 0.5f)
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = AppTheme.colors.onSecondarySurface
                )
            },
            trailingIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Mic,
                        contentDescription = "Voice Search",
                        tint = AppTheme.colors.onSecondarySurface
                    )
                }
            },
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = AppTheme.colors.surface,
                unfocusedContainerColor = AppTheme.colors.surface,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                focusedTextColor = AppTheme.colors.onSurface,
                unfocusedTextColor = AppTheme.colors.onSurface
            ),
            singleLine = true
        )
    }
}

@Composable
private fun SectionHeader(
    title: String,
    subtitle: String,
    onSeeAllClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = AppTheme.colors.onSecondarySurface,
                        fontWeight = FontWeight.Normal
                    )
                )
                if (subtitle.isNotEmpty()) {
                    Text(
                        text = subtitle,
                        style = MaterialTheme.typography.titleLarge.copy(
                            color = AppTheme.colors.onBackground,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }

            Text(
                text = "See all >",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = AppTheme.colors.highlightSurface
                ),
                modifier = Modifier.clickable { onSeeAllClick() }
            )
        }
    }
}

@Composable
private fun TopRatedHotelCard(hotel: Hotel) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(240.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = AppTheme.colors.surface
        )
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            // Hotel Image
            Image(
                painter = painterResource(id = hotel.imageRes),
                contentDescription = hotel.name,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            // Rating Badge
            Box(
                modifier = Modifier
                    .padding(12.dp)
                    .align(Alignment.TopStart)
                    .clip(RoundedCornerShape(8.dp))
                    .background(AppTheme.colors.surface.copy(alpha = 0.9f))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Rating",
                        tint = AppTheme.colors.onHighlightSurface,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = hotel.rating.toString(),
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = AppTheme.colors.onSurface,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }

            // Hotel Info
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
                    .background(
                        AppTheme.colors.surface.copy(alpha = 0.95f)
                    )
                    .padding(12.dp)
            ) {
                Text(
                    text = hotel.name,
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = AppTheme.colors.onSurface,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = hotel.location,
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = AppTheme.colors.onSecondarySurface
                    )
                )
            }
        }
    }
}

@Composable
private fun DiscoverHotelCard(hotel: Hotel, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = AppTheme.colors.surface
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            // Hotel Image
            Image(
                painter = painterResource(id = hotel.imageRes),
                contentDescription = hotel.name,
                modifier = Modifier
                    .width(100.dp)
                    .height(96.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(12.dp))

            // Hotel Info
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = hotel.name,
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = AppTheme.colors.onSurface,
                            fontWeight = FontWeight.Bold
                        )
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    // Rating
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        repeat(4) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,
                                tint = AppTheme.colors.onHighlightSurface,
                                modifier = Modifier.size(14.dp)
                            )
                        }
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = AppTheme.colors.onSecondarySurface,
                            modifier = Modifier.size(14.dp)
                        )
                    }
                }

                // Price and Book Button
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = AppTheme.colors.onSurface,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp
                                )
                            ) {
                                append(hotel.price)
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = AppTheme.colors.onSecondarySurface,
                                    fontSize = 12.sp
                                )
                            ) {
                                append(" /month")
                            }
                        }
                    )

                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = AppTheme.colors.actionSurface,
                            contentColor = AppTheme.colors.onActioSurface
                        ),
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        Text(
                            text = "Book now",
                            style = MaterialTheme.typography.labelMedium.copy(
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            }
        }
    }
}
