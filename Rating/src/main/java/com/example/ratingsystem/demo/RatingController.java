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

    @GetMapping(path="getUserJsonById/{userId}", produces={"application/json"})
    public List<RatingModel> getUserJsonById(@PathVariable("userId") int userId)
    {
        return(userRepo.findById(userId));
    }


    @PostMapping("setUserRatingJsonById")
    public String setUserRatingJsonById(@RequestBody Map<String, Integer> um)
    {
        try
        {
            int uId = um.get("userId");
            int uRating = um.get("rating");
            List<RatingModel> userDb = userRepo.findById(uId);
            Double dbCountRating = userDb.get(0).getCountUserRating();
            int dbCountRides = userDb.get(0).getCountUserRides();
            Double dbRating = (dbCountRating + uRating) / (dbCountRides + 1);
            userDb.get(0).setCountUserRating(dbCountRating + uRating);
            userDb.get(0).setCountUserRides(dbCountRides+1);
            userDb.get(0).setUserRating(dbRating);
            userRepo.save(userDb.get(0));
            return "Kaydedildi.";
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "Kaydedilemedi.";
        }
    }
}
