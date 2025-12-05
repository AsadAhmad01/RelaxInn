package com.project.relaxinn.presentation.ui.auth.signup

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.project.relaxinn.presentation.theme.AppTheme
import com.project.relaxinn.presentation.utills.CustomButton
import com.project.relaxinn.presentation.utills.CustomTextField

@Composable
fun SignUpScreen(
    onSignUpClick: () -> Unit,
    onSignInClick: () -> Unit
) {
    val viewModel: SignUpViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val scrollState = rememberScrollState()

    // Handle signup success
    LaunchedEffect(state.isSignUpSuccessful) {
        if (state.isSignUpSuccessful) {
            onSignUpClick()
            viewModel.resetSignUpSuccess()
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
                    value = state.fullName,
                    onValueChange = { viewModel.onEvent(SignUpEvent.FullNameChanged(it)) },
                    placeholder = "John Doe",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    errorMessage = state.nameError,
                    isError = state.nameError != null
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Email Field
                CustomTextField(
                    label = "Email",
                    value = state.email,
                    onValueChange = { viewModel.onEvent(SignUpEvent.EmailChanged(it)) },
                    placeholder = "Enter email",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    errorMessage = state.emailError,
                    isError = state.emailError != null
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Password Field
                CustomTextField(
                    label = "Password",
                    value = state.password,
                    onValueChange = { viewModel.onEvent(SignUpEvent.PasswordChanged(it)) },
                    placeholder = "************",
                    isPassword = true,
                    isPasswordVisible = state.isPasswordVisible,
                    onVisibilityChange = { viewModel.onEvent(SignUpEvent.TogglePasswordVisibility) },
                    errorMessage = state.passwordError,
                    isError = state.passwordError != null
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Confirm Password Field
                CustomTextField(
                    label = "Verify password",
                    value = state.confirmPassword,
                    onValueChange = { viewModel.onEvent(SignUpEvent.ConfirmPasswordChanged(it)) },
                    placeholder = "************",
                    isPassword = true,
                    isPasswordVisible = state.isConfirmPasswordVisible,
                    onVisibilityChange = { viewModel.onEvent(SignUpEvent.ToggleConfirmPasswordVisibility) },
                    errorMessage = state.confirmPasswordError,
                    isError = state.confirmPasswordError != null
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Terms and Conditions
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            viewModel.onEvent(SignUpEvent.TermsAcceptedChanged(!state.isTermsAccepted))
                        }
                ) {
                    Checkbox(
                        checked = state.isTermsAccepted,
                        onCheckedChange = { viewModel.onEvent(SignUpEvent.TermsAcceptedChanged(it)) },
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
                    onclick = { viewModel.onEvent(SignUpEvent.SignUpClicked) },
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
                        modifier = Modifier.clickable {
                            viewModel.onEvent(SignUpEvent.SignInClicked)
                            onSignInClick()
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
