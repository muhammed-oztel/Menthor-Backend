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

    @PostMapping("/confirm-account")
    public UserDto.Response ConfirmUserAccount(@RequestParam String token){
        return userService.ConfirmAccount(token);
    }

    @PutMapping("/update/{id}")
    public UserDto.Response Update(@PathVariable Long id, @RequestBody UserEntity user){
        return userService.Update(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public UserDto.Response Delete(@PathVariable Long id){
        return userService.Delete(id);
    }

    @GetMapping("/all/{role}/{deleted}")
    public List<UserEntity> ListByRole(@PathVariable String role, @PathVariable Boolean deleted){
        return userService.ListByRole(role, deleted);
    }
}
