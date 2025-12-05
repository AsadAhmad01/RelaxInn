package com.project.relaxinn.presentation.ui.auth.forgotpassword

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.relaxinn.presentation.utills.ValidationUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for ForgotPassword Screen
 * Handles all business logic, validation, and state management
 */
@HiltViewModel
class ForgotPasswordViewModel @Inject constructor() : ViewModel() {

    // Private mutable state
    private val _state = MutableStateFlow(ForgotPasswordState())
    
    // Public immutable state
    val state: StateFlow<ForgotPasswordState> = _state.asStateFlow()

    /**
     * Handle all user events from the UI
     */
    fun onEvent(event: ForgotPasswordEvent) {
        when (event) {
            is ForgotPasswordEvent.EmailChanged -> {
                _state.update { it.copy(
                    email = event.email,
                    emailError = null
                ) }
            }
            
            ForgotPasswordEvent.SubmitClicked -> {
                validateAndSubmit()
            }
            
            ForgotPasswordEvent.BackToLoginClicked -> {
                // Handle back to login navigation
                // This will be handled by the UI layer
            }
        }
    }

    /**
     * Validate email and submit password reset request
     */
    private fun validateAndSubmit() {
        val currentState = _state.value
        
        // Validate email
        val emailValidation = ValidationUtils.validateEmail(currentState.email)

        if (emailValidation.first) {
            // Email is valid, proceed with password reset
            performPasswordReset()
        } else {
            // Update state with validation error
            _state.update { it.copy(
                emailError = emailValidation.second
            ) }
        }
    }

    /**
     * Perform the actual password reset operation
     * In a real app, this would call a repository/use case
     */
    private fun performPasswordReset() {
        viewModelScope.launch {
            try {
                // Set loading state
                _state.update { it.copy(isLoading = true, errorMessage = null) }

                // TODO: Call authentication repository/use case here
                // Example: authRepository.resetPassword(email)
                
                // Simulate network delay
                kotlinx.coroutines.delay(1000)

                // For now, just mark as successful
                _state.update { it.copy(
                    isLoading = false,
                    isSubmitSuccessful = true
                ) }

            } catch (e: Exception) {
                // Handle error
                _state.update { it.copy(
                    isLoading = false,
                    errorMessage = e.message ?: "Failed to send reset email. Please try again."
                ) }
            }
        }
    }

    /**
     * Reset submit success state
     * Call this after navigation is complete
     */
    fun resetSubmitSuccess() {
        _state.update { it.copy(isSubmitSuccessful = false) }
    }

    /**
     * Clear error message
     */
    fun clearError() {
        _state.update { it.copy(errorMessage = null) }
    }
}
