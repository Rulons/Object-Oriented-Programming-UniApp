package com.mycompany.klainsuniapp;

public class Hall {

    private String hallName;
    private String type;

    public Hall(String hallName, String type) {
        this.hallName = hallName;
        this.type = type;
    }

    public String getHallName() {
        return hallName;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return hallName + " (" + type + ")";
    }
}
