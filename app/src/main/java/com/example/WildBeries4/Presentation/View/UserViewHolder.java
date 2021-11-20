package com.example.WildBeries4.Presentation.View;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.WildBeries4.Presentation.ViewModel.StatisticViewModel;
import com.example.WildBeries4.R;

public class UserViewHolder extends RecyclerView.ViewHolder {
    private final TextView userItemView;
    private final TextView userItemView1;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        userItemView = itemView.findViewById((R.id.tvAdminUserEmail));
        userItemView1 = itemView.findViewById(R.id.tvAdminUserRole);

    }
    public void bind(String text,String id){
        userItemView.setText(text);

        userItemView1.setText(id);
    }

    public static UserViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_recyclerview_item, parent,
                        false);
        return new UserViewHolder(view);
    }
}
