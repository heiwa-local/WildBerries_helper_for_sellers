package com.example.WildBeries4.Presentation.View.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.WildBeries4.Domain.Model.Statistic;
import com.example.WildBeries4.Domain.Model.UsersDTO;
import com.example.WildBeries4.Presentation.View.UserViewHolder;
import com.example.WildBeries4.R;

import java.util.List;

public class UserListAdapter extends ListAdapter<UsersDTO, UserViewHolder> {
    public UserListAdapter(@NonNull DiffUtil.ItemCallback<UsersDTO> diffCallback) {
        super(diffCallback);

    }

    protected UserListAdapter(@NonNull AsyncDifferConfig<UsersDTO> config) {
        super(config);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return UserViewHolder.create(parent);
    }


    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        UsersDTO current = getItem(position);
        holder.bind(current.getEmail(), current.getRole());

    }

    public static  class UserDiff extends DiffUtil.ItemCallback<UsersDTO>{
        @Override
        public boolean areItemsTheSame(@NonNull UsersDTO oldItem,
                                       @NonNull UsersDTO newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull UsersDTO oldItem,
                                          @NonNull UsersDTO newItem) {
            return oldItem.getUsers().equals(newItem.getUsers());
        }
    }
}
