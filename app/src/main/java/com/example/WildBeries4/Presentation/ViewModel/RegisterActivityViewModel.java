package com.example.WildBeries4.Presentation.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.WildBeries4.Domain.Model.UsersDTO;
import com.example.WildBeries4.Presentation.Repository.Room.StatisticRepository;

public class RegisterActivityViewModel extends AndroidViewModel {
    private StatisticRepository mRepository;

    public RegisterActivityViewModel(@NonNull Application application) {
        super(application);
        mRepository = new StatisticRepository(application);
    }

    public void addUser (UsersDTO usersDTO){mRepository.addUser(usersDTO);}

}
