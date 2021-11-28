package com.example.WildBeries4.Presentation.View;

import android.annotation.SuppressLint;
import android.app.Application;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import com.example.WildBeries4.Domain.Model.PostPojo;
import com.example.WildBeries4.Presentation.ViewModel.OpenPostPojoViewModel;
import com.example.WildBeries4.R;

import java.util.List;

public class OpenPostPojo extends AppCompatActivity {
    TextView tvInWayToClient;
    TextView tvInWayFromClient;
    TextView tvQuantity;
    TextView tvPrice;
    TextView tvDiscount;
    TextView tvSuplierArticle;
    ImageButton btnAddToCalendar;
    LiveData<List<PostPojo>> postPojo;


    private int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 100;
    private OpenPostPojoViewModel mOpenPostPojoViewModel;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_statistic);
        mOpenPostPojoViewModel = new OpenPostPojoViewModel(new Application());

        tvInWayToClient = findViewById(R.id.tvInWayToClient);
        tvInWayFromClient = findViewById(R.id.tvInWayFromClient);
        tvQuantity = findViewById(R.id.tvQuantity);
        tvPrice = findViewById(R.id.tvPrice);
        tvDiscount = findViewById(R.id.tvDiscount);
        tvSuplierArticle = findViewById(R.id.tvSuplierArticle);
        btnAddToCalendar = findViewById(R.id.btnAddToCalendar);

        Bundle arguments = getIntent().getExtras();

        String suplierArticle = arguments.get("SupplierArticle").toString();
        String inWayToClient = arguments.get("InWayToClient").toString();
        String inWayFromClient = arguments.get("InWayFromClient").toString();
        String quantityNotInOrders = arguments.get("QuantityNotInOrders").toString();
        String price = arguments.get("Price").toString();
        String discount = arguments.get("Discount").toString();

        postPojo =  mOpenPostPojoViewModel.getListFromWB();
        Uri uri = CalendarContract.Calendars.CONTENT_URI;

        postPojo.observe(this, postPojos -> {

            tvSuplierArticle.setText(suplierArticle);
            tvInWayToClient.setText(inWayToClient);
            tvInWayFromClient.setText(inWayFromClient);
            tvQuantity.setText(quantityNotInOrders);
            tvPrice.setText(price);
            tvDiscount.setText(discount);
        });
    }

//        btnAddToCalendar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
//                    ActivityCompat.requestPermissions(OpenPostPojo.this,new String[]{Manifest.permission.WRITE_CALENDAR},MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
//                }
//                else if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_CALENDAR) == PackageManager.PERMISSION_GRANTED){
//
//                    ContentResolver cr = getContentResolver();
//                    ContentValues cv = new ContentValues();
//
//                    Calendar startTime = Calendar.getInstance();
//                    SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.ENGLISH);
//                    try {
//                        startTime.setTime(formater.parse(postPojo.ge()));
//                    } catch (ParseException e) {
//                        e.printStackTrace();
//                    }
//
//                    cv.put(CalendarContract.Events.TITLE, "Поставка - " + postPojo.getSupplierArticle());
//                    cv.put(CalendarContract.Events.DESCRIPTION, postPojo.getInWayFromClient() + "штук на сумму " + postPojo.getInWayFromClient() + " рублей \nПодробности в приложении WildBerries Statistic");
//                    cv.put(CalendarContract.Events.DTSTART, startTime.getTimeInMillis());
//                    cv.put(CalendarContract.Events.DTEND, startTime.getTimeInMillis()+100);
//                    cv.put(CalendarContract.Events.CALENDAR_ID, 1);
//                    cv.put(CalendarContract.Events.EVENT_TIMEZONE, Calendar.getInstance().getTimeZone().getID());
//                    cr.insert(CalendarContract.Events.CONTENT_URI, cv);
//                    Toast.makeText(OpenPostPojo.this, "Added to calendar", Toast.LENGTH_SHORT).show();}
//            }
//        });
//            }
//        });


//        }



}
