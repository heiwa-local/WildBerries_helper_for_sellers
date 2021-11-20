package com.example.WildBeries4.Domain.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Users")
public class UsersDTO {
    @PrimaryKey(autoGenerate = true)
    public long id;



    @ColumnInfo(name = "role")
    public String role;
    @NonNull
    @ColumnInfo(name = "email")
    public String email;
    @ColumnInfo
    public String password;
    @ColumnInfo
    public String firstName;
    @ColumnInfo
    public String secondName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public UsersDTO(){

    }

    public UsersDTO (String role,String email, String password, String firstName, String secondName){
        this.role = role;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.password = password;
    }
    public String getUsers(){
        return this.email;
    }

}
