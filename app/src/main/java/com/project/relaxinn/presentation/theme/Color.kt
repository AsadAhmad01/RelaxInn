package com.project.relaxinn.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

// --------------------------------------------------
// BASE BRAND COLORS (Old)
// --------------------------------------------------

val BluePrimary = Color(0xFF3D5AFE)
val BlueGradientEnd = Color(0xFF6C63FF)

val LightPurple = Color(0xFF756FE6)
val LightBlue = Color(0xFF6896EA)
val DarkBrown = Color(0xFF763F3E)
val DarkPurple = Color(0xFF3F3962)
val Green = Color(0xFF4BB45A)
val RoseBrown = Color(0xFFD06464)
val LightBrown = Color(0xFFBD4646)
val DarkGrey = Color(0xFF2F3645)

// --------------------------------------------------
// RELAX INN THEME COLORS (Detected from Screenshots)
// --------------------------------------------------
val RelaxBg = Color(0xFF181A20)          // Main Background (Dark Gunmetal)
val RelaxSurface = Color(0xFF262A36)     // Cards & Input Fields (Lighter Gunmetal)
val RelaxBlue = Color(0xFF9FBDE2)        // Primary Button Color (Powder Blue)
val RelaxOrange = Color(0xFFDE856C)      // Accent Text (Terracotta)
val RelaxTextSec = Color(0xFF6E7787)     // Secondary Text (Muted Gray)
val RelaxStar = Color(0xFFF2B359)        // Rating Stars (Yellow)
val RelaxWhite = Color(0xFFFFFFFF)       // Primary Text
val RelaxDivider = Color(0xFF2F3645)     // Subtle dividers

// --------------------------------------------------
// DATA MODEL
// --------------------------------------------------
@Immutable
data class AppColors(
    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val onSurface: Color,
    val secondarySurface: Color,
    val onSecondarySurface: Color,
    val regularSurface: Color,
    val onRegularSurface: Color,
    val actionSurface: Color,
    val onActioSurface: Color,
    val highlightSurface: Color,
    val onHighlightSurface: Color,
    val cardGradientBlue: Color,
    val cardGradientPurple: Color,
    val chipBrown: Color,
    val chipDarkPurple: Color,
    val chipGreen: Color,
    val chipRoseBrown: Color,
    val chipLightBrown: Color,
    val chipDarkGrey: Color,
    // Optional: Add specific new slots if needed,
    // but for now we map to existing ones below
)

// --------------------------------------------------
// COMPOSITION LOCAL
// --------------------------------------------------
val LocalAppColors = staticCompositionLocalOf {
    AppColors(
        background = Color.Unspecified,
        onBackground = Color.Unspecified,
        surface = Color.Unspecified,
        onSurface = Color.Unspecified,
        secondarySurface = Color.Unspecified,
        onSecondarySurface = Color.Unspecified,
        regularSurface = Color.Unspecified,
        onRegularSurface = Color.Unspecified,
        actionSurface = Color.Unspecified,
        onActioSurface = Color.Unspecified,
        highlightSurface = Color.Unspecified,
        onHighlightSurface = Color.Unspecified,
        cardGradientBlue = Color.Unspecified,
        cardGradientPurple = Color.Unspecified,
        chipBrown = Color.Unspecified,
        chipDarkPurple = Color.Unspecified,
        chipGreen = Color.Unspecified,
        chipRoseBrown = Color.Unspecified,
        chipLightBrown = Color.Unspecified,
        chipDarkGrey = Color.Unspecified,
    )
}

// --------------------------------------------------
// UNIVERSAL APP COLOR PALETTE (Updated with New Theme)
// --------------------------------------------------
val UnifiedAppColors = AppColors(
    background = RelaxBg,                  // Updated: Main Dark Background
    onBackground = RelaxWhite,             // Updated: Main Text
    surface = RelaxSurface,                // Updated: Cards / Input fields
    onSurface = RelaxWhite,                // Updated: Text inside cards
    secondarySurface = RelaxSurface,       // Updated: Search bars
    onSecondarySurface = RelaxTextSec,     // Updated: Hint text / Muted text
    regularSurface = RelaxSurface,         // Chips / Containers
    onRegularSurface = RelaxWhite,         // Text on chips
    actionSurface = RelaxBlue,             // Updated: "Sign In" / "Book Now" buttons
    onActioSurface = RelaxBg,              // Updated: Text on Button (Dark text on Light Blue)
    highlightSurface = RelaxOrange,        // Updated: "Travel Agency" accent text
    onHighlightSurface = RelaxStar,        // Used for Stars or Price tags

    // Gradient / Chips mapping
    cardGradientBlue = LightBlue,          // Kept original for gradient fallback
    cardGradientPurple = LightPurple,      // Kept original for gradient fallback
    chipDarkPurple = DarkPurple,
    chipBrown = DarkBrown,
    chipGreen = Green,
    chipRoseBrown = RoseBrown,
    chipLightBrown = LightBrown,
    chipDarkGrey = DarkGrey
)

// --------------------------------------------------
// GRADIENT UTILITIES
// --------------------------------------------------
fun viewDetailsGradient(): Brush = Brush.linearGradient(
    colors = listOf(BluePrimary, BlueGradientEnd),
)

fun cardGradient(): Brush = Brush.linearGradient(
    colors = listOf(UnifiedAppColors.cardGradientBlue, UnifiedAppColors.cardGradientPurple),
)

// Updated: Single color solid brush often looks better for
// flat design (like the button in the screenshot), but if you need a gradient:
fun buttonGradient(): Brush = Brush.linearGradient(
    colors = listOf(RelaxBlue, Color(0xFF8BAFD6)), // Subtle gradient based on the new Blue
)