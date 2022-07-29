package com.menthor.MenthorProject.service;

import com.menthor.MenthorProject.dto.UserDto;
import com.menthor.MenthorProject.model.ConfirmationTokenEntity;
import com.menthor.MenthorProject.model.UserEntity;
import com.menthor.MenthorProject.repository.ConfirmationTokenRepository;
import com.menthor.MenthorProject.repository.UserRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final EmailSenderService emailSenderService;

    public UserService(UserRepository userRepository, ConfirmationTokenRepository confirmationTokenRepository, EmailSenderService emailSenderService) {
        this.userRepository = userRepository;
        this.confirmationTokenRepository = confirmationTokenRepository;
        this.emailSenderService = emailSenderService;
    }

    public UserDto.Response Register(UserEntity user){
        UserDto.Response response = new UserDto.Response();
        if (UserValidation(user.getEmail(), user.getPass(), user.getPhone())){
            response.setMessage("Hesap zaten mevcut. Lütfen bilgilerinizi kontrol ediniz.");
            return response;
        }else {
            user.setEnabled(false);
            userRepository.save(user);
            ConfirmationTokenEntity confirmationToken = new ConfirmationTokenEntity(user);
            confirmationTokenRepository.save(confirmationToken);
            SendEmailOption(user, confirmationToken);
            response.setMessage("Hesap Oluşturuldu.");
            return response;
        }
    }

    public UserDto.Response ConfirmAccount(String token){
        UserDto.Response response = new UserDto.Response();
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

    //validations..
    private Boolean UserValidation(String email, String pass, String phone){
        List<UserEntity> mail = userRepository.findByEmail(email);
        List<UserEntity> password = userRepository.findByPass(pass);
        List<UserEntity> t_phone = userRepository.findByPhone(phone);
        Boolean result = (mail.isEmpty() && password.isEmpty() && t_phone.isEmpty()) ? false:true;
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
}
