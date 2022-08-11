package com.menthor.service;

import com.menthor.model.Rating;
import com.menthor.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
            try {
                rating.setTotalRates(rating.getUserRating());
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            //UPDATING
            //Increment Ride Number
            ratingList.get(0).setCountUserRides(ratingList.get(0).getCountUserRides() + 1);

            ratingList.get(0).setUserRating(
                    (ratingList.get(0).getTotalRates() +
                            rating.getUserRating())/ratingList.get(0).getCountUserRides());

            ratingList.get(0).setTotalRates(ratingList.get(0).getTotalRates() + rating.getUserRating());

        }
    }

    public List<Rating>getRatingsService(Long userId) {

        return ratingRepository.findByUserId(userId);

    }

    public List<Rating> listRatingService() {
        return ratingRepository.findRatingList(PageRequest.of(0,5));
    }
}
