package com.example.sarmkadan.rieltorhelper.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Abilis on 25.04.2016.
 */
public class DbHelper extends SQLiteOpenHelper implements DataStrore {

    private static final String DB_NAME = "RIELTOR";
    private static final int DB_VERSION = 1;

    



    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
