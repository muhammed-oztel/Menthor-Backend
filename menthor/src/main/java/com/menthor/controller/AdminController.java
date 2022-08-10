package com.menthor.controller;

import com.menthor.dto.AdminDto;
import com.menthor.dto.UserDto;
import com.menthor.model.*;
import com.menthor.service.AdminService;
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

    @DeleteMapping("/deleteMatch/{matchId}")
    public UserDto.Response DeleteMatch(@PathVariable Long matchId){
        return adminService.DeleteMatch(matchId);
    }

    @GetMapping("/allMatch")
    public List<AdminDto.MatchResp> AllMatch(){
        return adminService.AllMatch();
    }

//    @GetMapping("/roleList")
//    public List[] UserListByRole(){
//        return adminService.UserListByRole();
//    }
}
