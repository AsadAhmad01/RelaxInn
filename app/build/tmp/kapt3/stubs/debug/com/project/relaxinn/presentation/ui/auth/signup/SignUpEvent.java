package com.project.relaxinn.presentation.ui.auth.signup;

/**
 * Represents all possible user events/actions on the SignUp Screen
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\t\u0003\u0004\u0005\u0006\u0007\b\t\n\u000bB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\t\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/project/relaxinn/presentation/ui/auth/signup/SignUpEvent;", "", "()V", "ConfirmPasswordChanged", "EmailChanged", "FullNameChanged", "PasswordChanged", "SignInClicked", "SignUpClicked", "TermsAcceptedChanged", "ToggleConfirmPasswordVisibility", "TogglePasswordVisibility", "Lcom/project/relaxinn/presentation/ui/auth/signup/SignUpEvent$ConfirmPasswordChanged;", "Lcom/project/relaxinn/presentation/ui/auth/signup/SignUpEvent$EmailChanged;", "Lcom/project/relaxinn/presentation/ui/auth/signup/SignUpEvent$FullNameChanged;", "Lcom/project/relaxinn/presentation/ui/auth/signup/SignUpEvent$PasswordChanged;", "Lcom/project/relaxinn/presentation/ui/auth/signup/SignUpEvent$SignInClicked;", "Lcom/project/relaxinn/presentation/ui/auth/signup/SignUpEvent$SignUpClicked;", "Lcom/project/relaxinn/presentation/ui/auth/signup/SignUpEvent$TermsAcceptedChanged;", "Lcom/project/relaxinn/presentation/ui/auth/signup/SignUpEvent$ToggleConfirmPasswordVisibility;", "Lcom/project/relaxinn/presentation/ui/auth/signup/SignUpEvent$TogglePasswordVisibility;", "app_debug"})
public abstract class SignUpEvent {
    
    private SignUpEvent() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/project/relaxinn/presentation/ui/auth/signup/SignUpEvent$ConfirmPasswordChanged;", "Lcom/project/relaxinn/presentation/ui/auth/signup/SignUpEvent;", "confirmPassword", "", "(Ljava/lang/String;)V", "getConfirmPassword", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
    public static final class ConfirmPasswordChanged extends com.project.relaxinn.presentation.ui.auth.signup.SignUpEvent {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String confirmPassword = null;
        
        public ConfirmPasswordChanged(@org.jetbrains.annotations.NotNull()
        java.lang.String confirmPassword) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getConfirmPassword() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.project.relaxinn.presentation.ui.auth.signup.SignUpEvent.ConfirmPasswordChanged copy(@org.jetbrains.annotations.NotNull()
        java.lang.String confirmPassword) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/project/relaxinn/presentation/ui/auth/signup/SignUpEvent$EmailChanged;", "Lcom/project/relaxinn/presentation/ui/auth/signup/SignUpEvent;", "email", "", "(Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
    public static final class EmailChanged extends com.project.relaxinn.presentation.ui.auth.signup.SignUpEvent {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String email = null;
        
        public EmailChanged(@org.jetbrains.annotations.NotNull()
        java.lang.String email) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getEmail() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.project.relaxinn.presentation.ui.auth.signup.SignUpEvent.EmailChanged copy(@org.jetbrains.annotations.NotNull()
        java.lang.String email) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/project/relaxinn/presentation/ui/auth/signup/SignUpEvent$FullNameChanged;", "Lcom/project/relaxinn/presentation/ui/auth/signup/SignUpEvent;", "fullName", "", "(Ljava/lang/String;)V", "getFullName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
    public static final class FullNameChanged extends com.project.relaxinn.presentation.ui.auth.signup.SignUpEvent {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String fullName = null;
        
        public FullNameChanged(@org.jetbrains.annotations.NotNull()
        java.lang.String fullName) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getFullName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.project.relaxinn.presentation.ui.auth.signup.SignUpEvent.FullNameChanged copy(@org.jetbrains.annotations.NotNull()
        java.lang.String fullName) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/project/relaxinn/presentation/ui/auth/signup/SignUpEvent$PasswordChanged;", "Lcom/project/relaxinn/presentation/ui/auth/signup/SignUpEvent;", "password", "", "(Ljava/lang/String;)V", "getPassword", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
    public static final class PasswordChanged extends com.project.relaxinn.presentation.ui.auth.signup.SignUpEvent {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String password = null;
        
        public PasswordChanged(@org.jetbrains.annotations.NotNull()
        java.lang.String password) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPassword() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.project.relaxinn.presentation.ui.auth.signup.SignUpEvent.PasswordChanged copy(@org.jetbrains.annotations.NotNull()
        java.lang.String password) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/project/relaxinn/presentation/ui/auth/signup/SignUpEvent$SignInClicked;", "Lcom/project/relaxinn/presentation/ui/auth/signup/SignUpEvent;", "()V", "app_debug"})
    public static final class SignInClicked extends com.project.relaxinn.presentation.ui.auth.signup.SignUpEvent {
        @org.jetbrains.annotations.NotNull()
        public static final com.project.relaxinn.presentation.ui.auth.signup.SignUpEvent.SignInClicked INSTANCE = null;
        
        private SignInClicked() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/project/relaxinn/presentation/ui/auth/signup/SignUpEvent$SignUpClicked;", "Lcom/project/relaxinn/presentation/ui/auth/signup/SignUpEvent;", "()V", "app_debug"})
    public static final class SignUpClicked extends com.project.relaxinn.presentation.ui.auth.signup.SignUpEvent {
        @org.jetbrains.annotations.NotNull()
        public static final com.project.relaxinn.presentation.ui.auth.signup.SignUpEvent.SignUpClicked INSTANCE = null;
        
        private SignUpClicked() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u00d6\u0003J\t\u0010\u000b\u001a\u00020\fH\u00d6\u0001J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005\u00a8\u0006\u000f"}, d2 = {"Lcom/project/relaxinn/presentation/ui/auth/signup/SignUpEvent$TermsAcceptedChanged;", "Lcom/project/relaxinn/presentation/ui/auth/signup/SignUpEvent;", "isAccepted", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class TermsAcceptedChanged extends com.project.relaxinn.presentation.ui.auth.signup.SignUpEvent {
        private final boolean isAccepted = false;
        
        public TermsAcceptedChanged(boolean isAccepted) {
        }
        
        public final boolean isAccepted() {
            return false;
        }
        
        public final boolean component1() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.project.relaxinn.presentation.ui.auth.signup.SignUpEvent.TermsAcceptedChanged copy(boolean isAccepted) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/project/relaxinn/presentation/ui/auth/signup/SignUpEvent$ToggleConfirmPasswordVisibility;", "Lcom/project/relaxinn/presentation/ui/auth/signup/SignUpEvent;", "()V", "app_debug"})
    public static final class ToggleConfirmPasswordVisibility extends com.project.relaxinn.presentation.ui.auth.signup.SignUpEvent {
        @org.jetbrains.annotations.NotNull()
        public static final com.project.relaxinn.presentation.ui.auth.signup.SignUpEvent.ToggleConfirmPasswordVisibility INSTANCE = null;
        
        private ToggleConfirmPasswordVisibility() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/project/relaxinn/presentation/ui/auth/signup/SignUpEvent$TogglePasswordVisibility;", "Lcom/project/relaxinn/presentation/ui/auth/signup/SignUpEvent;", "()V", "app_debug"})
    public static final class TogglePasswordVisibility extends com.project.relaxinn.presentation.ui.auth.signup.SignUpEvent {
        @org.jetbrains.annotations.NotNull()
        public static final com.project.relaxinn.presentation.ui.auth.signup.SignUpEvent.TogglePasswordVisibility INSTANCE = null;
        
        private TogglePasswordVisibility() {
        }
    }
}