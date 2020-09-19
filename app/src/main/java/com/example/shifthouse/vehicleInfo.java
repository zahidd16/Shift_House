package com.example.shifthouse;

public class vehicleInfo {
    private String Id;
    private String dec;
    private String updated;
    private String cat;

    public vehicleInfo() {

    }

    public vehicleInfo(String id, String dec, String updated, String cat) {
        Id = id;
        this.dec = dec;
        this.updated = updated;
        this.cat = cat;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getDec() {
        return dec;
    }

    public void setDec(String dec) {
        this.dec = dec;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }
}
