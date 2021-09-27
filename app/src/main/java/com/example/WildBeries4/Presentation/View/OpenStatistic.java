package com.example.WildBeries4.Presentation.View;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.WildBeries4.Domain.Model.Statistic;
import com.example.WildBeries4.Presentation.ViewModel.OpenStatisticViewModel;
import com.example.WildBeries4.Presentation.ViewModel.StatisticViewModel;
import com.example.WildBeries4.R;

public class OpenStatistic extends AppCompatActivity {
    TextView tvFullPriceView;
    Statistic statistic;
    private OpenStatisticViewModel mOpenStatisticViewModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_statistic);
        mOpenStatisticViewModel = new ViewModelProvider(this).get(OpenStatisticViewModel.class);

        tvFullPriceView = findViewById(R.id.tvFullPriceView);
        statistic = mOpenStatisticViewModel.getByName(getIntent().getStringExtra("name"));
        Double price = statistic.getFullPrice();
        tvFullPriceView.setText(price.toString());


    }
}
