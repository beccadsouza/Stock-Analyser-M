package org.rebecca.javabrains.StockAnalyser.model;

public class Company {
    private String description;
    private String sector;
    private String address;
    private String name;
    private String companyID;
    private String city;
    private String state;
    private String ticker;

    public Company() { }

    public Company(String description, String sector, String address, String name, String companyID, String city, String state, String ticker) {
        this.description = description;
        this.sector = sector;
        this.address = address;
        this.name = name;
        this.companyID = companyID;
        this.city = city;
        this.state = state;
        this.ticker = ticker;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

}