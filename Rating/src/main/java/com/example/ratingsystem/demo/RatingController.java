package com.example.ratingsystem.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class RatingController
{
    @Autowired
    UserRepo userRepo;

    @Autowired
    DriverRepo driverRepo;

    @GetMapping(path="/getUserJsonById/{userId}", produces={"application/json"})
    public List<UserModel> getUserJsonById(@PathVariable("userId") int userId)
    {
        /*
            Getting data of user for selected userId
         */

        //returning data of selected user
        return(userRepo.findById(userId));

    }

    @GetMapping(path="/getDriverJsonById/{driverId}", produces={"application/json"})
    public List<DriverModel> getDriverJsonById(@PathVariable("driverId") int driverId)
    {
        /*
            Getting data of driver for selected driverId
         */

        //returning data of selected driver
        return(driverRepo.findById(driverId));

    }


    @PostMapping("/setDriverRatingJsonById")
    public String setDriverRatingJsonById(@RequestBody Map<String, Integer> dm)
    {
        /*
            Rating given by User to the driver
         */

        try
        {
            //data of post request
            int dId = dm.get("driverId");
            int dRating = dm.get("rating");

            //getting driver data from db
            List<DriverModel> driverDb = driverRepo.findById(dId);
            System.out.println("driverDb " + driverDb);

            //getting countDriverRating and countDriverRides
            Double dbCountRating = driverDb.get(0).getcountDriverRating();
            int dbCountRides = driverDb.get(0).getcountDriverRides();


            //calculating the rating based on total ratings/total rides
            Double dbRating = (dbCountRating + dRating) / (dbCountRides + 1);


            //setting new CountRating, CountRides, Rating
            driverDb.get(0).setcountDriverRating(dbCountRating + dRating);
            driverDb.get(0).setcountDriverRides(dbCountRides+1);
            driverDb.get(0).setdriverRating(dbRating);

            driverRepo.save(driverDb.get(0));
            System.out.println("Rating is inserted");
            return "Your response is recorded";
        }

        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Error in insertion");
            return "Error in insertion";
        }

    }




    @PostMapping("/setUserRatingJsonById")
    public String setUserRatingJsonById(@RequestBody Map<String, Integer> um)
    {
        /*
            Rating given by Driver to the user
         */

        try
        {
            //data of post request
            int uId = um.get("userId");
            int uRating = um.get("rating");

            //getting driver data from db
            List<UserModel> userDb = userRepo.findById(uId);


            //getting countDriverRating and countDriverRides
            Double dbCountRating = userDb.get(0).getCountUserRating();
            int dbCountRides = userDb.get(0).getCountUserRides();


            //calculating the rating based on total ratings/total rides
            Double dbRating = (dbCountRating + uRating) / (dbCountRides + 1);


            //setting new CountRating, CountRides, Rating
            userDb.get(0).setCountUserRating(dbCountRating + uRating);
            userDb.get(0).setCountUserRides(dbCountRides+1);
            userDb.get(0).setUserRating(dbRating);

            userRepo.save(userDb.get(0));
            System.out.println("Rating is inserted");
            return "Your response is recorded";
        }

        catch (Exception e)
        {
            e.printStackTrace();

            System.out.println("Error in insertion");
            return "Error in insertion";

        }

    }



}
