package com.example.todo.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {



    @GetMapping
    public ResponseEntity<?> findApi() {
        return ResponseEntity.ok("hello");
    }

    @GetMapping("/keyword")
    public ResponseEntity<?> findHomeApi(@RequestParam String str) {
       
        return ResponseEntity.ok(str);
    }
}
