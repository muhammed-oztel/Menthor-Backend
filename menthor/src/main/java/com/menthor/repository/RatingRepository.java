package com.menthor.repository;

import com.menthor.model.Rating;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByUserId(Long userId);

    @Query("select u from Rating u order by u.userRating desc")
    List<Rating> findRatingList(Pageable pageable);

}
