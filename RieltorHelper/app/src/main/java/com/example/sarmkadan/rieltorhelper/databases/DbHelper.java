package com.example.sarmkadan.rieltorhelper.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Abilis on 25.04.2016.
 */
public class DbHelper extends SQLiteOpenHelper implements DataStore {

    private static final String DB_NAME = "RIELTOR";
    private static final int DB_VERSION = 3;
    private final String TAG = "Sqlite";




    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
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
}
