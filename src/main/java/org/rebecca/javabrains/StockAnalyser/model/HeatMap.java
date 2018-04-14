package org.rebecca.javabrains.StockAnalyser.model;

public class HeatMap {
    private String name;
    private double colorValue;
    private long value = 2;


    public double getColorValue() {
        return colorValue;
    }

    public void setColorValue(double colorValue) {
        this.colorValue = colorValue;
    }

    public HeatMap() {
    }

    public HeatMap(String name, double colorValue) {
        this.name = name;
        this.colorValue = colorValue;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
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
