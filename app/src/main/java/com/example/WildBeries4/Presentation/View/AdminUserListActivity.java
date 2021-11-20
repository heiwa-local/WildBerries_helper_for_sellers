package com.example.WildBeries4.Presentation.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.WildBeries4.Presentation.View.Adapters.StatisticListAdapter;
import com.example.WildBeries4.Presentation.View.Adapters.UserListAdapter;
import com.example.WildBeries4.Presentation.ViewModel.StatisticViewModel;
import com.example.WildBeries4.R;

public class AdminUserListActivity extends AppCompatActivity {
    private StatisticViewModel mStatisticViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_user_list);

        RecyclerView recyclerView = findViewById(R.id.recyclerview1);
        final UserListAdapter adapter = new UserListAdapter(new UserListAdapter.UserDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mStatisticViewModel = new ViewModelProvider(this).get(StatisticViewModel.class);

        mStatisticViewModel.getAllUsers().observe(this, usersDTOS -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(usersDTOS);

        });
    }
}