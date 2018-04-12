package org.rebecca.javabrains.StockAnalyser.model;

public class Investor{
    private String description;
    private String address;

    public Investor() {
    }

    private String type;
    private String state;
    private String city;
    private String name;
    private String investorID;
    private double holdingConc;


    public Investor(String description, String address, String type, String state, String city, String name, String investorID, double holdingConc) {
        this.description = description;
        this.address = address;
        this.type = type;
        this.state = state;
        this.city = city;
        this.name = name;
        this.investorID = investorID;
        this.holdingConc = holdingConc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInvestorID() {
        return investorID;
    }

    public void setInvestorID(String investorID) {
        this.investorID = investorID;
    }

    public double getHoldingConc() {
        return holdingConc;
    }

    public void setHoldingConc(double holdingConc) {
        this.holdingConc = holdingConc;
    }
}