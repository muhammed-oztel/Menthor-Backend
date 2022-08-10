package com.menthor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Rating {
    @Id
    @GeneratedValue
    private Long ratingId;

    private Long userId;
    private int countUserRides = 1;
    private double userRating;
    private double totalRates;

    public Rating() {
    }

    public Rating(int countUserRides, double userRating, double totalRates) {
        this.countUserRides = countUserRides;
        this.userRating = userRating;
        this.totalRates = totalRates;
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

    public double getTotalRates() {
        return totalRates;
    }

    public void setTotalRates(double totalRates) {
        this.totalRates = totalRates;
    }
}
