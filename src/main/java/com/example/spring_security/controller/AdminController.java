package com.example.spring_security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @GetMapping("/dashboard")
    public ResponseEntity<String> registerAdmin(){
        return ResponseEntity.ok("admin dashboard");
    }


}
