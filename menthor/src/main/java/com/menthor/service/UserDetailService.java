package com.menthor.service;

import com.menthor.dto.UserDto;
import com.menthor.model.UserDetailEntity;
import com.menthor.repository.UserDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailService {
    private final UserDetailRepository userDetailRepository;

    public UserDetailService(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
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

    public UserDto.Response Update(Long id, UserDetailEntity userDetail){
        UserDto.Response response = new UserDto.Response();
        UserDetailEntity detailInfo = userDetailRepository.getReferenceById(id);
        detailInfo.setField(userDetail.getField());
        userDetailRepository.save(detailInfo);
        response.setMessage("Alan Güncellendi.");
        return response;
    }

    public UserDto.Response Delete(Long id){
        UserDto.Response response = new UserDto.Response();
        userDetailRepository.deleteById(id);
        response.setMessage("Alan Silindi.");
        return response;
    }

    public List<UserDetailEntity> ListByUserId(Long id){
        return userDetailRepository.findByUserId(id);
    }
}