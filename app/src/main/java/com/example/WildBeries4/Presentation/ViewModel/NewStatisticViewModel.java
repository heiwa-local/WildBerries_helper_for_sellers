package com.example.WildBeries4.Presentation.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.WildBeries4.Domain.Model.Statistic;
import com.example.WildBeries4.Presentation.Repository.Room.StatisticRepository;

import java.util.List;

public class NewStatisticViewModel extends AndroidViewModel {
    private StatisticRepository mRepository;

    public NewStatisticViewModel(Application application) {
        super(application);
    }
    public void insert(Statistic name){mRepository.insert(name);}

}
