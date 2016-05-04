package com.example.sarmkadan.rieltorhelper.utils;

/**
 * Created by Kotov Alexandr on 04.05.16.
 */

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class RestWorker {
    /*
      Рыба для обработки Rest
     */
    HttpClient httpclient;

    public void RestWorker(){
        httpclient = new DefaultHttpClient();

    }
    public void GetRest(){
        HttpGet httpget = new HttpGet("http://kempir.com/testrest");

    }
    public void PostRest(){

    }
    public void PutRest(){

    }
    public void DeleteRest(){

    }
}
