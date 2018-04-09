package org.rebecca.javabrains.StockAnalyser.model;

public class Holding {
    private String investorID;
    private String companyID;
    private double percentChange;
    private double changeInShares;
    private double principalAmount;
    private double marketValue;
    private int quarterNo;

    public Holding() { }

    public Holding(String investorID, String companyID, double percentChange, double changeInShares, double principalAmount, double marketValue, int quarterNo) {
        this.investorID = investorID;
        this.companyID = companyID;
        this.percentChange = percentChange;
        this.changeInShares = changeInShares;
        this.principalAmount = principalAmount;
        this.marketValue = marketValue;
        this.quarterNo = quarterNo;
    }

    public String getInvestorID() {
        return investorID;
    }

    public void setInvestorID(String investorID) {
        this.investorID = investorID;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
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

    public int getQuarterNo() {
        return quarterNo;
    }

    public void setQuarterNo(int quarterNo) {
        this.quarterNo = quarterNo;
    }
}