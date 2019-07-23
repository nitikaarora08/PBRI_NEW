package com.patanjali.pbri_new.service;

public class SingletonClass {
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    private double latitude, longitude;
    static private SingletonClass mInsatnce;

    private SingletonClass() {

    }

    synchronized public static SingletonClass getInstance() {
        if (mInsatnce == null)
            mInsatnce = new SingletonClass();
        return mInsatnce;
    }



}






