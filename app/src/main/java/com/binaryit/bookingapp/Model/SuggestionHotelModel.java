package com.binaryit.bookingapp.Model;

public class SuggestionHotelModel {

    int image;
    String placeName, placeLocation;

    public SuggestionHotelModel(int image, String placeName, String placeLocation) {
        this.image = image;
        this.placeName = placeName;
        this.placeLocation = placeLocation;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceLocation() {
        return placeLocation;
    }

    public void setPlaceLocation(String placeLocation) {
        this.placeLocation = placeLocation;
    }
}
