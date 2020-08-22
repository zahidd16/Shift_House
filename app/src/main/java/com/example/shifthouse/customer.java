package com.example.shifthouse;

public class customer {

    private String nam;
    private String email;
    private String mob;
    private String ad;
    private String n;
    private String password;
    public customer(){

   }
    public customer(String nam, String email, String mob, String ad, String n, String password) {
        this.nam = nam;
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

