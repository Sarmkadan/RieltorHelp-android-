package com.example.sarmkadan.rieltorhelper.entities;

import java.util.Date;

/**
 * Created by Abilis on 26.04.2016.
 */
public class EarthSell extends Entity {

    private String cityDistrict;
    private String addresses;
    private String distanceToCity;
    private String fullSquarre;
    private String communicationsList;
    private String docs;
    private String docsList;
    private String outbuildings;
    private String buildingsList;
    private String typeOfArea;

    public EarthSell(int id, String phoneNumber, String fullName, Date date, int costUah, int costUsd,
                     String common, String cityDistrict, String addresses, String distanceToCity,
                     String fullSquarre, String communicationsList, String docs, String docsList,
                     String outbuildings, String buildingsList, String typeOfArea) {

        super(id, phoneNumber, fullName, date, costUah, costUsd, common);

        this.cityDistrict = cityDistrict;
        this.addresses = addresses;
        this.distanceToCity = distanceToCity;
        this.fullSquarre = fullSquarre;
        this.communicationsList = communicationsList;
        this.docs = docs;
        this.docsList = docsList;
        this.outbuildings = outbuildings;
        this.buildingsList = buildingsList;
        this.typeOfArea = typeOfArea;
    }

    public String getCityDistrict() {
        return cityDistrict;
    }

    public String getAddresses() {
        return addresses;
    }

    public String getDistanceToCity() {
        return distanceToCity;
    }

    public String getFullSquarre() {
        return fullSquarre;
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

    public String getOutbuildings() {
        return outbuildings;
    }

    public String getBuildingsList() {
        return buildingsList;
    }

    public String getTypeOfArea() {
        return typeOfArea;
    }

    @Override
    public String toString() {
        return getId() + " " + getPhoneNumber() + " " + getAddresses();
    }
}
