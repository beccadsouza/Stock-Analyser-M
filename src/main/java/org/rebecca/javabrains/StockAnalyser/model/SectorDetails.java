package org.rebecca.javabrains.StockAnalyser.model;

public class SectorDetails {
    private String sector;
    private double sumMarketValue;

    public SectorDetails() { }

    public SectorDetails(String sector, double sumMarketValue) {
        this.sector = sector;
        this.sumMarketValue = sumMarketValue;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public double getSumMarketValue() {
        return sumMarketValue;
    }

    public void setSumMarketValue(double sumMarketValue) {
        this.sumMarketValue = sumMarketValue;
    }
}
