package org.rebecca.javabrains.StockAnalyser.model;

public class HoldingDetailsCompany {
    private String investorID;
    private String investorName;
    private String investorCity;
    private String investorState;
    private double principalAmount;
    private double marketValue;
    private double percentChange;
    private double changeInShares;
    private double perPortfolio;

    public HoldingDetailsCompany() { }

    public String getInvestorID() {
        return investorID;
    }

    public void setInvestorID(String investorID) {
        this.investorID = investorID;
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

    public double getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(double principalAmount) {
        this.principalAmount = principalAmount;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }

    public double getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(double percentChange) {
        this.percentChange = percentChange;
    }

    public double getChangeInShares() {
        return changeInShares;
    }

    public void setChangeInShares(double changeInShares) {
        this.changeInShares = changeInShares;
    }

    public double getPerPortfolio() {
        return perPortfolio;
    }

    public void setPerPortfolio(double perPortfolio) {
        this.perPortfolio = perPortfolio;
    }

    public HoldingDetailsCompany(String investorID, String investorName, String investorCity, String investorState, double principalAmount, double marketValue, double percentChange, double changeInShares, double perPortfolio) {

        this.investorID = investorID;
        this.investorName = investorName;
        this.investorCity = investorCity;
        this.investorState = investorState;
        this.principalAmount = principalAmount;
        this.marketValue = marketValue;
        this.percentChange = percentChange;
        this.changeInShares = changeInShares;
        this.perPortfolio = perPortfolio;
    }
}
