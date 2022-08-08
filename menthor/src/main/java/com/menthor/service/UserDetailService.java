package com.menthor.service;

import com.menthor.dto.UserDto;
import com.menthor.model.UserDetailEntity;
import com.menthor.repository.UserDetailRepository;
<<<<<<< HEAD
=======

import org.apache.catalina.User;

>>>>>>> 14e2d095118af5eca14804b4307d16608f6b77fc
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailService {
    private final UserDetailRepository userDetailRepository;
<<<<<<< HEAD

    public UserDetailService(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
=======
    private final UserDto.Response response;

    public UserDetailService(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
        this.response = new UserDto.Response();
>>>>>>> 14e2d095118af5eca14804b4307d16608f6b77fc
    }

    public List<UserDetailEntity> FindAll(){
        return userDetailRepository.findAll();
    }

    public UserDto.Response Create(List<UserDetailEntity> userDetails){
        UserDto.Response response = new UserDto.Response();
<<<<<<< HEAD
=======

>>>>>>> 14e2d095118af5eca14804b4307d16608f6b77fc
        userDetailRepository.saveAll(userDetails);
        response.setMessage("Alan Eklendi.");
        return response;
    }

<<<<<<< HEAD
    public UserDto.Response Update(Long id, UserDetailEntity userDetail){
        UserDto.Response response = new UserDto.Response();
        UserDetailEntity detailInfo = userDetailRepository.getReferenceById(id);
        detailInfo.setField(userDetail.getField());
        userDetailRepository.save(detailInfo);
        response.setMessage("Alan Güncellendi.");
        return response;
    }

=======
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

>>>>>>> 14e2d095118af5eca14804b4307d16608f6b77fc
    public UserDto.Response Delete(Long id){
        UserDto.Response response = new UserDto.Response();
        userDetailRepository.deleteById(id);
        response.setMessage("Alan Silindi.");
        return response;
    }
<<<<<<< HEAD

    public List<UserDetailEntity> ListByUserId(Long id){
        return userDetailRepository.findByUserId(id);
    }
=======
>>>>>>> 14e2d095118af5eca14804b4307d16608f6b77fc
}
