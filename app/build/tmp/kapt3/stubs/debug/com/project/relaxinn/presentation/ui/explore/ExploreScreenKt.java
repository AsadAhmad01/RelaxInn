package com.project.relaxinn.presentation.ui.explore;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.OutlinedTextFieldDefaults;
import androidx.compose.material3.TabRowDefaults;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.text.font.FontWeight;
import com.project.relaxinn.R;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a<\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0003\u001a0\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00102\b\b\u0002\u0010\t\u001a\u00020\nH\u0003\u001a\u0012\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u001a(\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00102\b\b\u0002\u0010\t\u001a\u00020\nH\u0003\u001a\u001a\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\nH\u0003\u001a(\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00102\b\b\u0002\u0010\t\u001a\u00020\nH\u0003\u001a4\u0010\u0019\u001a\u00020\u00012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0003\u001a(\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u00062\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00102\b\b\u0002\u0010\t\u001a\u00020\nH\u0003\u001a.\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u00042\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0003\u00a8\u0006\""}, d2 = {"CategoryTabs", "", "categories", "", "", "selectedIndex", "", "onCategorySelected", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "ExploreHeader", "title", "viewMode", "Lcom/project/relaxinn/presentation/ui/explore/ViewMode;", "onViewModeToggle", "Lkotlin/Function0;", "ExploreScreen", "HotelListCard", "hotel", "Lcom/project/relaxinn/presentation/ui/explore/ExploreHotel;", "onBookClick", "LocationChip", "location", "MapHotelCard", "MapView", "hotels", "onHotelClick", "ResultsHeader", "count", "onFilterClick", "SearchBar", "query", "onQueryChange", "app_debug"})
public final class ExploreScreenKt {
    
    /**
     * Explore Screen - Discover new hotels and destinations with List/Map view toggle
     */
    @androidx.compose.runtime.Composable()
    public static final void ExploreScreen(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * Header with title and view mode toggle
     */
    @androidx.compose.runtime.Composable()
    private static final void ExploreHeader(java.lang.String title, com.project.relaxinn.presentation.ui.explore.ViewMode viewMode, kotlin.jvm.functions.Function0<kotlin.Unit> onViewModeToggle, androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * Search bar component
     */
    @androidx.compose.runtime.Composable()
    private static final void SearchBar(java.lang.String query, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onQueryChange, androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * Category tabs
     */
    @androidx.compose.runtime.Composable()
    private static final void CategoryTabs(java.util.List<java.lang.String> categories, int selectedIndex, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onCategorySelected, androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * Location chip
     */
    @androidx.compose.runtime.Composable()
    private static final void LocationChip(java.lang.String location, androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * Results header with count and filter
     */
    @androidx.compose.runtime.Composable()
    private static final void ResultsHeader(int count, kotlin.jvm.functions.Function0<kotlin.Unit> onFilterClick, androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * Hotel card for list view
     */
    @androidx.compose.runtime.Composable()
    private static final void HotelListCard(com.project.relaxinn.presentation.ui.explore.ExploreHotel hotel, kotlin.jvm.functions.Function0<kotlin.Unit> onBookClick, androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * Map view with hotel markers
     */
    @androidx.compose.runtime.Composable()
    private static final void MapView(java.util.List<com.project.relaxinn.presentation.ui.explore.ExploreHotel> hotels, kotlin.jvm.functions.Function1<? super com.project.relaxinn.presentation.ui.explore.ExploreHotel, kotlin.Unit> onHotelClick, androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * Hotel card for map view
     */
    @androidx.compose.runtime.Composable()
    private static final void MapHotelCard(com.project.relaxinn.presentation.ui.explore.ExploreHotel hotel, kotlin.jvm.functions.Function0<kotlin.Unit> onBookClick, androidx.compose.ui.Modifier modifier) {
    }
}