package com.example.sarmkadan.rieltorhelper.databases;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Abilis on 25.04.2016.
 */
public final class CreateAndDeleteTables {

    //Список содержит название всех таблиц в БД
    private static final ArrayList<String> TABLES = new ArrayList<>();

    //начальный префикс для удаления таблиц
    private static final String DROP_TABLE_IF_EXISTS = "DROP TABLE IF EXISTS";

    //запросы создания таблиц
    private static final String CREATE_AREND_IMAGE = "CREATE TABLE ArendImage (ID INTEGER PRIMARY KEY" +
            " AUTOINCREMENT NOT NULL, photo BLOB, title STRING, ArendID INTEGER REFERENCES Arend" +
            " (ID) ON DELETE CASCADE);";
    private static final String CREATE_AREND_ROOM = "CREATE TABLE ArendRoom (ID INTEGER PRIMARY KEY" +
            " AUTOINCREMENT UNIQUE NOT NULL, phoneNumber STRING (0, 30), fullName STRING, date STRING," +
            " typeOfRent STRING, numOfRooms STRING, district STRING, addresses STRING, floor STRING," +
            " square STRING, condition STRING, heating STRING, furniture STRING, furnitureList STRING," +
            " householdAppliances STRING, householdAppliancesList STRING, typeSettle STRING," +
            " typeOfRoom STRING, forWhom STRING, costUah INTEGER, costUsd INTEGER, common STRING);";
    private static final String CREATE_EARTH_SELL_IMAGE = "CREATE TABLE EarthSellImage (ID INTEGER" +
            " PRIMARY KEY AUTOINCREMENT NOT NULL, photo BLOB, title STRING, EarthSellID INTEGER" +
            " REFERENCES EarthSell (ID) ON DELETE CASCADE);";
    private static final String CREATE_KV_SELL = "CREATE TABLE KVsell (ID INTEGER PRIMARY KEY" +
            " AUTOINCREMENT UNIQUE NOT NULL, phoneNumber STRING, fullName STRING, date STRING," +
            " district STRING, addresses STRING, numOfRooms STRING, numOfFloors STRING," +
            " rentOrSell STRING, typeOfHouse STRING, fullSquare STRING, livingSquare STRING," +
            " kitchenSquare STRING, heating STRING, conditionalApartment STRING, furniture STRING," +
            " costUah INTEGER, costUsd INTEGER, common STRING);";
    private static final String CREATE_AREND_PRIM_IMAGE = "CREATE TABLE ArendPrimImage (ID INTEGER" +
            " PRIMARY KEY AUTOINCREMENT NOT NULL, photo BLOB, title STRING, ArendPrimID INTEGER" +
            " REFERENCES ArendPrim (ID) ON DELETE CASCADE);";
    private static final String CREATE_PRIM_SELL_IMAGE = "CREATE TABLE PrimSellImage (ID INTEGER" +
            " PRIMARY KEY AUTOINCREMENT NOT NULL, photo BLOB, title STRING, PrimSellID INTEGER" +
            " REFERENCES PrimSell (ID) ON DELETE CASCADE);";
    private static final String CREATE_AREND_ROOM_IMAGE = "CREATE TABLE ArendRoomImage (ID INTEGER" +
            " PRIMARY KEY AUTOINCREMENT NOT NULL, photo BLOB, title STRING, ArendRoomID INTEGER" +
            " REFERENCES ArendRoom (ID) ON DELETE CASCADE);";
    private static final String CREATE_AREND = "CREATE TABLE Arend (ID INTEGER PRIMARY KEY" +
            " AUTOINCREMENT UNIQUE NOT NULL, phoneNumber STRING, fullName STRING, date STRING," +
            " numOfRooms STRING, typeOfObject STRING, district STRING, addresses STRING, floor STRING," +
            " square STRING, condition STRING, heating STRING, furniture STRING, furnitureList STRING," +
            " householdAppliances STRING, householdAppliancesList STRING, costUah INTEGER, costUsd INTEGER," +
            " common STRING);";
    private static final String CREATE_HOSTEL_SELL = "CREATE TABLE HostelSell (ID INTEGER PRIMARY KEY" +
            " AUTOINCREMENT UNIQUE NOT NULL, phoneNumber STRING, fullName STRING, date STRING," +
            " district STRING, addresses STRING, systemHostel STRING, numOfFloors STRING," +
            " typeOfHouse STRING, fullSquare STRING, condition STRING, heating STRING," +
            " havingFurniture STRING, costUah INTEGER, costUsd INTEGER, common STRING);";
    private static final String CREATE_KV_SELL_IMAGE = "CREATE TABLE KVsellImage (ID INTEGER PRIMARY" +
            " KEY AUTOINCREMENT NOT NULL, photo BLOB, title STRING, KVsellID INTEGER REFERENCES" +
            " KVsell (ID) ON DELETE CASCADE);";
    private static final String CREATE_EARTH_SELL = "CREATE TABLE EarthSell (ID INTEGER PRIMARY KEY" +
            " AUTOINCREMENT UNIQUE NOT NULL, phoneNumber STRING, fullName STRING, date STRING," +
            " cityDistrict STRING, addresses STRING, distanceToCity INTEGER, fullSquare STRING," +
            " communicationsList STRING, docs STRING, docsList STRING, outbuildings STRING," +
            " buildingsList STRING, typeOfArea STRING, costUah INTEGER, costUsd INTEGER, common STRING);";
    private static final String CREATE_AREND_PRIM = "CREATE TABLE ArendPrim (ID INTEGER PRIMARY KEY" +
            " AUTOINCREMENT UNIQUE NOT NULL, phoneNumber STRING, fullName STRING, date STRING," +
            " district STRING, addresses STRING, rentOrSell STRING, kindOfRoom STRING," +
            " typeOfObject STRING, location STRING, numOfFloors STRING, square STRING," +
            " numOfRooms STRING, condition STRING, heating STRING, costUah INTEGER," +
            " costUsd INTEGER, common STRING);";
    private static final String CREATE_HOSTEL_SELL_IMAGE = "CREATE TABLE HostelSellImage" +
            " (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, photo BLOB, title STRING," +
            " HostelSellID INTEGER REFERENCES HostelSell (ID) ON DELETE CASCADE);";
    private static final String CREATE_PRIM_SELL = "CREATE TABLE PrimSell (ID INTEGER PRIMARY KEY" +
            " AUTOINCREMENT UNIQUE NOT NULL, phoneNumber STRING, fullName STRING, date STRING," +
            " district STRING, addresses STRING, rentOrSell STRING, kindOfRoom STRING," +
            " typeOfObject STRING, location STRING, numOfFloors STRING, square STRING," +
            " numOfRooms STRING, condition STRING, heating STRING, costUah INTEGER," +
            " costUsd INTEGER, common STRING);";
    private static final String CREATE_HOUSE_SELL = "CREATE TABLE HouseSell (ID INTEGER PRIMARY KEY" +
            " AUTOINCREMENT UNIQUE NOT NULL, phoneNumber STRING, fullName STRING, date STRING," +
            " cityDistrict STRING, fullAddress STRING, distanceToCity INTEGER, landSquare STRING," +
            " houseSquare STRING, typeOfHouse STRING, buildingsList STRING, communications STRING," +
            " communicationsList STRING, docs STRING, docsList STRING, costUah INTEGER," +
            " costUsd INTEGER, common STRING);";
    private static final String CREATE_HOUSE_SELL_IMAGE = "CREATE TABLE HouseSellImage" +
            " (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, photo BLOB, title STRING," +
            " houseSellID INTEGER REFERENCES HouseSell (ID) ON DELETE CASCADE);";


