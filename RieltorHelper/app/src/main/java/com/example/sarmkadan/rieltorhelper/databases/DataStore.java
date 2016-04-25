package com.example.sarmkadan.rieltorhelper.databases;


import android.database.sqlite.SQLiteDatabase;

import com.example.sarmkadan.rieltorhelper.databases.dbExceptions.NoSuchTableInDbException;
import com.example.sarmkadan.rieltorhelper.entities.ArendRoom;

import java.util.ArrayList;

/**
 * Created by Abilis on 25.04.2016.
 */

//эта штука будет определять методы, которые должны быть реализованы в классе DbHelper
public interface DataStore {

    //метод возращает список объектов класса ArendRoom
    public ArrayList<ArendRoom> getArendRoom(SQLiteDatabase db) throws NoSuchTableInDbException;

}
