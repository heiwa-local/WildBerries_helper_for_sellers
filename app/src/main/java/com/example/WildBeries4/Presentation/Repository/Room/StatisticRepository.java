package com.example.WildBeries4.Presentation.Repository.Room;


import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.WildBeries4.Domain.Model.Statistic;
import com.example.WildBeries4.Domain.Model.UsersDTO;
import com.example.WildBeries4.Presentation.Repository.Room.DAO.StatisticDAO;

import java.util.List;

public class StatisticRepository {
    private StatisticDAO m1name;

    private LiveData<List<Statistic>> AllStatistic;
    private LiveData<List<UsersDTO>> AllUsers;

    private LiveData<Statistic> statistic;
    private LiveData<UsersDTO> users;

    public StatisticRepository(Application application) {
        StatisticRoomDatabase db = StatisticRoomDatabase.getDatabase(application);
        m1name = db.StatisticDao();
        AllStatistic = m1name.getStatistic();
        AllUsers = m1name.getAllUsers();
    }

    //STATISTIC

    public LiveData<List<Statistic>> getAllStatistic() {
        return AllStatistic;
    }

    public void insert(Statistic name) {
        StatisticRoomDatabase.databaseWriteExecutor.execute(() -> {
            m1name.insert(name);
        });
    }

    public void deleteByName(String name, long id){
        StatisticRoomDatabase.databaseWriteExecutor.execute(() -> {
            m1name.deleteByNameAndId(name,id);
        });
    }
    public LiveData<Double> getTotalSum(){
        return m1name.getTotalSum();
    }

    public LiveData<Integer> getTotalVolume(){ return m1name.getTotalVolume();}

    public LiveData<Statistic> getByName(String name){
        return m1name.getByName(name);
    }

    //USERS

    public LiveData<List<UsersDTO>> getAllUsers(){ return m1name.getAllUsers();}

    public LiveData<UsersDTO> getUserByEmailAndPassword(String email, String password){ return m1name.getUserByEmailAndPassword(email, password);}

    public LiveData<UsersDTO> getUserByEmailAndRole (String email, String role){ return  m1name.getUserByEmailAndRole(email,role);}

    public void deleteAllUsers(){
        StatisticRoomDatabase.databaseWriteExecutor.execute(() -> {
            m1name.deleteAllUsers();
        });
    }
    public void addUser (UsersDTO usersDTO){
        StatisticRoomDatabase.databaseWriteExecutor.execute(() -> {
        m1name.addUser(usersDTO);
    });}
}
