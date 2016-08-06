package com.example.sarmkadan.rieltorhelper.utils;

import android.util.Log;


import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;



/**
 * Created by cav on 26.04.16.
 */

public class HttpRequest {
    private final static String LOG_TAG="syncHTTPRequest";

    public static String getRequest(String urlRequest){
        StringBuilder allpage = new StringBuilder();
        try{
            URLConnection conn = new URL(urlRequest).openConnection();
            InputStreamReader rd = new InputStreamReader(conn.getInputStream());

            int n = 0;
            char[] buffer = new char[40000];
            while ((n=rd.read(buffer,0,buffer.length))!=-1){
                allpage.append(buffer,0,n);
            }
            rd.close();
        }catch (Exception e){
            Log.d(LOG_TAG,e.getMessage());
            return "Error: "+e.getLocalizedMessage();

        }

        return allpage.toString();
    }
}
