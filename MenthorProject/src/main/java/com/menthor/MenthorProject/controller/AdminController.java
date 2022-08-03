package com.menthor.MenthorProject.controller;

import com.menthor.MenthorProject.dto.UserDto;
import com.menthor.MenthorProject.model.FileEntity;
import com.menthor.MenthorProject.model.MatchEntity;
import com.menthor.MenthorProject.model.UserDetailEntity;
import com.menthor.MenthorProject.model.UserEntity;
import com.menthor.MenthorProject.service.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/allUser")
    public List<UserEntity> AllUser(){
        return adminService.AllUser();
    }

    @GetMapping("/allUserDetail")
    public List<UserDetailEntity> AllUserDetail(){
        return adminService.AllUserDetail();
    }

    @GetMapping("/allFile")
    public List<FileEntity> AllFile(){
        return adminService.AllFile();
    }

    @PostMapping("/match")
    public UserDto.Response Match(@RequestBody MatchEntity matchInfo){
        return adminService.SaveMatch(matchInfo);
    }

    @DeleteMapping("/deleteMatch/{id}")
    public UserDto.Response DeleteMatch(@PathVariable Long id){
        return adminService.DeleteMatch(id);
    }
}
