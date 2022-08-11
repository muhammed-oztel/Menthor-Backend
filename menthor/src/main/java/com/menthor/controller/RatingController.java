package com.menthor.controller;

import com.menthor.dto.UserDto;
import com.menthor.model.Rating;
import com.menthor.service.RatingService;
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
        if(rating.getUserRating() > 5 || rating.getUserRating()<0)
        {
            return "Invalid User Rating! Please give rating between 0-5";
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

    @GetMapping("/listRating")
    public List<UserDto.RatingResp> listRatings(){
        return ratingService.listRatingService();
    }
}
