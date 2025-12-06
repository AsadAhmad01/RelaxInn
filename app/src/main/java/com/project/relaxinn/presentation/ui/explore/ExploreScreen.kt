package com.project.relaxinn.presentation.ui.explore

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ViewList
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
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
import com.project.relaxinn.presentation.theme.AppTheme

/**
 * Data class for explore hotels
 */
data class ExploreHotel(
    val name: String,
    val category: String,
    val distance: String,
    val price: String,
    val imageRes: Int,
    val rating: Float = 4.5f
)

/**
 * View mode enum
 */
enum class ViewMode {
    LIST, MAP
}

/**
 * Explore Screen - Discover new hotels and destinations with List/Map view toggle
 */
@Composable
fun ExploreScreen(modifier: Modifier = Modifier) {
    var viewMode by remember { mutableStateOf(ViewMode.LIST) }
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableIntStateOf(0) }

    // Sample data
    val hotels = listOf(
        ExploreHotel("Sapphires Hotel", "Hotel", "20 km away", "$75", R.drawable.ic_building_one, 4.5f),
        ExploreHotel("Brutalism House", "Hotel", "34 km away", "$42", R.drawable.ic_building_one, 4.2f),
        ExploreHotel("Kalibata Hotel", "Hotel", "38 km away", "$59", R.drawable.ic_building_one, 4.7f),
        ExploreHotel("The Linden Tower", "Hotel", "45 km away", "$98", R.drawable.ic_building_one, 4.8f)
    )

    val categories = listOf("Things to Do", "Hotels", "Restaurants", "Flights")

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AppTheme.colors.background)
    ) {
        // Header
        ExploreHeader(
            title = if (viewMode == ViewMode.LIST) "Search list" else "Near You",
            viewMode = viewMode,
            onViewModeToggle = { viewMode = if (viewMode == ViewMode.LIST) ViewMode.MAP else ViewMode.LIST }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Search Bar
        SearchBar(
            query = searchQuery,
            onQueryChange = { searchQuery = it },
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Category Tabs (only in List View)
        if (viewMode == ViewMode.LIST) {
            CategoryTabs(
                categories = categories,
                selectedIndex = selectedCategory,
                onCategorySelected = { selectedCategory = it }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Location Chip
            LocationChip(
                location = "Near Squid Tower Building",
                modifier = Modifier.padding(horizontal = 20.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Results Count and Filter
            ResultsHeader(
                count = hotels.size,
                onFilterClick = { /* TODO: Show filter dialog */ },
                modifier = Modifier.padding(horizontal = 20.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Hotel List
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(hotels) { hotel ->
                    HotelListCard(
                        hotel = hotel,
                        onBookClick = { /* TODO: Navigate to hotel detail */ }
                    )
                }
            }
        } else {
            // Map View
            MapView(
                hotels = hotels,
                onHotelClick = { /* TODO: Navigate to hotel detail */ }
            )
        }
    }
}

/**
 * Header with title and view mode toggle
 */
@Composable
private fun ExploreHeader(
    title: String,
    viewMode: ViewMode,
    onViewModeToggle: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // User Avatar
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

        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge.copy(
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
        )

        // View Mode Toggle Button
        IconButton(
            onClick = onViewModeToggle,
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(AppTheme.colors.surface)
        ) {
            Icon(
                imageVector = if (viewMode == ViewMode.LIST) Icons.Default.Map else Icons.Default.ViewList,
                contentDescription = "Toggle View",
                tint = AppTheme.colors.actionSurface
            )
        }
    }
}

/**
 * Search bar component
 */
@Composable
private fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = modifier.fillMaxWidth(),
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
            IconButton(onClick = { /* TODO: Advanced search */ }) {
                Icon(
                    imageVector = Icons.Default.FilterList,
                    contentDescription = "Filter",
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

/**
 * Category tabs
 */
@Composable
private fun CategoryTabs(
    categories: List<String>,
    selectedIndex: Int,
    onCategorySelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    TabRow(
        selectedTabIndex = selectedIndex,
        modifier = modifier.fillMaxWidth(),
        containerColor = Color.Transparent,
        contentColor = AppTheme.colors.actionSurface,
        indicator = { tabPositions ->
            TabRowDefaults.SecondaryIndicator(
                modifier = Modifier.tabIndicatorOffset(tabPositions[selectedIndex]),
                color = AppTheme.colors.actionSurface
            )
        }
    ) {
        categories.forEachIndexed { index, category ->
            Tab(
                selected = selectedIndex == index,
                onClick = { onCategorySelected(index) },
                text = {
                    Text(
                        text = category,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = if (selectedIndex == index) FontWeight.Bold else FontWeight.Normal
                        )
                    )
                },
                selectedContentColor = AppTheme.colors.actionSurface,
                unselectedContentColor = AppTheme.colors.onSecondarySurface
            )
        }
    }
}

/**
 * Location chip
 */
@Composable
private fun LocationChip(
    location: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = AppTheme.colors.surface
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_building_one),
                contentDescription = "Location",
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = location,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Medium
                )
            )
        }
    }
}

