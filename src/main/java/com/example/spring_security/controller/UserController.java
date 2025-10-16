package com.example.spring_security.controller;

import com.example.spring_security.utils.JwtUtils;
import com.nimbusds.jose.proc.SecurityContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    JwtUtils jwtUtils;

    @GetMapping("/{username}")
    @PreAuthorize("#username == authentication.principal.username or hasRole('ADMIN')")
    public ResponseEntity<Map<String, String>> getUserInfo(@PathVariable String username) {
        // Call Service method to get user info from DB by username
        return ResponseEntity.ok(Map.of("username", username));
    }

    @PostMapping("/signup")
    public String userSignUp(@RequestBody Map<String, String> user) {
        return jwtUtils.generateJwtToken(user.get("username"), new HashMap<>());
    }

    @PostMapping("/login")
    public String userLogin(@RequestHeader("Authorization") String authHeader) {
        log.info("Authorization Header: {}", authHeader);
        // TODO: Extract username and form Jwt and return JWT token
        return jwtUtils.generateJwtToken(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername(), new HashMap<>());
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')") // Only users with ADMIN role can access this endpoint
    public String getAllUser() {
        return "All users data";
    }

    @DeleteMapping("/{username}")
    @PreAuthorize("hasRole('ADMIN')") // Only users with ADMIN role can delete users
    public String deleteUser(@PathVariable String username) {
        return "User " + username + " deleted";
    }

    @GetMapping("/welcome")
    public String welcomeUser() {
        return "Welcome, authenticated user!";
    }

}
