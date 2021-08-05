package com.example.usrrighmvvmpractic.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static String BASEURL="https://balicuat.bajajallianz.com/";

    private static Retrofit retrofit=null;

    public static Retrofit getRetrofit(){

        if (retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
