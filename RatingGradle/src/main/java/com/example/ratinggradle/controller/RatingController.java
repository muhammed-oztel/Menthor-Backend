package com.example.ratinggradle.controller;

import com.example.ratinggradle.model.Rating;
import com.example.ratinggradle.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping("/setRating")
    public String createOrUpdateRating(@RequestBody Rating rating){
        if(rating.getUserRating() > 10 || rating.getUserRating()<0)
        {
            return "Invalid User Rating! Please give rating between 0-10";
        }
        try{
            ratingService.createUpdate(rating);
        }catch (Exception e){
            e.printStackTrace();
            return "Başarısız";
        }
        return "Kaydedildi";
    }

    @GetMapping ("/getRating/{userId}")
    public List<Rating> getRatings(@PathVariable Long userId){
      return ratingService.getRatingsService(userId);
    }
}
