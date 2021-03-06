package com.example.WildBeries4.Presentation.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.WildBeries4.Domain.Model.PostPojo;
import com.example.WildBeries4.Domain.Model.Statistic;
import com.example.WildBeries4.Presentation.Repository.Retrofit.ApiGETTER;
import com.example.WildBeries4.Presentation.Repository.Room.StatisticRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel implements LifecycleOwner {
    private StatisticRepository mRepository;
    private ApiGETTER mApiGETTER;
    public LiveData<List<Statistic>> statistic;
    public List<Statistic> statisticsList;

    public MainActivityViewModel(Application application) {
        super(application);
        mRepository = new StatisticRepository(application);
        mApiGETTER = new ApiGETTER();

    }
    public LiveData<Double> allSupply(){
        return mRepository.getTotalSum();
    }

    public LiveData<Integer> getTotalVolume(){return  mRepository.getTotalVolume();}

    public LiveData<List<PostPojo>> getListFromWB(){
        return  mApiGETTER.getListFromWB();
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return null;
    }
}
