package com.example.ratingsystem.demo;
import com.example.ratingsystem.demo.UserModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepo extends CrudRepository<UserModel, Integer>
{

    List<UserModel> findById(int userId);

}
