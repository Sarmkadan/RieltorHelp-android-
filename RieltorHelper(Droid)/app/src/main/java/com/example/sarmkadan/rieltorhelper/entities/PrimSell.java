package com.example.sarmkadan.rieltorhelper.entities;

import java.util.Date;

/**
 * Created by Abilis on 26.04.2016.
 */
public class PrimSell extends Entity {

    private String district;
    private String addresses;
    private String rentOrSell;
    private String kindOfRoom;
    private String typeOfObject;
    private String location;
    private String numOfFloors;
    private String square;
    private String numOfRooms;
    private String condition;
    private String heating;

    public PrimSell(int id, String phoneNumber, String fullName, Date date, int costUah, int costUsd,
                    String common, String district, String addresses, String rentOrSell, String kindOfRoom,
                    String typeOfObject, String location, String numOfFloors, String square,
                    String numOfRooms, String condition, String heating) {

        super(id, phoneNumber, fullName, date, costUah, costUsd, common);

        this.district = district;
        this.addresses = addresses;
        this.rentOrSell = rentOrSell;
        this.kindOfRoom = kindOfRoom;
        this.typeOfObject = typeOfObject;
        this.location = location;
        this.numOfFloors = numOfFloors;
        this.square = square;
        this.numOfRooms = numOfRooms;
        this.condition = condition;
        this.heating = heating;
    }

    public String getDistrict() {
        return district;
    }

    public String getAddresses() {
        return addresses;
    }

    public String getRentOrSell() {
        return rentOrSell;
    }

    public String getKindOfRoom() {
        return kindOfRoom;
    }

    public String getTypeOfObject() {
        return typeOfObject;
    }

    public String getLocation() {
        return location;
    }

    public String getNumOfFloors() {
        return numOfFloors;
    }

    public String getSquare() {
        return square;
    }

    public String getNumOfRooms() {
        return numOfRooms;
    }

    public String getCondition() {
        return condition;
    }

    public String getHeating() {
        return heating;
    }

    @Override
    public String toString() {
        return getId() + " " + getPhoneNumber() + " " + getAddresses();
    }
}
