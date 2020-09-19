package com.example.shifthouse;

public class newHelper {
    String vecId, vecDescription, vecDate, vecSpinner;

    public newHelper() {

    }

    public newHelper(String vecId, String vecDescription, String vecDate, String vecSpinner) {
        this.vecId = vecId;
        this.vecDescription = vecDescription;
        this.vecDate = vecDate;
        this.vecSpinner = vecSpinner;
    }

    public String getVecId() {
        return vecId;
    }

    public void setVecId(String vecId) {
        this.vecId = vecId;
    }

    public String getVecDescription() {
        return vecDescription;
    }

    public void setVecDescription(String vecDescription) {
        this.vecDescription = vecDescription;
    }

    public String getVecDate() {
        return vecDate;
    }

    public void setVecDate(String vecDate) {
        this.vecDate = vecDate;
    }

    public String getVecSpinner() {
        return vecSpinner;
    }

    public void setVecSpinner(String vecSpinner) {
        this.vecSpinner = vecSpinner;
    }
}
