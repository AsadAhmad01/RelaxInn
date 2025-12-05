package com.project.relaxinn.presentation.ui.auth.login

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
 * ViewModel for Login Screen
 * Handles all business logic, validation, and state management
 */
@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    // Private mutable state
    private val _state = MutableStateFlow(LoginState())
    
    // Public immutable state
    val state: StateFlow<LoginState> = _state.asStateFlow()

    /**
     * Handle all user events from the UI
     */
    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.EmailChanged -> {
                _state.update { it.copy(
                    email = event.email,
                    emailError = null // Clear error when user types
                ) }
            }
            
            is LoginEvent.PasswordChanged -> {
                _state.update { it.copy(
                    password = event.password,
                    passwordError = null // Clear error when user types
                ) }
            }
            
            is LoginEvent.TogglePasswordVisibility -> {
                _state.update { it.copy(
                    isPasswordVisible = !it.isPasswordVisible
                ) }
            }
            
            is LoginEvent.RememberMeChanged -> {
                _state.update { it.copy(
                    isRememberMeChecked = event.isChecked
                ) }
            }
            
            LoginEvent.LoginClicked -> {
                validateAndLogin()
            }
            
            LoginEvent.ForgotPasswordClicked -> {
                // Handle forgot password navigation
                // This will be handled by the UI layer
            }
            
            LoginEvent.SignUpClicked -> {
                // Handle sign up navigation
                // This will be handled by the UI layer
            }
        }
    }

    /**
     * Validate login form and proceed with login if valid
     */
    private fun validateAndLogin() {
        val currentState = _state.value
        
        // Validate all fields
        val (isValid, errors) = ValidationUtils.validateLoginForm(
            email = currentState.email,
            password = currentState.password
        )

        if (isValid) {
            // All validations passed, proceed with login
            performLogin()
        } else {
            // Update state with validation errors
            _state.update { it.copy(
                emailError = errors["email"],
                passwordError = errors["password"]
            ) }
        }
    }

    /**
     * Perform the actual login operation
     * In a real app, this would call a repository/use case
     */
    private fun performLogin() {
        viewModelScope.launch {
            try {
                // Set loading state
                _state.update { it.copy(isLoading = true, errorMessage = null) }

                // TODO: Call authentication repository/use case here
                // Example: authRepository.login(email, password)
                
                // Simulate network delay
                kotlinx.coroutines.delay(1000)

                // For now, just mark as successful
                _state.update { it.copy(
                    isLoading = false,
                    isLoginSuccessful = true
                ) }

            } catch (e: Exception) {
                // Handle login error
                _state.update { it.copy(
                    isLoading = false,
                    errorMessage = e.message ?: "Login failed. Please try again."
                ) }
            }
        }
    }

    /**
     * Reset login success state
     * Call this after navigation is complete
     */
    fun resetLoginSuccess() {
        _state.update { it.copy(isLoginSuccessful = false) }
    }

    /**
     * Clear error message
     */
    fun clearError() {
        _state.update { it.copy(errorMessage = null) }
    }
}
