package com.example.spring_security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    ;@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         // Call db to check existence of the user and return user
        return new User("root", passwordEncoder.encode("password@123"), AuthorityUtils.createAuthorityList("ROLE_USER"));
    }


}
