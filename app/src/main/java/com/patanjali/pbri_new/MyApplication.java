package com.patanjali.pbri_new;

import android.app.Application;
import android.net.http.RequestQueue;

public class MyApplication extends Application {

    private static MyApplication mInstance;
    private RequestQueue mRequestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }
}