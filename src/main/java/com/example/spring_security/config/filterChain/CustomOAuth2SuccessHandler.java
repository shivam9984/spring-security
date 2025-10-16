package com.example.spring_security.config.filterChain;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class CustomOAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // Implement custom logic upon successful OAuth2 authentication
        // For example, you can log user details or redirect to a specific page
        System.out.println("OAuth2 Authentication Successful for user: " + authentication.getName());
        // Redirect to a specific URL after successful authentication
        getRedirectStrategy().sendRedirect(request, response, "/api/home/welcome");
    }
}
