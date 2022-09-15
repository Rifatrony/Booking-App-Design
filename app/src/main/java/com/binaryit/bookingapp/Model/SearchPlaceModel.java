package com.binaryit.bookingapp.Model;

public class SearchPlaceModel {

    int image;
    String name, location, nearByLocation;
    double previousPrice, newPrice, offer;
    float rating;

    public SearchPlaceModel(int image, String name, String location, String nearByLocation, double previousPrice, double newPrice, double offer, float rating) {
        this.image = image;
        this.name = name;
        this.location = location;
        this.nearByLocation = nearByLocation;
        this.previousPrice = previousPrice;
        this.newPrice = newPrice;
        this.offer = offer;
        this.rating = rating;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNearByLocation() {
        return nearByLocation;
    }

    public void setNearByLocation(String nearByLocation) {
        this.nearByLocation = nearByLocation;
    }

    public double getPreviousPrice() {
        return previousPrice;
    }

    public void setPreviousPrice(double previousPrice) {
        this.previousPrice = previousPrice;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    public double getOffer() {
        return offer;
    }

    public void setOffer(double offer) {
        this.offer = offer;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
