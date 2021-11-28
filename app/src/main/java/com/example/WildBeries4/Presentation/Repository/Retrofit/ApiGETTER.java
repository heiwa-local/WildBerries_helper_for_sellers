package com.example.WildBeries4.Presentation.Repository.Retrofit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.WildBeries4.Domain.Model.PostPojo;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ApiGETTER {
    PostPojo postPojo1;
    List<PostPojo> postPojo;
    LiveData<List<PostPojo>> postPojoMLD;
    int i = 0;

    public LiveData<List<PostPojo>> getListFromWB() {
        MutableLiveData<List<PostPojo>> postPojoMLD = new MutableLiveData<>();
        NetworkService.getInstance()
                .getJSONApi()
                .getPriceWb().enqueue(new Callback<List<PostPojo>>() {
            @Override
            public void onResponse(Call<List<PostPojo>> call, Response<List<PostPojo>> response) {
                postPojo = response.body();
                postPojoMLD.setValue(postPojo);
            }

            @Override
            public void onFailure(Call<List<PostPojo>> call, Throwable t) {
                int i = 0;
            }
        });
        return postPojoMLD;
    }
    public LiveData<PostPojo> getPostPojoFromWB(int pos) {
        MutableLiveData<PostPojo> postPojoMLD = new MutableLiveData<>();
        NetworkService.getInstance()
                .getJSONApi()
                .getPriceWb().enqueue(new Callback<List<PostPojo>>() {
            @Override
            public void onResponse(Call<List<PostPojo>> call, Response<List<PostPojo>> response) {
                postPojo1 = response.body().get(pos);
                postPojoMLD.setValue(postPojo1);
            }

            @Override
            public void onFailure(Call<List<PostPojo>> call, Throwable t) {
                int i = 0;
            }
        });
        return postPojoMLD;
    }
}
