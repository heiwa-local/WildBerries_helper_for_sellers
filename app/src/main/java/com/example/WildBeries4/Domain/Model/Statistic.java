package com.example.WildBeries4.Domain.Model;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "Statistic")
public class Statistic {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo
    public String fullPrice;
    @ColumnInfo
    public String volume;
    @ColumnInfo
    public String onePrice;
    @ColumnInfo
    public String procent;
    @ColumnInfo
    public String logistic;
    @ColumnInfo
    public String data;

    public Statistic(String name, String fullPrice, String volume) {
        this.name = name;
        this.fullPrice = fullPrice;
        this.volume = volume;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(String fullPrice) {
        this.fullPrice = fullPrice;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getOnePrice() {
        return onePrice;
    }

    public void setOnePrice(String onePrice) {
        this.onePrice = onePrice;
    }

    public String getProcent() {
        return procent;
    }

    public void setProcent(String procent) {
        this.procent = procent;
    }

    public String getLogistic() {
        return logistic;
    }

    public void setLogistic(String logistic) {
        this.logistic = logistic;
    }

    public Statistic(@NonNull String statistic) {
        this.name = statistic;
    }

    public Statistic() {
    }

    public String getStatistic() {
        return this.name;
    }

}
