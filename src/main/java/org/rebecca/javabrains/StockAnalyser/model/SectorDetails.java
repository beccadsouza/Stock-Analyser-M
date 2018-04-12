package org.rebecca.javabrains.StockAnalyser.model;

public class SectorDetails {
    private String name;
    private double y;

    public SectorDetails() { }

    public SectorDetails(String name, double y) {
        this.name = name;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
