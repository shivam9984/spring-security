package com.example.spring_security.controller;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/mentor")
public class MentorController {

    @GetMapping("/info")
    public ResponseEntity<String> registerMentor(Map<String,String>mentorDetails){
        return ResponseEntity.ok("Mentor registered successfully");
    }

    public ResponseEntity<Map<String,String>> getMentorDetails(){
        return ResponseEntity.ok(Map.of("name","John Doe","subject","Mathematics"));
    }



}