/**
 * Results header with count and filter
 */
@Composable
private fun ResultsHeader(
    count: Int,
    onFilterClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$count hotel are found",
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Color.White
            )
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .clickable(onClick = onFilterClick)
                .padding(horizontal = 12.dp, vertical = 6.dp)
        ) {
            Icon(
                imageVector = Icons.Default.FilterList,
                contentDescription = "Filter",
                tint = AppTheme.colors.actionSurface,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "Edit filter",
                style = MaterialTheme.typography.bodySmall.copy(
                    color = AppTheme.colors.actionSurface
                )
            )
        }
    }
}

/**
 * Hotel card for list view
 */
@Composable
private fun HotelListCard(
    hotel: ExploreHotel,
    onBookClick: () -> Unit,
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
            // Hotel Image
            Image(
                painter = painterResource(id = hotel.imageRes),
                contentDescription = hotel.name,
                modifier = Modifier
                    .width(120.dp)
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp)),
                contentScale = ContentScale.Crop
            )

            // Hotel Details
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .padding(12.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = hotel.name,
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = hotel.category,
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = AppTheme.colors.onSecondarySurface
                        )
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = hotel.distance,
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = AppTheme.colors.onSecondarySurface
                        )
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${hotel.price} /month",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = AppTheme.colors.actionSurface,
                            fontWeight = FontWeight.Bold
                        )
                    )

                    Button(
                        onClick = onBookClick,
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = AppTheme.colors.actionSurface,
                            contentColor = AppTheme.colors.onActioSurface
                        ),
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp),
                        modifier = Modifier.height(32.dp)
                    ) {
                        Text(
                            text = "Book now",
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

/**
 * Map view with hotel markers
 */
@Composable
private fun MapView(
    hotels: List<ExploreHotel>,
    onHotelClick: (ExploreHotel) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // Map Background (placeholder)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(AppTheme.colors.surface.copy(alpha = 0.3f))
        ) {
            // Simulated map with grid pattern
            Image(
                painter = painterResource(id = R.drawable.ic_building_one),
                contentDescription = "Map",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                alpha = 0.2f
            )

            // Map markers (location pins)
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(40.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                repeat(4) { index ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = if (index % 2 == 0) Arrangement.Start else Arrangement.End
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "Hotel Location",
                            tint = AppTheme.colors.actionSurface,
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }
            }
        }

        // Floating hotel card
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(20.dp)
        ) {
            MapHotelCard(
                hotel = hotels.firstOrNull() ?: return,
                onBookClick = { onHotelClick(hotels.first()) }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Back button with results count
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_menu_revert),
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "${hotels.size} hotel are found",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.White,
                        fontWeight = FontWeight.Medium
                    )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Hotel list in map view
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(hotels.drop(1)) { hotel ->
                    MapHotelCard(
                        hotel = hotel,
                        onBookClick = { onHotelClick(hotel) }
                    )
                }
            }
        }
    }
}

/**
 * Hotel card for map view
 */
@Composable
private fun MapHotelCard(
    hotel: ExploreHotel,
    onBookClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = AppTheme.colors.surface.copy(alpha = 0.95f)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Hotel Image
            Image(
                painter = painterResource(id = hotel.imageRes),
                contentDescription = hotel.name,
                modifier = Modifier
                    .size(76.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(12.dp))

            // Hotel Info
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = hotel.name,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )

                Text(
                    text = hotel.category,
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = AppTheme.colors.onSecondarySurface
                    )
                )

                Text(
                    text = hotel.distance,
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = AppTheme.colors.onSecondarySurface
                    )
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    repeat(4) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = AppTheme.colors.onHighlightSurface,
                            modifier = Modifier.size(12.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Price and Button
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.height(76.dp)
            ) {
                Text(
                    text = "${hotel.price} /month",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = AppTheme.colors.actionSurface,
                        fontWeight = FontWeight.Bold
                    )
                )

                Button(
                    onClick = onBookClick,
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppTheme.colors.actionSurface,
                        contentColor = AppTheme.colors.onActioSurface
                    ),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                    modifier = Modifier.height(28.dp)
                ) {
                    Text(
                        text = "Book now",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
        }
    }
}
