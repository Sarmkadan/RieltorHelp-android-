package com.example.sarmkadan.rieltorhelper.utils;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by cav on 26.04.16.
 */
public class HttpRequest {

    public static String getRequest(String urlRequest){
        try{
            URL url = new URL(urlRequest);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new InputSource(url.openStream()));
            doc.getDocumentElement().normalize();

        }catch (Exception e){
            return "Error: "+e.getLocalizedMessage();

        }

        return null;
    }
}
