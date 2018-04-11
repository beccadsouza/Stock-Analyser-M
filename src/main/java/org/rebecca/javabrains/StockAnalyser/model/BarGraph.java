package org.rebecca.javabrains.StockAnalyser.model;

public class BarGraph {
    private String investorName;
    private double Q1;
    private double Q2;
    private double Q3;
    private double Q4;

    public BarGraph() { }

    public BarGraph(String investorName, double q1, double q2, double q3, double q4) {
        this.investorName = investorName;
        Q1 = q1;
        Q2 = q2;
        Q3 = q3;
        Q4 = q4;
    }

    public String getInvestorName() {
        return investorName;
    }

    public void setInvestorName(String investorName) {
        this.investorName = investorName;
    }

    public double getQ1() {
        return Q1;
    }

    public void setQ1(double q1) {
        Q1 = q1;
    }

    public double getQ2() {
        return Q2;
    }

    public void setQ2(double q2) {
        Q2 = q2;
    }

    public double getQ3() {
        return Q3;
    }

    public void setQ3(double q3) {
        Q3 = q3;
    }

    public double getQ4() {
        return Q4;
    }

    public void setQ4(double q4) {
        Q4 = q4;
    }
}
