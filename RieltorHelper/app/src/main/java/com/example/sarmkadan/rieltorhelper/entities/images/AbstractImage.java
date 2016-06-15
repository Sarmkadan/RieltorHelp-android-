package com.example.sarmkadan.rieltorhelper.entities.images;

/**
 * Created by Admin on 27.04.2016.
 */
public abstract class AbstractImage {

    private int id;
    private String title;
    private int linkedId;

    public AbstractImage(int id, String title, int linkedId) {
        this.id = id;
        this.title = title;
        this.linkedId = linkedId;
    }
}
