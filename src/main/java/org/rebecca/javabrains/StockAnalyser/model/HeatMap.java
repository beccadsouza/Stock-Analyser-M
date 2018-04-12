package org.rebecca.javabrains.StockAnalyser.model;

public class HeatMap {
    private String name;
    private double colorValue;
    private long rank;

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }

    public HeatMap() {
    }

    public HeatMap(long rank,String name, double colorValue) {
        this.rank = rank;
        this.name = name;
        this.colorValue = colorValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getcolorValue() {
        return colorValue;
    }

    public void setcolorValue(double colorValue) {
        this.colorValue = colorValue;
    }
}
