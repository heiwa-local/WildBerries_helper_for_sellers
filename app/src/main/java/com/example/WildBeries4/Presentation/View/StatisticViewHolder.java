package com.example.WildBeries4.Presentation.View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.WildBeries4.R;

public class StatisticViewHolder extends RecyclerView.ViewHolder {
    private final TextView statisticItemView;


    public StatisticViewHolder(@NonNull View itemView) {
        super(itemView);
        statisticItemView = itemView.findViewById((R.id.textView));
    }

    public void bind(String text){
        statisticItemView.setText(text);
    }

    static StatisticViewHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent,
                        false);
        return new StatisticViewHolder(view);
    }
}
