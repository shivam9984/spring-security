package com.example.spring_security.config.authProvider;

import org.hibernate.annotations.Collate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // Implement JWT authentication logic here
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }

}
