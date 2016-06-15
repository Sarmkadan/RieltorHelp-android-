package com.example.sarmkadan.rieltorhelper.entities;

import java.util.Date;

/**
 * Created by Abilis on 26.04.2016.
 */
public class HostelSell extends Entity {

    private String district;
    private String addresses;
    private String systemHostel;
    private String numOfFloors;
    private String typeOfHouse;
    private String fullSquare;
    private String condition;
    private String heating;
    private String havingFurniture;

    public HostelSell(int id, String phoneNumber, String fullName, Date date, int costUah, int costUsd,
                      String common, String district, String addresses, String systemHostel,
                      String numOfFloors, String typeOfHouse, String fullSquare, String condition,
                      String heating, String havingFurniture) {

        super(id, phoneNumber, fullName, date, costUah, costUsd, common);

        this.district = district;
        this.addresses = addresses;
        this.systemHostel = systemHostel;
        this.numOfFloors = numOfFloors;
        this.typeOfHouse = typeOfHouse;
        this.fullSquare = fullSquare;
        this.condition = condition;
        this.heating = heating;
        this.havingFurniture = havingFurniture;
    }

    public String getDistrict() {
        return district;
    }

    public String getAddresses() {
        return addresses;
    }

    public String getSystemHostel() {
        return systemHostel;
    }

    public String getNumOfFloors() {
        return numOfFloors;
    }

    public String getTypeOfHouse() {
        return typeOfHouse;
    }

    public String getFullSquare() {
        return fullSquare;
    }

    public String getCondition() {
        return condition;
    }

    public String getHeating() {
        return heating;
    }

    public String getHavingFurniture() {
        return havingFurniture;
    }

    @Override
    public String toString() {
        return getId() + " " + getPhoneNumber() + " " + getAddresses();
    }
}
