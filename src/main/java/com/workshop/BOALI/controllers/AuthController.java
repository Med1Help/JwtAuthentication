package com.workshop.BOALI.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService service;
    @PostMapping("/register")
    public ResponseEntity<AuthRes> register(@RequestBody RegisterReq req){
        return ResponseEntity.ok(service.register(req));
    }
    @PostMapping("/auth")
    public ResponseEntity<AuthRes> register(@RequestBody authReq req){
        return ResponseEntity.ok(service.auth(req));
    }
}
