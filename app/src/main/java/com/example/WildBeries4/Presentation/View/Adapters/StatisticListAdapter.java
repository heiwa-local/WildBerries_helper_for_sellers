package com.example.WildBeries4.Presentation.View.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.WildBeries4.Domain.Model.Statistic;
import com.example.WildBeries4.Presentation.View.OpenStatistic;
import com.example.WildBeries4.Presentation.View.StatisticViewHolder;
import com.example.WildBeries4.R;

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
        holder.bind(current.getName(),current.getId());
        Context context = holder.itemView.getContext();
        TextView tvName = holder.itemView.findViewById(R.id.tvNameMain);
        TextView tvId = holder.itemView.findViewById(R.id.tvId);

        holder.itemView.findViewById(R.id.tvNameMain).
                setOnClickListener( v ->{
                    Intent intent = new Intent(context, OpenStatistic.class);
                    intent.putExtra(
                            "name", tvName.getText().toString()
                    );
                    intent.putExtra(
                            "id", tvId.getText().toString()
                    );
                    context.startActivity(intent);
                });
    }

    public static  class StatisticDiff extends DiffUtil.ItemCallback<Statistic>{
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
