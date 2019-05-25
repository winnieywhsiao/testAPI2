package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class postActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API api = retrofit.create(API.class);
        Map<String, String> map = new HashMap<>();

        map.put("api_key", Config.API_KEY);
        map.put("view", "Grid%20view");
        map.put("pageSize", "10");
        USER user =  new USER("a111@gmail.com","1234");
        Call<Res> call = api.postUser(new Req(user));

        call.enqueue(new Callback<Res>() {
            @Override
            public void onResponse(Call<Res> call, Response<Res> response) {
                if(response.isSuccessful()){
                    Res res = response.body();

                    Log.e("MainActivity", response.raw() + "");
                }else{
                    Log.e("MainActivity", response.code() + "");
                    Log.e("MainActivity", "Connect Error");
                    Log.e("MainActivity", response.raw() + "");
                }
            }

            @Override
            public void onFailure(Call<Res> call, Throwable t) {
                Log.d("emails", "not connected");
            }
        });
    }
}
