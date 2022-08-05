package com.menthor.service;

import com.menthor.dto.UserDto;
import com.menthor.model.ConfirmationTokenEntity;
import com.menthor.model.UserEntity;
import com.menthor.repository.ConfirmationTokenRepository;
import com.menthor.repository.UserRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final EmailSenderService emailSenderService;
    private final PasswordEncoder passwordEncoder;
    private final UserDto.Response response;

    public UserService(UserRepository userRepository, ConfirmationTokenRepository confirmationTokenRepository, EmailSenderService emailSenderService) {
        this.userRepository = userRepository;
        this.confirmationTokenRepository = confirmationTokenRepository;
        this.emailSenderService = emailSenderService;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.response = new UserDto.Response();
    }

    public UserDto.Response Register(UserEntity user){
        if (UserValidation(user.getEmail(), user.getPhone())){
            response.setMessage("Hesap zaten mevcut. Lütfen bilgilerinizi kontrol ediniz.");
            return response;
        }else {
            user.setEnabled(false);
            String encodedPass = passwordEncoder.encode(user.getPass());
            user.setPass(encodedPass);
            user.setDeleted(false);
            userRepository.save(user);
            ConfirmationTokenEntity confirmationToken = new ConfirmationTokenEntity(user);
            confirmationTokenRepository.save(confirmationToken);
            SendEmailOption(user, confirmationToken);
            response.setMessage("Hesap Oluşturuldu.");
            return response;
        }
    }

    public UserDto.Response ConfirmAccount(String token){
        ConfirmationTokenEntity tokenInfo = confirmationTokenRepository.findByToken(token);
        if (tokenInfo != null){
            UserEntity user = userRepository.findByEmailIgnoreCase(tokenInfo.getUser().getEmail());
            user.setEnabled(true);
            userRepository.save(user);
            response.setMessage("Email Doğrulandı.");
            return response;
        }else {
            response.setMessage("Email Doğrulanamadı !!");
            return response;
        }
    }

    public UserDto.Response Update(Long id, UserEntity user){
        UserEntity userInfo = userRepository.getReferenceById(id);
        userInfo.setName(user.getName());
        userInfo.setSurname(user.getSurname());
        String encodedPass = passwordEncoder.encode(user.getPass());
        userInfo.setPass(encodedPass);
        userInfo.setBirth(user.getBirth());
        userInfo.setPhone(user.getPhone());
        userInfo.setPicture(user.getPicture());
        if (!(user.getEmail().equals(userInfo.getEmail())))
            userInfo.setEmail(user.getEmail());
        changeEmail(userInfo);
        userRepository.save(userInfo);
        response.setMessage("Hesap Bilgileri Güncellendi.");
        return response;
    }

    public UserDto.Response Delete(Long id){
        UserEntity user = userRepository.getReferenceById(id);
        user.setDeleted(true);
        userRepository.save(user);
        response.setMessage("Hesap Silindi.");
        return response;
    }

    public List<UserEntity> ListByRole(String role){
        return userRepository.findByRoleIgnoreCaseAndDeleted(role, false);
    }

    public Optional<UserEntity> GetSingle(Long id){
        return userRepository.findById(id);
    }

    public List<UserEntity> Search(String name){
        List<UserEntity> byName = userRepository.findByNameContainingIgnoreCaseAndRoleIgnoreCase(name, "mentor");
        List<UserEntity> bySurname = userRepository.findBySurnameContainingIgnoreCaseAndRoleIgnoreCase(name, "mentor");
        for (int i = 0; i < byName.size(); ++i){
            for (int j=0; j < bySurname.size(); ++j){
                if (byName.get(i).getId() == bySurname.get(j).getId())
                    bySurname.remove(j);
            }
        }
        byName.addAll(bySurname);
        return byName;
    }

    //validations..
    private Boolean UserValidation(String email, String phone){
        List<UserEntity> mail = userRepository.findByEmail(email);
        List<UserEntity> t_phone = userRepository.findByPhone(phone);
        Boolean result = (mail.isEmpty() && t_phone.isEmpty()) ? false:true;
        return result;
    }

    //mail sending settings function..
    private void SendEmailOption(UserEntity user, ConfirmationTokenEntity confirmationToken){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Hesap Oluşturuldu!!");
        mailMessage.setFrom("ahmetturanmetin18@gmail.com");
        mailMessage.setText("Hesabınızı onaylamak için lütfen buraya tıklayın : "+
                "http://localhost:8080/user/confirm-account?token="+confirmationToken.getToken());
        emailSenderService.sendEmail(mailMessage);
    }

    //change email operations..
    public void changeEmail(UserEntity user){
        ConfirmationTokenEntity tokenInfo = confirmationTokenRepository.findByUserId(user.getId());
        user.setEnabled(false);
        userRepository.save(user);
        SendEmailOption(user, tokenInfo);
    }
}