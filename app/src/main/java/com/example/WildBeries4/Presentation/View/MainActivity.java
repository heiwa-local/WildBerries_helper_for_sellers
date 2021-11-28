package com.example.WildBeries4.Presentation.View;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
import com.example.WildBeries4.Presentation.View.Adapters.PostPojoListAdapter;
import com.example.WildBeries4.Presentation.View.Adapters.PostPojoListAdapter.PostPojoDiff;
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
    int quantityNotInOrder;
    String allSum;
    double allTotalSum;
    TextView tvTotalSum;
    TextView tvTotalVolume;
    TextView tvQuantityNotInOrder;
    Button btnConverter;
    TextView tv11tv11;
    Button btnUserListForAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final PostPojoListAdapter adapter = new PostPojoListAdapter(new PostPojoListAdapter.PostPojoDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mStatisticViewModel = new ViewModelProvider(this).get(StatisticViewModel.class);
        mMainActivityViewModel = new MainActivityViewModel(new Application());

        postPojo = mMainActivityViewModel.getListFromWB();
        postPojo.observe(this, PostPogos -> {
            adapter.submitList(PostPogos);

        });
        Bundle arguments = getIntent().getExtras();
        btnUserListForAdmin = findViewById(R.id.btnUserListForAdmin);
        if (arguments.get("role").equals("Admin")){
            btnUserListForAdmin.setVisibility(View.VISIBLE);
        }
        else {
            btnUserListForAdmin.setVisibility(View.GONE);
        }
        btnUserListForAdmin.setOnClickListener(view ->{
            Intent intent = new Intent(this, AdminUserListActivity.class);
            startActivity(intent);
                });




//        postPojo.observe(this, new Observer<List<PostPojo>>() {
//            @Override
//            public void onChanged(List<PostPojo> postPojos) {
//                onePostPojo = postPojos.get(0);
//                tv11tv11.setText(onePostPojo.getBrand());
//            }
//        });
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


