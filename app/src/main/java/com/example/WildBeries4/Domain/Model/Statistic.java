package com.example.WildBeries4.Domain.Model;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Statistic")
public class Statistic {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo
    public String price;
    @ColumnInfo
    public Boolean in_cart;

    public Statistic(String name, String price, Boolean in_cart) {
        this.name = name;
        this.price = price;
        this.in_cart = in_cart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Boolean getIn_cart() {
        return in_cart;
    }

    public void setIn_cart(Boolean in_cart) {
        this.in_cart = in_cart;
    }

    public Statistic(@NonNull String statistic){this.name = statistic;}

    public String getStatistic(){return this.name;}

}
