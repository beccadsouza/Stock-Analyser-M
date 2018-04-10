package org.rebecca.javabrains.StockAnalyser.model;

public class Scoreboard {
    private String investorID;
    private long ranking;
    private String investorName;
    private String investorCity;
    private String investorState;
    private double sumMarketValue;
    private String companyName;

    public Scoreboard() {
    }

    public Scoreboard(String investorID, long ranking, String investorName, String investorCity, String investorState, double sumMarketValue, String companyName) {
        this.investorID = investorID;
        this.ranking = ranking;
        this.investorName = investorName;
        this.investorCity = investorCity;
        this.investorState = investorState;
        this.sumMarketValue = sumMarketValue;
        this.companyName = companyName;
    }

    public String getInvestorID() {
        return investorID;
    }

    public void setInvestorID(String investorID) {
        this.investorID = investorID;
    }

    public long getRanking() {
        return ranking;
    }

    public void setRanking(long ranking) {
        this.ranking = ranking;
    }

    public String getInvestorName() {
        return investorName;
    }

    public void setInvestorName(String investorName) {
        this.investorName = investorName;
    }

    public String getInvestorCity() {
        return investorCity;
    }

    public void setInvestorCity(String investorCity) {
        this.investorCity = investorCity;
    }

    public String getInvestorState() {
        return investorState;
    }

    public void setInvestorState(String investorState) {
        this.investorState = investorState;
    }

    public double getSumMarketValue() {
        return sumMarketValue;
    }

    public void setSumMarketValue(double sumMarketValue) {
        this.sumMarketValue = sumMarketValue;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
