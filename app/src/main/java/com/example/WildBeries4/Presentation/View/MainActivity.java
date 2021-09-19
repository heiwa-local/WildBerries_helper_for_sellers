package com.example.WildBeries4.Presentation.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.WildBeries4.Domain.Model.Statistic;
import com.example.WildBeries4.Presentation.ViewModel.NewStatisticActivity;
import com.example.WildBeries4.Presentation.ViewModel.StatisticViewModel;
import com.example.WildBeries4.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    public static final int NEW_STATISTIC_ACTIVITY_REQUEST_CODE = 1;

    private StatisticViewModel mStatisticViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final StatisticListAdapter adapter = new StatisticListAdapter(new StatisticListAdapter.StatisticDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mStatisticViewModel = new ViewModelProvider(this).get(StatisticViewModel.class);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener( view -> {
            Intent intent = new Intent(MainActivity.this, NewStatisticActivity.class);
            startActivityForResult(intent, NEW_STATISTIC_ACTIVITY_REQUEST_CODE);
        });
        mStatisticViewModel.getAllStatistic().observe(this, statistics -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(statistics);
        });
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_STATISTIC_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Statistic name = new Statistic(data.getStringExtra(NewStatisticActivity.EXTRA_REPLY));
            mStatisticViewModel.insert(name);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}


