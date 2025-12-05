package com.project.relaxinn.presentation.ui.auth.signup

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.project.relaxinn.presentation.theme.AppTheme
import com.project.relaxinn.presentation.utills.CustomButton
import com.project.relaxinn.presentation.utills.CustomTextField
import com.project.relaxinn.presentation.utills.ValidationUtils

@Composable
fun SignUpScreen(
    onSignUpClick: () -> Unit,
    onSignInClick: () -> Unit
) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    var isConfirmPasswordVisible by remember { mutableStateOf(false) }
    var isTermsAccepted by remember { mutableStateOf(false) }
    
    // Error states
    var nameError by remember { mutableStateOf<String?>(null) }
    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }
    var confirmPasswordError by remember { mutableStateOf<String?>(null) }

    val scrollState = rememberScrollState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = AppTheme.colors.background
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(vertical = 24.dp, horizontal = 30.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(60.dp))

            // Header
            Text(
                text = "Join the",
                style = AppTheme.typography.headline.copy(
                    fontWeight = FontWeight.Normal,
                    color = AppTheme.colors.onBackground
                ),
            )

            Text(
                text = "Experience",
                style = AppTheme.typography.headline.copy(
                    fontWeight = FontWeight.Bold,
                    color = AppTheme.colors.onBackground
                ),
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Unlock exclusive rates and premium residencies.",
                style = AppTheme.typography.body.copy(
                    color = AppTheme.colors.onSecondarySurface
                ),
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Full Name Field
            CustomTextField(
                label = "Full name",
                value = fullName,
                onValueChange = {
                    fullName = it
                    nameError = null // Clear error on input
                },
                placeholder = "John Doe",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                errorMessage = nameError,
                isError = nameError != null
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Email Field
            CustomTextField(
                label = "Email",
                value = email,
                onValueChange = {
                    email = it
                    emailError = null // Clear error on input
                },
                placeholder = "Enter email",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                errorMessage = emailError,
                isError = emailError != null
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Password Field
            CustomTextField(
                label = "Password",
                value = password,
                onValueChange = {
                    password = it
                    passwordError = null // Clear error on input
                },
                placeholder = "************",
                isPassword = true,
                isPasswordVisible = isPasswordVisible,
                onVisibilityChange = { isPasswordVisible = !isPasswordVisible },
                errorMessage = passwordError,
                isError = passwordError != null
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Confirm Password Field
            CustomTextField(
                label = "Verify password",
                value = confirmPassword,
                onValueChange = {
                    confirmPassword = it
                    confirmPasswordError = null // Clear error on input
                },
                placeholder = "************",
                isPassword = true,
                isPasswordVisible = isConfirmPasswordVisible,
                onVisibilityChange = { isConfirmPasswordVisible = !isConfirmPasswordVisible },
                errorMessage = confirmPasswordError,
                isError = confirmPasswordError != null
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Terms and Conditions
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { isTermsAccepted = !isTermsAccepted }
            ) {
                Checkbox(
                    checked = isTermsAccepted,
                    onCheckedChange = { isTermsAccepted = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = AppTheme.colors.actionSurface,
                        uncheckedColor = AppTheme.colors.onSecondarySurface,
                        checkmarkColor = AppTheme.colors.onActioSurface
                    )
                )
                Text(
                    text = buildAnnotatedString {
                        append("I agreed to the ")
                        withStyle(
                            style = SpanStyle(
                                color = AppTheme.colors.onSecondarySurface,
                                textDecoration = TextDecoration.Underline
                            )
                        ) {
                            append("Terms and Conditions")
                        }
                    },
                    style = MaterialTheme.typography.bodyMedium,
                    color = AppTheme.colors.onSecondarySurface
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Sign Up Button
            CustomButton(
                title = "Signup",
                onclick = {
                    // Validate all fields
                    val (isValid, errors) = ValidationUtils.validateSignUpForm(
                        name = fullName,
                        email = email,
                        password = password,
                        confirmPassword = confirmPassword
                    )

                    if (isValid && isTermsAccepted) {
                        // All validations passed
                        onSignUpClick()
                    } else {
                        // Set error messages
                        nameError = errors["name"]
                        emailError = errors["email"]
                        passwordError = errors["password"]
                        confirmPasswordError = errors["confirmPassword"]
                        
                        // Show terms error if not accepted
                        if (!isTermsAccepted && isValid) {
                            // You could show a toast or snackbar here
                        }
                    }
                },
                modifier = Modifier
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Sign In Link
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = buildAnnotatedString {
                        append("Already have an account? ")
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                color = AppTheme.colors.highlightSurface
                            )
                        ) {
                            append("Sign in")
                        }
                    },
                    style = MaterialTheme.typography.bodyMedium,
                    color = AppTheme.colors.onSecondarySurface,
                    modifier = Modifier.clickable { onSignInClick() }
                )
            }
        }
    }
}
