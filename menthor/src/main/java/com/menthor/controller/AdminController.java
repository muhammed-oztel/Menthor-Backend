package com.menthor.controller;

import com.menthor.model.FileEntity;
import com.menthor.model.MeetEntity;
import com.menthor.model.UserDetailEntity;
import com.menthor.model.UserEntity;
import com.menthor.service.AdminService;
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
