package com.example.WildBeries4.Presentation.Repository.Room;


import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.WildBeries4.Domain.Model.Statistic;
import com.example.WildBeries4.Presentation.Repository.Room.DAO.StatisticDAO;

import java.util.List;

public class StatisticRepository {
    private StatisticDAO m1name;
    private LiveData<List<Statistic>> AllStatistic;

    public StatisticRepository(Application application) {
        StatisticRoomDatabase db = StatisticRoomDatabase.getDatabase(application);
        m1name = db.StatisticDao();
        AllStatistic = m1name.getStatistic();
    }
    public LiveData<List<Statistic>> getAllStatistic() {
        return AllStatistic;
    }
    public void insert(Statistic name) {
        StatisticRoomDatabase.databaseWriteExecutor.execute(() -> {
            m1name.insert(name);
        });
    }
}
