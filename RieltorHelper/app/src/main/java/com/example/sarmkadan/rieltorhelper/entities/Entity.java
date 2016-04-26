package com.example.sarmkadan.rieltorhelper.entities;

import java.util.Date;

/**
 * Created by Admin on 25.04.2016.
 */
public abstract class Entity {

    protected int id;
    protected String phoneNumber;
    protected String fullName;
    protected Date date;
    protected int costUah;
    protected int costUsd;
    protected String common;


    public Entity(int id, String phoneNumber, String fullName, Date date, int costUah, int costUsd, String common) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
        this.date = date;
        this.costUah = costUah;
        this.costUsd = costUsd;
        this.common = common;
    }


    public int getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getDate() {
        return date;
    }

    public int getCostUah() {
        return costUah;
    }

    public int getCostUsd() {
        return costUsd;
    }

    public String getCommon() {
        return common;
    }
}
