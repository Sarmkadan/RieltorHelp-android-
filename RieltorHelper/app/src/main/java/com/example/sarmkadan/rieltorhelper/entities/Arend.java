package com.example.sarmkadan.rieltorhelper.entities;

import java.util.Date;

/**
 * Created by Abilis on 26.04.2016.
 */
public class Arend extends Entity {

    private String numOfRooms;
    private String typeOfObject;
    private String district;
    private String addresses;
    private String floor;
    private String square;
    private String condition;
    private String heating;
    private String furniture;
    private String furnitureList;
    private String householdAppliances;
    private String householdAppliancesList;

    public Arend(int id, String phoneNumber, String fullName, Date date, int costUah, int costUsd,
                 String common, String numOfRooms, String typeOfObject, String district,
                 String addresses, String floor, String square, String condition, String heating,
                 String furniture, String furnitureList, String householdAppliances,
                 String householdAppliancesList) {

        super(id, phoneNumber, fullName, date, costUah, costUsd, common);

        this.numOfRooms = numOfRooms;
        this.typeOfObject = typeOfObject;
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
    }

    public String getNumOfRooms() {
        return numOfRooms;
    }

    public String getTypeOfObject() {
        return typeOfObject;
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

    @Override
    public String toString() {
        return getId() + " " + getPhoneNumber() + " " + getAddresses();
    }
}
