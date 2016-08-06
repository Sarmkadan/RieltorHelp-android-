package com.example.gsontest.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Андрей on 03.08.2016.
 */
public class DataDTO {

    private String about;
    private String fio;
    private String phone;


    private Map<String, Object> otherProperties = new HashMap<String, Object>();

    public DataDTO() {

    }

    public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {

            this.phone = phone;
        }

        public String getFio() {
            return fio;
        }

        public void setFio(String fio) {
            this.fio = fio;
        }

        public String getAbout() {
            return about;
        }

        public void setAbout(String about) {
            this.about = about;
        }
    public Object get(String name) {
        return otherProperties.get(name);
    }
}
