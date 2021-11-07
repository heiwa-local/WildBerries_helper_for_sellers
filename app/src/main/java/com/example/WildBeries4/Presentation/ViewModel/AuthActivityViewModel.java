package com.example.WildBeries4.Presentation.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.WildBeries4.Domain.Model.UsersDTO;
import com.example.WildBeries4.Presentation.Repository.Room.StatisticRepository;


public class AuthActivityViewModel extends AndroidViewModel {

    private StatisticRepository mRepository;

    public AuthActivityViewModel(@NonNull Application application) {
        super(application);
        mRepository = new StatisticRepository(application);
    }

    public LiveData<UsersDTO> getUserByEmailAndPassword(String email, String password){
        return mRepository.getUserByEmailAndPassword(email, password);
    }

    public LiveData<UsersDTO> getUserByEmailAndRole(String email, String role){
        return mRepository.getUserByEmailAndRole(email, role);
    }
    public void deleteAllUsers (){ mRepository.deleteAllUsers();}

    public void addUser (UsersDTO usersDTO){mRepository.addUser(usersDTO);}

}
