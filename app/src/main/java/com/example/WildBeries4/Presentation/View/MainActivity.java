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

import com.example.WildBeries4.Domain.Model.Statistic;
import com.example.WildBeries4.Presentation.Repository.Room.StatisticRoomDatabase;
import com.example.WildBeries4.Presentation.View.Adapters.StatisticListAdapter;
import com.example.WildBeries4.Presentation.View.Adapters.StatisticListAdapter.StatisticDiff;
import com.example.WildBeries4.Presentation.ViewModel.MainActivityViewModel;
import com.example.WildBeries4.Presentation.ViewModel.StatisticViewModel;
import com.example.WildBeries4.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    public static final int NEW_STATISTIC_ACTIVITY_REQUEST_CODE = 1;
    private Statistic statistic;
    private LiveData<Statistic> statisticLiveData;
    private StatisticViewModel mStatisticViewModel;
    private MainActivityViewModel mMainActivityViewModel;
    private static volatile StatisticRoomDatabase INSTANCE;

    String allSum;
    double allTotalSum;
    TextView tvTotalSum;
    TextView tvTotalVolume;
    Button btnConverter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConverter = findViewById(R.id.btnConverter);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final StatisticListAdapter adapter = new StatisticListAdapter(new StatisticListAdapter.StatisticDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mStatisticViewModel = new ViewModelProvider(this).get(StatisticViewModel.class);
        mMainActivityViewModel = new MainActivityViewModel(new Application());
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener( view -> {
            Intent intent = new Intent(MainActivity.this, NewStatisticActivity.class);
            startActivityForResult(intent, NEW_STATISTIC_ACTIVITY_REQUEST_CODE);
        });
        mStatisticViewModel.getAllStatistic().observe(this, statistics -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(statistics);

        });
        tvTotalSum = findViewById(R.id.tvTotalSum);
        tvTotalVolume = findViewById(R.id.tvTotalWant);

//        mMainActivityViewModel.allSupply().observe(this, new Observer<Double>() {
//            @Override
//            public void onChanged(Double aDouble) {
//                tvTotalSum.setText(aDouble.toString()+"\n₽");
//            }
//        });
//        mMainActivityViewModel.getTotalVolume().observe(this, new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer integer) {
//                tvTotalVolume.setText(integer.toString()+"\nшт.");
//            }
//        });

        btnConverter.setOnClickListener(view ->{
            Intent intent = new Intent(MainActivity.this, ConverterActivity.class);
            startActivity(intent);
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


