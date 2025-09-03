package com.tanguydev.ismb.Infrastructure.Security;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class SecurityConfigTest {

    @Mock
    private JwtAuthenticationFilter jwtFilter;

    @Mock
    private CustomUserDetailsService uds;

    @InjectMocks
    private SecurityConfig securityConfig;

    public SecurityConfigTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void authenticationProvider_ShouldReturnConfiguredDaoAuthenticationProvider() {
        // Arrange

        // Act
        DaoAuthenticationProvider authenticationProvider = securityConfig.authenticationProvider();

        // Assert
        assertThat(authenticationProvider).isNotNull();
    }
}