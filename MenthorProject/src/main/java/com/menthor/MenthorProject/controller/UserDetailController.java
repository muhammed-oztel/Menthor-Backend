package com.menthor.MenthorProject.controller;

import com.menthor.MenthorProject.dto.UserDto;
import com.menthor.MenthorProject.model.UserDetailEntity;
import com.menthor.MenthorProject.service.UserDetailService;
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

    @PutMapping("/update/{id}")
    public UserDto.Response Update(@PathVariable Long id, @RequestBody UserDetailEntity userDetail){
        return userDetailService.Update(id, userDetail);
    }

    @DeleteMapping("/delete/{id}")
    public UserDto.Response Delete(@PathVariable Long id){
        return userDetailService.Delete(id);
    }

    @GetMapping("/listId/{id}")
    public List<UserDetailEntity> ListByUserId(@PathVariable Long id){
        return userDetailService.ListByUserId(id);
    }
}
