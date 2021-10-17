package com.example.WildBeries4.Presentation.View;

import android.Manifest;
import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.WildBeries4.Domain.Model.Statistic;
import com.example.WildBeries4.Presentation.ViewModel.OpenStatisticViewModel;
import com.example.WildBeries4.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class OpenStatistic extends AppCompatActivity {
    TextView tvFullPriceView;
    TextView tvVolumeView;
    TextView tvOnePriceView;
    TextView tvProcentView;
    TextView tvLogisticView;
    TextView tvDataView;
    ImageButton btnAddToCalendar;


    LiveData<Statistic> statistic;
    private int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 100;
    private OpenStatisticViewModel mOpenStatisticViewModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_statistic);
        mOpenStatisticViewModel = new OpenStatisticViewModel(new Application());

        tvFullPriceView = findViewById(R.id.tvFullPriceView);
        tvVolumeView = findViewById(R.id.tvVolumeView);
        tvOnePriceView = findViewById(R.id.tvOnePriceView);
        tvProcentView = findViewById(R.id.tvProcentView);
        tvLogisticView = findViewById(R.id.tvLogisticView);
        tvDataView = findViewById(R.id.tvDataView);
        btnAddToCalendar = findViewById(R.id.btnAddToCalendar);

        Bundle arguments = getIntent().getExtras();
        String name = arguments.get("name").toString();
        statistic =  mOpenStatisticViewModel.getByName(name);
        Uri uri = CalendarContract.Calendars.CONTENT_URI;

        statistic.observe(this, new Observer<Statistic>() {
            @Override
            public void onChanged(Statistic statistic) {
                tvDataView.setText("Поставка от: " + statistic.getData());
                tvFullPriceView.setText(statistic.getFullPrice()+"\n₽");
                tvVolumeView.setText(statistic.getVolume() + "\nштук");
                tvOnePriceView.setText(statistic.getOnePrice() + "\n₽");
                tvProcentView.setText(statistic.getProcent() + "\n%");
                tvLogisticView.setText(statistic.getLogistic() + "\n₽");


        btnAddToCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(OpenStatistic.this,new String[]{Manifest.permission.WRITE_CALENDAR},MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
                }
                else if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_CALENDAR) == PackageManager.PERMISSION_GRANTED){

                    ContentResolver cr = getContentResolver();
                    ContentValues cv = new ContentValues();

                    Calendar startTime = Calendar.getInstance();
                    SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.ENGLISH);
                    try {
                        startTime.setTime(formater.parse(statistic.getData()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    cv.put(CalendarContract.Events.TITLE, "Поставка - " + statistic.getName());
                    cv.put(CalendarContract.Events.DESCRIPTION, statistic.getVolume() + "штук на сумму " + statistic.getFullPrice() + " рублей \nПодробности в приложении WildBerries Statistic");
                    cv.put(CalendarContract.Events.DTSTART, startTime.getTimeInMillis());
                    cv.put(CalendarContract.Events.DTEND, startTime.getTimeInMillis()+100);
                    cv.put(CalendarContract.Events.CALENDAR_ID, 1);
                    cv.put(CalendarContract.Events.EVENT_TIMEZONE, Calendar.getInstance().getTimeZone().getID());
                    cr.insert(CalendarContract.Events.CONTENT_URI, cv);
                    Toast.makeText(OpenStatistic.this, "Added to calendar", Toast.LENGTH_SHORT).show();}
            }
        });
            }
        });


        }
}
