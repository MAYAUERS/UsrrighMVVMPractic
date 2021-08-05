package com.example.usrrighmvvmpractic.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.usrrighmvvmpractic.R;
import com.example.usrrighmvvmpractic.model.SucessResponse;
import com.example.usrrighmvvmpractic.network.APIInterface;
import com.example.usrrighmvvmpractic.network.ApiClient;
import com.example.usrrighmvvmpractic.viewModel.UserViewModel;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    Button button;
    TextView textView;

    UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.txt_1);
        button=findViewById(R.id.but_1);

        userViewModel=new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.init();
        userViewModel.getLiveData().observe(this, new Observer<SucessResponse>() {
            @Override
            public void onChanged(SucessResponse sucessResponse) {
                textView.setText(sucessResponse.getpInObj().getStringval10().toString());
            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userViewModel.getAllData();
            }
        });


        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callAPI();

            }
        });*/
    }

    private void callAPI() {

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

        APIInterface apiInterface=ApiClient.getRetrofit().create(APIInterface.class);
        Call<SucessResponse> call=apiInterface.getAPICall(jsonObject2);

        call.enqueue(new Callback<SucessResponse>() {
            @Override
            public void onResponse(Call<SucessResponse> call, Response<SucessResponse> response) {
                textView.setText(response.body().getpInObj().getStringval10().toString());
            }

            @Override
            public void onFailure(Call<SucessResponse> call, Throwable t) {
                textView.setText(t.getMessage().toString());
            }
        });
    }
}
