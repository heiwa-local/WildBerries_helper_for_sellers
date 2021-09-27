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
    public double fullPrice;
    @ColumnInfo
    public double volume;
    @ColumnInfo
    public double onePrice;
    @ColumnInfo
    public double procent;
    @ColumnInfo
    public double logistic;

    public Statistic(String name, double fullPrice, double volume) {
        this.name = name;
        this.fullPrice = fullPrice;
        this.volume = volume;
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

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getOnePrice(){
        return onePrice;
    }

    public void setOnePrice(double onePrice){
        this.onePrice = onePrice;
    }

    public double getProcent(){
        return procent;
    }

    public void setProcent(double procent){
        this.procent = procent;
    }

    public double getLogistic(){
        return logistic;
    }

    public void setLogistic(double logistic){
        this.logistic = logistic;
    }

    public Statistic(@NonNull String statistic){this.name = statistic;}

    public String getStatistic(){return this.name;}

}
