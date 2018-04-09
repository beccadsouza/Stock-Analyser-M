package org.rebecca.javabrains.StockAnalyser.model;

public class MarketShare {
    
    private double quarter1;
    private double quarter2;
    private double quarter3;
    private double quarter4;

    public MarketShare(double quarter1, double quarter2, double quarter3, double quarter4) {

        this.quarter1 = quarter1;
        this.quarter2 = quarter2;
        this.quarter3 = quarter3;
        this.quarter4 = quarter4;
    }
    
    public double getQuater1() {
        return quarter1;
    }

    public void setQuater1(double quarter1) {
        this.quarter1 = quarter1;
    }

    public double getQuater2() {
        return quarter2;
    }

    public void setQuater2(double quarter2) {
        this.quarter2 = quarter2;
    }

    public double getQuater3() {
        return quarter3;
    }

    public void setQuater3(double quarter3) {
        this.quarter3 = quarter3;
    }

    public double getQuater4() {
        return quarter4;
    }

    public void setQuater4(double quarter4) {
        this.quarter4 = quarter4;
    }
    
}
