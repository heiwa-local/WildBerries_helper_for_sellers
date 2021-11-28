package com.example.WildBeries4.Presentation.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.WildBeries4.Domain.Model.PostPojo;
import com.example.WildBeries4.Domain.Model.Statistic;
import com.example.WildBeries4.Presentation.Repository.Retrofit.ApiGETTER;
import com.example.WildBeries4.Presentation.Repository.Room.StatisticRepository;

import java.util.List;

public class OpenPostPojoViewModel extends AndroidViewModel {

    private StatisticRepository mRepository;
    private ApiGETTER mApiGETTER;
    private LiveData<PostPojo> statistic;
    private final LiveData<List<PostPojo>> AllStatistic;

    public OpenPostPojoViewModel(Application application) {
        super(application);
        mRepository = new StatisticRepository(application);
        mApiGETTER = new ApiGETTER();
        AllStatistic = mApiGETTER.getListFromWB();
    }
    public LiveData<List<PostPojo>> getListFromWB(){
        return  mApiGETTER.getListFromWB();
    }
    public LiveData<PostPojo> getPostPojoFromWB(int position){
        return mApiGETTER.getPostPojoFromWB(position);
    }

}
