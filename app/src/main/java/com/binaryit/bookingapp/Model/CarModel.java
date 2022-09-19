package com.binaryit.bookingapp.Model;

public class CarModel {

    String carName;
    int image, door, luggage, person;

    public CarModel(String carName, int image, int door, int luggage, int person) {
        this.carName = carName;
        this.image = image;
        this.door = door;
        this.luggage = luggage;
        this.person = person;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getDoor() {
        return door;
    }

    public void setDoor(int door) {
        this.door = door;
    }

    public int getLuggage() {
        return luggage;
    }

    public void setLuggage(int luggage) {
        this.luggage = luggage;
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }
}
