package com.project.relaxinn.presentation.ui.bookings;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.CardDefaults;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.text.font.FontWeight;
import com.project.relaxinn.R;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0003\u001a \u0010\t\u001a\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0003\u001a\u0012\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007\u001a.\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u00102\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0003\u001a0\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0003\u00a8\u0006\u0017"}, d2 = {"BookingCard", "", "booking", "Lcom/project/relaxinn/presentation/ui/bookings/Booking;", "onViewTicketClick", "Lkotlin/Function0;", "onCancelClick", "modifier", "Landroidx/compose/ui/Modifier;", "BookingsHeader", "onFilterClick", "MyBookingsScreen", "SegmentedControl", "selectedIndex", "", "onTabSelected", "Lkotlin/Function1;", "SegmentedControlButton", "text", "", "isSelected", "", "onClick", "app_debug"})
public final class MyBookingsScreenKt {
    
    /**
     * My Bookings Screen - View current and past hotel bookings
     */
    @androidx.compose.runtime.Composable()
    public static final void MyBookingsScreen(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * Header with title and filter button
     */
    @androidx.compose.runtime.Composable()
    private static final void BookingsHeader(kotlin.jvm.functions.Function0<kotlin.Unit> onFilterClick, androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * Segmented Control for switching between Current and History tabs
     */
    @androidx.compose.runtime.Composable()
    private static final void SegmentedControl(int selectedIndex, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onTabSelected, androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * Individual button for segmented control
     */
    @androidx.compose.runtime.Composable()
    private static final void SegmentedControlButton(java.lang.String text, boolean isSelected, kotlin.jvm.functions.Function0<kotlin.Unit> onClick, androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * Booking card displaying hotel information
     */
    @androidx.compose.runtime.Composable()
    private static final void BookingCard(com.project.relaxinn.presentation.ui.bookings.Booking booking, kotlin.jvm.functions.Function0<kotlin.Unit> onViewTicketClick, kotlin.jvm.functions.Function0<kotlin.Unit> onCancelClick, androidx.compose.ui.Modifier modifier) {
    }
}