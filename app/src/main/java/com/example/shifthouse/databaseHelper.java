package com.example.shifthouse;

public class databaseHelper {
    String employeeId, employeeName, employeeContact, employeeAddress, employeeSalary, spinnerSelect;

    public databaseHelper() {

    }

    public databaseHelper(String employeeId, String employeeName, String employeeContact, String employeeAddress, String employeeSalary, String spinnerSelect) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeContact = employeeContact;
        this.employeeAddress = employeeAddress;
        this.employeeSalary = employeeSalary;
        this.spinnerSelect = spinnerSelect;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeContact() {
        return employeeContact;
    }

    public void setEmployeeContact(String employeeContact) {
        this.employeeContact = employeeContact;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getSpinnerSelect() {
        return spinnerSelect;
    }

    public void setSpinnerSelect(String spinnerSelect) {
        this.spinnerSelect = spinnerSelect;
    }
}
