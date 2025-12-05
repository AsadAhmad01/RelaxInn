package com.project.relaxinn.presentation.ui.auth.forgotpassword

/**
 * Represents the UI state for the ForgotPassword Screen
 */
data class ForgotPasswordState(
    val email: String = "",
    val emailError: String? = null,
    val isLoading: Boolean = false,
    val isSubmitSuccessful: Boolean = false,
    val errorMessage: String? = null
)
