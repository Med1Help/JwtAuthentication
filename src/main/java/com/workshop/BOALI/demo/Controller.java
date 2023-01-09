package com.workshop.BOALI.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo-controller")
public class Controller {
    @PostMapping
    public ResponseEntity<String> say(){
        return ResponseEntity.ok("hello from secured endpoint");
    }
    @GetMapping("/v2")
    public ResponseEntity<String> hi(){
        return ResponseEntity.ok("hello from secured endpoint hi");
    }
}
