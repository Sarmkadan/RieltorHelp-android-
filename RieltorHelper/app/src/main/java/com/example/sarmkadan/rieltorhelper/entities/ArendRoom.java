package com.example.sarmkadan.rieltorhelper.entities;

import java.util.Date;

/**
 * Created by Admin on 25.04.2016.
 */
public class ArendRoom extends Entity {

    protected String typeOfRent;
    protected String numOfRooms;
    protected String district;
    protected String addresses;
    protected String floor;
    protected String square;
    protected String condition;
    protected String heating;
    protected String furniture;
    protected String furnitureList;
    protected String householdAppliances;
    protected String householdAppliancesList;
    protected String typeSettle;
    protected String typeOfRoom;
    protected String forWhom;

    public ArendRoom(int id, String phoneNumber, String fullName, Date date, int costUah, int costUsd, String common,
                     String typeOfRent, String numOfRooms, String district, String addresses,
                     String floor, String square, String condition, String heating, String furniture,
                     String furnitureList, String householdAppliances, String householdAppliancesList,
                     String typeSettle, String typeOfRoom, String forWhom) {

        super(id, phoneNumber, fullName, date, costUah, costUsd, common);

        this.typeOfRent = typeOfRent;
        this.numOfRooms = numOfRooms;
        this.district = district;
        this.addresses = addresses;
        this.floor = floor;
        this.square = square;
        this.condition = condition;
        this.heating = heating;
        this.furniture = furniture;
        this.furnitureList = furnitureList;
        this.householdAppliances = householdAppliances;
        this.householdAppliancesList = householdAppliancesList;
        this.typeSettle = typeSettle;
        this.typeOfRoom = typeOfRoom;
        this.forWhom = forWhom;
    }

    public String getTypeOfRent() {
        return typeOfRent;
    }

    public String getNumOfRooms() {
        return numOfRooms;
    }

    public String getDistrict() {
        return district;
    }

    public String getAddresses() {
        return addresses;
    }

    public String getFloor() {
        return floor;
    }

    public String getSquare() {
        return square;
    }

    public String getCondition() {
        return condition;
    }

    public String getHeating() {
        return heating;
    }

    public String getFurniture() {
        return furniture;
    }

    public String getFurnitureList() {
        return furnitureList;
    }

    public String getHouseholdAppliances() {
        return householdAppliances;
    }

    public String getHouseholdAppliancesList() {
        return householdAppliancesList;
    }

    public String getTypeSettle() {
        return typeSettle;
    }

    public String getTypeOfRoom() {
        return typeOfRoom;
    }

    public String getForWhom() {
        return forWhom;
    }

    @Override
    public String toString() {
        return getId() + " " + getPhoneNumber() + " " + getAddresses();
    }
}
