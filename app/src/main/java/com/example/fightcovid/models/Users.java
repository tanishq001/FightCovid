package com.example.fightcovid.models;

public class Users {
    String Name;
    String email;
    String location;
    String uid;
    public Users (String name,String email, String location,String uid){
        this.Name=name;
        this.email=email;
        this.location=location;
        this.uid=uid;
    }
    public String getUid(){
        return this.uid;
    }
    public String getName(){
        return this.Name;
    }
    public String getLocation(){
        return this.location;
    }
    public String getEmail(){
        return this.email;
    }

}
