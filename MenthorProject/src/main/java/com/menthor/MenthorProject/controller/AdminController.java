package com.menthor.MenthorProject.controller;

import com.menthor.MenthorProject.model.FileEntity;
import com.menthor.MenthorProject.model.MeetEntity;
import com.menthor.MenthorProject.model.UserDetailEntity;
import com.menthor.MenthorProject.model.UserEntity;
import com.menthor.MenthorProject.service.AdminService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/allMeet")
    public List<MeetEntity> AllMeet(){
        return adminService.AllMeet();
    }

    @GetMapping("/allFile")
    public List<FileEntity> AllFile(){
        return adminService.AllFile();
    }
}
