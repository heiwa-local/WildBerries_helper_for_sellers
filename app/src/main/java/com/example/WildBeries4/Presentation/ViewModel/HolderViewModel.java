package com.example.WildBeries4.Presentation.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.WildBeries4.Presentation.Repository.Room.StatisticRepository;

public class HolderViewModel extends AndroidViewModel {
    private StatisticRepository mRepository;


    public HolderViewModel(@NonNull Application application) {
        super(application);
        mRepository = new StatisticRepository(application);
    }

}
