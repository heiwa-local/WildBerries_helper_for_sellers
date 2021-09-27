package com.example.WildBeries4.Presentation.View;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.WildBeries4.Domain.Model.Statistic;
import com.example.WildBeries4.Presentation.ViewModel.StatisticViewModel;
import com.example.WildBeries4.R;

public class NewStatisticActivity extends AppCompatActivity {
    private StatisticViewModel mStatisticViewModel;
    private Statistic statistic;
    public static final String EXTRA_REPLY = "com.example.android.userlistsql.REPLY";

    private EditText mTvNameEnter;
    private EditText mTvFullPriceEnter;
    private EditText mTvVolumeEnter;
    private EditText mTvPriceWBEnter;
    private EditText mTvPercentEnter;
    private EditText mTvLogisticEnter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_statistic);

        mTvNameEnter = findViewById(R.id.tvNameEnter);
        mTvFullPriceEnter = findViewById(R.id.tvFullPriceEnter);
        mTvVolumeEnter = findViewById(R.id.tvVolumeEnter);
        mTvPriceWBEnter = findViewById(R.id.tvPriceWBEnter);
        mTvPercentEnter = findViewById(R.id.tvProcentWBEnter);
        mTvLogisticEnter = findViewById(R.id.tvLogisticEnter);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(mTvNameEnter.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String word = mTvNameEnter.getText().toString();
//
//                statistic.setName(mTvNameEnter.getText().toString());
//
//                Double fullPrice = Double.parseDouble(mTvFullPriceEnter.getText().toString());
//                statistic.setFullPrice(fullPrice);
//
//                Double volume = Double.parseDouble(mTvVolumeEnter.getText().toString());
//                statistic.setFullPrice(volume);
//
//                Double onePrice = Double.parseDouble(mTvPriceWBEnter.getText().toString());
//                statistic.setFullPrice(onePrice);
//
//                Double procent = Double.parseDouble(mTvPercentEnter.getText().toString());
//                statistic.setFullPrice(procent);
//
//                Double logistic = Double.parseDouble(mTvLogisticEnter.getText().toString());
//                statistic.setFullPrice(logistic);
//
//                mStatisticViewModel.insert(statistic);
                replyIntent.putExtra(EXTRA_REPLY, word);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });

    }
}