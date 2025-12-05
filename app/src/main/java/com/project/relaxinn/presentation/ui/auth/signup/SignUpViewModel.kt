package com.project.relaxinn.presentation.ui.auth.signup

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
 * ViewModel for SignUp Screen
 * Handles all business logic, validation, and state management
 */
@HiltViewModel
class SignUpViewModel @Inject constructor() : ViewModel() {

    // Private mutable state
    private val _state = MutableStateFlow(SignUpState())
    
    // Public immutable state
    val state: StateFlow<SignUpState> = _state.asStateFlow()

    /**
     * Handle all user events from the UI
     */
    fun onEvent(event: SignUpEvent) {
        when (event) {
            is SignUpEvent.FullNameChanged -> {
                _state.update { it.copy(
                    fullName = event.fullName,
                    nameError = null
                ) }
            }
            
            is SignUpEvent.EmailChanged -> {
                _state.update { it.copy(
                    email = event.email,
                    emailError = null
                ) }
            }
            
            is SignUpEvent.PasswordChanged -> {
                _state.update { it.copy(
                    password = event.password,
                    passwordError = null
                ) }
            }
            
            is SignUpEvent.ConfirmPasswordChanged -> {
                _state.update { it.copy(
                    confirmPassword = event.confirmPassword,
                    confirmPasswordError = null
                ) }
            }
            
            SignUpEvent.TogglePasswordVisibility -> {
                _state.update { it.copy(
                    isPasswordVisible = !it.isPasswordVisible
                ) }
            }
            
            SignUpEvent.ToggleConfirmPasswordVisibility -> {
                _state.update { it.copy(
                    isConfirmPasswordVisible = !it.isConfirmPasswordVisible
                ) }
            }
            
            is SignUpEvent.TermsAcceptedChanged -> {
                _state.update { it.copy(
                    isTermsAccepted = event.isAccepted
                ) }
            }
            
            SignUpEvent.SignUpClicked -> {
                validateAndSignUp()
            }
            
            SignUpEvent.SignInClicked -> {
                // Handle sign in navigation
                // This will be handled by the UI layer
            }
        }
    }

    /**
     * Validate signup form and proceed with signup if valid
     */
    private fun validateAndSignUp() {
        val currentState = _state.value
        
        // Validate all fields
        val (isValid, errors) = ValidationUtils.validateSignUpForm(
            name = currentState.fullName,
            email = currentState.email,
            password = currentState.password,
            confirmPassword = currentState.confirmPassword
        )

        // Check terms acceptance
        if (!currentState.isTermsAccepted) {
            _state.update { it.copy(
                errorMessage = "Please accept the Terms and Conditions"
            ) }
            return
        }

        if (isValid) {
            // All validations passed, proceed with signup
            performSignUp()
        } else {
            // Update state with validation errors
            _state.update { it.copy(
                nameError = errors["name"],
                emailError = errors["email"],
                passwordError = errors["password"],
                confirmPasswordError = errors["confirmPassword"]
            ) }
        }
    }

    /**
     * Perform the actual signup operation
     * In a real app, this would call a repository/use case
     */
    private fun performSignUp() {
        viewModelScope.launch {
            try {
                // Set loading state
                _state.update { it.copy(isLoading = true, errorMessage = null) }

                // TODO: Call authentication repository/use case here
                // Example: authRepository.signUp(name, email, password)
                
                // Simulate network delay
                kotlinx.coroutines.delay(1000)

                // For now, just mark as successful
                _state.update { it.copy(
                    isLoading = false,
                    isSignUpSuccessful = true
                ) }

            } catch (e: Exception) {
                // Handle signup error
                _state.update { it.copy(
                    isLoading = false,
                    errorMessage = e.message ?: "Sign up failed. Please try again."
                ) }
            }
        }
    }

    /**
     * Reset signup success state
     * Call this after navigation is complete
     */
    fun resetSignUpSuccess() {
        _state.update { it.copy(isSignUpSuccessful = false) }
    }

    /**
     * Clear error message
     */
    fun clearError() {
        _state.update { it.copy(errorMessage = null) }
    }
}
