package com.mycompany.sqlproject.Beans;

public class BuildingBean {
    private String registrationNumber;
    private String place;
    private String numberOfFloors;
    private String dateOfConstruction;

    public BuildingBean(String registrationNumber, String place, String numberOfFloors, String dateOfConstruction) {
        this.registrationNumber = registrationNumber;
        this.place = place;
        this.numberOfFloors = numberOfFloors;
        this.dateOfConstruction = dateOfConstruction;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getDateOfConstruction() {
        return dateOfConstruction;
    }

    public void setDateOfConstruction(String dateOfConstruction) {
        this.dateOfConstruction = dateOfConstruction;
    }

    
    
    
}
