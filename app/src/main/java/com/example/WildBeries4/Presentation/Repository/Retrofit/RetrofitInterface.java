package com.example.WildBeries4.Presentation.Repository.Retrofit;

import com.example.WildBeries4.Domain.Model.PostPojo;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface RetrofitInterface {

    @GET("v1/supplier/stocks?dateFrom=2021-09-25T21:00:00.000Z&key=ODdmMzA2ZjYtMmQ0YS00Njk3LTk2M2UtYzY4NTBmYzBmN2Rl")
    public Call<List<PostPojo>> getPriceWb();
}
//eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY2Nlc3NJRCI6Ijk2NTQzMzNhLTlkNjYtNGQ3OS04MGE2LWMyZDVjMDI1ZDcwNiJ9.7eBij7yjTBxFVrJISn2nCI-rIC_JH09C8ZVmoDHv4lw