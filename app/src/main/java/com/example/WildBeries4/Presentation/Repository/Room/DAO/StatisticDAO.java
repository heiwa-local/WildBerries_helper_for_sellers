package com.example.WildBeries4.Presentation.Repository.Room.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.WildBeries4.Domain.Model.Statistic;
import com.example.WildBeries4.Domain.Model.UsersDTO;

import java.util.List;

@Dao
public interface StatisticDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Statistic statistic);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertUser(UsersDTO usersDTO);

    @Query("DELETE FROM Statistic")
    void deleteAll();

    @Query("SELECT * FROM Statistic ORDER BY name ASC")
    LiveData<List<Statistic>> getStatistic();

    @Query("SELECT * FROM statistic WHERE name = :name")
    LiveData<Statistic> getByName(String name);

    @Query("DELETE FROM statistic WHERE name = :name AND id = :id")
    void deleteByNameAndId(String name,long id);

    @Query("SELECT SUM(fullPrice) as total FROM statistic")
    LiveData<Double> getTotalSum();

    @Query("SELECT SUM(volume) as total FROM statistic")
    LiveData<Integer> getTotalVolume();

    //USERS TABLE

    @Query("SELECT * FROM Users ORDER BY firstName ASC")
    LiveData<List<UsersDTO>> getAllUsers();

    @Query("SELECT * FROM Users WHERE email = :email AND password = :password")
    LiveData<UsersDTO> getUserByEmailAndPassword(String email, String password);

    @Query("SELECT * FROM Users WHERE email = :email AND role = :role")
    LiveData<UsersDTO> getUserByEmailAndRole(String email, String role);

    @Query("DELETE FROM Users")
    void deleteAllUsers();
    @Insert
    void addUser(UsersDTO usersDTO);
}
