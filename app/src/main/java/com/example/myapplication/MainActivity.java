package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    //private TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //text1 = (TextView) findViewById(R.id.text1);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.airtable.com/v0/appmHyXJUc2VFZiPt/User?api_key=key5hoPQlXIf5ig6M")//Config.BASE_URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API api = retrofit.create(API.class); //創建請求API的client server : 連到API.java

        Map<String, String> map = new HashMap<>();

        map.put("api_key", Config.API_KEY);
        map.put("view", "Grid%20view");
        map.put("pageSize", "10");

        Call<ListRes> call = api.getUser(map);

        call.enqueue(new Callback<ListRes>() {
            @Override
            public void onResponse(Call<ListRes> call, Response<ListRes> response) {
                if(response.isSuccessful()){
                    //StringBuffer sb = new StringBuffer();
                    ListRes listRes = response.body();
                    List<Res> resList =  listRes.records;
                    for (Res h: resList){
                        String each = h.fields.getEmail();

                        if(each.equals("sa@gmail.com")){
                            //Intent intent=new Intent();intent.setClass(MainActivity.this,postActivity.class);
                            Log.v("MainActivity" , "[Email] " + each);}
                    }
                    Log.e("MainActivity", response.raw() + "");
                }else{
                    Log.e("MainActivity", response.code() + "");
                    Log.e("MainActivity", "Connect Error");
                    Log.e("MainActivity", response.raw() + "");
                }
            }

            @Override
            public void onFailure(Call<ListRes> call, Throwable t) {
                Log.d("emails", "not connected");

            }
        });
    }
}
