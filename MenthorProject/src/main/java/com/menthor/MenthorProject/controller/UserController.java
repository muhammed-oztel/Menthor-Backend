package com.menthor.MenthorProject.controller;

import com.menthor.MenthorProject.dto.UserDto;
import com.menthor.MenthorProject.model.UserEntity;
import com.menthor.MenthorProject.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserDto.Response Register(@RequestBody UserEntity user){
        return userService.Register(user);
    }
}
