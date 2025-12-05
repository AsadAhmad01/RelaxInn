package com.project.relaxinn.presentation.ui.auth.forgotpassword

/**
 * Represents all possible user events/actions on the ForgotPassword Screen
 */
sealed class ForgotPasswordEvent {
    data class EmailChanged(val email: String) : ForgotPasswordEvent()
    object SubmitClicked : ForgotPasswordEvent()
    object BackToLoginClicked : ForgotPasswordEvent()
}
