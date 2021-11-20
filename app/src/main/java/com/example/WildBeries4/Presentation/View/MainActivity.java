package com.example.WildBeries4.Presentation.View;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.WildBeries4.Domain.Model.PostPojo;
import com.example.WildBeries4.Domain.Model.Statistic;
import com.example.WildBeries4.Presentation.Repository.Retrofit.ApiGETTER;
import com.example.WildBeries4.Presentation.Repository.Retrofit.NetworkService;
import com.example.WildBeries4.Presentation.Repository.Retrofit.NetworkService;
import com.example.WildBeries4.Presentation.Repository.Retrofit.RetrofitInterface;
import com.example.WildBeries4.Presentation.Repository.Room.StatisticRoomDatabase;
import com.example.WildBeries4.Presentation.View.Adapters.StatisticListAdapter;
import com.example.WildBeries4.Presentation.View.Adapters.StatisticListAdapter.StatisticDiff;
import com.example.WildBeries4.Presentation.ViewModel.MainActivityViewModel;
import com.example.WildBeries4.Presentation.ViewModel.StatisticViewModel;
import com.example.WildBeries4.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static final int NEW_STATISTIC_ACTIVITY_REQUEST_CODE = 1;
    private Statistic statistic;
    private LiveData<Statistic> statisticLiveData;
    private StatisticViewModel mStatisticViewModel;
    private MainActivityViewModel mMainActivityViewModel;
    private static volatile StatisticRoomDatabase INSTANCE;
    private LiveData<List<PostPojo>> postPojo;
    private PostPojo onePostPojo;

    String allSum;
    double allTotalSum;
    TextView tvTotalSum;
    TextView tvTotalVolume;
    Button btnConverter;
    TextView tv11tv11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final StatisticListAdapter adapter = new StatisticListAdapter(new StatisticListAdapter.StatisticDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mStatisticViewModel = new ViewModelProvider(this).get(StatisticViewModel.class);
        mMainActivityViewModel = new MainActivityViewModel(new Application());
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, NewStatisticActivity.class);
            startActivityForResult(intent, NEW_STATISTIC_ACTIVITY_REQUEST_CODE);
        });
        mStatisticViewModel.getAllStatistic().observe(this, statistics -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(statistics);

        });
        tvTotalSum = findViewById(R.id.tvTotalSum);
        tvTotalVolume = findViewById(R.id.tvTotalWant);
        tv11tv11 = findViewById(R.id.tv11tv11);
        postPojo = mMainActivityViewModel.getListFromWB();

        postPojo.observe(this, new Observer<List<PostPojo>>() {
            @Override
            public void onChanged(List<PostPojo> postPojos) {
                onePostPojo = postPojos.get(0);
                tv11tv11.setText(onePostPojo.getBrand());
            }
        });
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NEW_STATISTIC_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            String name = data.getStringExtra("name");
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}


