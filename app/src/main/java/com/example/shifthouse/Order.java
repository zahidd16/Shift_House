package com.example.shifthouse;

public class Order {
    private String userName;
    private String ID;
    private String vehicleCost;
    private String serviceCost;
    private String totalCost;
    private String startLocation;
    private String destination;
    private String distance;
    private String date;
    private String nCargo;
    private String nVan;
    private String nTruck;
    private String nElectricians;
    private String nPlumbers;
    private String nPainters;
    private String driversName;
    private String driversID;
    private String serviceProvidersName;
    private String getServiceProvidersID;
    private String driverNum;
    private String additionalNum;
    private String eTime;


    public Order() {

    }

    public Order(String userName, String ID, String vehicleCost, String serviceCost, String totalCost, String startLocation, String destination, String distance, String date, String nCargo, String nVan, String nTruck, String nElectricians, String nPlumbers, String nPainters, String driversName, String driversID, String serviceProvidersName, String getServiceProvidersID, String driverNum, String additionalNum, String eTime) {
        this.userName = userName;
        this.ID = ID;
        this.vehicleCost = vehicleCost;
        this.serviceCost = serviceCost;
        this.totalCost = totalCost;
        this.startLocation = startLocation;
        this.destination = destination;
        this.distance = distance;
        this.date = date;
        this.nCargo = nCargo;
        this.nVan = nVan;
        this.nTruck = nTruck;
        this.nElectricians = nElectricians;
        this.nPlumbers = nPlumbers;
        this.nPainters = nPainters;
        this.driversName = driversName;
        this.driversID = driversID;
        this.serviceProvidersName = serviceProvidersName;
        this.getServiceProvidersID = getServiceProvidersID;
        this.driverNum = driverNum;
        this.additionalNum = additionalNum;
        this.eTime = eTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getVehicleCost() {
        return vehicleCost;
    }

    public void setVehicleCost(String vehicleCost) {
        this.vehicleCost = vehicleCost;
    }

    public String getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(String serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getnCargo() {
        return nCargo;
    }

    public void setnCargo(String nCargo) {
        this.nCargo = nCargo;
    }

    public String getnVan() {
        return nVan;
    }

    public void setnVan(String nVan) {
        this.nVan = nVan;
    }

    public String getnTruck() {
        return nTruck;
    }

    public void setnTruck(String nTruck) {
        this.nTruck = nTruck;
    }

    public String getnElectricians() {
        return nElectricians;
    }

    public void setnElectricians(String nElectricians) {
        this.nElectricians = nElectricians;
    }

    public String getnPlumbers() {
        return nPlumbers;
    }

    public void setnPlumbers(String nPlumbers) {
        this.nPlumbers = nPlumbers;
    }

    public String getnPainters() {
        return nPainters;
    }

    public void setnPainters(String nPainters) {
        this.nPainters = nPainters;
    }

    public String getDriversName() {
        return driversName;
    }

    public void setDriversName(String driversName) {
        this.driversName = driversName;
    }

    public String getDriversID() {
        return driversID;
    }

    public void setDriversID(String driversID) {
        this.driversID = driversID;
    }

    public String getServiceProvidersName() {
        return serviceProvidersName;
    }

    public void setServiceProvidersName(String serviceProvidersName) {
        this.serviceProvidersName = serviceProvidersName;
    }

    public String getGetServiceProvidersID() {
        return getServiceProvidersID;
    }

    public void setGetServiceProvidersID(String getServiceProvidersID) {
        this.getServiceProvidersID = getServiceProvidersID;
    }

    public String getDriverNum() {
        return driverNum;
    }

    public void setDriverNum(String driverNum) {
        this.driverNum = driverNum;
    }

    public String getAdditionalNum() {
        return additionalNum;
    }

    public void setAdditionalNum(String additionalNum) {
        this.additionalNum = additionalNum;
    }

    public String geteTime() {
        return eTime;
    }

    public void seteTime(String eTime) {
        this.eTime = eTime;
    }
}