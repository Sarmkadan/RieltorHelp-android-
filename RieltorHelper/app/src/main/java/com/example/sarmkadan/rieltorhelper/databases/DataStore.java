package com.example.sarmkadan.rieltorhelper.databases;


import android.database.sqlite.SQLiteDatabase;

import com.example.sarmkadan.rieltorhelper.databases.dbExceptions.NoSuchTableInDbException;
import com.example.sarmkadan.rieltorhelper.entities.Entity;

import java.util.ArrayList;

/**
 * Created by Abilis on 25.04.2016.
 */

//эта штука будет определять методы, которые должны быть реализованы в классе DbHelper
public interface DataStore {

    //метод возращает список объектов класса Entity
    public ArrayList<Entity> getArendRoom(SQLiteDatabase db, String tableName) throws NoSuchTableInDbException;

}
