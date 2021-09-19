package com.example.WildBeries4.Presentation.Repository.Room.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.WildBeries4.Domain.Model.Statistic;

import java.util.List;

@Dao
public interface StatisticDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Statistic statistic);

    @Query("DELETE FROM Statistic")
    void deleteAll();

    @Query("SELECT * FROM Statistic ORDER BY name ASC")
    LiveData<List<Statistic>> getStatistic();
}
