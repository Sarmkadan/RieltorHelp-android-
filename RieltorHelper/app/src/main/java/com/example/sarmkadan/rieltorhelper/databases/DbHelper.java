package com.example.sarmkadan.rieltorhelper.databases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.sarmkadan.rieltorhelper.databases.dbExceptions.NoSuchTableInDbException;
import com.example.sarmkadan.rieltorhelper.entities.Arend;
import com.example.sarmkadan.rieltorhelper.entities.ArendRoom;
import com.example.sarmkadan.rieltorhelper.entities.EarthSell;
import com.example.sarmkadan.rieltorhelper.entities.Entity;
import com.example.sarmkadan.rieltorhelper.entities.HostelSell;
import com.example.sarmkadan.rieltorhelper.entities.KVsell;
import com.example.sarmkadan.rieltorhelper.utils.FormatingDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Abilis on 25.04.2016.
 */
public class DbHelper extends SQLiteOpenHelper implements DataStore {

    private static final String DB_NAME = "RIELTOR";
    private static final int DB_VERSION = 7;
    private final String TAG = "Sqlite";
    private static DbHelper dbHelper = null;


    private DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static DbHelper getDbHelpere(Context context) {
        if (dbHelper == null) {
            dbHelper = new DbHelper(context);
        }
        return dbHelper;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        CreateAndDeleteTables.createTables(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //запись в лог
        Log.w(TAG, "Обновление БД с версии " + oldVersion + " до версии " + newVersion);

        /* Тут бы неплохо вытащить все данные, которые есть в таблицах,
        чтобы импортировать их в новую БД
        */

        //удаляем таблицы
        CreateAndDeleteTables.dropTables(db);

        //создаем таблицы заново
        onCreate(db);
    }

    //метод возращает список объектов класса Entity
    public List<Entity> getEntitiesList(SQLiteDatabase db, String tableName) throws NoSuchTableInDbException {

        List<Entity> result = new ArrayList<>();

        Cursor cursor = db.query(tableName, null, null, null, null, null, null);

        //определяем, какого класса объект нужно создать. Он совпадает с названием таблицы в БД
        switch (tableName) {

            case "ArendRoom":
                //получаем список всех объектов типа ArendRoom
               result = createArendRoomList(cursor);
                break;
            case "Arend":
                //получаем список всех объектов типа Arend
                result = createArendList(cursor);
                break;
            case "ArendPrim":
                //получаем список всех объектов типа ArendPrim
                result = createArendPrimList(cursor);
                break;
            case "KVsell":
                //получаем список всех объектов типа KVsell
                result = createKvSellList(cursor);
                break;
            case "HostelSell":
                //получаем список всех объектов типа HostelSell
                result = createHostelSellList(cursor);
                break;
            case "EarthSell":
                //получаем список всех объектов типа EarthSell
                result = createEarthSellList(cursor);
                break;
            case "PrimSell":
                //получаем список всех объектов типа PrimSell
                result = createPrimSellList(cursor);
                break;
            case "HouseSell":
                //получаем список всех объектов типа HouseSell
                result = createHouseSellList(cursor);
                break;
        }

        cursor.close();

        return result;
    }


    //метод возвращает список созданных объектов класса ArendRoom на основе данных из БД
    private List<Entity> createArendRoomList(Cursor cursor) throws NoSuchTableInDbException {

        List<Entity> result = new ArrayList<>();

        if (cursor.moveToFirst()) {

            do {
                //определяем переменные
                int id = cursor.getInt(cursor.getColumnIndex("ID"));
                String phoneNumber = cursor.getString(cursor.getColumnIndex("phoneNumber"));
                String fullName = cursor.getString(cursor.getColumnIndex("fullName"));
                String dateStr = cursor.getString(cursor.getColumnIndex("date"));
                Date date = FormatingDate.getDateAsDate(dateStr);
                int costUah = cursor.getInt(cursor.getColumnIndex("costUah"));
                int costUsd = cursor.getInt(cursor.getColumnIndex("costUsd"));
                String common = cursor.getString(cursor.getColumnIndex("common"));
                String typeOfRent = cursor.getString(cursor.getColumnIndex("typeOfRent"));
                String numOfRooms = cursor.getString(cursor.getColumnIndex("numOfRooms"));
                String district = cursor.getString(cursor.getColumnIndex("district"));
                String addresses = cursor.getString(cursor.getColumnIndex("addresses"));
                String floor = cursor.getString(cursor.getColumnIndex("floor"));
                String square = cursor.getString(cursor.getColumnIndex("square"));
                String condition = cursor.getString(cursor.getColumnIndex("condition"));
                String heating = cursor.getString(cursor.getColumnIndex("heating"));
                String furniture = cursor.getString(cursor.getColumnIndex("furniture"));
                String furnitureList = cursor.getString(cursor.getColumnIndex("furnitureList"));
                String householdAppliances = cursor.getString(cursor.getColumnIndex("householdAppliances"));
                String householdAppliancesList = cursor.getString(cursor.getColumnIndex("householdAppliancesList"));
                String typeSettle = cursor.getString(cursor.getColumnIndex("typeSettle"));
                String typeOfRoom = cursor.getString(cursor.getColumnIndex("typeOfRoom"));
                String forWhom = cursor.getString(cursor.getColumnIndex("forWhom"));

                //создаем объект класса ArendRoom и добавляем его в список
                ArendRoom arendRoom = new ArendRoom(id, phoneNumber, fullName, date, costUah, costUsd,
                        common, typeOfRent, numOfRooms, district, addresses, floor, square, condition,
                        heating, furniture, furnitureList, householdAppliances, householdAppliancesList,
                        typeSettle, typeOfRoom, forWhom);

                result.add(arendRoom);

            } while (cursor.moveToNext());
        }
        else {
            throw new NoSuchTableInDbException();
        }

        return result;
    }

    //метод возвращает список созданных объектов класса KVSell на основе данных из БД
    private List<Entity> createKvSellList(Cursor cursor) throws NoSuchTableInDbException {

        List<Entity> result = new ArrayList<>();

        if (cursor.moveToFirst()) {

            do {
                //определяем переменные
                int id = cursor.getInt(cursor.getColumnIndex("ID"));
                String phoneNumber = cursor.getString(cursor.getColumnIndex("phoneNumber"));
                String fullName = cursor.getString(cursor.getColumnIndex("fullName"));
                String dateStr = cursor.getString(cursor.getColumnIndex("date"));
                Date date = FormatingDate.getDateAsDate(dateStr);
                int costUah = cursor.getInt(cursor.getColumnIndex("costUah"));
                int costUsd = cursor.getInt(cursor.getColumnIndex("costUsd"));
                String common = cursor.getString(cursor.getColumnIndex("common"));
                String district = cursor.getString(cursor.getColumnIndex("district"));
                String addresses = cursor.getString(cursor.getColumnIndex("addresses"));
                String numOfRooms = cursor.getString(cursor.getColumnIndex("numOfRooms"));
                String numOfFloors = cursor.getString(cursor.getColumnIndex("numOfFloors"));
                String rentOrSell = cursor.getString(cursor.getColumnIndex("rentOrSell"));
                String typeOfHouse = cursor.getString(cursor.getColumnIndex("typeOfHouse"));
                String fullSquare = cursor.getString(cursor.getColumnIndex("fullSquare"));
                String livingSquare = cursor.getString(cursor.getColumnIndex("livingSquare"));
                String kitchenSquare = cursor.getString(cursor.getColumnIndex("kitchenSquare"));
                String heating = cursor.getString(cursor.getColumnIndex("heating"));
                String conditionalApartment = cursor.getString(cursor.getColumnIndex("conditionalApartment"));
                String furniture = cursor.getString(cursor.getColumnIndex("furniture"));

                //создаем объект класса KVsell и добавляем его в список
                KVsell kVsell = new KVsell(id, phoneNumber, fullName, date, costUah, costUsd,
                        common, district, addresses, numOfRooms, numOfFloors, rentOrSell, typeOfHouse,
                        fullSquare, livingSquare, kitchenSquare, heating, conditionalApartment, furniture);

                result.add(kVsell);



            } while (cursor.moveToNext());
        }
        else {
            throw new NoSuchTableInDbException();
        }

        return result;
    }


    //метод возвращает список созданных объектов класса ArendPrim на основе данных из БД
    private List<Entity> createArendPrimList(Cursor cursor) throws NoSuchTableInDbException {

        List<Entity> result = new ArrayList<>();

        if (cursor.moveToFirst()) {

            do {
                //определяем переменные
                int id = cursor.getInt(cursor.getColumnIndex("ID"));
                String phoneNumber = cursor.getString(cursor.getColumnIndex("phoneNumber"));
                String fullName = cursor.getString(cursor.getColumnIndex("fullName"));
                String dateStr = cursor.getString(cursor.getColumnIndex("date"));
                Date date = FormatingDate.getDateAsDate(dateStr);
                int costUah = cursor.getInt(cursor.getColumnIndex("costUah"));
                int costUsd = cursor.getInt(cursor.getColumnIndex("costUsd"));
                String common = cursor.getString(cursor.getColumnIndex("common"));
                String s = cursor.getString(cursor.getColumnIndex(""));

                //создаем объект класса ArendPrim и добавляем его в список




            } while (cursor.moveToNext());
        }
        else {
            throw new NoSuchTableInDbException();
        }

        return result;
    }


    //метод возвращает список созданных объектов класса Arend на основе данных из БД
    private List<Entity> createArendList(Cursor cursor) throws NoSuchTableInDbException {

        List<Entity> result = new ArrayList<>();

        if (cursor.moveToFirst()) {

            do {
                //определяем переменные
                int id = cursor.getInt(cursor.getColumnIndex("ID"));
                String phoneNumber = cursor.getString(cursor.getColumnIndex("phoneNumber"));
                String fullName = cursor.getString(cursor.getColumnIndex("fullName"));
                String dateStr = cursor.getString(cursor.getColumnIndex("date"));
                Date date = FormatingDate.getDateAsDate(dateStr);
                int costUah = cursor.getInt(cursor.getColumnIndex("costUah"));
                int costUsd = cursor.getInt(cursor.getColumnIndex("costUsd"));
                String common = cursor.getString(cursor.getColumnIndex("common"));
                String numOfRooms = cursor.getString(cursor.getColumnIndex("numOfRooms"));
                String typeOfObject = cursor.getString(cursor.getColumnIndex("typeOfObject"));
                String district = cursor.getString(cursor.getColumnIndex("district"));
                String addresses = cursor.getString(cursor.getColumnIndex("addresses"));
                String floor = cursor.getString(cursor.getColumnIndex("floor"));
                String square = cursor.getString(cursor.getColumnIndex("square"));
                String condition = cursor.getString(cursor.getColumnIndex("condition"));
                String heating = cursor.getString(cursor.getColumnIndex("heating"));
                String furniture = cursor.getString(cursor.getColumnIndex("furniture"));
                String furnitureList = cursor.getString(cursor.getColumnIndex("furnitureList"));
                String householdAppliances = cursor.getString(cursor.getColumnIndex("householdAppliances"));
                String householdAppliancesList = cursor.getString(cursor.getColumnIndex("householdAppliancesList"));

                //создаем объект класса ArendKVSell и добавляем его в список
                Arend arend = new Arend(id, phoneNumber, fullName, date, costUah, costUsd,
                        common, numOfRooms, typeOfObject, district, addresses, floor, square,
                        condition, heating, furniture, furnitureList, householdAppliances,
                        householdAppliancesList);

                result.add(arend);

            } while (cursor.moveToNext());
        }
        else {
            throw new NoSuchTableInDbException();
        }

        return result;
    }


    //метод возвращает список созданных объектов класса HostelSell на основе данных из БД
    private List<Entity> createHostelSellList(Cursor cursor) throws NoSuchTableInDbException {

        List<Entity> result = new ArrayList<>();

        if (cursor.moveToFirst()) {

            do {
                //определяем переменные
                int id = cursor.getInt(cursor.getColumnIndex("ID"));
                String phoneNumber = cursor.getString(cursor.getColumnIndex("phoneNumber"));
                String fullName = cursor.getString(cursor.getColumnIndex("fullName"));
                String dateStr = cursor.getString(cursor.getColumnIndex("date"));
                Date date = FormatingDate.getDateAsDate(dateStr);
                int costUah = cursor.getInt(cursor.getColumnIndex("costUah"));
                int costUsd = cursor.getInt(cursor.getColumnIndex("costUsd"));
                String common = cursor.getString(cursor.getColumnIndex("common"));
                String district = cursor.getString(cursor.getColumnIndex("district"));
                String addresses = cursor.getString(cursor.getColumnIndex("addresses"));
                String systemHostel = cursor.getString(cursor.getColumnIndex("systemHostel"));
                String numOfFloors = cursor.getString(cursor.getColumnIndex("numOfFloors"));
                String typeOfHouse = cursor.getString(cursor.getColumnIndex("typeOfHouse"));
                String fullSquare = cursor.getString(cursor.getColumnIndex("fullSquare"));
                String condition = cursor.getString(cursor.getColumnIndex("condition"));
                String heating = cursor.getString(cursor.getColumnIndex("heating"));
                String havingFurniture = cursor.getString(cursor.getColumnIndex("havingFurniture"));


                //создаем объект класса HostelSell и добавляем его в список
                HostelSell hostelSell = new HostelSell(id, phoneNumber, fullName, date, costUah, costUsd,
                        common, district, addresses, systemHostel, numOfFloors, typeOfHouse, fullSquare,
                        condition, heating, havingFurniture);

                result.add(hostelSell);



            } while (cursor.moveToNext());
        }
        else {
            throw new NoSuchTableInDbException();
        }

        return result;
    }


    //метод возвращает список созданных объектов класса EarthSell на основе данных из БД
    private List<Entity> createEarthSellList(Cursor cursor) throws NoSuchTableInDbException {

        List<Entity> result = new ArrayList<>();

        if (cursor.moveToFirst()) {

            do {
                //определяем переменные
                int id = cursor.getInt(cursor.getColumnIndex("ID"));
                String phoneNumber = cursor.getString(cursor.getColumnIndex("phoneNumber"));
                String fullName = cursor.getString(cursor.getColumnIndex("fullName"));
                String dateStr = cursor.getString(cursor.getColumnIndex("date"));
                Date date = FormatingDate.getDateAsDate(dateStr);
                int costUah = cursor.getInt(cursor.getColumnIndex("costUah"));
                int costUsd = cursor.getInt(cursor.getColumnIndex("costUsd"));
                String common = cursor.getString(cursor.getColumnIndex("common"));
                String cityDistrict = cursor.getString(cursor.getColumnIndex("cityDistrict"));
                String addresses = cursor.getString(cursor.getColumnIndex("addresses"));
                String distanceToCity = cursor.getString(cursor.getColumnIndex("distanceToCity"));
                String fullSquare = cursor.getString(cursor.getColumnIndex("fullSquare"));
                String communicationsList = cursor.getString(cursor.getColumnIndex("communicationsList"));
                String docs = cursor.getString(cursor.getColumnIndex("docs"));
                String docsList = cursor.getString(cursor.getColumnIndex("docsList"));
                String outbuildings = cursor.getString(cursor.getColumnIndex("outbuildings"));
                String buildingsList = cursor.getString(cursor.getColumnIndex("buildingsList"));
                String typeOfArea = cursor.getString(cursor.getColumnIndex("typeOfArea"));

                //создаем объект класса EarthSell и добавляем его в список
                EarthSell earthSell = new EarthSell(id, phoneNumber, fullName, date, costUah, costUsd,
                        common, cityDistrict, addresses, distanceToCity, fullSquare, communicationsList,
                        docs, docsList, outbuildings, buildingsList, typeOfArea);

                result.add(earthSell);



            } while (cursor.moveToNext());
        }
        else {
            throw new NoSuchTableInDbException();
        }

        return result;
    }


    //метод возвращает список созданных объектов класса PrimSell на основе данных из БД
    private List<Entity> createPrimSellList(Cursor cursor) throws NoSuchTableInDbException {

        List<Entity> result = new ArrayList<>();

        if (cursor.moveToFirst()) {

            do {
                //определяем переменные
                int id = cursor.getInt(cursor.getColumnIndex("ID"));
                String phoneNumber = cursor.getString(cursor.getColumnIndex("phoneNumber"));
                String fullName = cursor.getString(cursor.getColumnIndex("fullName"));
                String dateStr = cursor.getString(cursor.getColumnIndex("date"));
                Date date = FormatingDate.getDateAsDate(dateStr);
                int costUah = cursor.getInt(cursor.getColumnIndex("costUah"));
                int costUsd = cursor.getInt(cursor.getColumnIndex("costUsd"));
                String common = cursor.getString(cursor.getColumnIndex("common"));
                String s = cursor.getString(cursor.getColumnIndex(""));

                //создаем объект класса PrimSell и добавляем его в список




            } while (cursor.moveToNext());
        }
        else {
            throw new NoSuchTableInDbException();
        }

        return result;
    }


    //метод возвращает список созданных объектов класса HouseSell на основе данных из БД
    private List<Entity> createHouseSellList(Cursor cursor) throws NoSuchTableInDbException {

        List<Entity> result = new ArrayList<>();

        if (cursor.moveToFirst()) {

            do {
                //определяем переменные
                int id = cursor.getInt(cursor.getColumnIndex("ID"));
                String phoneNumber = cursor.getString(cursor.getColumnIndex("phoneNumber"));
                String fullName = cursor.getString(cursor.getColumnIndex("fullName"));
                String dateStr = cursor.getString(cursor.getColumnIndex("date"));
                Date date = FormatingDate.getDateAsDate(dateStr);
                int costUah = cursor.getInt(cursor.getColumnIndex("costUah"));
                int costUsd = cursor.getInt(cursor.getColumnIndex("costUsd"));
                String common = cursor.getString(cursor.getColumnIndex("common"));
                String s = cursor.getString(cursor.getColumnIndex(""));

                //создаем объект класса HouseSell и добавляем его в список




            } while (cursor.moveToNext());
        }
        else {
            throw new NoSuchTableInDbException();
        }

        return result;
    }


}
