package com.patanjali.pbri_new.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by amit on 20/9/18.
 */

public class RetrofitClientInstance {


    private static Retrofit retrofit;
    private static final String BASE_URL = "http://1.6.145.44/farmers_project/index.php/";

      static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public static ApiInterface getApiClient(){
        return  getRetrofitInstance().create(ApiInterface.class);
    }
}
