package com.example.usrrighmvvmpractic.network;

import com.example.usrrighmvvmpractic.model.SucessResponse;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIInterface {



    //INSTAB/ws/api/usright

    @POST("INSTAB/ws/api/usright")
    Call<SucessResponse>getAPICall(@Body JsonObject jsonObject);
}
