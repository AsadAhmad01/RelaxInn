package com.project.relaxinn.presentation.ui.auth.login

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
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.relaxinn.presentation.theme.AppTheme
import com.project.relaxinn.presentation.utills.CustomButton
import com.project.relaxinn.presentation.utills.CustomTextField
import com.project.relaxinn.presentation.utills.ValidationUtils

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit, onSignUpClick: () -> Unit, onForgotPasswordClick: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    var isRememberMeChecked by remember { mutableStateOf(false) }

    // Error states
    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }

    Scaffold(
        modifier = Modifier.fillMaxSize(), containerColor = AppTheme.colors.background
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(vertical = 24.dp, horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(100.dp))

            // Header
            Text(
                text = "Welcome back",
                style = AppTheme.typography.headline.copy(
                    fontWeight = FontWeight.Bold, color = AppTheme.colors.onBackground
                ),
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Sign in to manage your stays.",
                style = AppTheme.typography.body.copy(
                    color = AppTheme.colors.onSecondarySurface
                ),
            )

            Spacer(modifier = Modifier.height(48.dp))

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

            Spacer(modifier = Modifier.height(16.dp))

            // Remember Me & Forgot Password
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable { isRememberMeChecked = !isRememberMeChecked }) {
                    Checkbox(
                        checked = isRememberMeChecked,
                        onCheckedChange = { isRememberMeChecked = it },
                        colors = CheckboxDefaults.colors(
                            checkedColor = AppTheme.colors.actionSurface,
                            uncheckedColor = AppTheme.colors.onSecondarySurface,
                            checkmarkColor = AppTheme.colors.onActioSurface
                        )
                    )
                    Text(
                        text = "Remember me",
                        style = MaterialTheme.typography.bodyMedium,
                        color = AppTheme.colors.onSecondarySurface
                    )
                }

                Text(
                    text = "Forgot password?", style = MaterialTheme.typography.bodyMedium.copy(
                        color = AppTheme.colors.highlightSurface
                    ), modifier = Modifier.clickable { onForgotPasswordClick() })
            }

            Spacer(modifier = Modifier.height(40.dp))

            // Sign In Button
            CustomButton(
                title = "Sign in", onclick = {
                    // Validate all fields
                    val (isValid, errors) = ValidationUtils.validateLoginForm(
                        email = email, password = password
                    )

                    if (isValid) {
                        // All validations passed
                        onLoginClick()
                    } else {
                        // Set error messages
                        emailError = errors["email"]
                        passwordError = errors["password"]
                    }
                }, modifier = Modifier
            )

            Spacer(modifier = Modifier.weight(1f))

            // Sign Up Link
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = buildAnnotatedString {
                        append("Don't have an Account? ")
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                color = AppTheme.colors.highlightSurface
                            )
                        ) {
                            append("Sign up")
                        }
                    },
                    style = MaterialTheme.typography.bodyMedium,
                    color = AppTheme.colors.onSecondarySurface,
                    modifier = Modifier.clickable { onSignUpClick() })
            }
        }
    }
}