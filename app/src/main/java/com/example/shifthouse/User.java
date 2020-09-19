package com.example.shifthouse;

import org.jetbrains.annotations.Contract;

public class User {

    private String nam;
    private String id;
    private String email;
    private String mob;
    private String ad;
    private String n;
    private String password;

    public User() {

    }

    public User(String nam, String id, String email, String mob, String ad, String n, String password) {
        this.nam = nam;
        this.id = id;
        this.email = email;
        this.mob = mob;
        this.ad = ad;
        this.n = n;
        this.password = password;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}



