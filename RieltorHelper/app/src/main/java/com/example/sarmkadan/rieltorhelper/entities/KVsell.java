package com.example.sarmkadan.rieltorhelper.entities;

import java.util.Date;

/**
 * Created by Abilis on 26.04.2016.
 */
public class KVsell extends Entity {

    private String district;
    private String addresses;
    private String numOfRooms;
    private String numOfFloors;
    private String rentOrSell;
    private String typeOfHouse;
    private String fullSquare;
    private String livingSquare;
    private String kitchenSquare;
    private String heating;
    private String conditionalApartment;
    private String furniture;

    public KVsell(int id, String phoneNumber, String fullName, Date date, int costUah, int costUsd,
                  String common, String district, String addresses, String numOfRooms,
                  String numOfFloors, String rentOrSell, String typeOfHouse, String fullSquare,
                  String livingSquare, String kitchenSquare, String heating,
                  String conditionalApartment, String furniture) {

        super(id, phoneNumber, fullName, date, costUah, costUsd, common);

        this.district = district;
        this.addresses = addresses;
        this.numOfRooms = numOfRooms;
        this.numOfFloors = numOfFloors;
        this.rentOrSell = rentOrSell;
        this.typeOfHouse = typeOfHouse;
        this.fullSquare = fullSquare;
        this.livingSquare = livingSquare;
        this.kitchenSquare = kitchenSquare;
        this.heating = heating;
        this.conditionalApartment = conditionalApartment;
        this.furniture = furniture;
    }

    public String getDistrict() {
        return district;
    }

    public String getAddresses() {
        return addresses;
    }

    public String getNumOfRooms() {
        return numOfRooms;
    }

    public String getNumOfFloors() {
        return numOfFloors;
    }

    public String getRentOrSell() {
        return rentOrSell;
    }

    public String getTypeOfHouse() {
        return typeOfHouse;
    }

    public String getFullSquare() {
        return fullSquare;
    }

    public String getLivingSquare() {
        return livingSquare;
    }

    public String getKitchenSquare() {
        return kitchenSquare;
    }

    public String getHeating() {
        return heating;
    }

    public String getConditionalApartment() {
        return conditionalApartment;
    }

    public String getFurniture() {
        return furniture;
    }

    @Override
    public String toString() {
        return getId() + " " + getPhoneNumber() + " " + getAddresses();
    }
}
