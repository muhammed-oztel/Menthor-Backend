package com.menthor.service;

import com.menthor.dto.UserDto;
import com.menthor.model.UserDetailEntity;
import com.menthor.repository.UserDetailRepository;

import org.apache.catalina.User;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailService {
    private final UserDetailRepository userDetailRepository;
    private final UserDto.Response response;

    public UserDetailService(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
        this.response = new UserDto.Response();
    }

    public List<UserDetailEntity> FindAll(){
        return userDetailRepository.findAll();
    }

    public UserDto.Response Create(List<UserDetailEntity> userDetails){
        UserDto.Response response = new UserDto.Response();

        userDetailRepository.saveAll(userDetails);
        response.setMessage("Alan Eklendi.");
        return response;
    }

    public UserDto.Response Update(Long userId, List<UserDetailEntity> updatedDetail){
        List<UserDetailEntity> deletedList = userDetailRepository.findByUserId(userId);
        if (!deletedList.isEmpty())
            userDetailRepository.deleteAll(deletedList);
        userDetailRepository.saveAll(updatedDetail);
        response.setMessage("Alan Güncellendi");
        return response;
    }

    public List<UserDetailEntity> ListByUserId(Long userId){
        return userDetailRepository.findByUserId(userId);
    }
}
