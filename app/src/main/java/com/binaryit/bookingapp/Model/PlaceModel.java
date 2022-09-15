package com.binaryit.bookingapp.Model;

public class PlaceModel {
    String placeName, placeLocation;

    public PlaceModel(String placeName, String placeLocation) {
        this.placeName = placeName;
        this.placeLocation = placeLocation;
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
