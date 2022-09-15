package com.binaryit.bookingapp.Model;

public class TourModel {

    String tourName, tourLocation, duration, tourType, generalInformation, date, include, exclude, food, travelDetails, contact;

    double price;
    int groupSize, image;

    public TourModel(String tourName, String tourLocation, String duration, String tourType, String generalInformation, String date, String include, String exclude, String food, String travelDetails, String contact, double price, int groupSize, int image) {
        this.tourName = tourName;
        this.tourLocation = tourLocation;
        this.duration = duration;
        this.tourType = tourType;
        this.generalInformation = generalInformation;
        this.date = date;
        this.include = include;
        this.exclude = exclude;
        this.food = food;
        this.travelDetails = travelDetails;
        this.contact = contact;
        this.price = price;
        this.groupSize = groupSize;
        this.image = image;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getTourLocation() {
        return tourLocation;
    }

    public void setTourLocation(String tourLocation) {
        this.tourLocation = tourLocation;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTourType() {
        return tourType;
    }

    public void setTourType(String tourType) {
        this.tourType = tourType;
    }

    public String getGeneralInformation() {
        return generalInformation;
    }

    public void setGeneralInformation(String generalInformation) {
        this.generalInformation = generalInformation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInclude() {
        return include;
    }

    public void setInclude(String include) {
        this.include = include;
    }

    public String getExclude() {
        return exclude;
    }

    public void setExclude(String exclude) {
        this.exclude = exclude;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getTravelDetails() {
        return travelDetails;
    }

    public void setTravelDetails(String travelDetails) {
        this.travelDetails = travelDetails;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(int groupSize) {
        this.groupSize = groupSize;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
