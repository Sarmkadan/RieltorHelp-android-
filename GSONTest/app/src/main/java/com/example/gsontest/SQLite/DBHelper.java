package com.example.gsontest.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Андрей on 04.08.2016.
 */
public class DBHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "rieltorsDB";
    public static final String TABLE_RIELTORS = "rieltors";
    public static final String KEY_FIO = "fio";
    public static final String KEY_PHONE = "phone";
    public static final String KEY_ABOUT = "about";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_RIELTORS + "(" + KEY_FIO + " text,"+
         KEY_PHONE + " text,"+KEY_ABOUT+" text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + TABLE_RIELTORS);

        onCreate(sqLiteDatabase);

    }
}
