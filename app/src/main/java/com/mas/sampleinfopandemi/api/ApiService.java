package com.mas.sampleinfopandemi.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.mas.sampleinfopandemi.api.Api.BASE_URL;

public class ApiService {

    public static Retrofit getRetrofitService(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
