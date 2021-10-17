package com.example.WildBeries4.Presentation.View;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.WildBeries4.Presentation.ViewModel.StatisticViewModel;
import com.example.WildBeries4.R;

public class StatisticViewHolder extends RecyclerView.ViewHolder {
    private final TextView statisticItemView;
    private final TextView statisticItemView1;


    public StatisticViewHolder(@NonNull View itemView) {
        super(itemView);
        statisticItemView = itemView.findViewById((R.id.tvNameMain));
        statisticItemView1 = itemView.findViewById(R.id.tvId);
        StatisticViewModel mHolderViewModel = new StatisticViewModel(new Application());
        itemView.findViewById(R.id.btnDelete).
                setOnClickListener( v ->{
                    mHolderViewModel.deleteByName(statisticItemView.getText().toString(),Long.parseLong(statisticItemView1.getText().toString()));
                });

    }

    public void bind(String text,long id){
        statisticItemView.setText(text);

        statisticItemView1.setText(Long.toString(id));
    }

    public static StatisticViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent,
                        false);
        return new StatisticViewHolder(view);
    }
}
