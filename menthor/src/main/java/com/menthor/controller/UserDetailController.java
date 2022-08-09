package com.menthor.controller;

import com.menthor.dto.UserDto;
import com.menthor.model.UserDetailEntity;
import com.menthor.service.UserDetailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/userDetail")
public class UserDetailController {
    private final UserDetailService userDetailService;

    public UserDetailController(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @GetMapping("/all")
    public List<UserDetailEntity> FindAll(){
        return userDetailService.FindAll();
    }

    @PostMapping("/create")
    public UserDto.Response Create(@RequestBody List<UserDetailEntity> userDetails){
        return userDetailService.Create(userDetails);
    }

    @GetMapping("/listId/{userId}")
    public List<UserDetailEntity> ListByUserId(@PathVariable Long userId){
        return userDetailService.ListByUserId(userId);
    }
}
