package org.rebecca.javabrains.StockAnalyser.model;

public class QuarterDetails {
    private long quarter;
    private double sumMarketValue;

    public QuarterDetails() { }

    public QuarterDetails(long quarter, double sumMarketValue) {
        this.quarter = quarter;
        this.sumMarketValue = sumMarketValue;
    }

    public long getQuarter() {
        return quarter;
    }

    public void setQuarter(long quarter) {
        this.quarter = quarter;
    }

    public double getSumMarketValue() {
        return sumMarketValue;
    }

    public void setSumMarketValue(double sumMarketValue) {
        this.sumMarketValue = sumMarketValue;
    }
}
