package com.example.sarmkadan.rieltorhelper.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Admin on 25.04.2016.
 */
public class FormatingDate {

    //формат даты dd:MM:yyyy
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd:MM:yyyy");

    private FormatingDate() {
    }

    //метод возвращает строковое представление даты в формате
    public static String getDateAsStr(Date date) {

        String result = simpleDateFormat.format(date);

        return result;
    }

    //метод возвращает представление даты в формате Date
    public static Date getDateAsDate(String str) {

        Date result;
        try {
            result = simpleDateFormat.parse(str);
        } catch (ParseException e) {
            result = new Date();
        }

        return result;
    }
}
