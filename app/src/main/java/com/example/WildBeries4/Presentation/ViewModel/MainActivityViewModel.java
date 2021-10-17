package com.example.WildBeries4.Presentation.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.WildBeries4.Domain.Model.Statistic;
import com.example.WildBeries4.Presentation.Repository.Room.StatisticRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel implements LifecycleOwner {
    private StatisticRepository mRepository;
    public LiveData<List<Statistic>> statistic;
    public List<Statistic> statisticsList;

    public MainActivityViewModel(Application application) {
        super(application);
        mRepository = new StatisticRepository(application);
    }
    public LiveData<Double> allSupply(){
        return mRepository.getTotalSum();
    }

    public LiveData<Integer> getTotalVolume(){return  mRepository.getTotalVolume();}

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return null;
    }
}
