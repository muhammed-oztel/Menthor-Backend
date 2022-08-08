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

<<<<<<< HEAD
    @PutMapping("/update/{id}")
    public UserDto.Response Update(@PathVariable Long id, @RequestBody UserDetailEntity userDetail){
        return userDetailService.Update(id, userDetail);
    }

=======
    @PutMapping("/update/{userId}")
    public UserDto.Response Update(@PathVariable Long userId, @RequestBody List<UserDetailEntity> updatedDetail){
        return userDetailService.Update(userId, updatedDetail);
    }

    @GetMapping("/listId/{userId}")
    public List<UserDetailEntity> ListByUserId(@PathVariable Long userId){
        return userDetailService.ListByUserId(userId);

>>>>>>> 14e2d095118af5eca14804b4307d16608f6b77fc
    @DeleteMapping("/delete/{id}")
    public UserDto.Response Delete(@PathVariable Long id){
        return userDetailService.Delete(id);
    }
<<<<<<< HEAD

    @GetMapping("/listId/{id}")
    public List<UserDetailEntity> ListByUserId(@PathVariable Long id){
        return userDetailService.ListByUserId(id);
=======
>>>>>>> 14e2d095118af5eca14804b4307d16608f6b77fc
    }
}
