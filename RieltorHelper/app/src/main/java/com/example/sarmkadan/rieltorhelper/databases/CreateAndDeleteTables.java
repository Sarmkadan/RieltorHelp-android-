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
    private static final String CREATE_AREND_IMAGE = "CREATE TABLE ArendImage (ID INTEGER PRIMARY" +
            " KEY AUTOINCREMENT NOT NULL, Картинка BLOB, Назва STRING, ArendID INTEGER REFERENCES" +
            " Arend (ID) ON DELETE CASCADE);";
    private static final String CREATE_AREND_ROOM = "CREATE TABLE ArendRoom (ID INTEGER PRIMARY KEY" +
            " AUTOINCREMENT UNIQUE NOT NULL, Телефон STRING (0, 30), ПІБ STRING, Дата_появи STRING," +
            " Тип_Оренди STRING, Кількість_Кімнат STRING, Район STRING, Адреса STRING, Поверх STRING," +
            " Площа STRING, Стан STRING, Опалення STRING, Меблі STRING, Меблі_список STRING," +
            " Побутова_техніка STRING, Список_техніки STRING, Тип_Заселення STRING, Тип_Кімнати STRING," +
            " Для_кого STRING, ЦінаГРН INTEGER, ЦінаДол INTEGER, Загальне STRING);";
    private static final String CREATE_EARTH_SELL_IMAGE = "CREATE TABLE EarthSellImage" +
            " (ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, Картинка BLOB, Назва STRING," +
            " EarthSellID INTEGER REFERENCES EarthSell (ID) ON DELETE CASCADE);";
    private static final String CREATE_KV_SELL = "CREATE TABLE KVsell (ID INTEGER PRIMARY KEY AUTOINCREMENT" +
            " UNIQUE NOT NULL, Телефон STRING, ПІБ STRING, Дата_появи STRING, Район STRING, Адреса STRING," +
            " Кількість_кімнат STRING, Кількість_поверхів STRING, Тип_ринку STRING, Тип_будинку STRING," +
            " Загальна_площа STRING, Площа_житлова STRING, Площа_кухні STRING, Опалення STRING," +
            " Стан_квартири STRING, Меблі STRING, ЦінаГРН INTEGER, ЦінаДол INTEGER, Загальне STRING);";
    private static final String CREATE_AREND_PRIM_IMAGE = "CREATE TABLE ArendPrimImage (ID INTEGER PRIMARY KEY" +
            " AUTOINCREMENT NOT NULL, Картинка BLOB, Назва STRING, ArendPrimID INTEGER REFERENCES" +
            " ArendPrim (ID) ON DELETE CASCADE);";
    private static final String CREATE_PRIM_SELL_IMAGE = "CREATE TABLE PrimSellImage (ID INTEGER PRIMARY KEY" +
            " AUTOINCREMENT NOT NULL, Картинка BLOB, Назва STRING, PrimSellID INTEGER REFERENCES" +
            " PrimSell (ID) ON DELETE CASCADE);";
    private static final String CREATE_AREND_ROOM_IMAGE = "CREATE TABLE ArendRoomImage (ID INTEGER PRIMARY KEY" +
            " AUTOINCREMENT NOT NULL, Картинка BLOB, Назва STRING, ArendRoomID INTEGER REFERENCES" +
            " ArendRoom (ID) ON DELETE CASCADE);";
    private static final String CREATE_AREND = "CREATE TABLE Arend (ID INTEGER PRIMARY KEY AUTOINCREMENT" +
            " UNIQUE NOT NULL, Телефон STRING, ПІБ STRING, Дата_появи STRING, Кількість_кімнат STRING," +
            " Тип_обєкту STRING, Район STRING, Адреса STRING, Поверх STRING, Площа STRING, Стан STRING," +
            " Опалення STRING, Меблі STRING, Список_меблів STRING, Побутова_техніка STRING," +
            " Список_техніки STRING, ЦінаГРН INTEGER, ЦінаДол INTEGER, Загальне STRING);";
    private static final String CREATE_HOSTEL_SELL = "CREATE TABLE HostelSell (ID INTEGER PRIMARY KEY AUTOINCREMENT" +
            " UNIQUE NOT NULL, Телефон STRING, ПІБ STRING, Дата_появи STRING, Район STRING, Адреса STRING," +
            " Система_гуртожитку STRING, Кількість_поверхів STRING, Тип_будинку STRING, Загальна_площа" +
            " STRING, Стан STRING, Опалення STRING, Наявність_меблів STRING, ЦінаГРН INTEGER, ЦінаДол" +
            " INTEGER, Загальне STRING);";
    private static final String CREATE_KV_SELL_IMAGE = "CREATE TABLE KVsellImage (ID INTEGER PRIMARY KEY" +
            " AUTOINCREMENT NOT NULL, Картинка BLOB, Назва STRING, KVsellID INTEGER REFERENCES KVsell" +
            " (ID) ON DELETE CASCADE);";
    private static final String CREATE_EARTH_SELL = "CREATE TABLE EarthSell (ID INTEGER PRIMARY KEY" +
            " AUTOINCREMENT UNIQUE NOT NULL, Телефон STRING, ПІБ STRING, Дата_появи STRING," +
            " Райони_Терн_обл STRING, Адреса STRING, Відстань_км INTEGER, Загальна_площа STRING," +
            " Комунікації_список STRING, Документи STRING, Документи_список STRING, Господарскі_будівлі" +
            " STRING, Господарскі_будівлі_список STRING, Тип_Ділянки STRING, ЦінаГРН INTEGER," +
            " ЦінаДол INTEGER, Загальне STRING);";
    private static final String CREATE_AREND_PRIM = "CREATE TABLE ArendPrim (ID INTEGER PRIMARY KEY" +
            " AUTOINCREMENT UNIQUE NOT NULL, Телефон STRING, ПІБ STRING, Дата_появи STRING," +
            " Район STRING, Адреса STRING, Тип_Ринку STRING, Вид_Приміщення STRING, Тип_обєкту STRING," +
            " Розташування STRING, Кільк_Поверхів STRING, Площа STRING, Кількість_Кімнат STRING," +
            " Стан STRING, Опалення STRING, ЦінаГРН INTEGER, ЦінаДол INTEGER, Загальне STRING);";
    private static final String CREATE_HOSTEL_SELL_IMAGE = "CREATE TABLE HostelSellImage (ID INTEGER" +
            " PRIMARY KEY AUTOINCREMENT NOT NULL, Картинка BLOB, Назва STRING, HostelSellID INTEGER" +
            " REFERENCES HostelSell (ID) ON DELETE CASCADE);";
    private static final String CREATE_PRIM_SELL = "CREATE TABLE PrimSell (ID INTEGER PRIMARY KEY" +
            " AUTOINCREMENT UNIQUE NOT NULL, Телефон STRING, ПІБ STRING, Дата_появи STRING, Район STRING," +
            " Адреса STRING, Тип_Ринку STRING, Вид_приміщення STRING, Тип_обєкту STRING," +
            " Розташування STRING, Кільк_поверхів STRING, Площа STRING, Кількість_Кімнат STRING," +
            " Стан STRING, Опалення STRING, ЦінаГРН INTEGER, ЦінаДол INTEGER, Загальне STRING);";
    private static final String CREATE_HOUSE_SELL = "CREATE TABLE HouseSell (ID INTEGER PRIMARY KEY" +
            " AUTOINCREMENT UNIQUE NOT NULL, Телефон STRING, ПІБ STRING, Дата_появи STRING," +
            " Райони_Терн_обл STRING, Повна_адреса STRING, Віддаль_від_міста INTEGER," +
            " Площа_землі STRING, Площа_будинку STRING, Тип_будинку STRING, Господарські_будівлі_список" +
            " STRING, Комунікації STRING, Список_комунікацій STRING, Документи STRING, Документи_список" +
            " STRING, ЦінаГРН INTEGER, ЦінаДол INTEGER, Загальне STRING);";
    private static final String CREATE_HOUSE_SELL_IMAGE = "CREATE TABLE HouseSellImage (ID INTEGER" +
            " PRIMARY KEY AUTOINCREMENT NOT NULL, Картинка BLOB, Назва STRING, houseSellID INTEGER" +
            " REFERENCES HouseSell (ID) ON DELETE CASCADE);";


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
