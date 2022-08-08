package com.example.ratinggradle.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Rating {
    @Id
    @GeneratedValue
    private Long ratingId;

    private Long userId;
    private String userName;
    private int countUserRides = 1;
    private double userRating;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getCountUserRides() {
        return countUserRides;
    }

    public void setCountUserRides(int countUserRides) {
        this.countUserRides = countUserRides;
    }

    public double getUserRating() {
        return userRating;
    }

    public void setUserRating(double userRating) {
        this.userRating = userRating;
    }

    public Long getRatingId() {
        return ratingId;
    }

    public Long getUserId() {
        return userId;
    }
}