    private CreateAndDeleteTables() {
    }

    //метод создает все таблицы в БД
    static void createTables(SQLiteDatabase db) {
        db.execSQL(CREATE_AREND_IMAGE);
        db.execSQL(CREATE_AREND_ROOM);
        db.execSQL(CREATE_EARTH_SELL_IMAGE);
        db.execSQL(CREATE_KV_SELL);
        db.execSQL(CREATE_AREND_PRIM_IMAGE);
        db.execSQL(CREATE_PRIM_SELL_IMAGE);
        db.execSQL(CREATE_AREND_ROOM_IMAGE);
        db.execSQL(CREATE_AREND);
        db.execSQL(CREATE_HOSTEL_SELL);
        db.execSQL(CREATE_KV_SELL_IMAGE);
        db.execSQL(CREATE_EARTH_SELL);
        db.execSQL(CREATE_AREND_PRIM);
        db.execSQL(CREATE_HOSTEL_SELL_IMAGE);
        db.execSQL(CREATE_PRIM_SELL);
        db.execSQL(CREATE_HOUSE_SELL);
        db.execSQL(CREATE_HOUSE_SELL_IMAGE);
    }

    //метод удаляет все таблицы в БД
    static void dropTables(SQLiteDatabase db) {

        //заполнение списка таблиц (названия таблиц в БД)
        TABLES.add("ArendImage");
        TABLES.add("ArendRoom");
        TABLES.add("EarthSellImage");
        TABLES.add("KVsell");
        TABLES.add("ArendPrimImage");
        TABLES.add("PrimSellImage");
        TABLES.add("ArendRoomImage");
        TABLES.add("Arend");
        TABLES.add("HostelSell");
        TABLES.add("KVsellImage");
        TABLES.add("EarthSell");
        TABLES.add("ArendPrim");
        TABLES.add("HostelSellImage");
        TABLES.add("PrimSell");
        TABLES.add("HouseSell");
        TABLES.add("HouseSellImage");

        //выполнение запросов на удаление таблиц
        for (String str : TABLES) {
            db.execSQL(DROP_TABLE_IF_EXISTS + " " + str);
        }

    }

}
