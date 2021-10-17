package com.example.WildBeries4.Presentation.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.WildBeries4.Domain.Model.Statistic;
import com.example.WildBeries4.Presentation.Repository.Room.StatisticRepository;
import com.example.WildBeries4.Presentation.View.NewStatisticActivity;

import java.util.List;

public class StatisticViewModel extends AndroidViewModel {

    private StatisticRepository mRepository;

    private final LiveData<List<Statistic>> AllStatistic;

    public StatisticViewModel(Application application) {
        super(application);
        mRepository = new StatisticRepository(application);
        AllStatistic = mRepository.getAllStatistic();
    }
    public LiveData<List<Statistic>> getAllStatistic(){return AllStatistic;}

    public void insert(Statistic name){mRepository.insert(name);}
    public void deleteByName(String name, long id){
        mRepository.deleteByName(name, id);
    }
}
