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
import com.example.WildBeries4.Presentation.View.OpenPostPojo;
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
        holder.bind(current.getSupplierArticle());
        Context context = holder.itemView.getContext();
        TextView tvName = holder.itemView.findViewById(R.id.tvNameMain);

        holder.itemView.findViewById(R.id.tvNameMain).
                setOnClickListener( v ->{
                    Intent intent = new Intent(context, OpenPostPojo.class);
                    intent.putExtra(
                            "LastChangeDate", current.getLastChangeDate()
                    );
                    intent.putExtra(
                            "SupplierArticle", current.getSupplierArticle()
                    );
                    intent.putExtra(
                            "TechSize", current.getTechSize()
                    );
                    intent.putExtra(
                            "Barcode", current.getBarcode()
                    );
                    intent.putExtra(
                            "Quantity", current.getQuantity()
                    );
                    intent.putExtra(
                            "IsSupply", current.getIsSupply()
                    );
                    intent.putExtra(
                            "IsRealization", current.getIsRealization()
                    );
                    intent.putExtra(
                            "QuantityFull", current.getQuantityFull()
                    );
                    intent.putExtra(
                            "QuantityNotInOrders", current.getQuantityNotInOrders()
                    );
                    intent.putExtra(
                            "WarehouseName", current.getWarehouseName()
                    );
                    intent.putExtra(
                            "InWayToClient", current.getInWayToClient()
                    );
                    intent.putExtra(
                            "InWayFromClient", current.getInWayFromClient()
                    );
                    intent.putExtra(
                            "NmId", current.getNmId()
                    );
                    intent.putExtra(
                            "Subject", current.getSubject()
                    );
                    intent.putExtra(
                            "Category", current.getCategory()
                    );
                    intent.putExtra(
                            "DaysOnSite", current.getDaysOnSite()
                    );
                    intent.putExtra(
                            "Brand", current.getBrand()
                    );
                    intent.putExtra(
                            "ScCode", current.getScCode()
                    );
                    intent.putExtra(
                            "Price", current.getPrice()
                    );
                    intent.putExtra(
                            "Discount", current.getDiscount()
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
