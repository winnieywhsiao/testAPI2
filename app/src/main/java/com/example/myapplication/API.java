package com.example.myapplication;

import java.sql.SQLTransactionRollbackException;
import java.util.List;
import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.Call;
import retrofit2.http.QueryMap;

public interface API {
    @GET("User")
    Call<ListRes> getUser(@QueryMap(encoded = true) Map<String, String> queryMap);

    @POST("User?api_key=key5hoPQlXIf5ig6M")
    Call<Res> postUser(@Body Req req);
}
