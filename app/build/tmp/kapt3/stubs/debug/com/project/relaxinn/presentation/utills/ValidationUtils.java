package com.project.relaxinn.presentation.utills;

import android.util.Patterns;

/**
 * Validation utilities for form inputs
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\n\u001a\u00020\u0006J.\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\f0\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u000e\u001a\u00020\u0006J\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\u0006J>\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\f0\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/project/relaxinn/presentation/utills/ValidationUtils;", "", "()V", "validateConfirmPassword", "Lkotlin/Pair;", "", "", "password", "confirmPassword", "validateEmail", "email", "validateLoginForm", "", "validateName", "name", "validatePassword", "validateSignUpForm", "app_debug"})
public final class ValidationUtils {
    @org.jetbrains.annotations.NotNull()
    public static final com.project.relaxinn.presentation.utills.ValidationUtils INSTANCE = null;
    
    private ValidationUtils() {
        super();
    }
    
    /**
     * Validates email format
     * @return Pair<Boolean, String> - (isValid, errorMessage)
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlin.Pair<java.lang.Boolean, java.lang.String> validateEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String email) {
        return null;
    }
    
    /**
     * Validates password strength
     * @return Pair<Boolean, String> - (isValid, errorMessage)
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlin.Pair<java.lang.Boolean, java.lang.String> validatePassword(@org.jetbrains.annotations.NotNull()
    java.lang.String password) {
        return null;
    }
    
    /**
     * Validates name field
     * @return Pair<Boolean, String> - (isValid, errorMessage)
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlin.Pair<java.lang.Boolean, java.lang.String> validateName(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    /**
     * Validates confirm password matches password
     * @return Pair<Boolean, String> - (isValid, errorMessage)
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlin.Pair<java.lang.Boolean, java.lang.String> validateConfirmPassword(@org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    java.lang.String confirmPassword) {
        return null;
    }
    
    /**
     * Validates all login fields
     * @return Pair<Boolean, Map<String, String>> - (isValid, fieldErrors)
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlin.Pair<java.lang.Boolean, java.util.Map<java.lang.String, java.lang.String>> validateLoginForm(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
        return null;
    }
    
    /**
     * Validates all signup fields
     * @return Pair<Boolean, Map<String, String>> - (isValid, fieldErrors)
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlin.Pair<java.lang.Boolean, java.util.Map<java.lang.String, java.lang.String>> validateSignUpForm(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    java.lang.String confirmPassword) {
        return null;
    }
}