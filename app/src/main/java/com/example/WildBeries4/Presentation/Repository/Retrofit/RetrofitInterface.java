package com.example.WildBeries4.Presentation.Repository.Retrofit;

import com.example.WildBeries4.Domain.Model.PostPojo;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface RetrofitInterface {

    @GET("")
    public Call<List<PostPojo>> getPriceWb();
}
