package com.project.relaxinn.presentation.ui.auth.login

/**
 * Represents all possible user events/actions on the Login Screen
 */
sealed class LoginEvent {
    data class EmailChanged(val email: String) : LoginEvent()
    data class PasswordChanged(val password: String) : LoginEvent()
    object TogglePasswordVisibility : LoginEvent()
    data class RememberMeChanged(val isChecked: Boolean) : LoginEvent()
    object LoginClicked : LoginEvent()
    object ForgotPasswordClicked : LoginEvent()
    object SignUpClicked : LoginEvent()
}
