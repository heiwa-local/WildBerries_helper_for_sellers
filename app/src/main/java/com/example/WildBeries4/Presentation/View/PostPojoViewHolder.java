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

public class PostPojoViewHolder extends RecyclerView.ViewHolder {
    private final TextView statisticItemView;


    public PostPojoViewHolder(@NonNull View itemView) {
        super(itemView);
        statisticItemView = itemView.findViewById((R.id.tvNameMain));
        StatisticViewModel mHolderViewModel = new StatisticViewModel(new Application());


    }

    public void bind(String text){
        statisticItemView.setText(text);

    }

    public static PostPojoViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent,
                        false);
        return new PostPojoViewHolder(view);
    }
}
