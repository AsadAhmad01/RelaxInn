package com.project.relaxinn.presentation.utills

import android.util.Patterns

/**
 * Validation utilities for form inputs
 */
object ValidationUtils {

    /**
     * Validates email format
     * @return Pair<Boolean, String> - (isValid, errorMessage)
     */
    fun validateEmail(email: String): Pair<Boolean, String> {
        return when {
            email.isBlank() -> Pair(false, "Email is required")
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> Pair(false, "Invalid email format")
            else -> Pair(true, "")
        }
    }

    /**
     * Validates password strength
     * @return Pair<Boolean, String> - (isValid, errorMessage)
     */
    fun validatePassword(password: String): Pair<Boolean, String> {
        return when {
            password.isBlank() -> Pair(false, "Password is required")
            password.length < 8 -> Pair(false, "Password must be at least 8 characters")
            !password.any { it.isUpperCase() } -> Pair(false, "Password must contain at least one uppercase letter")
            !password.any { it.isLowerCase() } -> Pair(false, "Password must contain at least one lowercase letter")
            !password.any { it.isDigit() } -> Pair(false, "Password must contain at least one number")
            else -> Pair(true, "")
        }
    }

    /**
     * Validates name field
     * @return Pair<Boolean, String> - (isValid, errorMessage)
     */
    fun validateName(name: String): Pair<Boolean, String> {
        return when {
            name.isBlank() -> Pair(false, "Name is required")
            name.length < 2 -> Pair(false, "Name must be at least 2 characters")
            !name.matches(Regex("^[a-zA-Z\\s]+$")) -> Pair(false, "Name can only contain letters and spaces")
            else -> Pair(true, "")
        }
    }

    /**
     * Validates confirm password matches password
     * @return Pair<Boolean, String> - (isValid, errorMessage)
     */
    fun validateConfirmPassword(password: String, confirmPassword: String): Pair<Boolean, String> {
        return when {
            confirmPassword.isBlank() -> Pair(false, "Please confirm your password")
            password != confirmPassword -> Pair(false, "Passwords do not match")
            else -> Pair(true, "")
        }
    }

    /**
     * Validates all login fields
     * @return Pair<Boolean, Map<String, String>> - (isValid, fieldErrors)
     */
    fun validateLoginForm(email: String, password: String): Pair<Boolean, Map<String, String>> {
        val errors = mutableMapOf<String, String>()
        
        val emailValidation = validateEmail(email)
        if (!emailValidation.first) {
            errors["email"] = emailValidation.second
        }
        
        val passwordValidation = validatePassword(password)
        if (!passwordValidation.first) {
            errors["password"] = passwordValidation.second
        }
        
        return Pair(errors.isEmpty(), errors)
    }

    /**
     * Validates all signup fields
     * @return Pair<Boolean, Map<String, String>> - (isValid, fieldErrors)
     */
    fun validateSignUpForm(
        name: String,
        email: String,
        password: String,
        confirmPassword: String
    ): Pair<Boolean, Map<String, String>> {
        val errors = mutableMapOf<String, String>()
        
        val nameValidation = validateName(name)
        if (!nameValidation.first) {
            errors["name"] = nameValidation.second
        }
        
        val emailValidation = validateEmail(email)
        if (!emailValidation.first) {
            errors["email"] = emailValidation.second
        }
        
        val passwordValidation = validatePassword(password)
        if (!passwordValidation.first) {
            errors["password"] = passwordValidation.second
        }
        
        val confirmPasswordValidation = validateConfirmPassword(password, confirmPassword)
        if (!confirmPasswordValidation.first) {
            errors["confirmPassword"] = confirmPasswordValidation.second
        }
        
        return Pair(errors.isEmpty(), errors)
    }
}
