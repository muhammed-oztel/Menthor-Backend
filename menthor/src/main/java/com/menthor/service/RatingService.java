package com.menthor.service;

import com.menthor.dto.UserDto;
import com.menthor.model.Rating;
import com.menthor.model.UserEntity;
import com.menthor.repository.RatingRepository;
import com.menthor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;
    private final UserRepository userRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository, UserRepository userRepository) {
        this.ratingRepository = ratingRepository;
        this.userRepository = userRepository;
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

    public List<UserDto.RatingResp> listRatingService() {
        try {
            List<Rating> ratingList = ratingRepository.findRatingList(PageRequest.of(0,5));
            List<UserDto.RatingResp> response = new ArrayList<UserDto.RatingResp>();
            Optional<UserEntity> user;
            for (int i=0;i<ratingList.size();++i){
                UserDto.RatingResp rating = new UserDto.RatingResp();
                user = userRepository.findById(ratingList.get(i).getUserId());
                rating.setUserRating(ratingList.get(i).getUserRating());
                rating.setNameSurname(user.get().getName()+" "+user.get().getSurname());
                rating.setPicture(user.get().getPicture());
                response.add(rating);
            }
            return response;
        }catch (Exception ex){
            throw ex;
        }
    }
}
