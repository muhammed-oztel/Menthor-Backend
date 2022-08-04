package com.example.ratingsystem.demo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepo extends CrudRepository<RatingModel, Integer>
{
    List<RatingModel> findById(int userId);
}
