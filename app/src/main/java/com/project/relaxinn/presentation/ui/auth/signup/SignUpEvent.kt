package com.project.relaxinn.presentation.ui.auth.signup

/**
 * Represents all possible user events/actions on the SignUp Screen
 */
sealed class SignUpEvent {
    data class FullNameChanged(val fullName: String) : SignUpEvent()
    data class EmailChanged(val email: String) : SignUpEvent()
    data class PasswordChanged(val password: String) : SignUpEvent()
    data class ConfirmPasswordChanged(val confirmPassword: String) : SignUpEvent()
    object TogglePasswordVisibility : SignUpEvent()
    object ToggleConfirmPasswordVisibility : SignUpEvent()
    data class TermsAcceptedChanged(val isAccepted: Boolean) : SignUpEvent()
    object SignUpClicked : SignUpEvent()
    object SignInClicked : SignUpEvent()
}
