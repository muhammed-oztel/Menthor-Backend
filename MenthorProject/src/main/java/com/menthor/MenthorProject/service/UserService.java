package com.menthor.MenthorProject.service;

import com.menthor.MenthorProject.dto.UserDto;
import com.menthor.MenthorProject.model.UserEntity;
import com.menthor.MenthorProject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto.Response Register(UserEntity user){
        UserDto.Response response = new UserDto.Response();
        if (UserValidation(user.getEmail(), user.getPass(), user.getPhone())){
            response.setMessage("Hesap zaten mevcut. Lütfen bilgilerinizi kontrol ediniz.");
            return response;
        }else {
            userRepository.save(user);
            response.setMessage("Hesap Oluşturuldu.");
            return response;
        }
    }

    //validations..
    private Boolean UserValidation(String email, String pass, String phone){
        List<UserEntity> mail = userRepository.findByEmail(email);
        List<UserEntity> password = userRepository.findByPass(pass);
        List<UserEntity> t_phone = userRepository.findByPhone(phone);
        Boolean result = (mail.isEmpty() && password.isEmpty() && t_phone.isEmpty()) ? false:true;
        return result;
    }
}
