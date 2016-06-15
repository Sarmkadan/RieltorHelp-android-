package com.example.sarmkadan.rieltorhelper.entities;

import java.util.Date;

/**
 * Created by Abilis on 26.04.2016.
 */
public class HouseSell extends Entity {

    private String cityDistrict;
    private String fullAddress;
    private String distanceToCity;
    private String landSquare;
    private String houseSquare;
    private String typeOpHouse;
    private String buildingsList;
    private String communications;
    private String communicationsList;
    private String docs;
    private String docsList;

    public HouseSell(int id, String phoneNumber, String fullName, Date date, int costUah, int costUsd,
                     String common, String cityDistrict, String fullAddress, String distanceToCity,
                     String landSquare, String houseSquare, String typeOpHouse, String buildingsList,
                     String communications, String communicationsList, String docs, String docsList) {

        super(id, phoneNumber, fullName, date, costUah, costUsd, common);

        this.cityDistrict = cityDistrict;
        this.fullAddress = fullAddress;
        this.distanceToCity = distanceToCity;
        this.landSquare = landSquare;
        this.houseSquare = houseSquare;
        this.typeOpHouse = typeOpHouse;
        this.buildingsList = buildingsList;
        this.communications = communications;
        this.communicationsList = communicationsList;
        this.docs = docs;
        this.docsList = docsList;
    }

    public String getCityDistrict() {
        return cityDistrict;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public String getDistanceToCity() {
        return distanceToCity;
    }

    public String getLandSquare() {
        return landSquare;
    }

    public String getHouseSquare() {
        return houseSquare;
    }

    public String getTypeOpHouse() {
        return typeOpHouse;
    }

    public String getBuildingsList() {
        return buildingsList;
    }

    public String getCommunications() {
        return communications;
    }

    public String getCommunicationsList() {
        return communicationsList;
    }

    public String getDocs() {
        return docs;
    }

    public String getDocsList() {
        return docsList;
    }

    @Override
    public String toString() {
        return getId() + " " + getPhoneNumber() + " " + getFullAddress();
    }
}
