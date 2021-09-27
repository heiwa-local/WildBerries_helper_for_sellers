package com.example.WildBeries4.Presentation.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.WildBeries4.Domain.Model.Statistic;
import com.example.WildBeries4.Presentation.Repository.Room.StatisticRepository;

import java.util.List;

public class OpenStatisticViewModel extends AndroidViewModel {

    private StatisticRepository mRepository;
    private Statistic statistic;
    private final LiveData<List<Statistic>> AllStatistic;

    public OpenStatisticViewModel(Application application) {
        super(application);
        mRepository = new StatisticRepository(application);

        AllStatistic = mRepository.getAllStatistic();
    }
    public Statistic getByName(String name){
        statistic = mRepository.getByName(name);
        return statistic;
    }
}
