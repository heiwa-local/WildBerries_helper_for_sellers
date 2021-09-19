package com.example.WildBeries4.Presentation.View;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.WildBeries4.Domain.Model.Statistic;

public class StatisticListAdapter extends ListAdapter<Statistic, StatisticViewHolder> {

    public StatisticListAdapter(@NonNull DiffUtil.ItemCallback<Statistic> diffCallback) {
        super(diffCallback);
    }

    protected StatisticListAdapter(@NonNull AsyncDifferConfig<Statistic> config) {
        super(config);
    }

    @NonNull
    @Override
    public StatisticViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return StatisticViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull StatisticViewHolder holder, int position) {
        Statistic current = getItem(position);
        holder.bind(current.getStatistic());
    }

    static  class StatisticDiff extends DiffUtil.ItemCallback<Statistic>{
        @Override
        public boolean areItemsTheSame(@NonNull Statistic oldItem,
                                       @NonNull Statistic newItem){
            return oldItem == newItem;
        }
        @Override
        public boolean areContentsTheSame(@NonNull Statistic oldItem,
                                          @NonNull Statistic newItem){
            return  oldItem.getStatistic().equals(newItem.getStatistic());
        }
    }
}
