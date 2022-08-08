package com.example.ratingsystem.demo;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DriverModel
{
    @Id
    private int driverId;
    private String driverName;
    private String driverPassword;
    private double countDriverRating;
    private int countDriverRides;
    private double driverRating;


    public long getdriverId() {
        return driverId;
    }

    public void setdriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getdriverName() {
        return driverName;
    }

    public void setdriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getdriverPassword() {
        return driverPassword;
    }

    public void setdriverPassword(String driverPassword) {
        this.driverPassword = driverPassword;
    }

    public double getcountDriverRating() {
        return countDriverRating;
    }

    public void setcountDriverRating(double countDriverRating) {
        this.countDriverRating = countDriverRating;
    }

    public int getcountDriverRides() {
        return countDriverRides;
    }

    public void setcountDriverRides(int countDriverRides) {
        this.countDriverRides = countDriverRides;
    }

    public double getdriverRating() {
        return driverRating;
    }

    public void setdriverRating(double driverRating) {
        this.driverRating = driverRating;
    }


    @Override
    public String toString() {
        return "UserModel{" +
                "driverId=" + driverId +
                ", driverName='" + driverName + '\'' +
                ", driverPassword='" + driverPassword + '\'' +
                ", countDriverRating=" + countDriverRating +
                ", countDriverRides=" + countDriverRides +
                ", driverRating=" + driverRating +
                '}';
    }
}
