package com.testapp.app1.services;

import com.testapp.app1.domain.User;
import com.testapp.app1.exceptions.EtAuthException;
import com.testapp.app1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Locale;
import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User validateUser(String email, String password) throws EtAuthException {
        if(email != null) email = email.toLowerCase();
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public User registerUser(String email, String password) throws EtAuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if(email != null) email = email.toLowerCase();
        if (!pattern.matcher(email).matches())
            throw new EtAuthException("Gecersiz email.");
        Integer count = userRepository.getCountByEmail(email);
        if (count > 0)
            throw new EtAuthException("Email zaten kullanilmis.");
        System.out.println(email + " " + password);
        Integer userId = userRepository.create(email, password);

        return userRepository.findById(userId);
    }
}
