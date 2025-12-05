package com.project.relaxinn.presentation.ui.auth.signup

/**
 * Represents the UI state for the SignUp Screen
 */
data class SignUpState(
    val fullName: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val isPasswordVisible: Boolean = false,
    val isConfirmPasswordVisible: Boolean = false,
    val isTermsAccepted: Boolean = false,
    val nameError: String? = null,
    val emailError: String? = null,
    val passwordError: String? = null,
    val confirmPasswordError: String? = null,
    val isLoading: Boolean = false,
    val isSignUpSuccessful: Boolean = false,
    val errorMessage: String? = null
)
