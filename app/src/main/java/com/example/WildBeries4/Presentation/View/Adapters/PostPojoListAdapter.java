package com.example.WildBeries4.Presentation.View.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.WildBeries4.Domain.Model.PostPojo;
import com.example.WildBeries4.Domain.Model.Statistic;
import com.example.WildBeries4.Presentation.View.OpenStatistic;
import com.example.WildBeries4.Presentation.View.PostPojoViewHolder;
import com.example.WildBeries4.Presentation.View.PostPojoViewHolder;
import com.example.WildBeries4.R;

public class PostPojoListAdapter extends ListAdapter<PostPojo, PostPojoViewHolder> {

    public PostPojoListAdapter(@NonNull DiffUtil.ItemCallback<PostPojo> diffCallback) {
        super(diffCallback);
    }

    protected PostPojoListAdapter(@NonNull AsyncDifferConfig<PostPojo> config) {
        super(config);
    }

    @NonNull
    @Override
    public PostPojoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return PostPojoViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull PostPojoViewHolder holder, int position) {
        PostPojo current = getItem(position);
        holder.bind(current.getSupplierArticle(),Long.parseLong(current.getInWayToClient()));
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

    public static  class PostPojoDiff extends DiffUtil.ItemCallback<PostPojo>{
        @Override
        public boolean areItemsTheSame(@NonNull PostPojo oldItem,
                                       @NonNull PostPojo newItem){
            return oldItem == newItem;
        }
        @Override
        public boolean areContentsTheSame(@NonNull PostPojo oldItem,
                                          @NonNull PostPojo newItem){
            return  oldItem.getPostPojo().equals(newItem.getPostPojo());
        }
    }
}
