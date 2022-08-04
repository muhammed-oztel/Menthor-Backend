package com.menthor.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/message")
public class MessageController {
    @GetMapping("/log")
    public ResponseEntity<String> getMessage(){
        return ResponseEntity.ok("Merhaba");
    }
}
