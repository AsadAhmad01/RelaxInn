package com.project.relaxinn.presentation.ui.auth.forgotpassword

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
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
import com.project.relaxinn.presentation.theme.AppTheme
import com.project.relaxinn.presentation.utills.CustomButton
import com.project.relaxinn.presentation.utills.CustomTextField
import com.project.relaxinn.presentation.utills.ValidationUtils

@Composable
fun ForgotPasswordScreen(
    onSubmitClick: () -> Unit,
    onBackToLoginClick: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    
    // Error state
    var emailError by remember { mutableStateOf<String?>(null) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = AppTheme.colors.background
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
                text = "Forgot Password",
                style = AppTheme.typography.headline.copy(
                    fontWeight = FontWeight.Bold,
                    color = AppTheme.colors.onBackground
                ),
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Tagline
            Text(
                text = "Enter your email to reset your password.",
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

            Spacer(modifier = Modifier.height(40.dp))

            // Submit Button
            CustomButton(
                title = "Submit",
                onclick = {
                    // Validate email
                    val emailValidation = ValidationUtils.validateEmail(email)

                    if (emailValidation.first) {
                        // Email is valid
                        onSubmitClick()
                    } else {
                        // Set error message
                        emailError = emailValidation.second
                    }
                },
                modifier = Modifier
            )

            Spacer(modifier = Modifier.weight(1f))

            // Back to Login Link
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = buildAnnotatedString {
                        append("Remember your password? ")
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
                    modifier = Modifier.clickable { onBackToLoginClick() }
                )
            }
        }
    }
}
