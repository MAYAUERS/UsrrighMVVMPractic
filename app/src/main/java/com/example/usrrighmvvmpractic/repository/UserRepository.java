package com.example.usrrighmvvmpractic.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.usrrighmvvmpractic.model.SucessResponse;
import com.example.usrrighmvvmpractic.network.APIInterface;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserRepository {

    private static String BASEURL="https://balicuat.bajajallianz.com/";

    //https://balicuat.bajajallianz.com/INSTAB/ws/api/usright
    private static Retrofit retrofit;
    private MutableLiveData<SucessResponse> mutableLiveData;

    APIInterface apiInterface;

    public UserRepository() {
       /* mutableLiveData = new MutableLiveData<>();

        apiInterface=new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(APIInterface.class);*/

        mutableLiveData= new MutableLiveData<>();

        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client=new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        apiInterface=new retrofit2.Retrofit.Builder()
                .baseUrl(BASEURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(APIInterface.class);

    }


    public void getApi(){

        //"p_in_obj":{"stringval34":"INSTAB","stringval30":"9.29","stringval1":"358525086570839"}}
        JSONObject jsonObject=new JSONObject();
        JSONObject jsonObject1=new JSONObject();
        JsonObject jsonObject2=new JsonObject();

        try {
            jsonObject1.put("stringval34","INSTAB");
            jsonObject1.put("stringval30","9.29");
            jsonObject1.put("stringval1","358525086570839");
            jsonObject.put("p_in_obj",jsonObject1);

            JsonParser jsonParser=new JsonParser();
            jsonObject2=(JsonObject)jsonParser.parse(jsonObject.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }


       /* apiInterface.getAPICall(jsonObject2).enqueue(new Callback<SucessResponse>() {
            @Override
            public void onResponse(Call<SucessResponse> call, Response<SucessResponse> response) {
                mutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<SucessResponse> call, Throwable t) {
                mutableLiveData.postValue(null);
            }
        });*/

        apiInterface.getAPICall(jsonObject2).enqueue(new Callback<SucessResponse>() {
            @Override
            public void onResponse(Call<SucessResponse> call, Response<SucessResponse> response) {
                if (response.body()!= null){
                    mutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<SucessResponse> call, Throwable t) {
                mutableLiveData.postValue(null);
            }
        });
    }

   public LiveData<SucessResponse> getAPILiveDatafromRepository(){
        return mutableLiveData;
   }
}
