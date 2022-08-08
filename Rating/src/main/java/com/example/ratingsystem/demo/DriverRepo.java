package com.example.ratingsystem.demo;
import com.example.ratingsystem.demo.DriverModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface DriverRepo extends CrudRepository<DriverModel, Integer>
{

    List<DriverModel> findById(int driverId);

}
