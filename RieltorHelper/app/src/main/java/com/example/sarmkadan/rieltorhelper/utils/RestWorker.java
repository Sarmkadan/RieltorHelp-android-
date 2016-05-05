package com.example.sarmkadan.rieltorhelper.utils;

/**
 * Created by Kotov Alexandr on 04.05.16.
 */

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class RestWorker {
    private final static String LOG_TAG="RestWorker";
    /*
      Рыба для обработки Rest
     */
    HttpClient httpclient;
    HttpResponse response;

    public void RestWorker(){
        httpclient = new DefaultHttpClient();

    }
    public String GetRest(){
        // запрашиваем список всех записей
        HttpGet httpget = new HttpGet("http://kempir.com/testrest/base/");
        try {
            response = httpclient.execute(httpget);
            HttpEntity httpEntity =response.getEntity();
            String line = EntityUtils.toString(httpEntity, "UTF-8");
            Log.d(LOG_TAG, line);
            return line;

        }catch (Exception e){
            Log.e(LOG_TAG,e.getMessage());
        }
        return null;
    }
    public void PostRest(){

    }
    public void PutRest(){

    }
    public void DeleteRest(){

    }
}
