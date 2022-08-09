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
        List<UserDetailEntity> deletedList = userDetailRepository.findByUserId(userDetails.get(0).getUserId());
        if (!deletedList.isEmpty())
            userDetailRepository.deleteAll(deletedList);
        userDetailRepository.saveAll(userDetails);
        response.setMessage("Alan Eklendi.");
        return response;
    }

    public List<UserDetailEntity> ListByUserId(Long userId){
        return userDetailRepository.findByUserId(userId);
    }
}
