package com.example.WildBeries4.Presentation.Repository.Retrofit;

import com.example.WildBeries4.Domain.Model.PostPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class NetworkService {
    private static NetworkService mInstance;
    private static final String BASE_URL = "https://suppliers-stats.wildberries.ru/api/";
    private Retrofit mRetrofit;

    private NetworkService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkService getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkService();
        }
        return mInstance;
    }

    public RetrofitInterface getJSONApi() {
        return mRetrofit.create(RetrofitInterface.class);
    }
}

