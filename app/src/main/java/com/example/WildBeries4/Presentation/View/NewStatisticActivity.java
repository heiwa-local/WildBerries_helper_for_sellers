package com.example.WildBeries4.Presentation.View;

import android.app.Application;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.WildBeries4.Domain.Model.Statistic;
import com.example.WildBeries4.Presentation.ViewModel.NewStatisticViewModel;
import com.example.WildBeries4.Presentation.ViewModel.StatisticViewModel;
import com.example.WildBeries4.R;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class NewStatisticActivity extends AppCompatActivity {
    public NewStatisticViewModel mNewStatisticViewModel;
    public Statistic statistic;
    public static final String EXTRA_REPLY = "com.example.android.userlistsql.REPLY";

    private EditText mTvNameEnter;
    private EditText mTvFullPriceEnter;
    private EditText mTvVolumeEnter;
    private EditText mTvPriceWBEnter;
    private EditText mTvPercentEnter;
    private EditText mTvLogisticEnter;
    private EditText mTvDataEnter;

    private LocalDateTime time;

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
        mTvDataEnter = findViewById(R.id.tvDataEnter);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            statistic = new Statistic();
            mNewStatisticViewModel = new NewStatisticViewModel(new Application());
            if (TextUtils.isEmpty(mTvNameEnter.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                statistic.setName(mTvNameEnter.getText().toString());
                statistic.fullPrice = mTvFullPriceEnter.getText().toString();
                statistic.volume = mTvVolumeEnter.getText().toString();
                statistic.onePrice = mTvPriceWBEnter.getText().toString();
                statistic.procent = mTvPercentEnter.getText().toString();
                statistic.logistic =mTvLogisticEnter.getText().toString();
                statistic.data = mTvDataEnter.getText().toString();

                mNewStatisticViewModel.insert(statistic);

                replyIntent.putExtra("name", statistic.name);

                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
        mTvDataEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();

                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                            @RequiresApi(api = Build.VERSION_CODES.O)
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                                calendar.set(Calendar.MINUTE, minute);

                                time = LocalDateTime.ofInstant(calendar.toInstant(), calendar.getTimeZone().toZoneId());
                                mTvDataEnter.setText(time.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")));
                            }
                        };

                        new TimePickerDialog(NewStatisticActivity.this, timeSetListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show();
                    }
                };

                new DatePickerDialog(NewStatisticActivity.this, dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

    }
}