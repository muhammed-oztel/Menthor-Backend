package com.menthor.LoginApi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {
    @GetMapping("/log")
    public ResponseEntity<String> getMessage(){
        return ResponseEntity.ok("Merhaba");
    }
}
