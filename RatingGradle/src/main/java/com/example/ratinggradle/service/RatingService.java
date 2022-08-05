package com.example.ratinggradle.service;

import com.example.ratinggradle.model.Rating;
import com.example.ratinggradle.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }


    @Transactional
    public void createUpdate(Rating rating) {
       List<Rating> ratingList = ratingRepository.findByUserId(rating.getUserId());

       if(ratingList.isEmpty()){
            ratingRepository.save(rating);
       }else{
           //UPDATING
           //Increment Ride Number

           ratingList.get(0).setUserRating(
                   (ratingList.get(0).getUserRating() +
                           rating.getUserRating())/2);

         ratingList.get(0).setCountUserRides(ratingList.get(0).getCountUserRides() + 1);
       }
    }

    public List<Rating>getRatingsService(Long userId) {

        return ratingRepository.findByUserId(userId);

    }
}
