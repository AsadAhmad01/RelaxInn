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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.project.relaxinn.presentation.theme.AppTheme
import com.project.relaxinn.presentation.utills.CustomButton
import com.project.relaxinn.presentation.utills.CustomTextField

@Composable
fun ForgotPasswordScreen(
    onSubmitClick: () -> Unit,
    onBackToLoginClick: () -> Unit
) {
    val viewModel: ForgotPasswordViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    // Handle submit success
    LaunchedEffect(state.isSubmitSuccessful) {
        if (state.isSubmitSuccessful) {
            snackbarHostState.showSnackbar("Password reset email sent successfully!")
            onSubmitClick()
            viewModel.resetSubmitSuccess()
        }
    }

    // Handle error messages
    LaunchedEffect(state.errorMessage) {
        state.errorMessage?.let { message ->
            snackbarHostState.showSnackbar(message)
            viewModel.clearError()
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = AppTheme.colors.background,
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize()) {
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
                    value = state.email,
                    onValueChange = { viewModel.onEvent(ForgotPasswordEvent.EmailChanged(it)) },
                    placeholder = "Enter email",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    errorMessage = state.emailError,
                    isError = state.emailError != null
                )

                Spacer(modifier = Modifier.height(40.dp))

                // Submit Button
                CustomButton(
                    title = "Submit",
                    onclick = { viewModel.onEvent(ForgotPasswordEvent.SubmitClicked) },
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
                        modifier = Modifier.clickable {
                            viewModel.onEvent(ForgotPasswordEvent.BackToLoginClicked)
                            onBackToLoginClick()
                        }
                    )
                }
            }

            // Loading Indicator
            if (state.isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        color = AppTheme.colors.actionSurface
                    )
                }
            }
        }
    }
}
