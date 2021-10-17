package com.example.WildBeries4.Domain.Model;


import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "Statistic")
public class Statistic {
    @PrimaryKey(autoGenerate = true)
    public long id;
    @NonNull
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo
    public double fullPrice;
    @ColumnInfo
    public int volume;
    @ColumnInfo
    public double onePrice;
    @ColumnInfo
    public double procent;
    @ColumnInfo
    public double logistic;
    @ColumnInfo
    public String data;



//    @ColumnInfo
//    public Color color;

    public Statistic(String name, double fullPrice, int volume) {
        this.name = name;
        this.fullPrice = fullPrice;
        this.volume = volume;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public double getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(double fullPrice) {
        this.fullPrice = fullPrice;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Double getOnePrice() {
        return onePrice;
    }

    public void setOnePrice(Double onePrice) {
        this.onePrice = onePrice;
    }

    public Double getProcent() {
        return procent;
    }

    public void setProcent(Double procent) {
        this.procent = procent;
    }

    public Double getLogistic() {
        return logistic;
    }

    public void setLogistic(Double logistic) {
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

//    public Color getColor() {
//        return color;
//    }
//
//    public void setColor(Color color) {
//        this.color = color;
//    }
}
